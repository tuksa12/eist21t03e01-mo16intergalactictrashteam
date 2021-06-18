package de.tum.in.ase.eist.igt.Model;

import de.tum.in.ase.eist.igt.Controller.Dimension2D;
import de.tum.in.ase.eist.igt.Controller.Point2D;

public abstract class MovableObject extends GameObject {

    protected static final int MAX_ANGLE = 360;
    protected static final int HALF_ANGLE = MAX_ANGLE / 2;

    private int direction;
    private int speed;
    private int acceleration;
    private boolean onBoard;

    public MovableObject(double startX, double startY, int mass, int width, int height, String iconLocation, int speed,
                         int acceleration, int direction){
        super(startX, startY, mass, width, height, iconLocation);
        this.direction = direction;
        this.speed = speed;
        this.acceleration = acceleration;
        this.onBoard = true;
    }

    /**
     * Move the object in the game model according to the current orientation, speed and acceleration.
     * TODO: add arguments to model gravitational impacts on movement
     * */
    public void move(Dimension2D gameBoardSize) {

        /*if (this.crunched) { // debries evaporated?
            return;
        }*/

        double maxX = gameBoardSize.getWidth();
        double maxY = gameBoardSize.getHeight();
        // calculate delta between old coordinates and new ones based on speed and
        // direction
        double deltaX = this.speed * Math.sin(Math.toRadians(this.direction));
        double deltaY = this.speed * Math.cos(Math.toRadians(this.direction));
        double newX = this.position.getX() + deltaX;
        double newY = this.position.getY() + deltaY;

        // calculate position in case the boarder of the game board has been reached bounce the spacecraft off the edge
        if (this.getClass() == SpaceCraft.class){
            if (newX < 0) {
                newX = -newX;
                this.direction = MAX_ANGLE - this.direction;
            } else if (newX + this.size.getWidth() > maxX) {
                newX = 2 * maxX - newX - 2 * this.size.getWidth();
                this.direction = MAX_ANGLE - this.direction;
            }

            if (newY < 0) {
                newY = -newY;
                this.direction = HALF_ANGLE - this.direction;
                if (this.direction < 0) {
                    this.direction = MAX_ANGLE + this.direction;
                }
            } else if (newY + this.size.getHeight() > maxY) {
                newY = 2 * maxY - newY - 2 * this.size.getHeight();
                this.direction = HALF_ANGLE - this.direction;
                if (this.direction < 0) {
                    this.direction = MAX_ANGLE + this.direction;
                }
            }
        } else {
            this.onBoard = false;
        }

        // set coordinates
        this.position = new Point2D(newX, newY);
    }

    /* ----------- GETTERS ---------- */
    public boolean isOnBoard() { return this.onBoard; }

    public int getSpeed() { return speed; }

    public int getAcceleration() { return acceleration; }

    /* ----------- SETTERS ---------- */
    public void setSpeed(int speed) { this.speed = speed; }

    /**
     * TODO: increase acceleration
     * */
    public void setAcceleration(int acceleration) {
        this.acceleration = acceleration;
    }

    public void setOnBoard(boolean onBoard) { this.onBoard = onBoard; }

    public void setDirection(int direction) { this.direction = direction; }
}
