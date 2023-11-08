package com.jkachele.aoc._2020.day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day6a {
    public static void main(String[] args) throws FileNotFoundException {
        File input = new File("src/com/jkachele/aoc/_2020/day6/input.txt");
        Scanner fileIn = new Scanner(input);
        ArrayList<String> lines = new ArrayList<>();

        while (fileIn.hasNext())
            lines.add(fileIn.nextLine());
        fileIn.close();
        System.out.println(lines);

        //groups are seperated into their own arraylists
        ArrayList<ArrayList<String>> groups = new ArrayList<>();
        ArrayList<String> temp = new ArrayList<>();
        for (String line : lines) {
            if(line.length() != 0) {
                temp.add(line);
            } else {
                ArrayList<String> add = new ArrayList<>(temp);
                groups.add(add);
                temp.clear();
            }
        }
        groups.add(temp);

        //removed duplicate answers from the groups
        ArrayList<ArrayList<Character>> groupAnswers = new ArrayList<>();
        for (int i = 0; i < groups.size(); i++) {
            ArrayList<Character> answers = new ArrayList<>();
            //adds all the answers of first person in group
            for (int j = 0; j < groups.get(i).get(0).length(); j++) {
                answers.add(groups.get(i).get(0).charAt(j));
            }
            //adds the answers of the remaining group if it isn't already counted
            for(int j = 1; j < groups.get(i).size(); j++) {
                for (int k = 0; k < groups.get(i).get(j).length(); k++) {
                    char answer = groups.get(i).get(j).charAt(k);
                    if(!answers.contains(answer)) {
                        answers.add(answer);
                    }
                }
            }
            groupAnswers.add(answers);
        }
        for(ArrayList<Character> answer : groupAnswers) {
            System.out.println(answer);
        }

        //counts number os answers in the groups
        int[] answerCount = new int[groups.size()];
        for (int i = 0; i < groupAnswers.size(); i++) {
            answerCount[i] = groupAnswers.get(i).size();
        }

        //sum of all the answers in the groups
        int sum = 0;
        for (int j : answerCount) {
            sum += j;
        }
        System.out.println("Answer sum: " + sum);
    }
}
