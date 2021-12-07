package com.jkachele.aoc._2021.day6;

public class LanternFish {
    /* ***************Instance Variables*************** */
    private int timer;
    private final int MaxTimer;

    /* ***************Constructors*************** */
    public LanternFish(int timer, int maxTimer) {
        this.timer = timer;
        this.MaxTimer = maxTimer;
    }

    /* ***************Getters and Setters*************** */
    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public int getMaxTimer() {
        return MaxTimer;
    }

    /* ***************Methods*************** */
    public boolean age1Day() {
        if(timer == 0) {
            timer = MaxTimer;
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