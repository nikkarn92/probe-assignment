package com.test.assignment.probe_test.dto;
import java.awt.*;
import java.util.List;

public class CommandResponse {
    public Point finalPosition;
    public String direction;
    public List<Point> visited;

    public CommandResponse(Point finalPosition, String direction, List<Point> visited) {
        this.finalPosition = finalPosition;
        this.direction = direction;
        this.visited = visited;
    }
}
