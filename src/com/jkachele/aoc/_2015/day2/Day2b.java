package com.jkachele.aoc._2015.day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day2b {
    public static void main(String[] args) {
        String fileName = "src/com/jkachele/aoc/_2015/day2/input.txt";
        // String fileName = "src/com/jkachele/aoc/_2015/day2/testInput.txt";
        ArrayList<String> lines = readFile(fileName);
        // System.out.println(lines);

        int totalRibbon = 0;
        for (int i = 0; i < lines.size(); i++) {
            String[] dimensionString = lines.get(i).split("x");
            int[] dimensions = Arrays.stream(dimensionString).mapToInt(Integer::parseInt).toArray();
            System.out.print(Arrays.toString(dimensions) + " -> ");

            int[] perimeters = new int[3];
            perimeters[0] = (dimensions[0] + dimensions[1]) * 2;
            perimeters[1] = (dimensions[1] + dimensions[2]) * 2;
            perimeters[2] = (dimensions[2] + dimensions[0]) * 2;
            System.out.println(Arrays.toString(perimeters) + " -> ");

            int minPerim = Arrays.stream(perimeters).min().getAsInt();

            int area = dimensions[0] * dimensions[1] * dimensions[2];

            totalRibbon += minPerim + area;
        }

        System.out.println(totalRibbon);
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
