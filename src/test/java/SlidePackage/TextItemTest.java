package SlidePackage;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextItemTest
{
    @Test
    void getTextTest_whereTextIsSet_shouldReturnText()
    {
        TextItem textItem = new TextItem(0, "testText");
        assertEquals("testText", textItem.getText());
    }

    @Test
    void getTextTest_whereTextIsNotSet_shouldReturnNoTextGiven()
    {
        TextItem textItem = new TextItem();
        assertEquals("No Text Given", textItem.getText());
    }
}
