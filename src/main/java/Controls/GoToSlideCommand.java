package Controls;

import Presentation.Presentation;

import javax.swing.*;

import static Controls.MenuController.PAGENR;

public class GoToSlideCommand implements Command
{
    private final Presentation presentation;

    public GoToSlideCommand(Presentation presentation)
    {
        this.presentation = presentation;
    }

    @Override
    public void execute()
    {
        String pageNumberStr = JOptionPane.showInputDialog((Object)PAGENR);
        int pageNumber = Integer.parseInt(pageNumberStr);
        presentation.setSlideNumber(pageNumber - 1);
    }
}
