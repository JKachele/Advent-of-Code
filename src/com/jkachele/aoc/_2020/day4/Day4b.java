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

        int goodPassports = 0;

        for(ArrayList<String> p: passports) {
            int fields = 0;
            String cidRegex = "cid:\\d+";
            for(String field : p) {
                if(!field.matches(cidRegex)) {
                    fields++;
                }
            }
            if(fields == 7) {
                boolean valid = true;
                for(String field : p) {
                    String fieldName = field.substring(0, 3);
                    switch(fieldName) {
                        case "byr":
                            if(!testBYR(field))
                                valid = false;
                            break;
                        case "iyr":
                            if(!testIYR(field))
                                valid = false;
                            break;
                        case "eyr":
                            if(!testEYR(field))
                                valid = false;
                            break;
                        case "hgt":
                            if(!testHGT(field))
                                valid = false;
                            break;
                        case "hcl":
                            if(!testHCL(field))
                                valid = false;
                            break;
                        case "ecl":
                            if(!testECL(field))
                                valid = false;
                            break;
                        case "pid":
                            if(!testPID(field))
                                valid = false;
                            break;
                        case "cid":
                            break;
                        default:
                            System.out.println("Error!");
                    }
                    if(!valid)
                        break;
                }
                if(valid)
                    goodPassports++;
            }
        }

        System.out.println(goodPassports);

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
        String regex = "hgt:\\d+(cm|in)";
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