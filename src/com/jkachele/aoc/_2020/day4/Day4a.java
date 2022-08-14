package com.jkachele.aoc._2020.day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day4a {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/com/jkachele/aoc/_2020/day4/input.txt");
        Scanner fileIn = new Scanner(file);
        ArrayList<String> lines = new ArrayList<>();

        while (fileIn.hasNext()) {
            lines.add(fileIn.nextLine());
        }
        fileIn.close();
        System.out.println(lines);

        ArrayList<ArrayList<String>> passports = new ArrayList<>();
        ArrayList<String> passport = new ArrayList<>();

        for(String line: lines) {
            if(!line.isEmpty()) {
                String[] lineSplit = line.split(" ");
                passport.addAll(Arrays.asList(lineSplit));
            } else {
                passports.add(passport);
                passport = new ArrayList<>();
            }
        }
        passports.add(passport);


        int goodPassports = 0;

        for(ArrayList<String> p: passports) {
            int fields = 0;
            String cidRegex = "cid:\\d+";
            for(String field : p) {
                if(!field.matches(cidRegex)) {
                    fields++;
                }
            }
            if(fields == 7)
                goodPassports++;
        }

        System.out.println(goodPassports);

    }
}