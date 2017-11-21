package typefaster.models;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GameTest {
    IGame game;
    @Before
    public void setUp() throws Exception {
        game = mock(Game.class, CALLS_REAL_METHODS);
    }

    @Test
    public void getVelocityTestHappyPath(){
        // Arrange
        Double expectedTime = 15.0;
        Integer expectedLength = 10;
        Double expectedVelocity = expectedLength/expectedTime;
        doReturn(expectedTime).when(game).getTotalTime();
        IText mockText = mock(IText.class);
        doReturn(expectedLength).when(mockText).getLength();
        game.setText(mockText);
        // Act
        Double actualVelocity = game.getVelocity();
        // Assert
        assertEquals(expectedVelocity, actualVelocity);
    }
}
