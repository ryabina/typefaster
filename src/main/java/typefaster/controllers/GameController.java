package typefaster.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import typefaster.models.Game;
import typefaster.models.IGame;

@Controller
public class GameController implements IGameController {
    IGame game = new Game();
    @Override
    @RequestMapping(path = "/game", method = RequestMethod.POST)
    public String startGame() {
        game.setStartTime();
        return "startGame";
    }

    @Override
    @RequestMapping(path = "/game", method = RequestMethod.PATCH)
    public String endGame(String text) {
        game.setText(text);
        game.setEndTime();
        return "endGame";
    }

    @Override
    @RequestMapping(path = "/game", method = RequestMethod.GET)
    public String showVelocity(){
        try{
            game.getVelocity();
        }
        catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return "velocity";
    }
}
