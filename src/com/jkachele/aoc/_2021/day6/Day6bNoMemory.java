package com.jkachele.aoc._2021.day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day6bNoMemory {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/com/jkachele/aoc/_2021/day6/input.txt");
        //File file = new File("src/com/jkachele/aoc/_2021/day6/testInput.txt.txt");
        Scanner fileIn = new Scanner(file);

        String line = fileIn.nextLine();
        fileIn.close();
        System.out.println(line);

        String[] ageStrings = line.split(",");
        ArrayList<Integer> cycles = new ArrayList<>();

        for(String ageString: ageStrings) {
            int age = Integer.parseInt(ageString);
            cycles.add(age);
        }


        //loops through 256 days
        for(int i=0; i<256; i++) {
            int numNewFish = 0;
            //System.out.printf("Day %d - %s%n", i, fishies);
            System.out.println(i);
            for(int j=0; j<cycles.size(); j++) {
                int timer = cycles.get(j);
                if(timer == 0) {
                    cycles.set(j, 6);
                    numNewFish++;
                }
                else {
                    cycles.set(j,timer - 1);
                }
            }
            for(int j=0; j<numNewFish; j++) {
                cycles.add(8);
            }
        }

        System.out.println();
        System.out.println(cycles.size());

    }
}