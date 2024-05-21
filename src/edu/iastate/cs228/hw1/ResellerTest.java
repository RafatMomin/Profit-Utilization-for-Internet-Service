package edu.iastate.cs228.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResellerTest {
    Town t = new Town(4, 4);
    Reseller r = new Reseller(t, 1, 2);

    @Test
    void test() {
        assertEquals(r.who(), State.RESELLER);
    }
}
