package Controls;

import Presentation.JabberPoint;
import Presentation.Presentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CommandTests
{
    private Presentation presentation;
    private NextSlideCommand nextSlideCommand;

    @BeforeEach
    public void setup()
    {
        JabberPoint.main(new String[0]);
        this.presentation = new Presentation();
        this.nextSlideCommand = new NextSlideCommand(presentation);
    }

    @Test
    public void execute_nextPage_shouldPass()
    {
        this.nextSlideCommand.execute();
        assertEquals(1, this.presentation.getSlideNumber());
    }
}