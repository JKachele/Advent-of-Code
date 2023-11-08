package com.jkachele.aoc._2021.day15;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day15b {
    public static void main(String[] args) {
        String fileName = "src/com/jkachele/aoc/_2021/day15/input.txt";
        //String fileName = "src/com/jkachele/aoc/_2021/day15/testInput.txt";
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
            System.out.println(lines);
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
            System.exit(0);
        }
        return lines;
    }
}