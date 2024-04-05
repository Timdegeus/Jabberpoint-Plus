package SlidePackage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SlideTest
{
    private ItemCreator textItemCreator;
    private ItemCreator bitmapItemCreator;
    private Slide slide;

    @BeforeEach
    public void setup()
    {
        this.textItemCreator = new TextItemCreator();
        this.bitmapItemCreator = new BitmapItemCreator();
        this.slide = new Slide();
    }

    @Test
    void createSlideItemTest_ShouldCreateNewTextItem()
    {
        SlideItem textItem = new TextItem(0, "testString");
        this.slide.createSlideItem(0, "testString", this.textItemCreator);
        assertEquals(textItem.toString(), this.slide.getSlideItem(0).toString());

    }

    @Test
    void createSlideItemTest_ShouldCreateNewBitmapItem()
    {
        SlideItem bitmapItem = new BitmapItem(0, "JabberPoint.gif");
        this.slide.createSlideItem(0, "JabberPoint.gif", this.bitmapItemCreator);
        assertEquals(bitmapItem.toString(), this.slide.getSlideItem(0).toString());

    }
}