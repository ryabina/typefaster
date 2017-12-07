package typefaster.controllers;

import org.junit.Before;
import org.junit.Test;
import typefaster.models.Game;
import typefaster.models.IGame;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GameControllerTest {
    IGame mockGame;
    IGameController gameController;
    @Before
    public void setUp() throws Exception {
        gameController = new GameController();
        mockGame = mock(Game.class);
    }

    @Test
    public void startGame() {
        // Arrange
        String expectedResponse = "Game started!";
        // Act
        String actualResponse = gameController.startGame();
        // Assert
        verify(mockGame).setStartTime();
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    public void endGame() {
    }

    @Test
    public void showVelocity() {
    }
}