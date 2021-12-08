package com.jkachele.aoc._2019.day1;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class Day1a {

    public static void main(String[] args) throws Exception{
        Scanner fileIn = new Scanner(new File("E:\\JavaProjects\\Advent-of-Code\\src\\com\\jkachele\\aoc\\_2019\\day1\\input.txt"));
        ArrayList<Integer> mass = new ArrayList<>();

        while(fileIn.hasNextInt()) {
            mass.add(fileIn.nextInt());
        }
        fileIn.close();

        int total = 0;

        for (int temp : mass) {
            total += (temp / 3) - 2;
        }

        System.out.print(total);

    }
}