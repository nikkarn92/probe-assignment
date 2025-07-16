package com.test.assignment.probe_test.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProbeTest {
    @Test
    void shouldInitializeProbeAtGivenPositionAndDirection() {
        Probe probe = new Probe(1, 2, Direction.NORTH);
        assertEquals(1, probe.getX());
        assertEquals(2, probe.getY());
        assertEquals(Direction.NORTH, probe.getDirection());
    }
}
