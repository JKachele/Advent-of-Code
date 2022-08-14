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

        int[][] cavern = new int[lines.size()][lines.get(0).length()];
        for(int i=0; i<lines.size(); i++) {
            String line = lines.get(i);
            for(int j=0; j<line.length(); j++) {
                cavern[i][j] = Integer.parseInt(line.substring(j, j+1));
            }
        }

        System.out.println(Arrays.deepToString(cavern));
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