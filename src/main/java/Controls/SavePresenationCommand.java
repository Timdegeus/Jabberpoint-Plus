package Controls;

import Presentation.Presentation;

public class SavePresenationCommand extends Command
{
    public SavePresenationCommand(Presentation presentation)
    {
        super(presentation);
    }

    @Override
    public boolean execute()
    {
        return false;
    }
}