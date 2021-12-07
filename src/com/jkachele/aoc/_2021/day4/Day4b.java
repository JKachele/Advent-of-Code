package com.jkachele.aoc._2021.day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day4b {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("E:\\JavaProjects\\AdventOfCode\\src\\com\\jkachele\\aoc\\_2021\\day4\\input.txt");
        Scanner fileIn = new Scanner(file);
        ArrayList<Board> boards = new ArrayList<>();

        String numberList = fileIn.nextLine();
        String[] numbers = numberList.split(",");
        int[] drawnNumbers = new int[numbers.length];
        for(int i=0; i<numbers.length; i++) {
            drawnNumbers[i] = Integer.parseInt(numbers[i]);
        }

        while(fileIn.hasNext()) {
            fileIn.nextLine();
            int[][] board = new int[5][5];
            for(int i=0; i<5; i++) {
                String rowString = fileIn.nextLine().trim();
                String[] rowNums = rowString.split("\\s+");
                int[] row = new int[rowNums.length];
                for(int j=0; j<rowNums.length; j++) {
                    row[j] = Integer.parseInt(rowNums[j]);
                }
                board[i] = row;
            }
            boards.add(new Board(board));
        }
        fileIn.close();

        for(Board board : boards) {
            System.out.println(board);
            System.out.println();
        }

        Board bingoBoard = runBingo(drawnNumbers, boards);

        int score = bingoBoard.getUnmarkedSum() * bingoBoard.getLastCalledNum();

        System.out.println("--------------------------------");
        System.out.println(bingoBoard);
        System.out.println(score);
    }

    public static Board runBingo(int[] drawnNumbers, ArrayList<Board> boards) {
        Board latestBingo = new Board();
        for(int i: drawnNumbers) {
            for(Board board: boards) {
                if(!board.isBingo() && board.numberInBoard(i)) {
                    board.setBingo(true);
                    board.setLastCalledNum(i);
                    latestBingo = board;
                }
            }
        }
        return latestBingo;
    }
}