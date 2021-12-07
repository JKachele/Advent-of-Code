package com.jkachele.aoc._2021.day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day6a {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("E:\\JavaProjects\\Advent-of-Code\\src\\com\\jkachele\\aoc\\_2021\\day6\\input.txt");
        //File file = new File("E:\\JavaProjects\\Advent-of-Code\\src\\com\\jkachele\\aoc\\_2021\\day6\\testInput.txt");
        Scanner fileIn = new Scanner(file);

        String line = fileIn.nextLine();
        fileIn.close();
        System.out.println(line);

        String[] ageStrings = line.split(",");
        ArrayList<LanternFish> fishies = new ArrayList<>();

        for(String ageString: ageStrings) {
            int age = Integer.parseInt(ageString);
            fishies.add(new LanternFish(age));
        }


        //loops through 80 days
        for(int i=0; i<80; i++) {
            int numNewFish = 0;
            //System.out.printf("Day %d - %s%n", i, fishies);
            for(LanternFish fish: fishies) {
                if(fish.age1Day())
                    numNewFish++;
            }
            for(int j=0; j<numNewFish; j++) {
                fishies.add(new LanternFish(8));
            }
        }

        System.out.println(fishies);
        System.out.println(fishies.size());

    }
}