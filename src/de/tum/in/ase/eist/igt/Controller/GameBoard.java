package de.tum.in.ase.eist.igt.Controller;

import de.tum.in.ase.eist.igt.Model.Debris;
import de.tum.in.ase.eist.igt.Model.GameObject;
import de.tum.in.ase.eist.igt.Model.Planet;
import de.tum.in.ase.eist.igt.Model.SpaceCraft;
import de.tum.in.ase.eist.igt.View.GameView;

import java.util.ArrayList;
import java.util.List;

public class GameBoard { //TODO

    private static final int NUMBER_OF_DEBRIS = 5;
    private static final int NUMBER_OF_PLANETS = 3;

    private final List<GameObject> gameObjects;

    private Player player;

    private GameView gameView;

    private final Dimension2D size;

    private boolean running;

    private GameOutcome gameOutcome = GameOutcome.OPEN;

    public GameBoard(Dimension2D size) {
        this.size = size;
        this.gameObjects = new ArrayList<GameObject>();
        //SpaceCraft playerCraft = new SpaceCraft();
        //this.player = new Player(playerCraft);
        //this.player.setup();
        createObstacles();
    }

    private void createObstacles() {
        /*for (int i = 0; i < NUMBER_OF_PLANETS; i++) {
            this.gameObjects.add(new Planet(this.size));
        }*/

        this.gameObjects.add(new Planet(100.0, 100.0, 42, 30,30,"planet.png"));
        this.gameObjects.add(new Planet(200.0, 200.0, 9000,30,30,"planet-brown.png"));
        //this.gameObjects.add(new SpaceCraft(25.0, 20.0, 10, 25, 25));
    }

    public Dimension2D getSize() {
        return size;
    }

    public boolean isRunning() {
        return this.running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public GameOutcome getGameOutcome() {
        return gameOutcome;
    }

    public List<GameObject> getGameObjects() {
        return this.gameObjects;
    }

    public SpaceCraft getPlayerSpaceCraft() {
        return this.player.getSpaceCraft();
    }

    public void update() {
        moveObstacles();
    }

    public void startGame(){
        this.running = true;
    }

    public void stopGame(){
        this.running = false;
    }

    public void moveObstacles() {
        // update the positions of the player car and the autonomous cars
        /*for (Debris debris : this.debris) {
            debris.drive(size);
        }
        this.player.getSpaceCraft().drive(size);

        // iterate through all debris and check if it is crunched
        for (Debris debris : debris) {
            if (debris.isCrunched()) {
                // because there is no need to check for a collision
                continue;
            }

            Collision collision = new Collision(player.getSpaceCraft(), debris);

            if (collision.isCrash()) {
                Car winner = collision.evaluate();
                Car loser = collision.evaluateLoser();
                printWinner(winner);
                loserCars.add(loser);

                loser.crunch();

                if(isWinner()){
                    gameOutcome = GameOutcome.WON;
                } else{
                    gameOutcome = GameOutcome.LOST;
                }

            }
        }*/
    }


}
