package com.jkachele.aoc._2021.day10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class Day10b {
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
        ArrayList<Long> completionScores = new ArrayList<>();

        for(String line : lines) {
            Stack<Character> stack = new Stack<>();
            boolean corrupted = false;
            for(int i=0; i<line.length(); i++) {
                char c = line.charAt(i);
                if(openChars.indexOf(c) != -1) {
                    stack.add(c);
                } else {
                    if(!stack.isEmpty()) {
                        switch (c) {
                            case ')':
                                if (stack.peek() == '(')
                                    stack.pop();
                                else
                                    corrupted = true;
                                break;
                            case ']':
                                if (stack.peek() == '[')
                                    stack.pop();
                                else
                                    corrupted = true;
                                break;
                            case '}':
                                if (stack.peek() == '{')
                                    stack.pop();
                                else
                                    corrupted = true;
                                break;
                            case '>':
                                if (stack.peek() == '<')
                                    stack.pop();
                                else
                                    corrupted = true;
                                break;
                            default:
                                System.out.println("Error!");
                        }
                    }
                }
                if(corrupted)
                    break;
            }

            if(!corrupted && !stack.isEmpty())
                completionScores.add(getCompletionScore(stack));
        }

        Collections.sort(completionScores);
        System.out.println(completionScores);
        System.out.println(completionScores.size());
        long winner = completionScores.get(((completionScores.size() + 1) / 2) - 1);
        System.out.println(winner);

    }

    public static long getCompletionScore(Stack<Character> stack) {
        long score = 0;
        String openChars = "([{<";
        while(!stack.isEmpty()) {
            char c = stack.pop();
            if(openChars.indexOf(c) != -1) {
                switch (c) {
                    case '(' -> {
                        score = score * 5;
                        score += 1;
                    }
                    case '[' -> {
                        score = score * 5;
                        score += 2;
                    }
                    case '{' -> {
                        score = score * 5;
                        score += 3;
                    }
                    case '<' -> {
                        score = score * 5;
                        score += 4;
                    }
                    default -> System.out.println("Error!");
                }
            } else
                stack.pop();
        }

        return score;
    }
}