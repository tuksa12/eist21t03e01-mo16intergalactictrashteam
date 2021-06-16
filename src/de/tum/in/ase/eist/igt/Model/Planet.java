package de.tum.in.ase.eist.igt.Model;

public class Planet extends StationaryObject {

    private static final String PLANET_IMAGE_FILE = "planet.png";
    private final double gravity;

    private static final int PLANET_HEIGHT = 25;
    private static final int PLANET_WIDTH = 25;

    public Planet(double startX, double startY, int mass) {
        super(startX, startY, mass, PLANET_WIDTH, PLANET_HEIGHT, PLANET_IMAGE_FILE);
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

