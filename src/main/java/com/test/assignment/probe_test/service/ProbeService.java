package com.test.assignment.probe_test.service;
import com.test.assignment.probe_test.model.Grid;
import com.test.assignment.probe_test.model.Probe;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ProbeService {

    private final Grid grid;

    public ProbeService(Grid grid) {
        this.grid = grid;
    }

    public List<Point> executeCommands(Probe probe, String commands) {
        List<Point> visited = new ArrayList<>();
        visited.add(new Point(probe.getPosX(), probe.getPosY()));

        for (char command : commands.toCharArray()) {
            int currentX = probe.getPosX();
            int currentY = probe.getPosY();

            switch (command) {
                case 'F' -> probe.moveForward();
                case 'B' -> probe.moveBackward();
                case 'L' -> probe.turnLeft();
                case 'R' -> probe.turnRight();
            }

            int newX = probe.getPosX();
            int newY = probe.getPosY();

            // If blocked, revert move
            if (!grid.isWithinBounds(newX, newY) || grid.hasObstacle(newX, newY)) {
                probe.setPosX(currentX);
                probe.setPosY(currentY);
            } else {
                visited.add(new Point(newX, newY));
            }
        }

        return visited;
    }
}
