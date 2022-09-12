package com.jkachele.aoc._2021.day15;

public class Cell {
    /* ***************Instance Variables*************** */
    private int riskLevel;
    private int posX;
    private int posY;
    private boolean open;
    private boolean closed;
    private int gCost;
    private int hCost;
    private int fCost;
    private Cell parentCell;
    private boolean path;

    /* ***************Constructors*************** */
    public Cell() {
        this(0, 0, 0, 0, 0, 0);
    }

    public Cell(int riskLevel) {
        this(riskLevel, 0, 0, 0, 0, 0);
    }

    public Cell(int riskLevel, int posX, int posY) {
        this(riskLevel, posX, posY, 0, 0, 0);
    }

    public Cell(int riskLevel, int posX, int posY, int gCost, int hCost, int fCost) {
        this.riskLevel = riskLevel;
        this.posX = posX;
        this.posY = posY;
        this.gCost = gCost;
        this.hCost = hCost;
        this.fCost = fCost;
        this.open = false;
        this.closed = false;
    }
    /* ***************Getters and Setters*************** */
    //region
    public int getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(int riskLevel) {
        this.riskLevel = riskLevel;
    }

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

    public int getGCost() {
        return gCost;
    }

    public void setGCost(int gCost) {
        this.gCost = gCost;
        this.fCost = this.hCost + gCost;
    }

    public int getHCost() {
        return hCost;
    }

    public void setHCost(int hCost) {
        this.hCost = hCost;
        this.fCost = this.gCost + hCost;
    }

    public int getFCost() {
        return fCost;
    }

    public void setFCost(int fCost) {
        this.fCost = fCost;
    }

    public Cell getParentCell() {
        return parentCell;
    }

    public void setParentCell(Cell parentCell) {
        this.parentCell = parentCell;
    }

    public boolean isPath() {
        return path;
    }

    public void setPath(boolean path) {
        this.path = path;
    }
    //endregion
    /* ***************Methods*************** */

    public String toString() {
        return String.format("RiskLevel: %d, PosX: %d, PosY: %d", riskLevel, posX, posY);
    }

    public String toStringPath() {
        String result;
        if (path) {
            result = String.format("*%d", riskLevel);
        } else {
            result = String.format("%d", riskLevel);
        }
        return result;
    }

    public String toStringCellNumber() {
        int cellNumber = (9 * posX + posY);
        return String.format("%d", cellNumber);
    }

}