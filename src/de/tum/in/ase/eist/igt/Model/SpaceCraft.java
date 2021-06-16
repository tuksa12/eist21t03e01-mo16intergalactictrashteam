package de.tum.in.ase.eist.igt.Model;


public class SpaceCraft extends MovableObject {

    private int lifePoints;
    private static final String SPACE_CRAFT_IMAGE_FILE = "SpaceCraft 2.png";
    private static final int SPACE_CRAFT_HEIGHT = 25;
    private static final int SPACE_CRAFT_WIDTH = 25;
    private String iconLocation;

    public SpaceCraft(double startX, double startY, int mass, int width, int height) {
        super(startX, startY, mass, SPACE_CRAFT_WIDTH, SPACE_CRAFT_HEIGHT, SPACE_CRAFT_IMAGE_FILE);
        this.lifePoints = 3;
    }
    /*
    TODO: setIconLocation() method must be added for the spacecraft icon
     */
    public void steer() {}

    public void processInput() {

    }

    public void shoot() {
        Shot shot = new Shot(this.getPosition().getX(), this.getPosition().getY());
    }

    public int getLifePoints() { return this.lifePoints; }

    public void setIconLocation(String iconLocation) {
        if (iconLocation == null) {
            throw new NullPointerException("The chassis image of a car cannot be null.");
        }
        this.iconLocation = iconLocation;
    }
}
