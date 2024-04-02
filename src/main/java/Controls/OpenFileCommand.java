package Controls;

import Acces.Accessor;
import Acces.XMLAccessor;
import Presentation.Presentation;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import static Controls.MenuController.*;

public class OpenFileCommand implements Command
{
    private final Frame parent;
    private final Presentation presentation;

    public OpenFileCommand(Frame parent, Presentation presentation) {
        this.parent = parent;
        this.presentation = presentation;
    }

    @Override
    public void execute()
    {
        presentation.clear();
        Accessor xmlAccessor = new XMLAccessor();

        try
        {
            xmlAccessor.loadFile(presentation, TESTFILE);
            presentation.setSlideNumber(0);
        }
        catch (IOException exc)
        {
            JOptionPane.showMessageDialog(parent, IOEX + exc, LOADERR, JOptionPane.ERROR_MESSAGE);
        }

        parent.repaint();
    }
}
