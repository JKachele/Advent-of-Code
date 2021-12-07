package com.jkachele.aoc._2019.day2;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Day2a {

    public static void main(String[] args) throws Exception{
        Scanner fileIn = new Scanner(new File("Text Docs\\2019Day2.txt"));
        ArrayList<Integer> code = new ArrayList<>();

        String input = fileIn.nextLine();
        boolean quit = false;
        boolean error = false;
        String intcode = input.replace(',', ' ');
        Scanner codeRead = new Scanner(intcode);

        while(codeRead.hasNextInt()) {
            code.add(codeRead.nextInt());
        }

        codeRead.close();

        code.set(1, 12);
        code.set(2, 2);

        //System.out.println(code.size());
        for(int i = 0; i < code.size(); i += 4) {
            int opcode = code.get(i);
            //System.out.print(i+", "+opcode+": ");
            switch(opcode) {
                case 1:
                    code.set(i+3, add(code, code.get(i+1), code.get(i+2)));
                    System.out.println(i+" sum of "+code.get(i+3)+" at "+(i+3));
                    break;
                case 2:
                    code.set(i+3, mult(code, code.get(i+1), code.get(i+2)));
                    System.out.println(i+" prod of "+code.get(i+3)+" at "+(i+3));
                    break;
                case 99:
                    quit = true;
                    break;
                default:
                    System.out.println("Error at Index "+i);
                    quit = true;
                    error = true;
                    break;
            }
            if(quit)
                break;
        }

        if(!error) {
            System.out.println(code.get(0));
            System.out.println(code);
        }

    }

    public static int add (ArrayList<Integer> array, int num1, int num2) {
        int sum = num1 + num2;
        return sum;
    }

    public static int mult (ArrayList<Integer> array, int num1, int num2) {
        int prod = num1 * num2;
        return prod;
    }

}