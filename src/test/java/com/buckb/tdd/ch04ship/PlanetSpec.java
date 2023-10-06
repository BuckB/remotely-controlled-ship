package com.buckb.tdd.ch04ship;

import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

@Test
public class PlanetSpec {

    private Planet planet;
    private final Point max = new Point(50, 50);
    private List<Point> obstacles;

    @BeforeMethod
    public void beforeTest() {
        this.obstacles = new ArrayList<>();
        this.obstacles.add(new Point(12, 13));
        this.obstacles.add(new Point(16, 32));
        this.planet = new Planet(this.max, this.obstacles);
    }

    @Test
    public void whenInstantiatedThenMaxIsSet() {
        assertEquals(this.planet.getMax(), this.max);
    }

    @Test
    public void whenInstantiatedThenObstaclesAreSet() {
        assertEquals(this.planet.getObstacles(), this.obstacles);
    }

}
