package com.test.assignment.probe_test.controller;

import com.test.assignment.probe_test.dto.CommandRequest;
import com.test.assignment.probe_test.dto.CommandResponse;
import com.test.assignment.probe_test.model.Direction;
import com.test.assignment.probe_test.model.Grid;
import com.test.assignment.probe_test.model.Probe;
import com.test.assignment.probe_test.service.ProbeService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/api/probe")
public class ProbeController {

    @PostMapping("/move")
    @Operation(summary = "Execute commands for the ocean probe")
    public CommandResponse moveProbe(@RequestBody CommandRequest request) {

        Grid grid = new Grid(
                request.grid.width,
                request.grid.height,
                request.grid.obstacles
        );

        Probe probe = new Probe(
                request.probe.x,
                request.probe.y,
                Direction.valueOf(request.probe.direction.toUpperCase())
        );

        ProbeService service = new ProbeService(grid);
        List<Point> visited = service.executeCommands(probe, request.commands);

        return new CommandResponse(
                new Point(probe.getPosX(), probe.getPosY()),
                probe.getFacingDirection().name(),
                visited
        );
    }
}
