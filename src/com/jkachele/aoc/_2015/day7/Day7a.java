package com.jkachele.aoc._2015.day7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Day7a {
    public static void main(String[] args) {
        final String fileName = "src/com/jkachele/aoc/_2015/day6/input.txt";
        // final String fileName = "src/com/jkachele/aoc/_2015/day6/testInput.txt";

        ArrayList<String> lines = readFile(fileName);
        System.out.println(lines);

        HashMap<String, Integer> wires = new HashMap<>();
        for(String line: lines) {
            String[] lineParts = line.split(" ");
            String in1 = "";
            String in2 = "";
            String out = "";
            String operator = "";
            switch(lineParts.length) {
                case 3 -> {
                    in1 = lineParts[0];
                    out = lineParts[2];
                    operator = "ASSIGN";
                }
                case 4 -> {
                    in1 = lineParts[1];
                    out = lineParts[3];
                    operator = "NOT";
                }
                case 5 -> {
                    in1 = lineParts[0];
                    in2 = lineParts[2];
                    out = lineParts[4];
                    operator = lineParts[1];
                } default -> {
                    System.err.println("Invalid line: " + line);
                    System.exit(0);
                }
            }
            switch(operator) {
                case "ASSIGN" -> {
                    
                }
            }
        }

        System.out.println(wires.get("a"));
    }

    public static <K, V> void putOrReplace(HashMap<K, V> map, K key, V value) {
        if(map.containsKey(key)) {
            map.replace(key, value);
        } else {
            map.put(key, value);
        }
    }

    public static boolean isNumber(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
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
