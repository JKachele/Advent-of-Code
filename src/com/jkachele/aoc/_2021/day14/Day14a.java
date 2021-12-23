package com.jkachele.aoc._2021.day14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day14a {
    public static void main(String[] args) throws FileNotFoundException {
        //File file = new File("src/com/jkachele/aoc/_2021/day14/input.txt");
        File file = new File("src/com/jkachele/aoc/_2021/day14/testInput.txt");
        Scanner fileIn = new Scanner(file);
        ArrayList<String> lines = new ArrayList<>();

        String template = fileIn.nextLine();
        fileIn.nextLine();

        while (fileIn.hasNext()) {
            lines.add(fileIn.nextLine());
        }
        fileIn.close();
        System.out.printf("%s : %s%n",template, lines);

        String[] pairs = new String[lines.size()];
        String[] insert = new String[lines.size()];

        for(int i=0; i<pairs.length; i++) {
            String rule = lines.get(i);
            String[] split = rule.split(" -> ");
            pairs[i] = split[0];
            insert[i] = split[1];
        }

        //loop for 10 steps
        for(int i=0; i<10; i++) {
            StringBuilder newTemplate = new StringBuilder();
            for(int c=1; c<template.length(); c++) {
                String pair = template.substring(c-1, c+1);
                int index = -1;
                for(int j=0; j<pairs.length; j++) {
                    if(pairs[j].equals(pair)) {
                        index = j;
                        break;
                    }
                }
                if(index != -1)
                    pair = String.format("%c%s", pair.charAt(0), insert[index]);
                newTemplate.append(pair);
            }
            newTemplate.append(template.substring(template.length()-1));
            template = newTemplate.toString();
            System.out.printf("Step %d - %s%n",i+1, template);
        }

        int answer = 0;


    }
}