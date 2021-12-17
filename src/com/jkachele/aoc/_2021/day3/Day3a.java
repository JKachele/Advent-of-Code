package com.jkachele.aoc._2021.day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day3a {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/com/jkachele/aoc/_2021/day3/input.txt");
        Scanner fileIn = new Scanner(file);
        ArrayList<String> lines = new ArrayList<>();

        while (fileIn.hasNext()) {
            lines.add(fileIn.nextLine());
        }
        fileIn.close();

        System.out.println(lines);

        int[] numOnes = new int[12];
        int[] numZeros = new int[12];
        char[] gammaChars = new char[12];
        char[] epsilonChars = new char[12];

        for(String line: lines) {
            for(int i=0; i<line.length(); i++) {
                if(line.charAt(i) == '1')
                    numOnes[i] += 1;
                else
                    numZeros[i] += 1;
            }
        }

        for(int i=0; i<numOnes.length; i++) {
            if(numOnes[i] > numZeros[i]) {
                gammaChars[i] = '1';
                epsilonChars[i] = '0';
            }
            else {
                gammaChars[i] = '0';
                epsilonChars[i] = '1';
            }
        }

        String gammaBits = new String(gammaChars);
        String epsilonBits = new String(epsilonChars);

        int gamma = Integer.parseInt(gammaBits, 2);
        int epsilon = Integer.parseInt(epsilonBits, 2);

        int power = gamma * epsilon;

        System.out.printf("Gamma Binary: %s   Gamma Decimal: %d%n", gammaBits, gamma);
        System.out.printf("Epsilon Binary: %s   Epsilon Decimal: %d%n", epsilonBits, epsilon);
        System.out.printf("Power Consumption: %d%n", power);

    }
}