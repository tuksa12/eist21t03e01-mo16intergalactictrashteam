package de.tum.in.ase.eist.igt.Model;

public class Debris extends Object {
    private int[] movement;

    public Debris(int startX, int startY, int mass, int speedX, int speedY) {
        super(startX, startY, mass);
        movement = new int[2];
        movement[0] = speedX;
        movement[1] = speedY;
    }

    /*
    destroys the current debris and instantiates 2 new ones
     */
    public void split(){
        Debris d1 = new Debris(getPosition()[0], getPosition()[1], getMass()/2, movement[0], movement[1]);
        Debris d2 = new Debris(getPosition()[0], getPosition()[1], getMass()/2, movement[0], movement[1]);
        evaporate();
    }

    /*
    destroys this debris
     */
    public void evaporate(){}
}
