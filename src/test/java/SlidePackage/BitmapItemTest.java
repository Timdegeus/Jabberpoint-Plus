
package SlidePackage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BitmapItemTest
{
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

}
