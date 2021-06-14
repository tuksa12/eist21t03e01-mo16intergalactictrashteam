package de.tum.in.ase.eist.igt.Controller;

import de.tum.in.ase.eist.igt.Model.SpaceCraft;

public class Player { //TODO

    private static final double START_X_COORDINATE = 0.0;
    private static final double START_Y_COORDINATE = 0.0;
    private static final int START_DIRECTION = 90;

    private SpaceCraft spaceCraft;

    public Player(SpaceCraft spaceCraft) {
        this.spaceCraft = spaceCraft;
    }

    public void setSpaceCraft(SpaceCraft spaceCraft) {
        this.spaceCraft = spaceCraft;
    }

    public SpaceCraft getSpaceCraft() {
        return spaceCraft;
    }

    public void setup() {
        // The player always starts in the upper left corner facing to the right
        spaceCraft.setPosition(START_X_COORDINATE, START_Y_COORDINATE);
        spaceCraft.setDirection(START_DIRECTION);
    }
}
