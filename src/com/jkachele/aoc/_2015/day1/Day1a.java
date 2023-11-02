package com.jkachele.aoc._2015.day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day1a {
    public static void main(String[] args) {
        String fileName = "src/com/jkachele/aoc/_2015/day1/input.txt";
        String instructionString = "";
        try {
            File file = new File(fileName);
            Scanner fileIn = new Scanner(file);

            instructionString = fileIn.nextLine();
            
            fileIn.close();
            // System.out.println(instructionString);
        } catch (FileNotFoundException e) {
            System.err.println("File Not Found");
            System.exit(0);
        }

        int floor = 0;
        for (int i = 0; i < instructionString.length(); i++) {
            if (instructionString.charAt(i) == '(') {
                floor++;
            } else {
                floor--;
            }
        }

        System.out.println(floor);

    }
}
