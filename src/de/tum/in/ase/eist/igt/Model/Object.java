package de.tum.in.ase.eist.igt.Model;

public abstract class Object {

    private int mass;
    private int[] position;

    public Object(int startX, int startY, int mass) {
        this.position = new int[2];
        this.position[0] = startX;
        this.position[1] = startY;
        this.mass = mass;
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

