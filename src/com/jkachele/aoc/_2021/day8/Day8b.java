package com.jkachele.aoc._2021.day8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day8b {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("E:\\JavaProjects\\Advent-of-Code\\src\\com\\jkachele\\aoc\\_2021\\day8\\input.txt");
        Scanner fileIn = new Scanner(file);
        ArrayList<String> lines = new ArrayList<>();

        while(fileIn.hasNext()) {
            lines.add(fileIn.nextLine());
        }
        fileIn.close();
        System.out.println(lines);

        String[][] inDigits = new String[lines.size()][10];
        //String[][] outDigits = new String[lines.size()][4];

        for(int i=0; i<lines.size(); i++) {
            String[] values = lines.get(i).split(" \\| ");
            String[] inputValues = values[0].split(" ");
            //String[] outputValues = values[1].split(" ");
            inDigits[i] = inputValues;
            //outDigits[i] = outputValues;
        }

        for(String[] inDigit : inDigits) {
            String[] key = getKey(inDigit);
            System.out.println(Arrays.toString(key));
        }
    }

    public static String[] getKey(String[] digits) {
        String[] key = new String[10];
        ArrayList<String> unknownDigits = new ArrayList<>();
        //Set the 4 known digits: 1, 4, 7, and 8
        for(String digit : digits) {
            switch(digit.length()) {
                case 2 -> key[1] = digit;
                case 3 -> key[7] = digit;
                case 4 -> key[4] = digit;
                case 7 -> key[8] = digit;
                default -> unknownDigits.add(digit);
            }
        }

        //sets 2, 5, and 6
        char one1 = key[1].charAt(0);
        char one2 = key[1].charAt(1);
        ArrayList<String> twoFiveSix = new ArrayList<>();
        for(String digit : unknownDigits) {
            if((digit.contains(String.valueOf(one1)) && !digit.contains(String.valueOf(one2))) ||
                    (digit.contains(String.valueOf(one2)) && !digit.contains(String.valueOf(one1))))
                twoFiveSix.add(digit);
        }
        char segmentF = 0;
        for(String digit : twoFiveSix) {
            if(digit.length() == 6) {
                key[6] = digit;
                unknownDigits.remove(digit);
                if(digit.contains(String.valueOf(one1)))
                    segmentF = one1;
                else
                    segmentF = one2;
            }
        }
        for(String digit : twoFiveSix) {
            if(digit.contains(String.valueOf(segmentF))) {
                key[5] = digit;
                unknownDigits.remove(digit);
            }
            else {
                key[2] = digit;
                unknownDigits.remove(digit);
            }
        }

        //sets 3
        for(String digit : unknownDigits) {
            if(digit.length() == 5) {
                key[3] = digit;
                unknownDigits.remove(digit);
            }
        }

        //sets last 2: 0 and 9
        char[] fourSegments = new char[4];
        for(int i=0; i<4; i++)
            fourSegments[i] = key[4].charAt(i);
        boolean is9 = true;
        for(char c: fourSegments) {
            if(!unknownDigits.get(0).contains(String.valueOf(c))) {
                is9 = false;
                break;
            }
        }
        if(is9) {
            key[9] = unknownDigits.get(0);
            key[0] = unknownDigits.get(1);
        } else {
            key[0] = unknownDigits.get(0);
            key[9] = unknownDigits.get(1);
        }

        return key;
    }
}