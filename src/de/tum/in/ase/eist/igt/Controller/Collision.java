package de.tum.in.ase.eist.igt.Controller;

import de.tum.in.ase.eist.igt.Model.Debris;
import de.tum.in.ase.eist.igt.Model.Obstacles;
import de.tum.in.ase.eist.igt.Model.SpaceCraft;

public class Collision { //TODO

    protected final SpaceCraft car1;
    protected final Debris car2;
    private final boolean crash;

    public Collision(SpaceCraft car1, Debris car2) { // Perhaps multiple constructors depending on the collision
        this.car1 = car1;
        this.car2 = car2;
        this.crash = detectCollision();
    }

    public boolean isCrash() {
        return crash;
    }

    public boolean detectCollision() {
        Point2D p1 = car1.getPosition();
        Dimension2D d1 = car1.getSize();

        Point2D p2 = car2.getPosition();
        Dimension2D d2 = car2.getSize();

        boolean above = p1.getY() + d1.getHeight() < p2.getY();
        boolean below = p1.getY() > p2.getY() + d2.getHeight();
        boolean right = p1.getX() + d1.getWidth() < p2.getX();
        boolean left = p1.getX() > p2.getX() + d2.getWidth();

        return !above && !below && !right && !left;
    }

    public Obstacles evaluate() { // ??? How to evaluate collision: Lives?
                                  // Make SpaceCraft an obstacle??

        Point2D p1 = this.car1.getPosition();
        Point2D p2 = this.car2.getPosition();

        Car winnerCar = null;
        if (p1.getX() < p2.getX()) {
            winnerCar = this.car2;
        } else {
            winnerCar = this.car1;
        }
        return winnerCar;
    }

    public Obstacles evaluateLoser() {
        Car winner = evaluate();
        if (this.car1 == winner) {
            return this.car2;
        }
        return this.car1;
    }

}