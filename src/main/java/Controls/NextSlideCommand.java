package Controls;

import Presentation.Presentation;

public class NextSlideCommand extends Command
{
    public NextSlideCommand(Presentation presentation)
    {
        super(presentation);
    }

    @Override
    public boolean execute()
    {
        presentation.nextSlide();
        return false;
    }
}
