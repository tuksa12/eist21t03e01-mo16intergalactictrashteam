package de.tum.in.ase.eist.igt.Controller;

import de.tum.in.ase.eist.igt.Model.SpaceCraft;
import de.tum.in.ase.eist.igt.View.GameBoardUI;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class KeyboardInput {

    private SpaceCraft spaceCraft;

    public KeyboardInput(GameBoardUI gameBoardUI, SpaceCraft userSpaceCraft) {
        this.spaceCraft = userSpaceCraft;
        gameBoardUI.addEventHandler(KeyEvent.KEY_PRESSED, this::keyPressed);
    }

    /**
     *
     * TODO: implement tilting for A and D input
     * */
    private void keyPressed(KeyEvent keyInput) {
        Point2D spaceCraftPosition = spaceCraft.getPosition();

        switch(keyInput.getCode()) {

            case UP, W: spaceCraft.setPosition(spaceCraft.getPosition().getX(), spaceCraft.getPosition().getY() - spaceCraft.getSpeed());
                break;

            case S, DOWN: spaceCraft.setPosition(spaceCraft.getPosition().getX(), spaceCraft.getPosition().getY() + spaceCraft.getSpeed());
                break;

            case A, LEFT: spaceCraft.setPosition(spaceCraft.getPosition().getX() - spaceCraft.getSpeed(), spaceCraft.getPosition().getY());
                break;

            case D, RIGHT: spaceCraft.setPosition(spaceCraft.getPosition().getX() + spaceCraft.getSpeed(), spaceCraft.getPosition().getY());
                break;
        
        }

        /*double deltaX = clickPosition.getX() - spaceCraftPosition.getX();
        deltaX = Math.abs(deltaX);
        double deltaY = clickPosition.getY() - spaceCraftPosition.getY();
        int degree = (int) Math.toDegrees(Math.atan2(deltaY, deltaX));

        if (clickPosition.getX() > spaceCraftPosition.getX()) {
            degree = ANGLE_90_DEGREES - degree;
        } else {
            degree = ANGLE_270_DEGREES + degree;
        }

        spaceCraft.setDirection(degree);*/
    }

}
