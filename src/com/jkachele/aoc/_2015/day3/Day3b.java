package com.jkachele.aoc._2015.day3;

import com.jkachele.aoc.utils.Vector2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class Day3b {
    public static void main(String[] args) {
        String fileName = "src/com/jkachele/aoc/_2015/day3/input.txt";
        // String fileName = "src/com/jkachele/aoc/_2015/day3/testInput.txt";
        String directions = readFile(fileName).get(0);
        System.out.println(directions);

        Set<Vector2> houses = new HashSet<>();
        houses.add(new Vector2());
        Vector2 santaHouse = new Vector2();
        Vector2 roboHouse = new Vector2();
        for (int i = 0; i < directions.length(); i++) {
            if (i % 2 ==0) {
                switch (directions.charAt(i)) {
                    case '>' -> santaHouse.x++;
                    case '<' -> santaHouse.x--;
                    case '^' -> santaHouse.y++;
                    case 'v' -> santaHouse.y--;
                }

                houses.add(new Vector2(santaHouse));
            } else {
                switch (directions.charAt(i)) {
                    case '>' -> roboHouse.x++;
                    case '<' -> roboHouse.x--;
                    case '^' -> roboHouse.y++;
                    case 'v' -> roboHouse.y--;
                }

                houses.add(new Vector2(roboHouse));
            }
        }

        System.out.println(houses.size());
    }

    
    public static ArrayList<String> readFile(String fileName) {
        ArrayList<String> lines = new ArrayList<>();
        try {
            File file = new File(fileName);
            Scanner fileIn = new Scanner(file);

            while (fileIn.hasNext()) {
                lines.add(fileIn.nextLine());
            }
            fileIn.close();
            // System.out.println(lines);
        } catch (FileNotFoundException e) {
            System.err.println("File Not Found");
            System.exit(0);
        }
        return lines;
    }
}
