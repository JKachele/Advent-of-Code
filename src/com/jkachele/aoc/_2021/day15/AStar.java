package com.jkachele.aoc._2021.day15;

import java.util.ArrayList;

public class AStar {
    /* ***************Instance Variables*************** */
    private static Cell[][] cells;
    private static Cell startCell;
    private static Cell targetCell;
    private static int pathRisk;

    private static ArrayList<Cell> openCells = new ArrayList<>();
    private static ArrayList<Cell> closedCells = new ArrayList<>();

    /* ***************Constructors*************** */
    public static void initialize(Cell[][] cells) {
        AStar.cells = cells;
    }

    /* ***************Getters and Setters*************** */
    //region
    public static Cell[][] getCells() {
        return cells;
    }

    public static void setCells(Cell[][] cells) {
        AStar.cells = cells;
    }

    public static ArrayList<Cell> getOpenCells() {
        return openCells;
    }

    public static void setOpenCells(ArrayList<Cell> openCells) {
        AStar.openCells = openCells;
    }

    public static ArrayList<Cell> getClosedCells() {
        return closedCells;
    }

    public static void setClosedCells(ArrayList<Cell> closedCells) {
        AStar.closedCells = closedCells;
    }

    public static int getPathRisk() {
        return pathRisk;
    }

    public static void setPathRisk(int pathRisk) {
        AStar.pathRisk = pathRisk;
    }
    //endregion
    /* ***************Methods*************** */
    public static void run() {
        startCell = cells[0][0];
        targetCell = cells[cells.length - 1][cells[0].length - 1];
        calcHCost();
        setFirstCell();
    }

    private static void algLoop() {
        boolean found = false;
        while(!found) {
            Cell currentCell = findLowestFCost();
            if(currentCell != null) {
                openCells.remove(currentCell);
                closedCells.add(currentCell);
                if(currentCell.getHCost() == 0) {
                    setPath();
                    found = true;
                } else {
                    openSurroundingCells(currentCell);
                }
            } else {
                found = true;
            }
        }
    }

    private static void calcHCost() {
        int[] targetCellCoords = {targetCell.getPosX(), targetCell.getPosY()};

        for(Cell[] row: cells) {
            for(Cell current: row) {
                int[] cellCoords = {current.getPosX(), current.getPosY()};
                int distance = Math.abs(targetCellCoords[0] - cellCoords[0]) + Math.abs(targetCellCoords[1] - cellCoords[1]);
                current.setHCost(distance);
            }
        }
    }

    private static void setFirstCell() {
        closedCells.add(startCell);
        openSurroundingCells(startCell);
    }

    private static void openSurroundingCells(Cell centerCell) {
        for(int x = -1; x < 2; x++) {
            for(int y = -1; y < 2; y++) {
                int cellPosX = centerCell.getPosX() + x;
                int cellPosY = centerCell.getPosY() + y;
                if((cellPosX >= 0 && cellPosX < cells[0].length) && (cellPosY >= 0 && cellPosY < cells.length)) {
                    Cell cell = cells[cellPosX][cellPosY];
                    int gCost = centerCell.getGCost() + cell.getRiskLevel();
                    if(!openCells.contains(cell)) {
                        cell.setGCost(gCost);
                        openCells.add(cell);
                        cell.setParentCell(centerCell);
                    } else if(cell.getGCost() > gCost) {
                        cell.setGCost(gCost);
                        cell.setParentCell(centerCell);
                    }
                }
            }
        }
    }

    private static Cell findLowestFCost() {
        Cell lowestCell;
        try{
            //find the lowest f-cost of all the open cells
            int lowF = Integer.MAX_VALUE;
            for(Cell i: openCells){
                if(i.getFCost() < lowF){
                    lowF = i.getFCost();
                }
            }

            //find all the cells with the lowest f-cost
            ArrayList<Cell> lowFCells = new ArrayList<>();
            for(Cell i: openCells){
                if(i.getFCost() == lowF){
                    lowFCells.add(i);
                }
            }

            //if there are multiple cells with the lowest f-cost, find cell with the lowest h-cost
            //doesn't matter if multiple cells with same f and h cost, picks first one
            if(lowFCells.size() != 1){
                int lowH = Integer.MAX_VALUE;
                int lowHCell = 0;
                for(int i=0; i<lowFCells.size(); i++) {
                    if(lowFCells.get(i).getHCost() < lowH){
                        lowH = lowFCells.get(i).getHCost();
                        lowHCell = i;
                    }
                }
                lowestCell = lowFCells.get(lowHCell);
            } else {
                lowestCell = lowFCells.get(0);
            }

        } catch (Exception e) {
            return null;
        }
        return lowestCell;
    }

    private static void setPath() {
        pathRisk = 0;
        Cell currentCell = targetCell;
        do {
            pathRisk += currentCell.getRiskLevel();
            currentCell.setPath(true);
            currentCell = currentCell.getParentCell();
        } while(currentCell != startCell);
    }

}