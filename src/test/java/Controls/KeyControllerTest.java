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
        presentation = new Presentation();
        keyController = new KeyController(presentation);
        testComponent = new JFrame();
        JabberPoint.main(new String[0]);
    }

    @Test
    void nextSlideTest()
    {
        presentation.setSlideNumber(1);
        KeyEvent keyEvent = new KeyEvent(testComponent, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_PAGE_DOWN, 'a');
        keyController.keyPressed(keyEvent);
        assertEquals(2, presentation.getSlideNumber());
    }
}