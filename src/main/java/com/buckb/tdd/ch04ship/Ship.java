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
}
