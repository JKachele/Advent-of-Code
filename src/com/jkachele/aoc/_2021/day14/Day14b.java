package com.jkachele.aoc._2021.day14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day14b {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/com/jkachele/aoc/_2021/day14/input.txt");
        Scanner fileIn = new Scanner(file);
        ArrayList<String> lines = new ArrayList<>();

        while (fileIn.hasNext()) {
            lines.add(fileIn.nextLine());
        }
        fileIn.close();
        System.out.println(lines);
    }
}