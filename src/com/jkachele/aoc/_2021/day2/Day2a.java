package com.jkachele.aoc._2021.day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day2a {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("E:\\JavaProjects\\Advent-of-Code\\src\\com\\jkachele\\aoc\\_2021\\day2\\input.txt");
        Scanner fileIn = new Scanner(file);
        ArrayList<String> lines = new ArrayList<>();

        while(fileIn.hasNext())
            lines.add(fileIn.nextLine());
        fileIn.close();

        System.out.println(lines);

        String[] directions = new String[lines.size()];
        int[] distances = new int[lines.size()];

        for(int i=0; i<lines.size(); i++) {
            String[] split = lines.get(i).split(" ");
            directions[i] = split[0];
            distances[i] = Integer.parseInt(split[1]);
        }

        int horizontal = 0;
        int depth = 0;

        for(int i=0; i<directions.length; i++) {
            String direction = directions[i];

            switch(direction) {
                case "forward" -> horizontal += distances[i];
                case "down" -> depth += distances[i];
                case "up" -> depth -= distances[i];
                default -> System.out.println("Undefined Case");
            }
        }

        int mult = horizontal * depth;

        System.out.printf("Position: (%d, %d)\tMultiplied: %d%n", horizontal, depth, mult);

    }
}
