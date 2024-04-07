package Controls;

import Presentation.Presentation;

public interface Command
{
    public abstract String getTitle();
    public abstract void execute();
}
