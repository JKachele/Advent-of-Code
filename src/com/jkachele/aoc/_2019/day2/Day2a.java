package com.jkachele.aoc._2019.day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day2a {
    public static void main(String[] args) {
        String fileName = "src/com/jkachele/aoc/_2019/day2/input.txt";
        //String fileName = "src/com/jkachele/aoc/_2019/day2/testInput.txt";
        ArrayList<String> lines = readFile(fileName);

        String[] intcodeString = lines.get(0).split(",");
        int[] intcode = new int[intcodeString.length];
        for (int i = 0; i < intcodeString.length; i++) {
            intcode[i] = Integer.parseInt(intcodeString[i]);
        }
        System.out.println(Arrays.toString(intcode));

        //replace position 1 with the value 12 and replace position 2 with the value 2 (from AOC Challenge)
        intcode[1] = 12;
        intcode[2] = 2;

        int i = 0;
        boolean halt = false;
        while(i < intcode.length) {
            switch (intcode[i]) {
                case 1 -> code1(intcode, i);
                case 2 -> code2(intcode, i);
                case 99 -> halt = true;
            }
            if(halt)
                break;
            i += 4;
        }

        System.out.println(Arrays.toString(intcode));
    }

    public static void code1(int[] intcode, int index) {
        int num1Index = intcode[index + 1];
        int num2Index = intcode[index + 2];
        int sumIndex = intcode[index + 3];

        int num1 = intcode[num1Index];
        int num2 = intcode[num2Index];

        int sum = num1 + num2;
        intcode[sumIndex] = sum;
    }

    public static void code2(int[] intcode, int index) {
        int num1Index = intcode[index + 1];
        int num2Index = intcode[index + 2];
        int productIndex = intcode[index + 3];

        int num1 = intcode[num1Index];
        int num2 = intcode[num2Index];

        int product = num1 * num2;
        intcode[productIndex] = product;
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