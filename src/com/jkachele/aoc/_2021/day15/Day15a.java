package com.jkachele.aoc._2021.day15;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day15a {
    public static void main(String[] args) {
        //String fileName = "src/com/jkachele/aoc/_2021/day15/input.txt";
        String fileName = "src/com/jkachele/aoc/_2021/day15/testInput.txt";

        ArrayList<String> lines = readFile(fileName);

        Cell[][] cavern = new Cell[lines.size()][lines.get(0).length()];
        for(int y=0; y<lines.size(); y++) {
            String line = lines.get(y);
            for(int x=0; x<line.length(); x++) {
                int riskLevel = Integer.parseInt(line.substring(x, x+1));
                cavern[y][x] = new Cell(riskLevel, x, y);
            }
        }

        AStar.initialize(cavern);

        /*
        for(Cell[] row: cavern) {
            for(Cell cell: row) {
                System.out.print(cell.getHCost() + "\t");
            }
            System.out.println();
        }
        */
    }

    public static ArrayList<String> readFile(String fileName) {
        ArrayList<String> lines = new ArrayList<>();
        try {
            File file = new File(fileName);
            Scanner fileIn = new Scanner(file);

            while (fileIn.hasNext()) {
                lines.add(fileIn.nextLine());
            }
            fileIn.close();
            System.out.println(lines);
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
            System.exit(0);
        }
        return lines;
    }

    public static void aStarAlgorithm(int[][] grid, int[] beginning, int[] ending) {

    }
}