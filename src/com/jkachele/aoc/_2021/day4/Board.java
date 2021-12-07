package com.jkachele.aoc._2021.day4;

import java.util.Arrays;

public class Board {
    /* ***************Instance Variables*************** */
    private int[][] numberBoard;
    private boolean[][] markedBoard;
    private int lastCalledNum = 0;
    private boolean bingo = false;

    /* ***************Constructors*************** */
    public Board() {
        this(new int[5][5]);
    }

    public Board(int[][] numberBoard) {
        this.numberBoard = numberBoard;
        markedBoard = new boolean[5][5];
        setMarkedBoard();
    }

    /* ***************Getters and Setters*************** */
    //region
    public int[][] getNumberBoard() {
        return numberBoard;
    }

    public void setNumberBoard(int[][] numberBoard) {
        this.numberBoard = numberBoard;
    }

    public boolean[][] getMarkedBoard() {
        return markedBoard;
    }

    public void setMarkedBoard(boolean[][] markedBoard) {
        this.markedBoard = markedBoard;
    }

    public int getLastCalledNum() {
        return lastCalledNum;
    }

    public void setLastCalledNum(int lastCalledNum) {
        this.lastCalledNum = lastCalledNum;
    }

    public boolean isBingo() {
        return bingo;
    }

    public void setBingo(boolean bingo) {
        this.bingo = bingo;
    }
    //endregion
    /* ***************Methods*************** */
    private void setMarkedBoard() {
        for(boolean[] row: markedBoard)
            Arrays.fill(row, false);
    }

    public boolean numberInBoard(int num) {
        for(int i=0; i<numberBoard.length; i++) {
            for(int j=0; j<numberBoard[i].length; j++) {
                if(numberBoard[i][j] == num) {
                    markedBoard[i][j] = true;
                    return bingo();
                }
            }
        }
        return false;
    }

    private boolean bingo() {
        //check for horizontal Bingo
        for(boolean[] row: markedBoard) {
            boolean temp = true;
            for(boolean b: row) {
                if (!b) {
                    temp = false;
                    break;
                }
            }
            if(temp)
                return true;
        }
        //check for vertical Bingo
        for(int i=0; i<markedBoard[0].length; i++) {
            boolean temp = true;
            for (boolean[] booleans : markedBoard) {
                if (!booleans[i]) {
                    temp = false;
                    break;
                }
            }
            if(temp)
                return true;
        }
        return false;
    }

    public int getUnmarkedSum() {
        int sum = 0;
        for(int i=0; i<markedBoard.length; i++) {
            for(int j=0; j<markedBoard[i].length; j++) {
                if(!markedBoard[i][j])
                    sum += numberBoard[i][j];
            }
        }
        return sum;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[[");
        sb.append(numberBoard[0][0]);
        sb.append((markedBoard[0][0])? "-T": "-F");
        for(int j=1; j<numberBoard[0].length; j++) {
            sb.append(", ");
            sb.append(numberBoard[0][j]);
            sb.append((markedBoard[0][j])? "-T": "-F");
        }
        sb.append("]");
        for(int i=1; i<numberBoard.length; i++) {
            sb.append("\n [");
            sb.append(numberBoard[i][0]);
            sb.append((markedBoard[i][0])? "-T": "-F");
            for(int j=1; j<numberBoard[i].length; j++) {
                sb.append(", ");
                sb.append(numberBoard[i][j]);
                sb.append((markedBoard[i][j])? "-T": "-F");
            }
            sb.append("]");
        }
        sb.append(']');
        return sb.toString();
    }

}