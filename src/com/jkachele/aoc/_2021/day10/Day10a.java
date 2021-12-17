package com.jkachele.aoc._2021.day10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Day10a {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/com/jkachele/aoc/_2021/day10/input.txt");
        Scanner fileIn = new Scanner(file);
        ArrayList<String> lines = new ArrayList<>();

        while (fileIn.hasNext()) {
            lines.add(fileIn.nextLine());
        }
        fileIn.close();
        System.out.println(lines);

        String openChars = "([{<";
        int totalErrorScore = 0;

        for(String line : lines) {
            Stack<Character> stack = new Stack<>();
            for(int i=0; i<line.length(); i++) {
                char c = line.charAt(i);
                int errorScore = 0;
                if(openChars.indexOf(c) != -1) {
                    stack.add(c);
                } else {
                    if(!stack.isEmpty()) {
                        switch (c) {
                            case ')':
                                if (stack.peek() == '(')
                                    stack.pop();
                                else
                                    errorScore = 3;
                                break;
                            case ']':
                                if (stack.peek() == '[')
                                    stack.pop();
                                else
                                    errorScore = 57;
                                break;
                            case '}':
                                if (stack.peek() == '{')
                                    stack.pop();
                                else
                                    errorScore = 1197;
                                break;
                            case '>':
                                if (stack.peek() == '<')
                                    stack.pop();
                                else
                                    errorScore = 25137;
                                break;
                            default:
                                System.out.println("Error!");
                        }
                        if(errorScore != 0) {
                            totalErrorScore += errorScore;
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(totalErrorScore);

    }
}