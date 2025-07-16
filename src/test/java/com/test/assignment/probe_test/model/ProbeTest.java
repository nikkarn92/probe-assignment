package com.test.assignment.probe_test.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProbeTest {
    @Test
    void shouldInitializeProbeAtGivenPositionAndDirection() {
        Probe probe = new Probe(1, 2, Direction.NORTH);
        assertEquals(1, probe.getPosX());
        assertEquals(2, probe.getPosY());
        assertEquals(Direction.NORTH, probe.getFacingDirection());
    }

    @Test
    void shouldMoveForwardWhenFacingNorth() {
        Probe probe = new Probe(1, 1, Direction.NORTH);
        probe.moveForward();
        assertEquals(1, probe.getPosX());
        assertEquals(2, probe.getPosY());
        assertEquals(Direction.NORTH, probe.getFacingDirection());
    }
}
