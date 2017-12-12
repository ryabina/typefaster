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
        game.setText(text);
        game.setEndTime();
        return "Game ended!";
    }

    @Override
    public String showVelocity(){
        try{
            game.getVelocity();
        }
        catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return "Your velocity is great!";
    }
}
