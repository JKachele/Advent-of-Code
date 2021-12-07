package com.jkachele.aoc._2021.day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day3b {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("E:\\JavaProjects\\AdventOfCode\\src\\com\\jkachele\\aoc\\_2021\\day3\\input.txt");
        Scanner fileIn = new Scanner(file);
        ArrayList<String> lines = new ArrayList<>();

        while (fileIn.hasNext()) {
            lines.add(fileIn.nextLine());
        }
        fileIn.close();

        System.out.println(lines);

        //find the Oxygen rating
        ArrayList<String> oxygenRatingLines = new ArrayList<>(lines);
        for(int i=0; i<12; i++) {
            if(oxygenRatingLines.size() == 1)
                break;
            removeInvalid(oxygenRatingLines, i, moreOnes(oxygenRatingLines, i));
        }
        String oxygenRatingBin = oxygenRatingLines.get(0);
        int oxygenRating = Integer.parseInt(oxygenRatingBin, 2);

        //find the CO2 rating
        ArrayList<String> co2RatingLines = new ArrayList<>(lines);
        for(int i=0; i<12; i++) {
            if(co2RatingLines.size() == 1)
                break;
            removeInvalid(co2RatingLines, i, !moreOnes(co2RatingLines, i));
        }
        String co2RatingBin = co2RatingLines.get(0);
        int co2Rating = Integer.parseInt(co2RatingBin, 2);

        int lifeSupportRating = oxygenRating * co2Rating;

        System.out.printf("Oxygen Binary: %s   Oxygen Decimal: %d%n", oxygenRatingBin, oxygenRating);
        System.out.printf("CO2 Binary: %s   CO2 Decimal: %d%n", co2RatingBin, co2Rating);
        System.out.printf("Life Support Rating: %d%n", lifeSupportRating);

    }

    //calculates if there are more ones in a specified position in the list of values
    public static boolean moreOnes(ArrayList<String> lines, int place) {
        int numOnes = 0;
        int numZeros = 0;

        for(String line: lines) {
            if(line.charAt(place) == '1')
                numOnes += 1;
            else
                numZeros += 1;
        }

        return numOnes >= numZeros;
    }

    //removes all values from the list if the specified position doesn't match the given bit
    public static void removeInvalid(ArrayList<String> lines, int place, boolean one) {
        StringBuilder regexBuild = new StringBuilder();

        //builds the regex, so it tests if a specific bit in the line matches the boolean
        for(int i=0; i<12; i++) {
            if(i != place)
                regexBuild.append("\\d");
            else
            if(one)
                regexBuild.append('1');
            else
                regexBuild.append('0');
        }

        String regex = regexBuild.toString();

        //removes all lines that don't match the regex
        lines.removeIf(line -> !line.matches(regex));

    }

}