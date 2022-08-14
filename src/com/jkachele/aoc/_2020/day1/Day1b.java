package com.jkachele.aoc._2020.day1;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class Day1b {

    public static void main(String[] args) throws Exception {
        Scanner fileIn = new Scanner(new File("src/com/jkachele/aoc/_2021/day1/input.txt"));
        ArrayList<Integer> numbers = new ArrayList<>();

        while(fileIn.hasNextInt()) {
            numbers.add(fileIn.nextInt());
        }

        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        boolean quit = false;
        for(int i = 0; i < numbers.size(); i++) {
            num1 = numbers.get(i);
            int temp = 2020 - num1;
            for(num2 = 0; num2 < temp; num2++) {
                num3 = temp - num2;
                if(numbers.contains(num2)) {
                    if(numbers.contains(num3)) {
                        quit = true;
                        break;
                    }
                }
            }
            if(quit)
                break;
        }

        int product = num1 * num2 * num3;

        System.out.print(product);
    }
}
