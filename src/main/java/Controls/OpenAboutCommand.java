package Controls;

import Presentation.Presentation;

import java.awt.*;

public class OpenAboutCommand implements Command
{
    private final Frame parent;

    public OpenAboutCommand(Frame parent)
    {
        this.parent = parent;
    }

    @Override
    public void execute()
    {
        AboutBox.show(parent);
    }
}
