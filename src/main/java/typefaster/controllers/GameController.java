package typefaster.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import typefaster.models.Game;
import typefaster.models.IGame;

@Controller
public class GameController implements IGameController {
    public static final String START_GAME_VIEW = "startGame";
    public static final String END_GAME_VIEW = "endGame";
    public static final String VELOCITY_VIEW = "velocity";
    public static final String HOME_VIEW = "home";

    IGame game = new Game();
    @Override
    @RequestMapping(path = "/game", method = RequestMethod.POST)
    public String startGame() {
        game.setStartTime();
        return START_GAME_VIEW;
    }

    @Override
    @RequestMapping(path = "/game", method = RequestMethod.PATCH)
    public String endGame(String text) {
        game.setText(text);
        game.setEndTime();
        return END_GAME_VIEW;
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
        return VELOCITY_VIEW;
    }

    @Override
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String showHomePage() {
        return HOME_VIEW;
    }
}
