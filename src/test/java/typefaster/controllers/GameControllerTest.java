package typefaster.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import typefaster.models.IGame;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
@RunWith(MockitoJUnitRunner.class)

public class GameControllerTest {
    @Mock
    IGame mockGame;
    @InjectMocks
    GameController gameController;
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void startGame() {
        // Arrange
        String expectedViewName = GameController.START_GAME_VIEW;
        // Act
        String actualViewName = gameController.startGame();
        // Assert
        verify(mockGame).setStartTime();
        assertEquals(expectedViewName, actualViewName);
    }

    @Test
    public void endGame() {
        // Arrange
        String expectedText = "Yo-yo-yo";
        String expectedViewName = GameController.END_GAME_VIEW;
        // Act
        String actualViewName = gameController.endGame(expectedText);
        // Assert
        verify(mockGame).setText(expectedText);
        verify(mockGame).setEndTime();
        assertEquals(expectedViewName, actualViewName);
    }

    @Test
    public void showVelocity() throws Exception {
        // Arrange
        String expectedViewName = GameController.VELOCITY_VIEW;
        // Act
        String actualViewName = gameController.showVelocity();
        // Assert
        verify(mockGame).getVelocity();
        assertEquals(expectedViewName, actualViewName);
    }

    @Test
    public void showHomePage(){
        // Arrange
        String expectedViewName = GameController.HOME_VIEW;
        // Act
        String actualViewName = gameController.showHomePage();
        // Assert
        assertEquals(expectedViewName, actualViewName);
    }
}