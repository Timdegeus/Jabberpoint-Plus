package SlidePackage;

public class TextItemCreator extends ItemCreator
{
    @Override
    public SlideItem createSlideItem(int level, String string)
    {
        return new TextItem(level, string);
    }
}
