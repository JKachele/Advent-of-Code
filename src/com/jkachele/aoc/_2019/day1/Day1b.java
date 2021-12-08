package com.jkachele.aoc._2019.day1;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class Day1b {

    public static void main(String[] args) throws Exception{
        Scanner fileIn = new Scanner(new File("E:\\JavaProjects\\Advent-of-Code\\src\\com\\jkachele\\aoc\\_2019\\day1\\input.txt"));
        ArrayList<Integer> mass = new ArrayList<>();

        while(fileIn.hasNextInt()) {
            mass.add(fileIn.nextInt());
        }
        fileIn.close();

        int total = 0;

        for (int temp : mass) {
            int add = (temp / 3) - 2;
            while (add > 0) {
                total += add;
                add = (add / 3) - 2;
            }
        }

        System.out.print(total);

    }
}