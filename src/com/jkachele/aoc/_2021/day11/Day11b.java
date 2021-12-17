package com.jkachele.aoc._2021.day11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day11b {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/com/jkachele/aoc/_2021/day11/input.txt");
        Scanner fileIn = new Scanner(file);
        ArrayList<String> lines = new ArrayList<>();

        while (fileIn.hasNext()) {
            lines.add(fileIn.nextLine());
        }
        fileIn.close();
        System.out.println(lines);

        int[][] energy = new int[lines.size()][lines.get(0).length()];

        for(int i=0; i<lines.size(); i++) {
            String line = lines.get(i);
            char[] chars = line.toCharArray();
            for(int j=0; j<chars.length; j++) {
                energy[i][j] = Integer.parseInt(String.valueOf(chars[j]));
            }
        }

        for(int[] row: energy)
            System.out.println(Arrays.toString(row));

        int[][] surroundOffsets = {{-1, -1}, {0, -1}, {1, -1}, {-1, 0}, {1, 0}, {-1, 1}, {0, 1}, {1, 1}};

        //Loops until all flash, 10 = needs to be lit, 11 = already been lit
        int cycles = 0;
        while(!allEquals(energy, 0)) {
            //increase all by one
            for (int x = 0; x < energy.length; x++) {
                for (int y = 0; y < energy[x].length; y++) {
                    energy[x][y]++;
                }
            }

            while (contains(energy, 10)) {
                for (int x = 0; x < energy.length; x++) {
                    for (int y = 0; y < energy[x].length; y++) {
                        if (energy[x][y] == 10) {
                            //increase surrounding octopuses
                            for (int[] o : surroundOffsets) {
                                try {
                                    if (energy[x + o[0]][y + o[1]] != 10 && energy[x + o[0]][y + o[1]] != 11)
                                        energy[x + o[0]][y + o[1]]++;
                                } catch (Exception e) {
                                    System.out.print(".");
                                }
                            }
                            energy[x][y] = 11;
                        }
                    }
                }
            }

            //set all that flashed to 0
            for (int x = 0; x < energy.length; x++) {
                for (int y = 0; y < energy[x].length; y++) {
                    if (energy[x][y] == 11)
                        energy[x][y] = 0;
                }
            }
            cycles++;
        }

        System.out.println();
        System.out.println(cycles);

    }

    public static boolean contains(int[][] array, int test) {
        for(int[] row: array) {
            for(int element: row) {
                if(element == test)
                    return true;
            }
        }
        return false;
    }

    public static boolean allEquals(int[][] array, int test) {
        for(int[] row: array) {
            for(int element: row) {
                if(element != test)
                    return false;
            }
        }
        return true;
    }

}