package com.test.assignment.probe_test.model;

import java.awt.*;
import java.util.List;

public class Grid {
    private final int width;
    private final int height;
    private final List<Point> obstacles;

    public Grid(int width, int height) {
        this(width, height, List.of());
    }

    public Grid(int width, int height, List<Point> obstacles) {
        this.width = width;
        this.height = height;
        this.obstacles = obstacles;
    }

    public boolean isWithinBounds(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    public boolean hasObstacle(int x, int y) {
        return obstacles.contains(new Point(x, y));
    }
}
