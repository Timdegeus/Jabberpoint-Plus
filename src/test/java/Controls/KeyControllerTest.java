package Controls;

import Presentation.Presentation;
import Presentation.JabberPoint;
import SlideViewer.SlideViewerComponent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

class KeyControllerTest
{
    private Presentation presentation;
    private KeyController keyController;
    private JFrame testComponent;

    @BeforeEach
    void setup() throws IOException
    {
        this.testComponent = new JFrame();
        JabberPoint.main(new String[0]);
        this.presentation = new Presentation();
        this.keyController = new KeyController(presentation);
    }

    @Test
    void nextSlideCommandTest()
    {
        assertEquals(0, this.presentation.getSlideNumber());
        this.keyController.keyPressed(new KeyEvent(testComponent, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_PAGE_DOWN, 'a'));
        assertEquals(1, this.presentation.getSlideNumber());
    }
}