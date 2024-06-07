
package SlidePackage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.BufferedImage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BitmapItemTest
{
    private BitmapItem bitmapItem;
    private Style style;

    @BeforeEach
    public void setUp()
    {
        this.bitmapItem = new BitmapItem(1, "JabberPoint.gif");
        this.style = new Style(1, Color.BLACK, 20, 20);
    }

    @Test
    void getNameTest_whereBitmapItemHasName_shouldReturnName()
    {
        BitmapItem bitmapItem = new BitmapItem(0, "testName.jpg");
        assertEquals("testName.jpg", bitmapItem.getName());
    }

    @Test
    void toStringTest_shouldReturnBitmapItemAsString()
    {
        BitmapItem bitmapItem = new BitmapItem(0, "testName.jpg");
        assertEquals("Slide.BitmapItem[0,testName.jpg]", bitmapItem.toString());
    }

    @Test
    public void BitmapItemTest_Draw_ShouldDrawBitmapItem()
    {
        // Maak een BufferImage om op te tekenen
        BufferedImage image = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = image.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, image.getWidth(), image.getHeight());

        // Bepaal schaal voor tekenen
        float scale = 1.0f;

        // Teken de BitmapItem
        bitmapItem.draw(10, 10, scale, g, style, null);
        g.dispose();

        int pixelColor = image.getRGB(30, 30); // Check een pixel waar de BitmapItem getekend zou moeten zijn
        assertNotEquals(0, pixelColor);
        // check of de pixels niet transparant zijn (oftewel of er wel daadwerkelijk iets is getekent)
    }
}
