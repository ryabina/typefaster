package typefaster.models;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;


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
        Double expectedTime = 10.0;
        Integer expectedLength = 15;
        Double expectedVelocity = 1.5;
        doReturn(expectedTime).when(game).getTotalTime();
        IText mockText = mock(IText.class);
        doReturn(expectedLength).when(mockText).getLength();
        game.setText(mockText);
        // Act
        Double actualVelocity = game.getVelocity();
        // Assert
        assertEquals(expectedVelocity, actualVelocity);
    }

    @Test(expected = ArithmeticException.class)
    public void getVelocityTestNoTime(){
        // Arrange
        Double expectedTime = 0.0;
        doReturn(expectedTime).when(game).getTotalTime();
        IText mockText = mock(IText.class);
        game.setText(mockText);
        // Act
        game.getVelocity();
        // Assert
        fail("did not throw exception");
    }

    @Test
    public void getTotalTimeHappyPath(){
        // Arrange
        DateTime expectedEndTime = new DateTime(1511768832000L);
        DateTime expectedStartTime = new DateTime(1511768822000L);
        Double expectedTotalTime = 10.0;
        doReturn(expectedEndTime).when(game).getEndTime();
        doReturn(expectedStartTime).when(game).getStartTime();
        // Act
        Double actualTotalTime = game.getTotalTime();
        // Assert
        assertEquals(expectedTotalTime,actualTotalTime);
    }

    @Test
    public void setEndTime(){
        // Arrange
        // Act
        game.setEndTime();
        // Assert
        verify(game).getCurrentTime();
    }

    @Test
    public void getEndTimeNoEndTime(){
        // Arrange
        // Act
        game.getEndTime();
        // Assert
        verify(game).setEndTime();
    }
}
