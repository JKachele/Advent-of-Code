package com.jkachele.aoc._2020.day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day5a {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/com/jkachele/aoc/_2020/day5/input.txt");
        Scanner fileIn = new Scanner(file);
        ArrayList<String> lines = new ArrayList<>();

        while (fileIn.hasNext()) {
            lines.add(fileIn.nextLine());
        }
        fileIn.close();
        System.out.println(lines);

        char[][] seats = new char[lines.size()][lines.get(0).length()];

        for(int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            for(int j = 0; j < line.length(); j++) {
                seats[i][j] = line.charAt(j);
            }
        }

        for(char[] seat: seats) {

        }
    }
}