package com.jkachele.aoc._2021.day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day6b {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("E:\\JavaProjects\\Advent-of-Code\\src\\com\\jkachele\\aoc\\_2021\\day6\\input.txt");
        //File file = new File("E:\\JavaProjects\\Advent-of-Code\\src\\com\\jkachele\\aoc\\_2021\\day6\\testInput.txt.txt");
        Scanner fileIn = new Scanner(file);

        String line = fileIn.nextLine();
        fileIn.close();
        System.out.println(line);

        String[] ageStrings = line.split(",");

        //array of the available ages to keep track of how many fish are of a particular age
        long[] ages = new long[9];

        for(String ageString: ageStrings) {
            int age = Integer.parseInt(ageString);
            ages[age]++;
        }



        //loops through 256 days
        for(int i=0; i<256; i++) {
            System.out.printf("Day %d - %o%n", i, getTotal(ages));
            long numNewFish = ages[0];
            //shifts all the elements down by one
            for(int j=0; j<8; j++)
                ages[j] = ages[j+1];
            //adds the reset fish to the age 6 index
            ages[6] += numNewFish;
            //adds newborn fish to age 8 index
            ages[8] = numNewFish;
        }

        System.out.printf("Day 256 - %o%n", getTotal(ages));
    }

    //calculate total number of fish
    public static long getTotal(long[] ages) {
        long total = 0;
        for(long numFish: ages)
            total += numFish;
        return total;
    }
}