package Controls;

import Presentation.Presentation;

public class GoToSlideCommand extends Command
{
    public GoToSlideCommand(Presentation presentation)
    {
        super(presentation);
    }

    @Override
    public boolean execute()
    {
        return false;
    }
}
