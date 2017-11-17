package typefaster.models;
import com.sun.xml.internal.ws.developer.UsesJAXBContext;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {
    IGame game;
    @Before
    public void setUp() throws Exception {
        game = new Game();
    }

    @Test
    public void getVelocityTestHappyPath(){
        // Arrange
        Double expectedVelocity;
        // Act
        Double actualVelocity = game.getVelocity();
        // Assert
        assertEquals(expectedVelocity, actualVelocity);
    }
}
