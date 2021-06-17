package de.tum.in.ase.eist.igt.Model;

public class Planet extends StationaryObject {

    private final double gravity;

    public Planet(double startX, double startY, int mass, int planet_width, int planet_height, String fileName) {
        super(startX, startY, mass, planet_width, planet_height, fileName);
        this.gravity = 2;
    }


    /*
    this methods takes a object as a parameter (either a Debris object or the spacecraft) and returns the gravitational pull on that object
     */
    public double gravityAttraction(GameObject obj) {
        double gravityValue = gravity * this.getMass() * obj.getMass();
        double distance = Math.hypot(this.getPosition().getX() - obj.getPosition().getX(), this.getPosition().getY() - obj.getPosition().getY());
        return gravityValue/distance;
    }

    public boolean closeEnough(GameObject obj) {
        double distance = Math.hypot(this.getPosition().getX() - obj.getPosition().getX(), this.getPosition().getY() - obj.getPosition().getY());

        if (distance <= 2.5) {
            return true;
        }
        return false;
    }
}

