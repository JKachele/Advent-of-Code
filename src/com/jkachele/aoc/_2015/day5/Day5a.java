package com.jkachele.aoc._2015.day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day5a {
    public static void main(String[] args) {
        final String fileName = "src/com/jkachele/aoc/_2015/day5/input.txt";
        // final String fileName = "src/com/jkachele/aoc/_2015/day5/testInput.txt";
        final char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        final String[] badStrings = {"ab", "cd", "pq", "xy"};

        ArrayList<String> strings = readFile(fileName);
        System.out.println(strings);

        int niceCount = 0;
        for (int i = 0; i < strings.size(); i++) {
            String string = strings.get(i);
            int vowelCount = 0;
            boolean hasDouble = false;
            boolean noBad = true;
            for (int j = 0; j < string.length(); j++) {
                for (char vowel: vowels) {
                    if (string.charAt(j) == vowel) {
                        vowelCount++;
                    }
                }
                if (j > 0) {
                    if (string.charAt(j) == string.charAt(j - 1)) {
                        hasDouble = true;
                    }
                    for (String bad: badStrings) {
                        if (bad.charAt(0) == string.charAt(j - 1) && bad.charAt(1) == string.charAt(j)) {
                            noBad = false;
                        }
                    }
                }
            }
            if (vowelCount >= 3 && hasDouble && noBad) {
                niceCount++;
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
