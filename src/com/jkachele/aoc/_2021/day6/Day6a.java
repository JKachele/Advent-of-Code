package com.jkachele.aoc._2021.day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day6a {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("E:\\JavaProjects\\Advent-of-Code\\src\\com\\jkachele\\aoc\\_2021\\day6\\input.txt");
        Scanner fileIn = new Scanner(file);

        String line = fileIn.nextLine();
        fileIn.close();
        System.out.println(line);

        String[] ageStrings = line.split(",");
        ArrayList<LanternFish> fishies = new ArrayList<>();

        for(String ageString: ageStrings) {
            int age = Integer.parseInt(ageString);
            fishies.add(new LanternFish(age, 6));
        }


        //loops through 80 days
        for(int i=0; i<80; i++) {
            ArrayList<Integer> newFish = new ArrayList<>();
            for(LanternFish fish: fishies) {
                if(fish.age1Day())
                    newFish.add(fish.getMaxTimer() + 2);
            }
            for(int j: newFish) {
                fishies.add(new LanternFish(j, j));
            }
        }

    }
}