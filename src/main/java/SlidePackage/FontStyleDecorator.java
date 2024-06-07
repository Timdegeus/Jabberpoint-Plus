package SlidePackage;

import java.awt.*;
import java.awt.image.ImageObserver;

public class FontStyleDecorator extends SlideItem
{
        private final SlideItem decoratedItem;
        private final Font font;

        public FontStyleDecorator(SlideItem decoratedItem, Font font)
        {
            this.decoratedItem = decoratedItem;
            this.font = font;
        }

        @Override
        public Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale, Style style)
        {
            return decoratedItem.getBoundingBox(g, observer, scale, style);
        }

        @Override
        public void draw(int x, int y, float scale, Graphics g, Style style, ImageObserver observer)
        {
            Font originalFont = g.getFont();
            g.setFont(font);
            decoratedItem.draw(x, y, scale, g, style, observer);
            g.setFont(originalFont);
        }
}
