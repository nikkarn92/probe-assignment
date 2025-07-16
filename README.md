# Ocean Probe Control API

A Spring Boot REST API to remotely control a submersible probe on an ocean grid.

---

## Features

- Move the probe forward (`F`) or backward (`B`)
- Turn the probe left (`L`) or right (`R`)
- Block movement beyond grid or into obstacles
- Track and return visited coordinates
- Built using TDD (Test-Driven Development)
- Fully documented with Swagger

---

## Tech Stack

- Java 17
- Spring Boot
- JUnit 5
- Mockito
- Springdoc OpenAPI (Swagger)

---

## API Endpoint

**POST** `/api/probe/move`

### Sample Request

```json
{
  "grid": {
    "width": 5,
    "height": 5,
    "obstacles": [[2, 2], [3, 3]]
  },
  "probe": {
    "x": 0,
    "y": 0,
    "direction": "NORTH"
  },
  "commands": "FFRFF"
}
```

### Sample Response

```json
{
  "finalPosition": [2, 2],
  "direction": "EAST",
  "visited": [[0,0], [0,1], [0,2], [1,2], [2,2]]
}
```

---

## Running Tests

```bash
./mvnw test
```

---

## Swagger UI

Once the app is running, explore the API at:  
[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---

## 📜 Git Commit History (Chronological TDD Flow)

| Commit ID | Message                                      | Description                                    |
|-----------|----------------------------------------------|------------------------------------------------|
| fbebff5   | Initial commit                               | Empty Maven Spring Boot project created        |
| 75736ac   | Project Structure                            | Base folder/project setup                      |
| dfe8b84   | Create ProbeTest.java                        | Test class for Probe                           |
| 8f7d482   | add shouldInitializeProbeAtGivenPosition...  | TDD test for initializing Probe                |
| 6d7414e   | Create Probe.java                            | Probe class with position/direction            |
| 09500a7   | update shouldInitializeProbeAtGivenPosition  | Fix test with updated field names              |
| fc7326a   | add shouldMoveForwardWhenFacingNorth         | TDD test for moveForward                       |
| 2384a16   | add Direction.java                           | Direction enum (NORTH, SOUTH, EAST, WEST)      |
| d79737b   | add shouldMoveBackwardWhenFacingNorth        | TDD test for moveBackward                      |
| 1420a0a   | add moveBackward                             | Implement moveBackward in Probe                |
| fc8704a   | add shouldTurnLeftFromNorthToWest            | TDD test for turnLeft                          |
| d2148eb   | add turnLeft                                 | Implement turnLeft in Probe                    |
| 9654812   | add shouldTurnRightFromNorthToEast           | TDD test for turnRight                         |
| 93203ec   | add turnRight                                | Implement turnRight in Probe                   |
| 15dce5d   | Create GridTest.java                         | New test class for Grid logic                  |
| cb4a52c   | create shouldAllowMoveWithinBoundaries       | TDD test for valid in-bound movement           |
| 8fdc480   | add shouldRejectMoveOutsideBoundaries        | TDD test for out-of-bound movement             |
| 2f7407c   | Update Grid.java                             | Added obstacle handling in Grid                |
| 727c67b   | add shouldDetectObstacle                     | TDD test for obstacle detection                |
| 21ac4cf   | add hasObstacle                              | Obstacle check logic in Grid                   |
| d997d8a   | Create ProbeServiceTest.java                 | Test class for ProbeService                    |
| 9aa3d3d   | add shouldExecuteCommandsAndAvoidObstacles   | TDD test for full command flow                 |
| 7278caa   | Create ProbeService.java                     | Main executor logic for parsing commands       |
| f4bb2e6   | Create DTO class                             | CommandRequest and CommandResponse DTOs        |
| e360100   | Create ProbeController.java                  | REST API controller for /api/probe/move        |
| c8f570f   | Create GlobalExceptionHandler.java           | Global error handler for bad input             |
---

## Run the App

```bash
./mvnw spring-boot:run
```

---

## Author
Nikhil Karn
nik.karn92@gmail.com