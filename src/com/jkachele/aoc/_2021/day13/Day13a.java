package com.jkachele.aoc._2021.day13;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
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
        int lineNum = 0;
        int maxNum = 0;
        while(!lines.get(lineNum).isEmpty()) {
            String line = lines.get(lineNum);
            String[] dotString = line.split(",");
            int x = Integer.parseInt(dotString[0]);
            int y = Integer.parseInt(dotString[1]);
            if(x > maxNum || y > maxNum)
                maxNum = Math.max(x, y);
            Integer[] dot = {x, y};
            dots.add(dot);
            lineNum++;
        }

        lineNum++;

        ArrayList<Integer[]> folds = new ArrayList<>();

        while(lineNum < lines.size()) {
            String foldString = lines.get(lineNum).substring(11);
            String[] fold = foldString.split("=");
            Integer[] foldInt = new Integer[2];

            if(fold[0].equals("x"))
                foldInt[0] = 0;
            else if(fold[0].equals("y"))
                foldInt[0] = 1;

            foldInt[1] = Integer.parseInt(fold[1]);
            folds.add(foldInt);

            lineNum++;
        }

        for(Integer[] fold : folds) {
            System.out.printf("%s", Arrays.toString(fold));
        }

        boolean[][] paper = new boolean[maxNum + 1][maxNum + 1];

        for(Integer[] dot : dots)
            paper[dot[0]][dot[1]] = true;


    }

    public boolean[][] fold(boolean[][] paper, boolean x, int fold) {
        boolean[][] newPaper;
        if(x) {
            newPaper = new boolean[fold - 1][paper[0].length];
            for(int i = fold - 1; i >= 0; i++) {

            }
        } else {
            newPaper = new boolean[paper.length][fold - 1];
        }

        return newPaper;
    }
}
