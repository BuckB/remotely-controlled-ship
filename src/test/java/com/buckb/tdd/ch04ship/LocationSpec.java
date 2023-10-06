package com.buckb.tdd.ch04ship;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotSame;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class LocationSpec {

    private final int x = 12;
    private final int y = 32;
    private final Direction direction = Direction.NORTH;
    private Point max;
    private Location location;
    private List<Point> obstacles;

    @BeforeMethod
    public void beforeTest() {
        this.max = new Point(50, 50);
        this.location = new Location(new Point(this.x, this.y), this.direction);
        this.obstacles = new ArrayList<>();
    }

    @Test
    public void whenInstantiatedThenXIsStored() {
        assertEquals(this.location.getX(), this.x);
    }

    @Test
    public void whenInstantiatedThenYIsStored() {
        assertEquals(this.location.getY(), this.y);
    }

    @Test
    public void whenInstantiatedThenDirectionIsStored() {
        assertEquals(this.location.getDirection(), this.direction);
    }

    @Test
    public void givenDirectionNWhenForwardThenYDecreases() {
        this.location.forward(this.max, this.obstacles);
        assertEquals(this.location.getY(), this.y - 1);
    }

    @Test
    public void givenDirectionSWhenForwardThenYIncreases() {
        this.location.setDirection(Direction.SOUTH);
        this.location.forward(this.max, this.obstacles);
        assertEquals(this.location.getY(), this.y + 1);
    }

    @Test
    public void givenDirectionEWhenForwardThenXIncreases() {
        this.location.setDirection(Direction.EAST);
        this.location.forward(this.max, this.obstacles);
        assertEquals(this.location.getX(), this.x + 1);
    }

    @Test
    public void givenDirectionWWhenForwardThenXDecreases() {
        this.location.setDirection(Direction.WEST);
        this.location.forward(this.max, this.obstacles);
        assertEquals(this.location.getX(), this.x - 1);
    }

    @Test
    public void givenDirectionNWhenBackwardThenYIncreases() {
        this.location.setDirection(Direction.NORTH);
        this.location.backward(this.max, this.obstacles);
        assertEquals(this.location.getY(), this.y + 1);
    }

    @Test
    public void givenDirectionSWhenBackwardThenYDecreases() {
        this.location.setDirection(Direction.SOUTH);
        this.location.backward(this.max, this.obstacles);
        assertEquals(this.location.getY(), this.y - 1);
    }

    @Test
    public void givenDirectionEWhenBackwardThenXDecreases() {
        this.location.setDirection(Direction.EAST);
        this.location.backward(this.max, this.obstacles);
        assertEquals(this.location.getX(), this.x - 1);
    }

    @Test
    public void givenDirectionWWhenBackwardThenXIncreases() {
        this.location.setDirection(Direction.WEST);
        this.location.backward(this.max, this.obstacles);
        assertEquals(this.location.getX(), this.x + 1);
    }

    @Test
    public void whenTurnLeftThenDirectionIsSet() {
        this.location.turnLeft();
        assertEquals(this.location.getDirection(), Direction.WEST);
    }

    @Test
    public void whenTurnRightThenDirectionIsSet() {
        this.location.turnRight();
        assertEquals(this.location.getDirection(), Direction.EAST);
    }

    @Test
    public void givenSameObjectsWhenEqualsThenTrue() {
        assertTrue(this.location.equals(this.location));
    }

    @Test
    public void givenDifferentObjectWhenEqualsThenFalse() {
        assertFalse(this.location.equals("bla"));
    }

    @Test
    public void givenDifferentXWhenEqualsThenFalse() {
        Location locationCopy = new Location(new Point(999, this.location.getY()), this.location.getDirection());
        assertFalse(this.location.equals(locationCopy));
    }

    @Test
    public void givenDifferentYWhenEqualsThenFalse() {
        Location locationCopy = new Location(new Point(this.location.getX(), 999), this.location.getDirection());
        assertFalse(this.location.equals(locationCopy));
    }

    @Test
    public void givenDifferentDirectionWhenEqualsThenFalse() {
        Location locationCopy = new Location(this.location.getPoint(), Direction.SOUTH);
        assertFalse(this.location.equals(locationCopy));
    }

    @Test
    public void givenSameXYDirectionWhenEqualsThenTrue() {
        Location locationCopy = new Location(this.location.getPoint(), this.location.getDirection());
        assertTrue(this.location.equals(locationCopy));
    }

    @Test
    public void whenCopyThenDifferentObject() {
        Location copy = this.location.copy();
        assertNotSame(this.location, copy);
    }

    @Test
    public void whenCopyThenEquals() {
        Location copy = this.location.copy();
        assertEquals(copy, this.location);
    }

    @Test
    public void givenDirectionEAndXEqualsMaxXWhenForwardThen1() {
        this.location.setDirection(Direction.EAST);
        this.location.getPoint().setX(this.max.getX());
        this.location.forward(this.max, this.obstacles);
        assertEquals(this.location.getX(), 1);
    }

    @Test
    public void givenDirectionWAndXEquals1WhenForwardThenMaxX() {
        this.location.setDirection(Direction.WEST);
        this.location.getPoint().setX(1);
        this.location.forward(this.max, this.obstacles);
        assertEquals(this.location.getX(), this.max.getX());
    }

    @Test
    public void givenDirectionNAndYEquals1WhenForwardThenMaxY() {
        this.location.setDirection(Direction.NORTH);
        this.location.getPoint().setY(1);
        this.location.forward(this.max, this.obstacles);
        assertEquals(this.location.getY(), this.max.getY());
    }

    @Test
    public void givenDirectionSAndYEqualsMaxYWhenForwardThen1() {
        this.location.setDirection(Direction.SOUTH);
        this.location.getPoint().setY(this.max.getY());
        this.location.forward(this.max, this.obstacles);
        assertEquals(this.location.getY(), 1);
    }

    @Test
    public void givenObstacleWhenForwardThenReturnFalse() {
        this.location.setDirection(Direction.EAST);
        this.obstacles.add(new Point(this.x + 1, this.y));
        assertFalse(this.location.forward(this.max, this.obstacles));
    }

    @Test
    public void givenObstacleWhenBackwardThenReturnFalse() {
        this.location.setDirection(Direction.EAST);
        this.obstacles.add(new Point(this.x - 1, this.y));
        assertFalse(this.location.backward(this.max, this.obstacles));
    }

}
