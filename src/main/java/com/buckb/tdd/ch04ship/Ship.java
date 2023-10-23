package com.buckb.tdd.ch04ship;

public class Ship {

    private Location location;

    public Ship(Location location) {
        this.location = location;
    }

    public Location location() {
        return this.location;
    }

    public boolean moveForward() {
        return this.location.forward();
    }

    public boolean moveBackward() {
        return this.location.backward();
    }

    public void moveLeft() {
        this.location.turnLeft();
    }

    public void moveRight() {
        this.location.turnRight();
    }

    public void readCommand(String command) {
        switch (command.toLowerCase()) {
            case "f" -> this.moveForward();
            default -> throw new IllegalArgumentException("Invalid command: " + command);
        }
    }
}
