package com.buckb.tdd.ch04ship;

public class Point {

    private int x;
    public int getX() {
        return this.x;
    }
    public void setX(int x) {
        this.x = x;
    }

    private int y;
    public int getY() {
        return this.y;
    }
    public void setY(int y) {
        this.y = y;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
