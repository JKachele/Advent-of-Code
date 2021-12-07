package com.jkachele.aoc._2021.day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Day1a {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("E:\\JavaProjects\\Advent-of-Code\\src\\com\\jkachele\\aoc\\_2021\\day1\\input.txt");
        Scanner fileIn = new Scanner(file);
        ArrayList<Integer> depths = new ArrayList<>();
        int numIncreases = 0;

        while(fileIn.hasNext()) {
            String input = fileIn.nextLine();
            depths.add(Integer.parseInt(input));
        }

        for(int i=1; i<depths.size(); i++) {
            int prev = depths.get(i - 1);
            int cur = depths.get(i);
            if(cur > prev)
                numIncreases++;
        }

        System.out.println(depths);
        System.out.println(numIncreases);

        fileIn.close();
    }
}
