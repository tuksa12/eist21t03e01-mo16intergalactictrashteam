package de.tum.in.ase.eist.igt.Model;

import de.tum.in.ase.eist.igt.Controller.Dimension2D;
import de.tum.in.ase.eist.igt.Controller.Point2D;

public abstract class GameObject {

    private int mass;
    private Point2D position;
    private Dimension2D size;


    public GameObject(double startX, double startY, int mass, int width, int height, String iconLocation) {
        this.position = new Point2D(startX, startY);
        this.mass = mass;
        this.size = new Dimension2D(width, height);
        this.setIconLocation(iconLocation);
    }

    public int getMass() {
        return this.mass;
    }

    public int[] getPosition() {
        return this.position;
    }

    public void setPosition(int newX, int newY) {
        this.position[0] = newX;
        this.position[1] = newY;
    }

}

