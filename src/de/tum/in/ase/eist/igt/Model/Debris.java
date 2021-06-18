package de.tum.in.ase.eist.igt.Model;

public class Debris extends MovableObject{

    /**
     * TODO: spawn derbies on a random edge position
     *
     * */

    private int[] movement;
    private static final String DEBRIS_IMAGE_FILE = "Debris.png";

    private static final int DEBRIS_HEIGHT = 25;
    private static final int DEBRIS_WIDTH = 25;
    private static final int INITIAL_SPEED = 10;
    private static final int ACCELERATION = 0;
    private static final int INITIAL_DIRECTION = 0;


    public Debris(double startX, double startY, int mass, int speedX, int speedY) {
        super(startX, startY, mass, DEBRIS_WIDTH, DEBRIS_HEIGHT, DEBRIS_IMAGE_FILE, INITIAL_SPEED, ACCELERATION, INITIAL_DIRECTION);
        movement = new int[2];
        movement[0] = speedX;
        movement[1] = speedY;
    }

    /*
    destroys the current debris and instantiates 2 new ones
     */
    public void split(){
        Debris d1 = new Debris(getPosition().getX(), getPosition().getY(), getMass()/2, movement[0], movement[1]);
        Debris d2 = new Debris(getPosition().getX(), getPosition().getY(), getMass()/2, movement[0], movement[1]);
        evaporate();
    }

    /**
     * Destroys this debris when collided with a planet and tags it for removal from the game board.
     */
    public void evaporate(){ this.setOnBoard(false); }

}
