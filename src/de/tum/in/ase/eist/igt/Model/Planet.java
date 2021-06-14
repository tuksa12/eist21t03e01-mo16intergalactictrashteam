package de.tum.in.ase.eist.igt.Model;

public class Planet extends Object {

    private final double gravity;

    public Planet(int startX, int startY, int mass) {
        super(startX, startY, mass);
        this.gravity = 2;
    }

    /*
    this methods takes a object as a parameter (either a Debris object or the spacecraft) and returns the gravitational pull on that object
     */
    public double gravityAttraction(Object obj) {
        double gravityValue = gravity * this.getMass() * obj.getMass();
        double distance = Math.hypot(this.getPosition()[0] - obj.getPosition()[0], this.getPosition()[1] - obj.getPosition()[1]);
        return gravityValue/distance;
    }

    public boolean closeEnough(Object obj) {
        double distance = Math.hypot(this.getPosition()[0] - obj.getPosition()[0], this.getPosition()[1] - obj.getPosition()[1]);

        if (distance <= 2.5) {
            return true;
        }
        return false;
    }
}

