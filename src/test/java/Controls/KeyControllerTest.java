package Controls;

import Presentation.JabberPoint;
import Presentation.Presentation;
import SlidePackage.Slide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class KeyControllerTest
{

    private Presentation presentation;
    private KeyController keyController;
    private Component component;

    @BeforeEach
    public void setup() throws IOException
    {
        JabberPoint.main(new String[0]);
        this.presentation = new Presentation();
        this.keyController = new KeyController(presentation);
        this.component = new JFrame();
        this.presentation.append(new Slide());
        this.presentation.append(new Slide());
    }

    @ParameterizedTest
    @ValueSource(ints = {KeyEvent.VK_PAGE_DOWN, KeyEvent.VK_DOWN, KeyEvent.VK_ENTER, '+'})
    void keyController_nextPage_shouldPass(int keyCode)
    {
        assertEquals(0, this.presentation.getSlideNumber());
        this.keyController.keyPressed(new KeyEvent(this.component, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, keyCode, 'a'));
        assertEquals(1, this.presentation.getSlideNumber());
    }

    @ParameterizedTest
    @ValueSource(ints = {KeyEvent.VK_PAGE_UP, KeyEvent.VK_UP, '-'})
    void keyController_previousPage_shouldPass(int keyCode)
    {
        this.presentation.setSlideNumber(2);
        assertEquals(2, this.presentation.getSlideNumber());
        this.keyController.keyPressed(new KeyEvent(this.component, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, keyCode, 'a'));
        assertEquals(1, this.presentation.getSlideNumber());
    }
}