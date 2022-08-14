package com.jkachele.aoc._2020.day2;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class Day2a {

    public static void main(String[] args) throws Exception{
        Scanner fileIn = new Scanner(new File("src/com/jkachele/aoc/_2020/day2/input.txt"));
        ArrayList<String> input = new ArrayList<>();
        ArrayList<Integer> rangeH = new ArrayList<>();
        ArrayList<Integer> rangeL = new ArrayList<>();
        ArrayList<String> character = new ArrayList<>();
        ArrayList<String> pwd = new ArrayList<>();
        int count;
        int countPwd = 0;

        while(fileIn.hasNext()) {
            input.add(fileIn.nextLine());
        }

        for(int i = 0; i < input.size(); i++) {
            input.set(i, input.get(i).replace('-', ' '));
            input.set(i, input.get(i).replace(':', ' '));
        }

        for(int i = 0; i < input.size(); i++) {
            Scanner seperate = new Scanner(input.get(i));
            rangeL.add(seperate.nextInt());
            rangeH.add(seperate.nextInt());
            character.add(seperate.next());
            pwd.add(seperate.next());
        }

        for(int i = 0; i < pwd.size(); i++) {
            count = countChar(pwd.get(i), character.get(i).charAt(0));
            if(count >= rangeL.get(i) && count <= rangeH.get(i)) {
                countPwd++;
            }
        }

        System.out.println(input);
        System.out.println(rangeL);
        System.out.println(rangeH);
        System.out.println(character);
        System.out.println(pwd);
        System.out.println(countPwd);

    }

    public static int countChar(String str, char c)
    {
        int count = 0;

        for(int i=0; i < str.length(); i++)
        {    if(str.charAt(i) == c)
            count++;
        }

        return count;
    }
}