package com.jkachele.aoc._2021.day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1b {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("E:\\JavaProjects\\AdventOfCode\\src\\com\\jkachele\\aoc\\_2021\\day1\\input.txt");
        Scanner fileIn = new Scanner(file);
        ArrayList<Integer> depths = new ArrayList<>();
        ArrayList<Integer> windowDepths = new ArrayList<>();
        int numIncreases = 0;

        while(fileIn.hasNext()) {
            String input = fileIn.nextLine();
            depths.add(Integer.parseInt(input));
        }

        //creates 3 window array
        for(int i=2; i<depths.size(); i++) {
            int a = depths.get(i-2);
            int b = depths.get(i-1);
            int c = depths.get(i);
            windowDepths.add(a + b + c);
        }

        //count increases
        for(int i=1; i<windowDepths.size(); i++) {
            int prev = windowDepths.get(i - 1);
            int cur = windowDepths.get(i);
            if(cur > prev)
                numIncreases++;
        }

        System.out.println(depths);
        System.out.println(windowDepths);
        System.out.println(numIncreases);

        fileIn.close();
    }
}
