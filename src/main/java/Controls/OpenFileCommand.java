package Controls;

import Acces.Accessor;
import Acces.XMLAccessor;
import Presentation.Presentation;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static Controls.MenuController.*;

public class OpenFileCommand implements Command
{
    private final Frame parent;
    private final Presentation presentation;
    private static final String TITLE = "Open file";

    public OpenFileCommand(Frame parent, Presentation presentation)
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
        Accessor xmlAccessor = new XMLAccessor();
        JFileChooser fileChooser = createjFileChooser();
        fileChooser.showOpenDialog(this.parent);

        try
        {
            xmlAccessor.loadFile(this.presentation, fileChooser.getSelectedFile().getPath());
            this.presentation.setSlideNumber(0);
        }
        catch (IOException exc)
        {
            JOptionPane.showMessageDialog(this.parent, IOEX + exc, LOADERR, JOptionPane.ERROR_MESSAGE);
        }

        this.parent.repaint();
    }

    //creates a JFileChooser which only shows xml files
    private static JFileChooser createjFileChooser() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileFilter()
        {
            public String getDescription() {
                return "XML files (*.xml)";
            }

            public boolean accept(File f)
            {
                if (f.isDirectory())
                {
                    return true;
                }
                else
                {
                    String filename = f.getName().toLowerCase();
                    return filename.endsWith(".xml");
                }
            }
        }
        );
        return fileChooser;
    }
}
