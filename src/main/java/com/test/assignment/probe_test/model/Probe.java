package com.test.assignment.probe_test.model;

public class Probe {

    private int posX;
    private int posY;
    private Direction facingDirection;

    /**
     * Constructor to initialize the probe's position and direction.
     *
     * @param posX           Initial X-coordinate
     * @param posY           Initial Y-coordinate
     * @param facingDirection Initial direction (NORTH, EAST, SOUTH, WEST)
     */
    public Probe(int posX, int posY, Direction facingDirection) {
        this.posX = posX;
        this.posY = posY;
        this.facingDirection = facingDirection;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public Direction getFacingDirection() {
        return facingDirection;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void setFacingDirection(Direction facingDirection) {
        this.facingDirection = facingDirection;
    }

    public void moveForward() {
        switch (facingDirection) {
            case NORTH -> posY++;
            case SOUTH -> posY--;
            case EAST  -> posX++;
            case WEST  -> posX--;
        }
    }

    public void moveBackward() {
        switch (facingDirection) {
            case NORTH -> posY--;
            case SOUTH -> posY++;
            case EAST  -> posX--;
            case WEST  -> posX++;
        }
    }
}
