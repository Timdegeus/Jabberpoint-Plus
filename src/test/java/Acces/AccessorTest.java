package Acces;

import Presentation.Presentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class AccessorTest
{
    private Presentation presentation;

    @BeforeEach
    public void setup()
    {
        this.presentation = new Presentation();
    }

    @Test
    public void demoPresentation_loadFile_shouldLoad() throws IOException
    {
        assertDoesNotThrow(() -> new DemoPresentation().loadFile(this.presentation, ""));
        assertEquals("Demo Presentation", this.presentation.getTitle());
        assertEquals(3, this.presentation.getSize());
    }

    @Test
    public void xmlAccessor_loadFile_shouldLoad() throws IOException
    {
        assertDoesNotThrow(() -> new XMLAccessor().loadFile(this.presentation, "test.xml"));
        assertEquals("XML-Based Presentation for Jabberpoint", this.presentation.getTitle());
    }
}
