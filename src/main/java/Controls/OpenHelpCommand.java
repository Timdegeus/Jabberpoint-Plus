package Controls;

import Presentation.Presentation;

public class OpenHelpCommand extends Command
{
    public OpenHelpCommand(Presentation presentation)
    {
        super(presentation);
    }

    @Override
    public boolean execute()
    {
        return false;
    }
}
