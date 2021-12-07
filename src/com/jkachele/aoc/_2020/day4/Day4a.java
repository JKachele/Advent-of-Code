package com.jkachele.aoc._2020.day4;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Day4a {

    public static void main(String[] args) throws Exception{
        Scanner fileIn = new Scanner(new File("Text Docs\\2020Day4.txt"));
        ArrayList<String> passports = new ArrayList<>();

        while(fileIn.hasNext()) {
            String temp = "";
            String input;
            while(!(input = fileIn.nextLine()).equals("")) {
                input.replace(':', ' ');
                temp.concat(" "+input);
                passports.add(temp);
            }
        }

        System.out.println(passports);

    }
}