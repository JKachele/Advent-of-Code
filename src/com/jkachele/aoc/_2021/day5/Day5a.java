package com.jkachele.aoc._2021.day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day5a {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("E:\\JavaProjects\\AdventOfCode\\src\\com\\jkachele\\aoc\\_2021\\day5\\input.txt");
        Scanner fileIn = new Scanner(file);
        //ArrayList<String> linesIn = new ArrayList<>();
        ArrayList<int[][]> lines = new ArrayList<>();

        while (fileIn.hasNext()) {
            int[][] line = new int[2][2];

            String next1 = fileIn.next();
            String[] point1 = next1.split(",");
            line[0][0] = Integer.parseInt(point1[0]);
            line[0][1] = Integer.parseInt(point1[1]);

            fileIn.next();

            String next2 = fileIn.next();
            String[] point2 = next2.split(",");
            line[1][0] = Integer.parseInt(point2[0]);
            line[1][1] = Integer.parseInt(point2[1]);

            lines.add(line);
        }
        fileIn.close();

        for(int[][] line : lines) {
            System.out.printf("[%s, %s], ", Arrays.toString(line[0]), Arrays.toString(line[1]));
        }



    }
}