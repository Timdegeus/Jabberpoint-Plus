package SlidePackage;

public class BitmapItemCreator extends ItemCreator
{
    // maakt een nieuwe BitmapItem
    @Override
    public SlideItem createSlideItem(int level, String information)
    {
        return new BitmapItem(level, information);
    }
}
