package SlidePackage;

public abstract class StyleDecorator extends SlideItem
{
    private SlideItem item;

    public StyleDecorator(SlideItem item)
    {
        this.item = item;
    }
}
