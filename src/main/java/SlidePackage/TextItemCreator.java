package SlidePackage;

public class TextItemCreator extends ItemCreator
{
    // maakt een niewe TextItem
    @Override
    public SlideItem createSlideItem(int level, String information)
    {
        return new TextItem(level, information);
    }
}
