package SlidePackage;

public class BitmapItemCreator extends ItemCreator
{
    @Override
    public SlideItem createSlideItem(int level, String string)
    {
        return new BitmapItem(level, string);
    }
}
