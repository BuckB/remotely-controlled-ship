package com.buckb.tdd.ch04ship;

import java.util.ArrayList;
import java.util.List;

public class Location {

    private static final int FORWARD = 1;
    private static final int BACKWARD = -1;
    private Point point;
    private Direction direction;

    public int getX() {
        return this.point.getX();
    }

    public int getY() {
        return this.point.getY();
    }

    public Point getPoint() {
        return this.point;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Location(Point point, Direction direction) {
        this.point = point;
        this.direction = direction;
    }

    public boolean forward() {
        return this.move(FORWARD, new Point(100, 100), new ArrayList<>());
    }

    public boolean forward(Point max) {
        return this.move(FORWARD, max, new ArrayList<>());
    }

    public boolean forward(Point max, List<Point> obstacles) {
        return this.move(FORWARD, max, obstacles);
    }

    public boolean backward() {
        return this.move(BACKWARD, new Point(100, 100), new ArrayList<>());
    }

    public boolean backward(Point max) {
        return this.move(BACKWARD, max, new ArrayList<>());
    }

    public boolean backward(Point max, List<Point> obstacles) {
        return this.move(BACKWARD, max, obstacles);
    }

    private boolean move(int fw, Point max, List<Point> obstacles) {
        int x = this.point.getX();
        int y = this.point.getY();
        switch (this.getDirection()) {
            case NORTH -> y = this.wrap(this.getY() + fw, max.getY());
            case SOUTH -> y = this.wrap(this.getY() - fw, max.getY());
            case EAST -> x = this.wrap(this.getX() + fw, max.getX());
            case WEST -> x = this.wrap(this.getX() - fw, max.getX());
            default -> throw new IllegalArgumentException("Unexpected value: " + this.getDirection());
        }
        if (this.isObstacle(new Point(x, y), obstacles)) {
            return false;
        } else {
            this.point = new Point(x, y);
            return true;
        }
    }

    private boolean isObstacle(Point point, List<Point> obstacles) {
        for (Point obstacle : obstacles) {
            if (obstacle.getX() == point.getX() && obstacle.getY() == point.getY()) {
                return true;
            }
        }
        return false;
    }

    private int wrap(int point, int maxPoint) {
        int result = point;
        if (maxPoint > 0) {
            if (point > maxPoint) {
                result = 1;
            } else if (point <= 0) {
                result = maxPoint;
            }
        }
        return result;
    }

    public void turnLeft() {
        this.direction = this.direction.turnLeft();
    }

    public void turnRight() {
        this.direction = this.direction.turnRight();
    }

    public Location copy() {
        return new Location(new Point(this.point.getX(), this.point.getY()), this.direction);
    }

    @Override
    public boolean equals(Object o) {
        return this == o || o instanceof Location other &&
                other.getX() == this.getX() &&
                other.getY() == this.getY() &&
                other.direction.equals(this.direction);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.point == null) ? 0 : this.point.hashCode());
        result = prime * result + ((this.direction == null) ? 0 : this.direction.hashCode());
        return result;
    }
}
