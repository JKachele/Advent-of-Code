package com.jkachele.aoc._2020.day1;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class Day1a {

    public static void main(String[] args) throws Exception {
        Scanner fileIn = new Scanner(new File("src/com/jkachele/aoc/_2020/day1/input.txt"));
        ArrayList<Integer> numbers = new ArrayList<>();

        while(fileIn.hasNextInt()) {
            numbers.add(fileIn.nextInt());
        }

        int num1 = 0;
        int num2 = 0;
        for(int i = 0; i < numbers.size(); i++) {
            num1 = numbers.get(i);
            num2 = 2020 - num1;
            if(numbers.contains(num2)) {
                break;
            }
        }

        int product = num1 * num2;

        System.out.print(product);
    }
}