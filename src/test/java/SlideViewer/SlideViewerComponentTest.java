package SlideViewer;

import Presentation.Presentation;
import SlidePackage.Slide;
import SlidePackage.Style;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Color;

import static org.junit.jupiter.api.Assertions.*;

public class SlideViewerComponentTest {
    private Presentation presentation;
    private Slide slide;
    private JFrame frame;
    private SlideViewerComponent slideViewerComponent;

    @BeforeEach
    public void setUp() {
        presentation = new Presentation();
        slide = new Slide();
        frame = new JFrame();
        slideViewerComponent = new SlideViewerComponent(presentation, frame);
    }

    @Test
    public void SlideViewerComponent_ConstructorTest() {
        assertNotNull(slideViewerComponent);
        assertEquals(presentation, slideViewerComponent.getPresentation());
        assertNotNull(slideViewerComponent.getLabelFont());
        assertEquals(frame, slideViewerComponent.getFrame());
        assertEquals(Color.white, slideViewerComponent.getBackground());
    }

    @Test
    public void SlideViewerComponent_GetPreferredSizeTest() {
        Dimension expectedSize = new Dimension(Slide.getWidth(), Slide.getHeight());
        assertEquals(expectedSize, slideViewerComponent.getPreferredSize());
    }

    @Test
    public void SlideViewerComponent_UpdateWithNullSlideTest() {
        slideViewerComponent.update(presentation, null);
        assertEquals(presentation, slideViewerComponent.getPresentation());
        assertNull(slideViewerComponent.getSlide());
    }

    @Test
    public void SlideViewerComponent_UpdateWithValidSlideTest() {
        presentation.setTitle("Test Presentation");
        slideViewerComponent.update(presentation, slide);
        assertEquals(presentation, slideViewerComponent.getPresentation());
        assertEquals(slide, slideViewerComponent.getSlide());
        assertEquals("Test Presentation", frame.getTitle());
    }

    @Test
    public void SlideViewerComponent_PaintComponentWithoutSlideTest() {
        BufferedImage image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
        Graphics graphics = image.getGraphics();

        presentation.setSlideNumber(-1);
        slideViewerComponent.paintComponent(graphics);

        assertEquals(Color.white, graphics.getColor());
    }
}