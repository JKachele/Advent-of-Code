package com.jkachele.aoc._2015.day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day2a {
    public static void main(String[] args) {
        String fileName = "src/com/jkachele/aoc/_2015/day2/input.txt";
        // String fileName = "src/com/jkachele/aoc/_2015/day2/testInput.txt";
        ArrayList<String> lines = readFile(fileName);
        // System.out.println(lines);

        int totalPaperArea = 0;
        for (int i = 0; i < lines.size(); i++) {
            String[] dimensionString = lines.get(i).split("x");
            int[] dimensions = Arrays.stream(dimensionString).mapToInt(Integer::parseInt).toArray();
            System.out.print(Arrays.toString(dimensions) + " -> ");

            int[] sides = new int[3];
            sides[0] = dimensions[0] * dimensions[1];
            sides[1] = dimensions[1] * dimensions[2];
            sides[2] = dimensions[2] * dimensions[0];
            System.out.print(Arrays.toString(sides) + " -> ");

            int surfaceArea = (sides[0] + sides[1] + sides[2]) * 2;
            System.out.print(surfaceArea + " -> ");

            int minSide = Arrays.stream(sides).min().getAsInt();
            int paperArea = surfaceArea + minSide;
            System.out.println(paperArea);

            totalPaperArea += paperArea;
        }

        System.out.println(totalPaperArea);
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
            // System.out.println(lines);
        } catch (FileNotFoundException e) {
            System.err.println("File Not Found");
            System.exit(0);
        }
        return lines;
    }
}
