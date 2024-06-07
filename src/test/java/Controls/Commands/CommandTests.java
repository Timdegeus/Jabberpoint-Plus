package Controls.Commands;

import Presentation.JabberPoint;
import Controls.Command;
import Controls.NextSlideCommand;
import Controls.PreviousSlideCommand;
import Presentation.Presentation;
import SlidePackage.Slide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandTests
{
    private Presentation presentation;
    private NextSlideCommand nextSlideCommand;
    private PreviousSlideCommand previousSlideCommand;
    private Component component;

    @BeforeEach
    public void setup() throws IOException
    {
        JabberPoint.main(new String[0]);
        this.presentation = new Presentation();
        this.nextSlideCommand = new NextSlideCommand(presentation);
        this.previousSlideCommand = new PreviousSlideCommand(presentation);
        this.component = new JFrame();
        this.presentation.append(new Slide());
        this.presentation.append(new Slide());
    }

    @Test
    public void nextPage_shouldPass()
    {
        assertEquals(0, this.presentation.getSlideNumber());
        this.nextSlideCommand.execute();
        assertEquals(1, this.presentation.getSlideNumber());
    }

    @Test
    public void previousPage_shouldPass()
    {
        this.presentation.setSlideNumber(2);
        assertEquals(2, this.presentation.getSlideNumber());
        this.previousSlideCommand.execute();
        assertEquals(1, this.presentation.getSlideNumber());
    }


}
