package com.jkachele.aoc._2021.day12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day12a {

    private static int numPaths = 0;

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
        Cave startCave = new Cave();
        Cave endCave = new Cave();
        for(String[] connection: connections) {
            for(String caveName: connection) {
                boolean large = Character.isUpperCase(caveName.charAt(0));
                Cave cave = new Cave(caveName, large);
                if(caveName.equals("start")) {
                    cave.setStart(true);
                    startCave = cave;
                }
                else if(caveName.equals("end")) {
                    cave.setEnd(true);
                    endCave = cave;
                }
                caves.putIfAbsent(caveName, cave);
            }
        }

        for(String[] connection: connections) {
            caves.get(connection[0]).addConnectingCave(caves.get(connection[1]));
            caves.get(connection[1]).addConnectingCave(caves.get(connection[0]));
        }

        for(Map.Entry<String, Cave> entry: caves.entrySet()) {
            Cave cave = entry.getValue();
            if(cave.getName().equals("start")) {
                cave.setStart(true);
                startCave = cave;
            }
            else if(cave.getName().equals("end")) {
                cave.setEnd(true);
                endCave = cave;
            }
        }

        for(Map.Entry<String, Cave> entry: caves.entrySet()) {
            System.out.printf("[%s: %s] ", entry.getKey(), entry.getValue().printConnectingCaves());
        }

        ArrayList<Cave> path = new ArrayList<>();
        path.add(startCave);
        printAllPaths(startCave, endCave, caves, path);

        System.out.println(numPaths);

    }

    public static void printAllPaths(Cave current, Cave end, HashMap<String, Cave> caves, ArrayList<Cave> path) {

        if(current.equals(end)) {
            System.out.println(path);
            numPaths++;
            return;
        }

        current.visit();

        for(Cave i: current.getConnectingCaves()) {
            if(!i.isVisited()) {
                path.add(i);
                printAllPaths(i, end, caves, path);
                path.remove(i);
            }
        }

        current.setVisited(false);
    }
}