package com.test.assignment.probe_test.dto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.awt.*;
import java.util.List;

public class CommandRequest {
    public GridRequest grid;
    public ProbeRequest probe;
    public String commands;

    public static class GridRequest {
        @Min(1)
        public int width;

        @Min(1)
        public int height;

        public List<List<Integer>> obstacles;
    }

    public static class ProbeRequest {
        @Min(0)
        public int x;

        @Min(0)
        public int y;

        @NotBlank
        public String direction;
    }
}

