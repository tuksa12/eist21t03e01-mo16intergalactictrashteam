package de.tum.in.ase.eist.igt.Model;

public abstract class MovableObject extends GameObject {


    public MovableObject(double startX, double startY, int mass, int width, int height, String iconLocation){
        super(startX, startY, mass, width, height, iconLocation);
    }

    public void move() {}

}
