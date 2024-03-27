package Controls;

import Presentation.Presentation;

public class OpenFileCommand extends Command
{
    public OpenFileCommand(Presentation presentation)
    {
        super(presentation);
    }

    @Override
    public boolean execute()
    {
        return false;
    }
}
