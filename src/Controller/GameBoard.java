package Controller;

import Model.Obstacles;
import View.GameView;

import java.util.List;

public class GameBoard {
    private List<Obstacles> obstacles;
    private Player player;
    private GameView gameView;
    private boolean running;


    public void startGame(){
        running = true;
    }

    public void stopGame(){
        running = false;
    }
}
