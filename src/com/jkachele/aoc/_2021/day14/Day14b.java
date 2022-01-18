package com.jkachele.aoc._2021.day14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day14b {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/com/jkachele/aoc/_2021/day14/input.txt");
        //File file = new File("src/com/jkachele/aoc/_2021/day14/testInput.txt");
        Scanner fileIn = new Scanner(file);
        ArrayList<String> lines = new ArrayList<>();

        String template = fileIn.nextLine();
        fileIn.nextLine();

        while (fileIn.hasNext()) {
            lines.add(fileIn.nextLine());
        }
        fileIn.close();
        System.out.printf("%s : %s%n",template, lines);

        Map<String, String[]> replacements = createReplacementMap(lines);
        Map<String, Long> templateMap = createStartingMap(template, replacements);

        System.out.println(templateMap);
        //loop for 40 steps
        for(int i=0; i<40; i++) {
            templateMap = transform(templateMap, replacements);
            System.out.printf("\r%d - %s", i, templateMap);
        }
        System.out.println();
        printAnswer(templateMap, template);
    }

    public static Map<String, String[]> createReplacementMap(ArrayList<String> rules) {
        //first string is the sequence for the rule, the second is a string array with the 2 replacements
        //(1st char of first string + insertion, insertion + 2nd char of first string)
        Map<String, String[]> replacements = new HashMap<>();
        for (String rule : rules) {
            String[] split = rule.split(" -> ");
            String pattern = split[0];
            String insertion = split[1];
            String[] replace = {pattern.charAt(0) + insertion, insertion + pattern.charAt(1)};

            replacements.put(pattern, replace);

        }

        return replacements;
    }

    public static Map<String, Long> createStartingMap(String template, Map<String, String[]> rules) {
        Map<String, Long> map = new HashMap<>();

        for(String key: rules.keySet()) {
            map.put(key, 0L);
        }

        for(int i=0; i<template.length()-1; i++) {
            String pair = template.substring(i, i+2);
            map.replace(pair, map.get(pair) + 1);
        }

        return map;
    }

    public static Map<String, Long> createBlankMap(Map<String, String[]> rules) {
        Map<String, Long> map = new HashMap<>();

        for(String key: rules.keySet()) {
            map.put(key, 0L);
        }

        return map;
    }

    public static Map<String, Long> transform(Map<String, Long> template, Map<String, String[]> replacements) {
        Map<String, Long> newTemplate = createBlankMap(replacements);

        for (Map.Entry<String, Long> entry : template.entrySet()) {
            String[] replace = replacements.get(entry.getKey());
            for(String r: replace) {
                newTemplate.replace(r, newTemplate.get(r) + entry.getValue());
            }
        }

        return newTemplate;
    }

    public static void printAnswer(Map<String, Long> templateMap, String template) {
        Map<Character, Long> elements = new HashMap<>();

        for(Map.Entry<String, Long> entry: templateMap.entrySet()) {
            char char0 = entry.getKey().charAt(0);
            if(elements.putIfAbsent(char0, entry.getValue()) != null) {
                elements.replace(char0, elements.get(char0) + entry.getValue());
            }
        }
        //adds the last character of the initial template
        elements.replace(template.charAt(template.length()-1), elements.get(template.charAt(template.length()-1)) + 1);
        System.out.println(elements);

        long max = 0;
        long min = Long.MAX_VALUE;
        for (long elementNum : elements.values()) {
            if (elementNum > max)
                max = elementNum;
            if (elementNum < min)
                min = elementNum;
        }

        Long answer = max - min;

        System.out.println(answer);
    }
}