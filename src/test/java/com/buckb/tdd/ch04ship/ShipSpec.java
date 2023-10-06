package com.buckb.tdd.ch04ship;

import org.testng.annotations.*;
import static org.testng.Assert.*;

@Test
public class ShipSpec {

    private Ship ship;
    private Point point;
    private Location location;
    private final int x = 0;
    private final int y = 0;

    @BeforeMethod
    public void setup() {
        this.point = new Point(this.x, this.y);
        this.location = new Location(this.point, Direction.NORTH);
        this.ship = new Ship(new Location(new Point(this.x, this.y), Direction.NORTH));
    }

    @Test
    public void given_new_ship_then_location_is_set() {
        assertEquals(this.ship.location(), this.location, "Ship starting location should equals N");
    }

    @Test
    public void given_ship_moves_when_moveForward_then_forward() {
        this.location.forward();
        this.ship.moveForward();
        assertEquals(this.ship.location(), this.location);
    }

    @Test
    public void given_ship_moves_when_moveBackwards_then_backwards() {
        this.location.backward();
        this.ship.moveBackward();
        assertEquals(this.ship.location(), this.location);
    }

    @Test
    public void given_ship_moves_when_moveLeft_then_left() {
        this.location.turnLeft();
        this.ship.moveLeft();
        assertEquals(this.ship.location(), this.location);
    }

    @Test
    public void given_ship_moves_when_moveRight_then_right() {
        this.location.turnRight();
        this.ship.moveRight();
        assertEquals(this.ship.location(), this.location);
    }

}
