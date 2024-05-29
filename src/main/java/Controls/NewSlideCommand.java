package Controls;

import Presentation.Presentation;

import java.awt.*;

public class NewSlideCommand implements Command
{
    private final Frame parent;
    private final Presentation presentation;
    private static final String TITLE = "New slide";

    public NewSlideCommand(Frame parent, Presentation presentation)
    {
        this.parent = parent;
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
        this.presentation.clear();
        this.parent.repaint();
    }
}
