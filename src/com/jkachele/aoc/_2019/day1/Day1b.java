package com.jkachele.aoc._2019.day1;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class Day1b {

    public static void main(String[] args) throws Exception{
        Scanner fileIn = new Scanner(new File("Text Docs\\2019Day1.txt"));
        ArrayList<Integer> mass = new ArrayList<>();

        while(fileIn.hasNextInt()) {
            mass.add(fileIn.nextInt());
        }

        int total = 0;

        for(int i = 0; i < mass.size(); i++) {
            int temp = mass.get(i);
            int add = ((int)(temp / 3)) - 2;
            while(add > 0) {
                total += add;
                add = ((int)(add / 3)) - 2;
            }
        }

        System.out.print(total);

    }
}