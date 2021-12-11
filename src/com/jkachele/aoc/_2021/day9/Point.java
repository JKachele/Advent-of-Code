package com.jkachele.aoc._2021.day9;

public class Point {
    /* ***************Instance Variables*************** */
    private int posX;
    private int posY;
    private int height;

    /* ***************Constructors*************** */

    public Point(int posX, int posY, int height) {
        this.posX = posX;
        this.posY = posY;
        this.height = height;
    }
    /* ***************Getters and Setters*************** */
    //region
    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    //endregion
    /* ***************Methods*************** */
    public String toString() {
        return String.format("[%d, %d]", posX, posY);
    }

}