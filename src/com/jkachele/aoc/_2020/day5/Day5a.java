package com.jkachele.aoc._2020.day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day5a {
    public static void main(String[] args) throws FileNotFoundException {
        File input = new File("src/com/jkachele/aoc/_2020/day5/input.txt");
        Scanner fileIn = new Scanner(input);
        ArrayList<String> lines = new ArrayList<>();

        while (fileIn.hasNext()) {
            lines.add(fileIn.nextLine());
        }
        fileIn.close();
        System.out.println(lines);

        //loops through the lines separating each seat into its own array of pointers
        char[][] seatPointer = new char[lines.size()][lines.get(0).length()];
        for(int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            for(int j = 0; j < line.length(); j++) {
                seatPointer[i][j] = line.charAt(j);
            }
        }
        System.out.println(Arrays.deepToString(seatPointer));

        //uses pointers to determine seat row and column
        int[][] seatNumber = new int[lines.size()][2];
        for(int i = 0; i < seatPointer.length; i++) {
            //determine seat row using first 7 chars of pointer
            int row = 0;
            for(int j = 0; j < 7; j++) {
                if(seatPointer[i][j] == 'B') {
                    /*uses binary to determine seat row
                    If the first pointer is 'B', is means the seat is in the last 64 seats,
                    so 64 is added to the seat row
                    */
                    double binaryMultiplier = Math.pow(2, 6 - j);
                    row += binaryMultiplier;
                }
            }

            //determine seat column using the last 3 chars of pointer
            int column = 0;
            for(int j = 7; j < 10; j++) {
                if(seatPointer[i][j] == 'R') {
                    /*uses binary to determine seat row
                    If the first pointer is 'R', is means the seat is in the last 4 seats,
                    so 4 is added to the seat row
                    */
                    double binaryMultiplier = Math.pow(2, 9 - j);
                    column += binaryMultiplier;
                }
            }
            seatNumber[i][0] = row;
            seatNumber[i][1] = column;
        }
        System.out.println(Arrays.deepToString(seatNumber));

        //determine seat id
        int[] seatID = new int[lines.size()];
        for(int i = 0; i < seatNumber.length; i++) {
            //calculate seat id be multiplying seat row by 8 and adding the column
            seatID[i] = (seatNumber[i][0] * 8) + seatNumber[i][1];
        }
        System.out.println(Arrays.toString(seatID));

        //determine largest seat id
        int largestID = 0;
        for(int id: seatID) {
            if(largestID < id)
                largestID = id;
        }
        System.out.println(largestID);
    }
}