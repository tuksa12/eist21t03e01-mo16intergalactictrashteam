package de.tum.in.ase.eist.igt.Model;

public class Shot extends MovableObject {

    private double speed;
    private static final String SHOT_IMAGE_FILE = "Lazer.png";

    private static final int SHOT_HEIGHT = 25;
    private static final int SHOT_WIDTH = 25;

    public Shot(double startX, double startY) {
        super(startX, startY, 0, SHOT_WIDTH, SHOT_HEIGHT, SHOT_IMAGE_FILE);
        this.speed = 4;
    }

    public double getSpeed() { return this.speed; }
}

