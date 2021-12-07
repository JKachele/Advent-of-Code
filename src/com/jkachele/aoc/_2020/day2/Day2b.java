package com.jkachele.aoc._2020.day2;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Day2b {
    public static void main(String[] args) throws Exception{
        Scanner fileIn = new Scanner(new File("Text Docs\\2020Day2.txt"));
        ArrayList<String> input = new ArrayList<>();
        ArrayList<Integer> indexH = new ArrayList<>();
        ArrayList<Integer> indexL = new ArrayList<>();
        ArrayList<String> character = new ArrayList<>();
        ArrayList<String> pwd = new ArrayList<>();
        int countPwd = 0;
        int indH, indL;
        char pwdChar;

        while(fileIn.hasNext()) {
            input.add(fileIn.nextLine());
        }

        for(int i = 0; i < input.size(); i++) {
            input.set(i, input.get(i).replace('-', ' '));
            input.set(i, input.get(i).replace(':', ' '));
        }

        for(int i = 0; i < input.size(); i++) {
            Scanner seperate = new Scanner(input.get(i));
            indexL.add(seperate.nextInt());
            indexH.add(seperate.nextInt());
            character.add(seperate.next());
            pwd.add(seperate.next());
        }

        for(int i = 0; i < pwd.size(); i++) {
            indL = indexL.get(i) - 1;
            indH = indexH.get(i) - 1;
            pwdChar = character.get(i).charAt(0);
            if(pwd.get(i).contains(character.get(i))){
                if((pwd.get(i).indexOf(pwdChar, indL) == indL) ^ (pwd.get(i).indexOf(pwdChar, indH) == indH)) {
                    countPwd++;
                }
            }
        }

        System.out.println(input);
        System.out.println(indexL);
        System.out.println(indexH);
        System.out.println(character);
        System.out.println(pwd);
        System.out.println(countPwd);
        fileIn.close();

    }
}
