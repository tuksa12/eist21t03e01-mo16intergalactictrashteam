package de.tum.in.ase.eist.igt.Model;

public class Shot extends Object{

    private double speed;

    public Shot(int startX, int startY) {
        super(startX, startY, 0);
        this.speed = 4;
    }

    public double getSpeed() { return this.speed; }
}

