package Controls;

import Presentation.Presentation;

public class PreviousSlideCommand implements Command
{
   private final Presentation presentation;
    private static final String TITLE = "Previous slide";

    public PreviousSlideCommand(Presentation presentation)
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
        presentation.prevSlide();
    }
}
