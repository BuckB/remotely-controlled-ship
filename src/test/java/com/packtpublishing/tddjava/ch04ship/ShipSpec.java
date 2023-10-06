package com.packtpublishing.tddjava.ch04ship;

import org.testng.annotations.*;

import static org.testng.Assert.*;

@Test
public class ShipSpec {

    Ship ship;
    Point point;
    Location location;

    @BeforeMethod
    public void setup() {
        this.point = new Point(0, 0);
        this.location = new Location(this.point, Direction.NORTH);
        this.ship = new Ship(this.location);
    }

    public void given_new_ship_then_location_is_set() {
        assertEquals(this.ship.location(), this.location);
    }
}
