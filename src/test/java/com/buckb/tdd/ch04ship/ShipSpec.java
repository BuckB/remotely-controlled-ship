package com.buckb.tdd.ch04ship;

import org.testng.annotations.*;
import static org.testng.Assert.*;

@Test
@SuppressWarnings("all")
public class ShipSpec {

    private Ship ship;
    private Point point;
    private Location location;
    private Planet planet;
    private Point maxPoint;
    private final int x = 0;
    private final int y = 0;

    @BeforeMethod
    public void setup() {
        this.point = new Point(this.x, this.y);
        this.location = new Location(this.point, Direction.NORTH);
        this.maxPoint = new Point(50, 50);
        this.planet = new Planet(this.maxPoint);
        this.ship = new Ship(this.location, this.planet);
    }

    @Test
    public void given_new_ship_then_location_is_set() {
        assertEquals(this.ship.location(), this.location, "Ship starting location should equals N");
    }

    @Test
    public void given_new_ship_then_Planet_is_set() {
        assertTrue(this.planet.equals(this.ship.planet()));
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

    @Test
    public void given_ship_readsCommand_when_f_then_moveForward() {
        this.location.forward();
        this.ship.readCommand("f");
        assertEquals(this.ship.location(), this.location);
    }

    @Test
    public void given_ship_readsCommand_when_b_then_moveBackward() {
        this.location.backward();
        this.ship.readCommand("b");
        assertEquals(this.ship.location(), this.location);
    }

    @Test
    public void given_ship_readsCommand_when_r_then_moveRight() {
        this.location.turnRight();
        this.ship.readCommand("r");
        assertEquals(this.ship.location(), this.location);
    }

    @Test
    public void given_ship_readsCommand_when_l_then_moveLeft() {
        this.location.turnLeft();
        this.ship.readCommand("l");
        assertEquals(this.ship.location(), this.location);
    }

    @Test
    public void given_ship_readsCommand_when_multiple_commands_then_execute_all() {
        this.location.backward();
        this.location.turnRight();
        this.location.forward();
        this.location.turnLeft();
        this.ship.readCommand("brfl");
        assertEquals(this.ship.location(), this.location);
    }

    @Test
    public void when_ship_moves_forward_overpass_x_boundary_east() {
        this.location.setDirection(Direction.EAST);
        this.location.getPoint().setX(this.planet.getMax().getX());
        this.ship.readCommand("f");
        assertEquals(this.location.getX(), 1);
    }

    @Test
    public void when_ship_moves_backward_overpass_x_boundary_east() {
        this.location.setDirection(Direction.WEST);
        this.location.getPoint().setX(this.planet.getMax().getX());
        this.ship.readCommand("b");
        assertEquals(this.location.getX(), 1);
    }
}
