package Controls;

import Presentation.Presentation;

public class PreviousSlideCommand extends Command
{
    public PreviousSlideCommand(Presentation presentation)
    {
        super(presentation);
    }

    @Override
    public boolean execute()
    {
        presentation.prevSlide();
        return false;
    }
}
