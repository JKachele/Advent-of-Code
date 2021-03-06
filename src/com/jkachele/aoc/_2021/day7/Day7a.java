package com.jkachele.aoc._2021.day7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Day7a {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/com/jkachele/aoc/_2021/day7/input.txt");
        //File file = new File("src/com/jkachele/aoc/_2021/day7/input.txt");
        Scanner fileIn = new Scanner(file);

        String line = fileIn.nextLine();
        fileIn.close();

        String[] positionStrings = line.split(",");
        int[] positions = new int[positionStrings.length];

        for(int i=0; i<positions.length; i++)
            positions[i] = Integer.parseInt(positionStrings[i]);

        System.out.println(Arrays.toString(positions));

        int max = 0;
        for(int i: positions) {
            if(i > max)
                max = i;
        }

        int minFuel = Integer.MAX_VALUE;
        int minFuelPos = 0;
        for(int i=0; i<max; i++) {
            int fuel = 0;
            for(int position: positions) {
                fuel += Math.abs(position - i);
            }
            if(fuel < minFuel) {
                minFuel = fuel;
                minFuelPos = i;
            }
        }

        System.out.printf("Fuel cost at position %d - %d", minFuelPos, minFuel);

    }
}