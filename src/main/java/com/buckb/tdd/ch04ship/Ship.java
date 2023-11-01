package com.buckb.tdd.ch04ship;

public class Ship {

    private Location location;
    private Planet planet;

    public Ship(Location location, Planet planet) {
        this.location = location;
        this.planet = planet;
    }

    public Location location() {
        return this.location;
    }

    public Planet planet() {
        return this.planet;
    }

    public boolean moveForward() {
        return this.location.forward(this.planet.getMax());
    }

    public boolean moveBackward() {
        return this.location.backward(this.planet.getMax());
    }

    public void moveLeft() {
        this.location.turnLeft();
    }

    public void moveRight() {
        this.location.turnRight();
    }

    public void readCommand(String command) {
        for (char direction : command.toLowerCase().toCharArray()) {
            switch (direction) {
                case 'f' -> this.moveForward();
                case 'b' -> this.moveBackward();
                case 'r' -> this.moveRight();
                case 'l' -> this.moveLeft();
                default -> throw new IllegalArgumentException("Invalid command: " + command);
            }
        }
    }
}
