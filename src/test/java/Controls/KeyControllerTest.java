package Controls;

import Presentation.Presentation;
import Presentation.JabberPoint;
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
    private Component testComponent;

    @BeforeEach
    void setup() throws IOException
    {
        testComponent = new JFrame();
        presentation = new Presentation();
        keyController = new KeyController(presentation);
        JabberPoint.main(new String[0]);
    }

    @Test
    void nextSlideTest()
    {
        KeyEvent keyEvent = new KeyEvent(testComponent, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_PAGE_DOWN, KeyEvent.CHAR_UNDEFINED);
        keyController.keyPressed(keyEvent);
        assertEquals(1, presentation.getSlideNumber());
    }
}