package com.jkachele.aoc.utils;

public class Vector2 {
    public int x;
    public int y;

    public Vector2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Vector2() {
        this(0, 0);
    }

    public Vector2(Vector2 vector) {
        this(vector.x, vector.y);
    }

    //@Overide
    public String toString() {
        return String.format("[%d, %d]", x, y);
    }

    //@Overide
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final Vector2 vector = (Vector2) obj;

        return (this.x == vector.x) && (this.y == vector.y);
    }

    //@Overide
    public int hashCode() {
        int hash = 17;
        hash = hash * 31 + x;
        hash = hash * 31 + y;
        return hash;
    }
}
