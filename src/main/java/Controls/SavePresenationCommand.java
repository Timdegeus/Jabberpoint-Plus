package Controls;

import Acces.Accessor;
import Acces.XMLAccessor;
import Presentation.Presentation;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import static Controls.MenuController.*;

public class SavePresenationCommand implements Command
{
    private final Frame parent;
    private final Presentation presentation;
    private static final String TITLE = "Save";

    public SavePresenationCommand(Frame parent, Presentation presentation)
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
        Accessor xmlAccessor = new XMLAccessor();

        try
        {
            xmlAccessor.saveFile(this.presentation, SAVEFILE);
        }
        catch (IOException exc)
        {
            String errorMessage = IOEX + exc;

            ErrorBox.show(this.parent, errorMessage, SAVEERR);
        }
    }
}
