package typefaster.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TextTest {
    IText text;

    @Before
    public void setUp() throws Exception {
        text = new Text();
    }

    @Test
    public void getLength() {
        // Arrange
        String expectedText = "1234567890";
        Integer expectedLength = 10;
        text.setText(expectedText);

        // Act
        Integer actualLength = text.getLength();

        // Assert
        assertEquals(expectedLength, actualLength);
    }

}