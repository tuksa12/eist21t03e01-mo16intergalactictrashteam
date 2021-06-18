package de.tum.in.ase.eist.igt.Controller;

import de.tum.in.ase.eist.igt.Model.Debris;
import de.tum.in.ase.eist.igt.Model.GameObject;
import de.tum.in.ase.eist.igt.Model.Planet;
import de.tum.in.ase.eist.igt.Model.SpaceCraft;
import de.tum.in.ase.eist.igt.View.GameView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class GameBoard {

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
        SpaceCraft playerCraft = new SpaceCraft();
        this.player = new Player(playerCraft);
        this.player.setup();
        createGameObjects();
        PlayerInput playerInput = new PlayerInput(player.getSpaceCraft());
    }

    /**
     * Create game objects in the model, including all planets, debris and the space craft.
     *
     * */
    private void createGameObjects() {

        this.gameObjects.add(new Planet(100.0, 100.0, 42, 30,30,"planet.png"));
        this.gameObjects.add(new Planet(200.0, 200.0, 9000,30,30,"planet-brown.png"));
        this.gameObjects.add(this.player.getSpaceCraft());
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
        moveGameObjects();
    }

    public void startGame(){
        this.running = true;
    }

    public void stopGame(){
        this.running = false;
    }

    private Collection<Debris> getDebris(){
        HashSet<Debris> debris = new HashSet<>();

        for (GameObject gameObject : this.gameObjects){
            if (gameObject.getClass() == Debris.class) debris.add((Debris) gameObject);
        }

        return debris;
    }

    public void moveGameObjects() {
        // update the positions of the player car and the autonomous cars
        for (Debris debris : this.getDebris()) {

            // move debris
            debris.move(size);

            // remove object if it went off board, meaning it crossed the canvas boundaries
            if (!debris.isOnBoard()) this.getDebris().remove(debris);
        }

        this.player.getSpaceCraft().move(size);

        /*// iterate through all debris and check if it is crunched
        for (Debris debris : debris) {
            *//*if (debris.isCrunched()) {
                // because there is no need to check for a collision
                continue;
            }*//*

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
