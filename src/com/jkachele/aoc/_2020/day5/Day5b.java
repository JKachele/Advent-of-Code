package com.jkachele.aoc._2020.day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day5b {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/com/jkachele/aoc/_2020/day5/input.txt");
        Scanner fileIn = new Scanner(file);
        ArrayList<String> lines = new ArrayList<>();

        while (fileIn.hasNext()) {
            lines.add(fileIn.nextLine());
        }
        fileIn.close();
        System.out.println(lines);

        //loops through the lines separating each seat into its own array of pointers
        char[][] seatPointer = new char[lines.size()][lines.get(0).length()];
        for(int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            for(int j = 0; j < line.length(); j++) {
                seatPointer[i][j] = line.charAt(j);
            }
        }
        System.out.println(Arrays.deepToString(seatPointer));

        //uses pointers to determine seat row and column
        int[][] seatNumber = new int[lines.size()][2];
        for(int i = 0; i < seatPointer.length; i++) {
            //determine seat row using first 7 chars of pointer
            int row = 0;
            for(int j = 0; j < 7; j++) {
                if(seatPointer[i][j] == 'B') {
                    /*uses binary to determine seat row
                    If the first pointer is 'B', is means the seat is in the last 64 seats,
                    so 64 is added to the seat row
                    */
                    double binaryMultiplier = Math.pow(2, 6 - j);
                    row += binaryMultiplier;
                }
            }

            //determine seat column using the last 3 chars of pointer
            int column = 0;
            for(int j = 7; j < 10; j++) {
                if(seatPointer[i][j] == 'R') {
                    /*uses binary to determine seat row
                    If the first pointer is 'R', is means the seat is in the last 4 seats,
                    so 4 is added to the seat row
                    */
                    double binaryMultiplier = Math.pow(2, 9 - j);
                    column += binaryMultiplier;
                }
            }
            seatNumber[i][0] = row;
            seatNumber[i][1] = column;
        }
        System.out.println(Arrays.deepToString(seatNumber));

        //determine seat id
        int[] seatID = new int[lines.size()];
        for(int i = 0; i < seatNumber.length; i++) {
            //calculate seat id be multiplying seat row by 8 and adding the column
            seatID[i] = (seatNumber[i][0] * 8) + seatNumber[i][1];
        }
        System.out.println(Arrays.toString(seatID));

        //sort list of IDs using quicksort
        quicksort(seatID, 0, seatID.length - 1);
        System.out.println(Arrays.toString(seatID));

        //determine missing ID
        int missingID = 0;
        for(int i = 0; i < seatID.length - 1; i++) {
            if(seatID[i] + 1 != seatID[i + 1]) {
                missingID = seatID[i] + 1;
                break;
            }
        }

        System.out.println(missingID);

    }

    private static void quicksort(int[] numbers, int lowIndex, int highIndex) {
        if(lowIndex < highIndex) {
            int partitionIndex = partition(numbers, lowIndex, highIndex);

            quicksort(numbers, lowIndex, partitionIndex - 1);
            quicksort(numbers, partitionIndex + 1, highIndex);
        }
    }

    //partitions array section and returns index of pivot
    private static int partition(int[] numbers, int lowIndex, int highIndex) {
        //pivot is the last number in the array
        int pivot = numbers[highIndex];

        int lowPointer = lowIndex;
        int highPointer = highIndex;

        while(lowPointer < highPointer) {
            //increments low pointer until the element is greater than the pivot or until it reaches the high pointer
            while(numbers[lowPointer] <= pivot && lowPointer < highPointer){
                lowPointer++;
            }
            //increments high pointer until the element is less than the pivot or until it reaches the low pointer
            while(numbers[highPointer] >= pivot && lowPointer < highPointer){
                highPointer--;
            }
            swapElements(numbers, lowPointer, highPointer);
        }
        //once the pointers are pointing at the same number, that number is swapped with the pivot placing
        //it in its final position
        swapElements(numbers, lowPointer, highIndex);

        //the pointers are now pointing at the pivot so its index is returned
        return lowPointer;
    }

    private static void swapElements(int[] numbers, int lowIndex, int highIndex) {
        int temp = numbers[lowIndex];
        numbers[lowIndex] = numbers[highIndex];
        numbers[highIndex] = temp;
    }
}