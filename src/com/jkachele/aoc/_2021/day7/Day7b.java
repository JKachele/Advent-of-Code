package com.jkachele.aoc._2021.day7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Day7b {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("E:\\JavaProjects\\Advent-of-Code\\src\\com\\jkachele\\aoc\\_2021\\day7\\input.txt");
        Scanner fileIn = new Scanner(file);

        String line = fileIn.nextLine();
        fileIn.close();

        String[] positionStrings = line.split(",");
        int[] positions = new int[positionStrings.length];

        for(int i=0; i<positions.length; i++)
            positions[i] = Integer.parseInt(positionStrings[i]);

        System.out.println(Arrays.toString(positions));
    }
}