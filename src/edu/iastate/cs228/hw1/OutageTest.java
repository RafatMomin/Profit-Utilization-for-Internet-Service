package edu.iastate.cs228.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OutageTest {

    Town t = new Town(4, 4);
    Outage o = new Outage(t, 1, 2);

    @Test
    void test() {
        assertEquals(o.who(), State.OUTAGE);
    }
}
