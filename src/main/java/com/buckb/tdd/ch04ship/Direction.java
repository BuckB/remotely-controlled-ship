package com.buckb.tdd.ch04ship;

public enum Direction {

    NORTH(0, 'N'),
    EAST(1, 'E'),
    SOUTH(2, 'S'),
    WEST(3, 'W'),
    NONE(4, 'X');

    private final int value;
    private final char shortName;

    private Direction(final int newValue, final char shortNameValue) {
        this.value = newValue;
        this.shortName = shortNameValue;
    }

    public static Direction getFromShortName(final char shortName) {
        var result = Direction.NONE;
        for (Direction direction : Direction.values()) {
            if (direction.shortName == shortName) {
                result = direction;
            }
        }
        return result;
    }
/*
    public static Direction getFromShortName(final char shortName) {
        return switch (shortName) {
            case 'E' -> Direction.EAST;
            case 'S' -> Direction.SOUTH;
            case 'W' -> Direction.WEST;
            case 'N' -> Direction.NORTH;
            default -> Direction.NONE;
        };
    }
 */
    public Direction turnLeft() {
        int index = (this.value + 3) % 4;
        return Direction.values()[index];
    }

    public Direction turnRight() {
        int index = (this.value + 1) % 4;
        return Direction.values()[index];
    }

}
