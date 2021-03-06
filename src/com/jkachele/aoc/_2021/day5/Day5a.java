package com.jkachele.aoc._2021.day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day5a {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/com/jkachele/aoc/_2021/day5/input.txt");
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

        //2d array of points to track covered points
        int[][] diagram = new int[1000][1000];

        //loops through all the lines and adds them to the diagram
        for(int[][] line : lines) {
            //if X coordinate is the same, then it's a vertical segment
            if(line[0][0] == line[1][0]) {
                int x = line[0][0];
                int minY = Math.min(line[0][1], line[1][1]);
                int maxY = Math.max(line[0][1], line[1][1]);
                //loops through the points on the line from the start to the end point and adds one to the diagram
                for(int y=minY; y<=maxY; y++)
                    diagram[x][y]++;
            }
            //if Y coordinate is the same, then it's a horizontal segment
            if(line[0][1] == line[1][1]) {
                int y = line[0][1];
                int minX = Math.min(line[0][0], line[1][0]);
                int maxX = Math.max(line[0][0], line[1][0]);
                //loops through the points on the line from the start to the end point and adds one to the diagram
                for(int x=minX; x<=maxX; x++)
                    diagram[x][y]++;
            }
        }

        int score = 0;

        for(int[] row: diagram) {
            for(int point: row) {
                //System.out.printf("%d ", point);
                if(point > 1)
                    score++;
            }
            //System.out.println();
        }

        System.out.printf("%nScore: %d%n", score);

    }
}