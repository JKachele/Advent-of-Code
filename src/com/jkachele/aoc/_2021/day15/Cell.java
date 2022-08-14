package com.jkachele.aoc._2021.day15;

public class Cell {
    /* ***************Instance Variables*************** */
    private int riskLevel;
    private boolean open;
    private boolean closed;
    private int gCost;
    private int hCost;
    private int fCost;

    /* ***************Constructors*************** */
    public Cell() {
        this(0, false, false, 0, 0, 0);
    }

    public Cell(int riskLevel) {
        this(riskLevel, false, false, 0, 0, 0);
    }

    public Cell(int riskLevel, boolean open, boolean closed, int gCost, int hCost, int fCost) {
        this.riskLevel = riskLevel;
        this.open = open;
        this.closed = closed;
        this.gCost = gCost;
        this.hCost = hCost;
        this.fCost = fCost;
    }
    /* ***************Getters and Setters*************** */
    //region
    public int getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(int riskLevel) {
        this.riskLevel = riskLevel;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public int getgCost() {
        return gCost;
    }

    public void setgCost(int gCost) {
        this.gCost = gCost;
    }

    public int gethCost() {
        return hCost;
    }

    public void sethCost(int hCost) {
        this.hCost = hCost;
    }

    public int getfCost() {
        return fCost;
    }

    public void setfCost(int fCost) {
        this.fCost = fCost;
    }
    //endregion
    /* ***************Methods*************** */


}