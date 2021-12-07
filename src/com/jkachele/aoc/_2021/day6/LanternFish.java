package com.jkachele.aoc._2021.day6;

public class LanternFish {
    /* ***************Instance Variables*************** */
    private int timer;

    /* ***************Constructors*************** */
    public LanternFish(int timer) {
        this.timer = timer;
    }

    /* ***************Getters and Setters*************** */
    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    /* ***************Methods*************** */
    public boolean age1Day() {
        if(timer == 0) {
            timer = 6;
            return true;
        }
        else {
            timer--;
            return false;
        }
    }

    public String toString() {
        return Integer.toString(timer);
    }

}