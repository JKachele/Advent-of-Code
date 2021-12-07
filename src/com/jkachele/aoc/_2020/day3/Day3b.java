package com.jkachele.aoc._2020.day3;

import java.io.File;
import java.util.Scanner;

public class Day3b {

    public static void main(String[] args) throws Exception{
        Scanner tempFileIn = new Scanner(new File("Text Docs\\2020Day3.txt"));
        int Lines = 0;
        int Length = 0;
        while(tempFileIn.hasNext()) {
            String temp = tempFileIn.next();
            Length  = temp.length();
            Lines++;
        }
        tempFileIn.close();
        Scanner fileIn = new Scanner(new File("Text Docs\\2020Day3.txt"));
        char field[][] = new char[Lines][Length];

        for(int i = 0; i < Lines; i++) {
            String line = fileIn.next();
            for(int j = 0; j < Length; j++) {
                field[i][j] = line.charAt(j);
            }
        }

        long trees11 = 0;
        long trees31 = 0;
        long trees51 = 0;
        long trees71 = 0;
        long trees12 = 0;

        for(int y = 0; y < Lines; y += 1) {
            int x = (y * 1) % Length;
            if(field[y][x] == '#')
                trees11++;
        }

        for(int y = 0; y < Lines; y++) {
            int x = (y * 3) % Length;
            if(field[y][x] == '#')
                trees31++;
        }

        for(int y = 0; y < Lines; y += 1) {
            int x = (y * 5) % Length;
            if(field[y][x] == '#')
                trees51++;
        }

        for(int y = 0; y < Lines; y += 1) {
            int x = (y * 7) % Length;
            if(field[y][x] == '#')
                trees71++;
        }

        for(int y = 0; y < Lines; y += 2) {
            int x = (y / 2) % Length;
            if(field[y][x] == '#')
                trees12++;
        }

        long answer = trees11 * trees31 * trees51 * trees71 * trees12;
        System.out.println(trees11+", "+trees31+", "+trees51+", "+trees71+", "+trees12);
        System.out.println(answer);
        fileIn.close();

    }
}