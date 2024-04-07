package SlidePackage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BitmapItemTest
{
    @Test
    void getNameTest_whereBitmapItemHasName_shouldReturnName()
    {
        BitmapItem bitmapItem = new BitmapItem(0, "testName");
        assertEquals("testName", bitmapItem.getName());
    }

    @Test
    void getNameTest_whereBitmapItemHasNoName_shouldReturnName()
    {
        BitmapItem bitmapItem = new BitmapItem();
        assertEquals(null, bitmapItem.getName());
    }

}
