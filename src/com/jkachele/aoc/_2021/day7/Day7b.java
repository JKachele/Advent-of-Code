package com.jkachele.aoc._2021.day7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day7b {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("E:\\JavaProjects\\Advent-of-Code\\src\\com\\jkachele\\aoc\\_2021\\day[day]\\input.txt");
        Scanner fileIn = new Scanner(file);
        ArrayList<String> lines = new ArrayList<>();

        while (fileIn.hasNext()) {
            lines.add(fileIn.nextLine());
        }
        fileIn.close();
        System.out.println(lines);
    }
}