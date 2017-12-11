package typefaster.controllers;

import typefaster.models.Game;
import typefaster.models.IGame;

public class GameController implements IGameController {
    IGame game = new Game();
    @Override
    public String startGame() {
        game.setStartTime();
        return "Game started!";
    }

    @Override
    public String endGame(String text) {
        return null;
    }

    @Override
    public String showVelocity() {
        return null;
    }
}
