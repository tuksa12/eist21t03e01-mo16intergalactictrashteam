package de.tum.in.ase.eist.igt.Model;

import de.tum.in.ase.eist.igt.Controller.Dimension2D;
import de.tum.in.ase.eist.igt.Controller.Point2D;

public abstract class GameObject {

    private String iconLocation;
    private int mass;
    private Point2D position;
    private Dimension2D size;


    public GameObject(double startX, double startY, int mass, int width, int height, String iconLocation) {
        this.position = new Point2D(startX, startY);
        this.mass = mass;
        this.size = new Dimension2D(width, height);
        this.setIconLocation(iconLocation);
    }

    /* ---------- GETTERS ----------*/
    public Dimension2D getSize(){
        return size;
    }

    public int getMass() {
        return this.mass;
    }

    public Point2D getPosition() {
        return this.position;
    }

    public void setPosition(int newX, int newY) {
        this.position = new Point2D(newX, newY);
    }

    public String getIconLocation() {return this.iconLocation; }

    /* --------- SETTERS ---------- */
    /**
     * Sets the image path of an game object.
     *
     * @param iconLocation the path to the image file
     * @throws NullPointerException if iconLocation is null
     */
    public void setIconLocation(String iconLocation){
        if (iconLocation == null) throw new NullPointerException("Image location mustn't be null!");
        this.iconLocation = iconLocation;
    }

}

