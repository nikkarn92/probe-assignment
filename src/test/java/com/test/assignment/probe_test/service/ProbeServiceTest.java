package com.test.assignment.probe_test.service;

import com.test.assignment.probe_test.model.Direction;
import com.test.assignment.probe_test.model.Grid;
import com.test.assignment.probe_test.model.Probe;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProbeServiceTest {

    @Test
    void shouldExecuteCommandsAndAvoidObstacles() {
        Probe probe = new Probe(0, 0, Direction.NORTH);
        Grid grid = new Grid(5, 5, List.of(new Point(0, 2))); // obstacle at (0,2)

        ProbeService service = new ProbeService(grid);
        List<Point> visited = service.executeCommands(probe, "FFRFF");

        assertEquals(2, probe.getPosX());         // Final X
        assertEquals(1, probe.getPosY());         // Final Y (blocked before hitting (0,2))
        assertEquals(Direction.EAST, probe.getFacingDirection());

        assertTrue(visited.contains(new Point(0, 0)));
        assertTrue(visited.contains(new Point(0, 1)));
        assertFalse(visited.contains(new Point(0, 2))); // Should be blocked
    }

}
