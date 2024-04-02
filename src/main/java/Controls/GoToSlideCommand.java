package Controls;

import Presentation.Presentation;

import javax.swing.*;

import java.awt.*;
import java.util.regex.Pattern;

import static Controls.MenuController.PAGENR;

public class GoToSlideCommand implements Command
{
    private final Frame parent;
    private final Presentation presentation;
    private String errorMessage;

    public GoToSlideCommand(Frame parent, Presentation presentation)
    {
        this.parent = parent;
        this.presentation = presentation;
    }

    @Override
    public void execute()
    {
        String pageNumberStr = JOptionPane.showInputDialog((Object)PAGENR);

        int pageNumber;

        if(!Pattern.matches("[a-zA-Z]+", pageNumberStr) && !pageNumberStr.isEmpty())
        {
            pageNumber = Integer.parseInt(pageNumberStr);
            presentation.setSlideNumber(pageNumber - 1);
        }
        else
        {
            errorMessage = "The provided input is not valid. Please enter a number.\n Provided input: " + pageNumberStr;
            ErrorBox.show(parent, errorMessage);
            System.out.println("Provided input is not a number. Input: " + pageNumberStr);
        }
    }
}
