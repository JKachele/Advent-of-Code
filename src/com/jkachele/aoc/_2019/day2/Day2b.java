package com.jkachele.aoc._2019.day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day2b {
    public static void main(String[] args) {
        String fileName = "src/com/jkachele/aoc/_2019/day2/input.txt";
        //String fileName = "src/com/jkachele/aoc/_2019/day2/testInput.txt";
        ArrayList<String> lines = readFile(fileName);

        String[] intcodeString = lines.get(0).split(",");
        int[] originalIntcode = new int[intcodeString.length];
        for (int i = 0; i < intcodeString.length; i++) {
            originalIntcode[i] = Integer.parseInt(intcodeString[i]);
        }
        System.out.println(Arrays.toString(originalIntcode));

        final int TARGETOUTPUT = 19690720;
        int[] intcode = new int[originalIntcode.length];
        boolean found = false;
        int noun = 0;
        int verb = 0;
        for(int i = 0; i < 100; i++) {
            for(int j = 0; j < 100; j++) {
                intcode = Arrays.copyOf(originalIntcode, originalIntcode.length);
                intcode[1] = i;
                intcode[2] = j;

                int index = 0;
                boolean halt = false;
                while(index < intcode.length) {
                    switch (intcode[index]) {
                        case 1 -> code1(intcode, index);
                        case 2 -> code2(intcode, index);
                        case 99 -> halt = true;
                    }
                    if(halt)
                        break;
                    index += 4;
                }

                if(intcode[0] == TARGETOUTPUT) {
                    found = true;
                    noun = i;
                    verb = j;
                }

                if(found)
                    break;
            }
            if(found)
                break;
        }

        System.out.println(Arrays.toString(intcode));
        System.out.println(100 * noun + verb);
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