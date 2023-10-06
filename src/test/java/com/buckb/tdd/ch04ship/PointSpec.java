package com.buckb.tdd.ch04ship;

import org.testng.annotations.*;
import static org.testng.Assert.*;

@Test
public class PointSpec {

    private Point point;
    private final int x = 12;
    private final int y = 21;

    @BeforeMethod
    public void beforeTest() {
        this.point = new Point(this.x, this.y);
    }

    @Test
    public void whenInstantiatedThenXIsSet() {
        assertEquals(this.point.getX(), this.x);
    }

    @Test
    public void whenInstantiatedThenYIsSet() {
        assertEquals(this.point.getY(), this.y);
    }

}
