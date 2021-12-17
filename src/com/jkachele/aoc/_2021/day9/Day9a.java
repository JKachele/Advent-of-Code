package com.jkachele.aoc._2021.day9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day9a {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/com/jkachele/aoc/_2021/day9/input.txt");
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

        for(int[] height : heights)
            System.out.println(Arrays.toString(height));

        int riskSum = 0;

        final int[][] offsets = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};

        for(int i=0; i<heights.length; i++) {
            for(int j=0; j<heights[i].length; j++) {
                boolean lower = true;
                for(int[] offset: offsets) {
                    try {
                        if(heights[i][j] >= heights[i+offset[0]][j+offset[1]]) {
                            lower = false;
                            break;
                        }
                    } catch (Exception e) {
                        System.out.print(".");
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