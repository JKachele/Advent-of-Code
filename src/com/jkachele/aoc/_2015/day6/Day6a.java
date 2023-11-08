package com.jkachele.aoc._2015.day6;

import com.jkachele.aoc.utils.Vector2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day6a {
    public static void main(String[] args) {
        final String fileName = "src/com/jkachele/aoc/_2015/day6/input.txt";
        // final String fileName = "src/com/jkachele/aoc/_2015/day6/testInput.txt";

        ArrayList<String> lines = readFile(fileName);
        // System.out.println(lines);

        boolean[][] lights = new boolean[1000][1000];
        for (int x = 0; x < lights.length; x++) {
            for (int y = 0; y < lights[x].length; y++) {
                lights[x][y] = false;
            }
        }

        for (int i = 0; i < lines.size(); i++) {
            String[] words = lines.get(i).split(" ");
            // System.out.println(Arrays.toString(words));
            int mode = 0;   // 0=off 1=on 2=toggle
            String c1String = "";
            String c2String = "";
            if (words[0].equals("toggle")) {
                mode = 2;
                c1String = words[1];
                c2String = words[3];
            } else if (words[1].equals("on")) {
                mode = 1;
                c1String = words[2];
                c2String = words[4];
            } else if (words[1].equals("off")) {
                mode = 0;
                c1String = words[2];
                c2String = words[4];
            } else {
                System.err.println("Invalid Instructon!");
                System.exit(1);
            }

            String[] c1Strings = c1String.split(",");
            String[] c2Strings = c2String.split(",");

            Vector2 c1 = new Vector2(Integer.parseInt(c1Strings[0]), Integer.parseInt(c1Strings[1]));
            Vector2 c2 = new Vector2(Integer.parseInt(c2Strings[0]), Integer.parseInt(c2Strings[1]));

            System.out.printf("%d: %s -> %s\n", mode, c1, c2);
            
            switch(mode) {
                case 0 -> {
                    for (int x = c1.x; x <= c2.x; x++) {
                        for (int y = c1.y; y <= c2.y; y++) {
                            lights[x][y] = false;
                        }
                    }
                }
                case 1 -> {
                    for (int x = c1.x; x <= c2.x; x++) {
                        for (int y = c1.y; y <= c2.y; y++) {
                            lights[x][y] = true;
                        }
                    }
                }
                case 2 -> {
                    for (int x = c1.x; x <= c2.x; x++) {
                        for (int y = c1.y; y <= c2.y; y++) {
                            lights[x][y] = lights[x][y] ? false : true;
                        }
                    }
                }
            }
        }

        int on = 0;
        for (int x = 0; x < lights.length; x++) {
            for (int y = 0; y < lights[x].length; y++) {
                if (lights[x][y]) {
                    on++;
                }
            }
        }

        System.out.println(on);
    }

    public static ArrayList<String> readFile(String fileName) {
        ArrayList<String> lines = new ArrayList<>();
        try {
            File file = new File(fileName);
            Scanner fileIn = new Scanner(file);

            while (fileIn.hasNext()) {
                lines.add(fileIn.nextLine());
            }
            fileIn.close();
            // System.out.println(lines);
        } catch (FileNotFoundException e) {
            System.err.println("File Not Found");
            System.exit(0);
        }
        return lines;
    }
}
