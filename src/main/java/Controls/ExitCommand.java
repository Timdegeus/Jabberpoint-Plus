package Controls;

import Presentation.Presentation;

public class ExitCommand extends Command
{
    public ExitCommand(Presentation presentation)
    {
        super(presentation);
    }

    @Override
    public boolean execute()
    {
        presentation.exit(0);
        return false;
    }
}
