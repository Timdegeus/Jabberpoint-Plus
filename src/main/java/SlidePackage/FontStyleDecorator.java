package SlidePackage;

import java.awt.*;
import java.awt.image.ImageObserver;

public class FontStyleDecorator extends StyleDecorator
{
    private Font font;
    private int size;
    private int indent;
    private int leading;

    public FontStyleDecorator(SlideItem item)
    {
        super(item);
    }

    public Font getFont()
    {
        return this.font;
    }

    public void setFont(Font font)
    {
        this.font = font;
    }

    public int getSize()
    {
        return this.size;
    }

    public void setSize(int size)
    {
        this.size = size;
    }

    public int getIndent()
    {
        return this.indent;
    }

    public void setIndent(int indent)
    {
        this.indent = indent;
    }

    public int getLeading()
    {
        return this.leading;
    }

    public void setLeading(int leading)
    {
        this.leading = leading;
    }

    @Override
    public Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale, Style style)
    {
        return null;
    }

    @Override
    public void draw(int x, int y, float scale, Graphics g, Style style, ImageObserver observer)
    {

    }
}
