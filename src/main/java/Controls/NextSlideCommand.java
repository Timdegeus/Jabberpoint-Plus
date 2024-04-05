package Controls;

import Presentation.Presentation;

public class NextSlideCommand implements Command
{
    private final Presentation presentation;
    private static final String TITLE = "Next slide";

    public NextSlideCommand(Presentation presentation)
    {
        this.presentation = presentation;
    }

    @Override
    public String getTitle()
    {
        return TITLE;
    }

    @Override
    public void execute()
    {
        presentation.nextSlide();
    }
}
