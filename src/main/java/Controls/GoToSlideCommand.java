package Controls;

import Presentation.Presentation;

import javax.swing.*;

import java.awt.*;
import java.util.regex.Pattern;

public class GoToSlideCommand implements Command
{
    private final Frame parent;
    private final Presentation presentation;
    private static final String TITLE = "Go to";
    protected static final String PAGENR = "Page number?";

    public GoToSlideCommand(Frame parent, Presentation presentation)
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
        String pageNumberStr = JOptionPane.showInputDialog((Object) PAGENR);

        int pageNumber;

        if(!Pattern.matches("[a-zA-Z]+", pageNumberStr) && !pageNumberStr.isEmpty())
        {
            pageNumber = Integer.parseInt(pageNumberStr);
            if (pageNumber <= this.presentation.getSize())
            {
                this.presentation.setSlideNumber(pageNumber - 1);
            }
            else
            {
                String errorMessage = "The provided slide number is greater than the number of slides. " +
                        "Please enter a number of a slide that exists.\n Provided input: " + pageNumber +
                        ", actual number of slides:" + this.presentation.getSize() ;
                String title = "Error";

                ErrorBox.show(this.parent, errorMessage, title);
            }
        }
        else
        {
            String errorMessage = "The provided input is not valid. Please enter a number.\n Provided input: "
                    + pageNumberStr;
            String title = "Error";

            ErrorBox.show(this.parent, errorMessage, title);
        }
    }
}
