package Controls;

import Presentation.Presentation;

public class PreviousSlideCommand implements Command
{
   private final Presentation presentation;

    public PreviousSlideCommand(Presentation presentation)
    {
        this.presentation = presentation;
    }

    @Override
    public void execute()
    {
        presentation.prevSlide();
    }
}
