package com.jkachele.aoc._2019.day2;

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;

public class Day2a {
    public static void main(String[] args) throws Exception{
        File file = new File("E:\\JavaProjects\\Advent-of-Code\\src\\com\\jkachele\\aoc\\_2019\\day2\\input.txt");
        Scanner fileIn = new Scanner(file);

        String line = fileIn.nextLine();
        fileIn.close();

        String[] intCodeStrings = line.split(",");
        int[] intCode = new int[intCodeStrings.length];

        for(int i=0; i<intCode.length; i++)
            intCode[i] = Integer.parseInt(intCodeStrings[i]);

        System.out.println(Arrays.toString(intCode));


    }

    public static void add(int[] intCode, int index) {

    }
}