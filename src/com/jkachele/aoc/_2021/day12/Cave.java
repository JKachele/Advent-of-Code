package com.jkachele.aoc._2021.day12;

import java.util.ArrayList;

public class Cave {
    /* ***************Instance Variables*************** */
    private String name;
    private boolean large;
    private ArrayList<Cave> connectingCaves;
    private boolean visited;
    private boolean start;
    private boolean end;
    private boolean twiceCave;
    private int timesVisited = 0;

    /* ***************Constructors*************** */
    public Cave() {
        this("", false);
    }

    public Cave(String name, boolean large) {
        this.name = name;
        this.large = large;
        connectingCaves = new ArrayList<>();
        visited = false;
        twiceCave = false;
    }

    /* ***************Getters and Setters*************** */
    //region
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isLarge() {
        return large;
    }

    public void setLarge(boolean large) {
        this.large = large;
    }

    public ArrayList<Cave> getConnectingCaves() {
        return connectingCaves;
    }

    public void setConnectingCaves(ArrayList<Cave> connectingCaves) {
        this.connectingCaves = connectingCaves;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isStart() {
        return start;
    }

    public void setStart(boolean start) {
        this.start = start;
    }

    public boolean isEnd() {
        return end;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }

    public boolean isTwiceCave() {
        return twiceCave;
    }

    public void setTwiceCave(boolean twiceCave) {
        this.twiceCave = twiceCave;
    }

    public int getTimesVisited() {
        return timesVisited;
    }

    public void setTimesVisited(int timesVisited) {
        this.timesVisited = timesVisited;
    }
    //endregion
    /* ***************Methods*************** */
    public void addConnectingCave(Cave connectingCave) {
        this.connectingCaves.add(connectingCave);
    }

    public void visit() {
        if(!this.large && this.twiceCave) {
            timesVisited++;
            if (timesVisited > 1)
                this.visited = true;
        } else if(!this.large)
            this.visited = true;
    }

    public void unVisit() {
        this.visited = false;
        if(timesVisited > 0)
            timesVisited--;
    }

    public String printConnectingCaves() {
        StringBuilder sb = new StringBuilder();
        for(Cave cave : this.connectingCaves) {
            sb.append(cave.getName()).append(" ");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return name;
    }
}