package com.jkachele.aoc._2021.day9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day9a {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("E:\\JavaProjects\\Advent-of-Code\\src\\com\\jkachele\\aoc\\_2021\\day9\\input.txt");
        Scanner fileIn = new Scanner(file);
        ArrayList<String> lines = new ArrayList<>();

        while (fileIn.hasNext()) {
            lines.add(fileIn.nextLine());
        }
        fileIn.close();
        System.out.println(lines);

        int[][] heights = new int[lines.size()][lines.get(0).length()];

        for(int i=0; i<lines.size(); i++) {
            String line = lines.get(i);
            char[] chars = line.toCharArray();
            for(int j=0; j<chars.length; j++) {
                heights[i][j] = Integer.parseInt(String.valueOf(chars[j]));
            }
        }

        int maxX = heights.length;
        int maxY = heights[0].length;
        int riskSum = 0;

        final int[][] offsets = {{1, 1}, {1, 1}};

        for(int i=0; i<maxX; i++) {
            for(int j=0; j<maxY; j++) {
                boolean lower = true;
                for(int k=i-1; k<=i+1; k++) {
                    for(int l=j-1; l<=j+1; l++) {
                        try {
                            if(i!=k && j!=l && heights[i][j] >= heights[k][l]) {
                                lower = false;
                            }
                        } catch (Exception e) {
                            System.out.print(".");
                        }
                    }
                }
                if(lower) {
                    riskSum += 1 + heights[i][j];
                }
            }
        }

        System.out.println();
        System.out.println(riskSum);
    }
}