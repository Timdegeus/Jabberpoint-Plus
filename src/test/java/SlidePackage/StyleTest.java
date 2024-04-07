
package SlidePackage;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StyleTest
{
    @Test
    void getStyleTest_WhereStyleExists_ShouldReturnStyle()
    {
        Style.createStyles();
        assertEquals("[0,java.awt.Color[r=255,g=0,b=0]; 48 on 20]", Style.getStyle(0).toString());
    }

    @Test
    void createStylesTest_whereStandardStylesAreCreated_ShouldCreateAllStandardStyles()
    {
        Style.createStyles();
        assertEquals("[0,java.awt.Color[r=255,g=0,b=0]; 48 on 20]", Style.getStyle(0).toString());
        assertEquals("[20,java.awt.Color[r=0,g=0,b=255]; 40 on 10]", Style.getStyle(1).toString());
        assertEquals("[50,java.awt.Color[r=0,g=0,b=0]; 36 on 10]", Style.getStyle(2).toString());
        assertEquals("[70,java.awt.Color[r=0,g=0,b=0]; 30 on 10]", Style.getStyle(3).toString());
        assertEquals("[90,java.awt.Color[r=0,g=0,b=0]; 24 on 10]", Style.getStyle(4).toString());
    }

    @Test
    void toStringTest_whereAllItemsAreSet_ShouldReturnAllItemsInString()
    {
        Style style = new Style(1, Color.black, 1, 1);
        assertEquals("[1,java.awt.Color[r=0,g=0,b=0]; 1 on 1]", style.toString());
    }

    @Test
    void getFontTest_whereFontIsCalled_shouldReturnFont()
    {
        Style style = new Style(1, Color.black, 1, 1);
        Font font = style.getFont(1);
        assertEquals("java.awt.Font[family=Dialog,name=Helvetica,style=bold,size=1]", font.toString());
    }
}
