package com.test.assignment.probe_test.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GridTest {

    @Test
    void shouldAllowMoveWithinBoundaries() {
        Grid grid = new Grid(5, 5);
        assertTrue(grid.isWithinBounds(4, 4));
    }
}
