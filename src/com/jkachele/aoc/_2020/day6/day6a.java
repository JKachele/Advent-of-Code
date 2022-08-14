package com.jkachele.aoc._2020.day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day6a {
    public static void main(String[] args) throws FileNotFoundException {
        File input = new File("src/com/jkachele/aoc/_2020/day6/input.txt");
        Scanner fileIn = new Scanner(input);
        ArrayList<String> lines = new ArrayList<>();

        while (fileIn.hasNext())
            lines.add(fileIn.nextLine());
        fileIn.close();
        System.out.println(lines);
    }
}
