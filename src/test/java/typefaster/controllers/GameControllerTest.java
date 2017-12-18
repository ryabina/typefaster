package typefaster.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import typefaster.models.Game;
import typefaster.models.IGame;
import typefaster.models.IText;
import typefaster.models.Text;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
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
        String expectedResponse = "startGame";
        // Act
        String actualResponse = gameController.startGame();
        // Assert
        verify(mockGame).setStartTime();
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    public void endGame() {
        // Arrange
        String expectedText = "Yo-yo-yo";
        String expectedResponse = "endGame";
        // Act
        String actualResponse = gameController.endGame(expectedText);
        // Assert
        verify(mockGame).setText(expectedText);
        verify(mockGame).setEndTime();
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    public void showVelocity() throws Exception {
        // Arrange
        String expectedVelocity = "velocity";
        // Act
        String actualVelocity = gameController.showVelocity();
        // Assert
        verify(mockGame).getVelocity();
        assertEquals(expectedVelocity, actualVelocity);
    }
}