package de.tum.in.ase.eist.igt.Model;


public class SpaceCraft extends Object {

    private int lifePoints;

    public SpaceCraft(int startX, int startY, int mass) {
        super(startX, startY, mass);
        this.lifePoints = 3;
    }
    /*
    it moves the spacecraft according to the input from the Player class
     */
    public void steer() {}

    public void processInput() {

    }

    public void shoot() {
        Shot shot = new Shot(this.getPosition()[0], this.getPosition()[1]);
    }

    public int getLifePoints() { return this.lifePoints; }
}
