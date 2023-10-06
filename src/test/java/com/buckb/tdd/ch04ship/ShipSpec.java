package com.buckb.tdd.ch04ship;

import org.testng.annotations.*;

import static org.testng.Assert.*;

@Test
public class ShipSpec {

    Ship ship;
    Point point;
    Location location;
    private final int x = 0;
    private final int y = 0;

    @BeforeClass
    public void setup() {
        this.point = new Point(this.x, this.y);
        this.location = new Location(this.point, Direction.NORTH);
        this.ship = new Ship(new Location(new Point(this.x,this.y), Direction.NORTH));
    }

    @Test
    public void given_new_ship_then_location_is_set() {
        assertEquals(this.ship.location(), this.location, "Ship starting location should equals N");
    }
}
