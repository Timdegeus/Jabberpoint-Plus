package Controls;

import Presentation.Presentation;

import java.awt.*;

public class NewSlideCommand implements Command
{
    private final Frame parent;
    private final Presentation presentation;

    public NewSlideCommand(Frame parent, Presentation presentation)
    {
        this.parent = parent;
        this.presentation = presentation;
    }

    @Override
    public void execute()
    {
        presentation.clear();
        parent.repaint();
    }
}
