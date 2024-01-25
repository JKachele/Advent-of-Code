package com.jkachele.aoc._2015.day8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day8a {
    public static void main(String[] args) {
        final String fileName = "src/com/jkachele/aoc/_2015/day8/input.txt";
        // final String fileName = "src/com/jkachele/aoc/_2015/day8/testInput.txt";

        ArrayList<String> lines = readFile(fileName);
        System.out.println(lines);
        
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
