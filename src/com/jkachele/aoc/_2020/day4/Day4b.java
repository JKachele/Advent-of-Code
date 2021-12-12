package com.jkachele.aoc._2020.day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day4b {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/com/jkachele/aoc/_2020/day4/input.txt");
        Scanner fileIn = new Scanner(file);
        ArrayList<String> lines = new ArrayList<>();

        while (fileIn.hasNext()) {
            lines.add(fileIn.nextLine());
        }
        fileIn.close();

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

        System.out.println(passports);
    }

    public static boolean testBYR(String field) {
        String regex = "byr:\\d{4}";
        if(field.matches(regex)) {
            int year = Integer.parseInt(field.substring(4));
            return year >= 1920 && year <= 2002;
        }
        return false;
    }

    public static boolean testIYR(String field) {
        String regex = "iyr:\\d{4}";
        if(field.matches(regex)) {
            int year = Integer.parseInt(field.substring(4));
            return year >= 2010 && year <= 2020;
        }
        return false;
    }

    public static boolean testEYR(String field) {
        String regex = "eyr:\\d{4}";
        if(field.matches(regex)) {
            int year = Integer.parseInt(field.substring(4));
            return year >= 2020 && year <= 2030;
        }
        return false;
    }

    public static boolean testHGT(String field) {
        String regex = "hgt:\\d+(cm||in)";
        if(field.matches(regex)) {
            String unit = field.substring(field.length()-2);
            int height = Integer.parseInt(field.substring(4, field.length()-2));
            if(unit.equals("cm")) {
                return height >= 150 && height <= 193;
            } else if(unit.equals("in")) {
                return height >= 59 && height <= 76;
            }
        }
        return false;
    }

    public static boolean testHCL(String field) {
        String regex = "hcl:#[a-f0-9]{6}";
        return field.matches(regex);
    }

    public static boolean testECL(String field) {
        String[] colors = {"amb", "blu", "brn", "gry", "grn", "hzl", "oth"};
        String ecl = field.substring(4);
        return Arrays.asList(colors).contains(ecl);
    }

    public static boolean testPID(String field) {
        String regex = "pid:\\d{9}";
        return field.matches(regex);
    }
}