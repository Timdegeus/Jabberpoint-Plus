package Controls;

import Presentation.Presentation;

public class ExitCommand implements Command
{
    private final Presentation presentation;
    private static final String TITLE = "Exit";

    public ExitCommand(Presentation presentation)
    {
       this.presentation = presentation;
    }

    @Override
    public String getTitle()
    {
        return TITLE;
    }

    @Override
    public void execute()
    {
        this.presentation.exit(0);
    }
}
