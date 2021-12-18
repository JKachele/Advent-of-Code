package com.jkachele.aoc._2021.day13;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day13a {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/com/jkachele/aoc/_2021/day13/input.txt");
        Scanner fileIn = new Scanner(file);
        ArrayList<String> lines = new ArrayList<>();

        while (fileIn.hasNext())
            lines.add(fileIn.nextLine());
        fileIn.close();
        System.out.println(lines);

        ArrayList<Integer[]> dots = new ArrayList<>();

        //loop to get the coordinates of the dots into an integer array and to determine the largest position of a dot
        int maxNum = 0;
        int lineNum = 0;
        while(!lines.get(lineNum).isEmpty()) {
            String line = lines.get(lineNum);
            String[] dotString = line.split(",");
            int x = Integer.parseInt(dotString[0]);
            int y = Integer.parseInt(dotString[1]);
            if(x > maxNum)
                maxNum = x;
            else if(y > maxNum)
                maxNum = y;
            Integer[] dot = {x, y};
            dots.add(dot);
            lineNum++;
        }

        boolean[][] paper = new boolean[maxNum][maxNum];

        for(Integer[] dot : dots) {
            paper[dot[0]][dot[1]] = true;
        }
    }
}
