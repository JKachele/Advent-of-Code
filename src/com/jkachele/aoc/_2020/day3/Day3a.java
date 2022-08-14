package com.jkachele.aoc._2020.day3;

import java.io.File;
import java.util.Scanner;

public class Day3a {

    public static void main(String[] args) throws Exception{

        File input = new File("src/com/jkachele/aoc/_2020/day3/input.txt");

        Scanner fileSizeCounter = new Scanner(input);
        int Lines = 0;
        int Length = 0;
        while(fileSizeCounter.hasNext()) {
            String temp = fileSizeCounter.next();
            Length  = temp.length();
            Lines++;
        }
        fileSizeCounter.close();

        Scanner fileIn = new Scanner(input);
        char field[][] = new char[Lines][Length];

        for(int i = 0; i < Lines; i++) {
            String line = fileIn.next();
            for(int j = 0; j < Length; j++) {
                field[i][j] = line.charAt(j);
            }
        }

        int trees = 0;

        for(int y = 0; y < Lines; y++) {
            int x = (y * 3) % Length;
            if(field[y][x] == '#')
                trees++;
        }

        System.out.println(trees);

		/*
		for(int i = 0; i < Lines; i++) {
			for(int j = 0; j < Length; j++) {
				System.out.print(field[i][j]);
			}
			System.out.println();
		}
		*/
    }
}
