package typefaster.models;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class GameTest {
    @Mock
    IText mockText;

    @InjectMocks
    @Spy
    Game game;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getVelocityTestHappyPath()throws Exception{
        // Arrange
        Double expectedTime = 10.0;
        Integer expectedLength = 15;
        Double expectedVelocity = 1.5;
        doReturn(expectedTime).when(game).getTotalTime();
        doReturn(expectedLength).when(mockText).getLength();
        // Act
        Double actualVelocity = game.getVelocity();
        // Assert
        assertEquals(expectedVelocity, actualVelocity);
    }

    @Test(expected = ArithmeticException.class)
    public void getVelocityTestNoTime() throws Exception{
        // Arrange
        Double expectedTime = 0.0;
        doReturn(expectedTime).when(game).getTotalTime();
        // Act
        game.getVelocity();
        // Assert
        fail("did not throw exception");
    }

    @Test (expected = Exception.class)
    public void getVelocityTestNoData() throws Exception{
        // Arrange
        // Act
        game.getVelocity();
        // Assert
        fail("did not throw exception");
    }


    @Test
    public void getTotalTimeHappyPath() throws Exception{
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

    @Test
    public void setStartTime(){
        // Arrange
        // Act
        game.setStartTime();
        // Assert
        verify(game).getCurrentTime();
    }

    @Test
    public void getStartTime() throws Exception{
        // Arrange
        DateTime expectedStartTime = new DateTime(1511768832000L);
        doReturn(expectedStartTime).when(game).getCurrentTime();
        game.setStartTime();
        // Act
        DateTime actualStartTime = game.getStartTime();
        // Assert
        assertEquals(expectedStartTime, actualStartTime);
    }

    @Test(expected = Exception.class)
    public void getStartTimeNoTime() throws Exception{
        // Arrange
        // Act
        game.getStartTime();
        // Assert
        fail("did not throw exception");
    }

    @Test (expected = Exception.class)
    public void getTotalTimeNoStartTime() throws Exception{
        // Arrange
        // Act
        game.getTotalTime();
        // Assert
        fail("did not throw exception");
    }
    @Test
    public void setText(){
        // Arrange
        String expectedText = "Yo-yo-yo!";
        // Act
        game.setText(expectedText);
        // Assert
        verify(mockText).setText(expectedText);
    }
}
