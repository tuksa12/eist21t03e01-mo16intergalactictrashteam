package de.tum.in.ase.eist.igt.Controller;

import de.tum.in.ase.eist.igt.Model.SpaceCraft;
import de.tum.in.ase.eist.igt.View.GameBoardUI;
import javafx.scene.input.KeyEvent;


/**
 * For some reason our KeyboardInput was not detected when using this class like MouseSteering. Therefore we hot-fixed
 *  it by implementing the keyboard controls in the GalacticGarbagemenApplication directly.
 * */
public class KeyboardInput {

    private final SpaceCraft spaceCraft;

    public KeyboardInput(GameBoardUI gameBoardUI, SpaceCraft userSpaceCraft) {
        this.spaceCraft = userSpaceCraft;
        gameBoardUI.addEventHandler(KeyEvent.KEY_PRESSED, this::keyPressed);
    }

    /**
     * Handles keyboard input and manipulates the space craft accordingly with acceleration / deceleration and tilting
     *  operations.
     *
     * @implNote Hot fixed in GalacticGarbagemenApplication.start() as this method did not recognized the input.
     *
     * TODO: add shooting functionality
     * */
    protected void keyPressed(KeyEvent keyInput) {

        switch (keyInput.getCode()) {
            case W, UP -> {
                spaceCraft.accelerate();
                System.out.println("Up pressed");
            }
            case S, DOWN -> {
                spaceCraft.decelerate();
                System.out.println("Down pressed");
            }
            case A, LEFT -> {
                spaceCraft.setDirection(2);
                System.out.println("Left pressed");
            }
            case D, RIGHT -> {
                spaceCraft.setDirection(-2);
                System.out.println("Right pressed");
            }
        }

        System.out.println(keyInput.getCharacter());

        /*
        double deltaX = clickPosition.getX() - spaceCraftPosition.getX();
        deltaX = Math.abs(deltaX);
        double deltaY = clickPosition.getY() - spaceCraftPosition.getY();
        int degree = (int) Math.toDegrees(Math.atan2(deltaY, deltaX));

        if (clickPosition.getX() > spaceCraftPosition.getX()) {
            degree = ANGLE_90_DEGREES - degree;
        } else {
            degree = ANGLE_270_DEGREES + degree;
        }

        spaceCraft.setDirection(degree);
        */
    }

}
