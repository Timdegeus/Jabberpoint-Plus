package Controls;

import Presentation.Presentation;

public class OpenAboutCommand extends Command
{
    public OpenAboutCommand(Presentation presentation)
    {
        super(presentation);
    }

    @Override
    public boolean execute()
    {
        return false;
    }
}