package com.jkachele.aoc._2019.day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day1a {
    public static void main(String[] args) {
        String fileName = "src/com/jkachele/aoc/_2019/day1/input.txt";
        //String fileName = "src/com/jkachele/aoc/_2019/day1/testInput.txt";
        ArrayList<String> lines = readFile(fileName);

        int[] fuelList = new int[lines.size()];
        for (int i = 0; i < lines.size(); i++) {
            int mass = Integer.parseInt(lines.get(i).trim());
            fuelList[i] = (mass / 3) - 2;
        }
        System.out.println(Arrays.toString(fuelList));

        int totalFuel = 0;
        for(int fuel: fuelList) {
            totalFuel += fuel;
        }

        System.out.println(totalFuel);
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