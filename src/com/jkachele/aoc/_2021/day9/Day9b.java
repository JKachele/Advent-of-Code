package com.jkachele.aoc._2021.day9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day9b {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/com/jkachele/aoc/_2021/day9/input.txt");
        Scanner fileIn = new Scanner(file);
        ArrayList<String> lines = new ArrayList<>();

        while (fileIn.hasNext()) {
            lines.add(fileIn.nextLine());
        }
        fileIn.close();
        System.out.println(lines);

        Point[][] points = new Point[lines.size()][lines.get(0).length()];

        for(int i=0; i<lines.size(); i++) {
            String line = lines.get(i);
            char[] chars = line.toCharArray();
            for(int j=0; j<chars.length; j++) {
                points[i][j] = new Point(i, j, Integer.parseInt(String.valueOf(chars[j])));
            }
        }

        final int[][] offsets = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};

        ArrayList<Point> lowPoints = new ArrayList<>();

        for(int i=0; i<points.length; i++) {
            for(int j=0; j<points[i].length; j++) {
                boolean lower = true;
                for(int[] offset: offsets) {
                    try {
                        if(points[i][j].getHeight() >= points[i+offset[0]][j+offset[1]].getHeight()) {
                            lower = false;
                            break;
                        }
                    } catch (Exception e) {
                        System.out.print(".");
                    }
                }
                if(lower) {
                    lowPoints.add(points[i][j]);
                }
            }
        }

        System.out.println();
        for(Point i : lowPoints)
            System.out.print(i+", ");
        System.out.println();

        ArrayList<Integer> basins = new ArrayList<>();

        for(Point point : lowPoints) {
            int basinSize = 0;
            Queue<Point> open = new LinkedList<>();
            ArrayList<Point> visited = new ArrayList<>();
            open.add(point);
            visited.add(point);
            while(!open.isEmpty()) {
                ArrayList<Point> adding = new ArrayList<>();
                Point current = open.poll();
                basinSize++;
                int x = current.getPosX();
                int y = current.getPosY();
                for(int[] offset: offsets) {
                    try {
                        Point test = points[x+offset[0]][y+offset[1]];
                        if(!visited.contains(test) && test.getHeight() != 9) {
                            open.add(test);
                            visited.add(test);
                        }
                    } catch (Exception e) {
                        System.out.print(".");
                    }
                }
            }
            basins.add(basinSize);
        }

        basins.sort(Collections.reverseOrder());

        long output = (long) basins.get(0) * basins.get(1) * basins.get(2);

        System.out.println();
        System.out.println(output);

    }
}