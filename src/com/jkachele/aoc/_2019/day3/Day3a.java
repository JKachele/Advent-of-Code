package com.jkachele.aoc._2019.day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day3a {
    public static void main(String[] args) {
        String fileName = "src/com/jkachele/aoc/_2019/day3/input.txt";
        //String fileName = "src/com/jkachele/aoc/_2019/day3/testInput.txt";
        ArrayList<String> lines = readFile(fileName);

        String[] line1 = lines.get(0).split(",");
        String[] line2 = lines.get(1).split(",");
        System.out.println(Arrays.toString(line1));
        System.out.println(Arrays.toString(line2));

        ArrayList<int[][]> line1V = new ArrayList<>();
        ArrayList<int[][]> line1H = new ArrayList<>();
        ArrayList<int[][]> line2V = new ArrayList<>();
        ArrayList<int[][]> line2H = new ArrayList<>();

        findSegments(line1, line1V, line1H);
        findSegments(line2, line2V, line2H);


    }

    public static void findSegments(String[] line, ArrayList<int[][]> lineV, ArrayList<int[][]> lineH) {
        int[] position = {0, 0};
        for(String segment: line) {
            char direction = segment.charAt(0);
            int distance = Integer.parseInt(segment.substring(1));
            int[] newPosition = Arrays.copyOf(position, position.length);

            switch (direction) {
                case 'R' -> {
                    newPosition[0] = position[0] + distance;
                    lineH.add(parseSegment(position, newPosition));
                }
                case 'L' -> {
                    newPosition[0] = position[0] - distance;
                    lineH.add(parseSegment(position, newPosition));
                }
                case 'U' -> {
                    newPosition[1] = position[1] + distance;
                    lineV.add(parseSegment(position, newPosition));
                }
                case 'D' -> {
                    newPosition[1] = position[1] - distance;
                    lineV.add(parseSegment(position, newPosition));
                }
            }
            position = Arrays.copyOf(newPosition, newPosition.length);
        }
    }

    //creates a 2d array in the syntax [[x1, x2], [y1, y2]]
    public static int[][] parseSegment(int[] position1, int[] position2) {
        int[][] result = new int[2][2];

        result[0][0] = position1[0];
        result[0][1] = position2[0];
        result[1][0] = position1[1];
        result[1][1] = position2[1];

        return result;
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
}