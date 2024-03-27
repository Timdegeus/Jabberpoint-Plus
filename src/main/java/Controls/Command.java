package Controls;

import Presentation.Presentation;

public abstract class Command
{
    public Presentation presentation;

    public Command(Presentation presentation)
    {
        this.presentation = presentation;
    }

    public abstract boolean execute();
}
