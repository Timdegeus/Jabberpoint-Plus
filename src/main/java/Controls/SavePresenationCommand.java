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

    public SavePresenationCommand(Frame parent, Presentation presentation)
    {
        this.parent = parent;
        this.presentation = presentation;
    }

    @Override
    public void execute()
    {
        Accessor xmlAccessor = new XMLAccessor();

        try
        {
            xmlAccessor.saveFile(presentation, SAVEFILE);
        }
        catch (IOException exc)
        {
            JOptionPane.showMessageDialog(parent, IOEX + exc,
                    SAVEERR, JOptionPane.ERROR_MESSAGE);
        }
    }
}
