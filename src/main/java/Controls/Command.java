package Controls;

import Presentation.Presentation;

public abstract class Command
{
    private Presentation presentation;

    public Command(Presentation presentation)
    {
        this.presentation = presentation;
    }

    public abstract void execute();
}
