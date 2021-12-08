package com.jkachele.aoc._2021.day8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day8a {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("E:\\JavaProjects\\Advent-of-Code\\src\\com\\jkachele\\aoc\\_2021\\day8\\input.txt");
        Scanner fileIn = new Scanner(file);
        ArrayList<String> lines = new ArrayList<>();

        while(fileIn.hasNext()) {
            lines.add(fileIn.nextLine());
        }
        fileIn.close();
        System.out.println(lines);

        String[][] digits = new String[lines.size()][4];

        for(int i=0; i<lines.size(); i++) {
            String[] values = lines.get(i).split(" \\| ");
            String[] outputValues = values[1].split(" ");
            digits[i] = outputValues;
        }

        int numUniqueDigits = 0;
        for(String[] digitSet : digits) {
            for(String digit: digitSet) {
                if(digit.length() == 2 || digit.length() == 3 || digit.length() == 4 || digit.length() == 7)
                    numUniqueDigits++;
            }
        }

        System.out.println(numUniqueDigits);
    }
}