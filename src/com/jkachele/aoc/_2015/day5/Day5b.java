package com.jkachele.aoc._2015.day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day5b {
    public static void main(String[] args) {
        final String fileName = "src/com/jkachele/aoc/_2015/day5/input.txt";
        // final String fileName = "src/com/jkachele/aoc/_2015/day5/testInput.txt";

        ArrayList<String> strings = readFile(fileName);
        System.out.println(strings);

        int niceCount = 0;
        for (int i = 0; i < strings.size(); i++) {
            String string = strings.get(i);
            boolean repeat = false;
            boolean matchingPair = false;
            for (int j = 1; j < string.length(); j++) {
                if (j > 1 && string.charAt(j) == string.charAt(j - 2)) {
                    repeat = true;
                }
                String currentPair = string.substring(j - 1, j + 1);
                if (string.substring(j+1).contains(currentPair)) {
                    matchingPair = true;
                }
            }
            if (repeat && matchingPair) {
                niceCount++;
                System.out.println(string);
            }
        }

        System.out.println(niceCount);
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
