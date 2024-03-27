package Controls;

import Presentation.Presentation;

public class NewSlideCommand extends Command
{
    public NewSlideCommand(Presentation presentation)
    {
        super(presentation);
    }

    @Override
    public boolean execute()
    {
        return false;
    }
}
