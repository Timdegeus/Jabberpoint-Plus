package Controls;

import Presentation.Presentation;

import java.awt.*;

public class OpenAboutCommand implements Command
{
    private final Frame parent;
    private static final String TITLE = "About";

    public OpenAboutCommand(Frame parent)
    {
        this.parent = parent;
    }

    @Override
    public String getTitle()
    {
        return TITLE;
    }

    @Override
    public void execute()
    {
        AboutBox.show(this.parent);
    }
}
