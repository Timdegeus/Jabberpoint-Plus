
package SlidePackage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.font.TextAttribute;
import java.text.AttributedString;
import java.awt.image.BufferedImage;

import static org.junit.jupiter.api.Assertions.*;


public class TextItemTest {
    private TextItem textItem;
    private Style style;

    @BeforeEach
    public void setUp()
    {
        textItem = new TextItem(1, "Test text");
        style = new Style(20, Color.blue, 40, 10);
    }

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

    @Test
    public void testGetText()
    {
        assertEquals("Test text", textItem.getText());
    }

    @Test
    public void TextItemTest_GetAttributedString_ShouldReturnFontAttribute()
    {
        float scale = 1.0f;
        AttributedString attributedString = textItem.getAttributedString(style, scale);
        assertEquals(style.getFont(), attributedString.getIterator().getAttribute(TextAttribute.FONT));
    }

    @Test
    public void TextItemTest_GetBoundingBox_ShouldReturnBoundingBox()
    {
        BufferedImage image = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_ARGB);
        Graphics g = image.getGraphics();
        float scale = 1.0f;
        Rectangle boundingBox = textItem.getBoundingBox(g, null, scale, style);
        assertNotNull(boundingBox);
        assertTrue(boundingBox.width > 0);
        assertTrue(boundingBox.height > 0);
    }

    @Test
    public void TextItemTest_Draw_ShouldDrawTextItem()
    {
        BufferedImage image = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = image.createGraphics();
        g.setColor(Color.WHITE); // Ensure the background is non-transparent
        g.fillRect(0, 0, image.getWidth(), image.getHeight());
        g.setColor(style.getColor()); // Set the drawing color
        g.setFont(style.getFont(1.0f)); // Set the font
        float scale = 1.0f;
        textItem.draw(10, 10, scale, g, style, null);
        g.dispose(); // Dispose of the graphics context

        // Check if the graphics object has been drawn upon
        int pixelColor = image.getRGB(10, 10); // An arbitrary pixel to check
        assertNotEquals(0, pixelColor); // The pixel should not be fully transparent
    }
}
