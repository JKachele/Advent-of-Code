package com.jkachele.aoc._2015.day7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Day7b {
    public static void main(String[] args) {
        final String fileName = "src/com/jkachele/aoc/_2015/day7/input.txt";
        // final String fileName = "src/com/jkachele/aoc/_2015/day7/testInput.txt";

        ArrayList<String> lines = readFile(fileName);
        System.out.println(lines);

        HashMap<String, Integer> wires = new HashMap<>();
        ArrayList<Gate> gates = new ArrayList<>();
        ArrayList<Gate> gates2 = new ArrayList<>();
        for(String line: lines) {
            String[] lineParts = line.split(" ");
            String in1 = "";
            String in2 = "";
            String out = "";
            GateType operator = null;
            switch(lineParts.length) {
                case 3 -> {
                    in1 = lineParts[0];
                    out = lineParts[2];
                    operator = GateType.ASSIGN;
                }
                case 4 -> {
                    in1 = lineParts[1];
                    out = lineParts[3];
                    operator = GateType.NOT;
                }
                case 5 -> {
                    in1 = lineParts[0];
                    in2 = lineParts[2];
                    out = lineParts[4];
                    switch(lineParts[1]) {
                        case "AND" -> operator = GateType.AND;
                        case "OR" -> operator = GateType.OR;
                        case "LSHIFT" -> operator = GateType.LSHIFT;
                        case "RSHIFT" -> operator = GateType.RSHIFT;
                        default -> {
                            System.err.println("Invalid line: " + line);
                            System.exit(0);
                        }
                    }
                } default -> {
                    System.err.println("Invalid line: " + line);
                    System.exit(0);
                }
            }
            Gate gate = new Gate(operator, in1, in2, out);
            gates.add(gate);
            gates2.add(gate);
        }

        runGates(wires, gates);
        int a = wires.get("a");
        wires.clear();
        wires.put("b", a);
        runGates(wires, gates2);

        System.out.println();
        System.out.println(wires.get("a"));
    }

    public static void runGates(HashMap<String, Integer> wires, ArrayList<Gate> gates) {
        while (!wires.containsKey("a")) {
            for (int i = 0; i < gates.size(); i++) {
                Gate gate = gates.get(i);
                int in1 = -1;
                int in2 = -1;
                if(wires.containsKey(gate.output())) {
                    gates.remove(i);
                    i--;
                    continue;
                }

                if (isNumber(gate.input1())) {
                    in1 = Integer.parseInt(gate.input1());
                } else if (wires.containsKey(gate.input1())) {
                    in1 = wires.get(gate.input1());
                } else {
                    continue;
                }
                if (isNumber(gate.input2())) {
                    in2 = Integer.parseInt(gate.input2());
                } else if (wires.containsKey(gate.input2())) {
                    in2 = wires.get(gate.input2());
                } else if (gate.type() != GateType.NOT &&
                           gate.type() != GateType.ASSIGN) {
                    continue;
                }

                switch(gate.type()) {
                    case ASSIGN -> {
                        putOrReplace(wires, gate.output(), in1);
                    }
                    case NOT -> {
                        putOrReplace(wires, gate.output(), ~in1);
                    }
                    case AND -> {
                        putOrReplace(wires, gate.output(), in1 & in2);
                    }
                    case OR -> {
                        putOrReplace(wires, gate.output(), in1 | in2);
                    }
                    case LSHIFT -> {
                        putOrReplace(wires, gate.output(), in1 << in2);
                    }
                    case RSHIFT -> {
                        putOrReplace(wires, gate.output(), in1 >> in2);
                    }
                }

                gates.remove(i);
                i--;
                System.out.print(".");
            }
        }
    }

    public static <K, V> void putOrReplace(HashMap<K, V> map, K key, V value) {
        if(map.containsKey(key)) {
            map.replace(key, value);
        } else {
            map.put(key, value);
        }
    }

    public static boolean isNumber(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
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

record Gate(GateType type, String input1, String input2, String output) {}

enum GateType {
    ASSIGN,
    NOT,
    AND,
    OR,
    LSHIFT,
    RSHIFT
}
