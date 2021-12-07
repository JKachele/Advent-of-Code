package com.jkachele.aoc._2021.day4;

public class Test {
    public static void main(String[] args) {

        int[][] test = {{0, 1, 2, 3, 4}, {1, 2, 3, 4, 5}, {2, 3, 4, 5, 6}, {3, 4, 5, 6, 7}, {4, 5, 6, 7, 8}};

        Board board = new Board(test);

        System.out.println(board);

    }
}
