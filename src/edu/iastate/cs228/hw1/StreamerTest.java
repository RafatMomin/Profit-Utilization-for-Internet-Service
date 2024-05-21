package edu.iastate.cs228.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StreamerTest {
    Town t = new Town(4, 4);
    Streamer s = new Streamer(t, 1, 2);

    @Test
    void test() {
        assertEquals(s.who(), State.STREAMER);
    }
}
