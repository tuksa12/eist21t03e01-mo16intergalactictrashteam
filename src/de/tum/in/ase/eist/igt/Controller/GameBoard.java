package de.tum.in.ase.eist.igt.Controller;

import de.tum.in.ase.eist.igt.Model.Obstacles;
import de.tum.in.ase.eist.igt.View.GameView;

import java.util.List;

public class GameBoard {
    private List<Obstacles> obstacles;
    private Player player;
    private GameView gameView;
    private boolean running;

    // de.tum.in.ase.eist.igt

    public void startGame(){
        running = true;
    }

    public void stopGame(){
        running = false;
    }
}
