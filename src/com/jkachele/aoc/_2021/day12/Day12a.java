package com.jkachele.aoc._2021.day12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day12a {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/com/jkachele/aoc/_2021/day12/input.txt");
        Scanner fileIn = new Scanner(file);
        ArrayList<String> lines = new ArrayList<>();

        while (fileIn.hasNext()) {
            lines.add(fileIn.nextLine());
        }
        fileIn.close();
        System.out.println(lines);

        String[][] connections = new String[lines.size()][2];
        for(int i=0; i<lines.size(); i++) {
            connections[i] = lines.get(i).split("-");
        }

        HashMap<String, Cave> caves = new HashMap<>();
        for(String[] connection: connections) {
            for(String caveName: connection) {
                boolean large = Character.isUpperCase(caveName.charAt(0));
                Cave cave = new Cave(caveName, large);
                if(caveName.equals("start"))
                    cave.setStart(true);
                else if(caveName.equals("end"))
                    cave.setEnd(true);
                caves.putIfAbsent(caveName, cave);
            }
        }

        for(String[] connection: connections) {
            caves.get(connection[0]).addConnectingCave(caves.get(connection[1]));
            caves.get(connection[1]).addConnectingCave(caves.get(connection[0]));
        }

        for(Map.Entry<String, Cave> entry: caves.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().printConnectingCaves());
        }

    }
}