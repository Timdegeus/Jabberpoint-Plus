package Acces;

import Presentation.Presentation;
import SlidePackage.*;

/** Een ingebouwde demo-presentatie
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

class DemoPresentation extends Accessor 
{
    ItemCreator textItemCreator = new TextItemCreator();
    ItemCreator bitmapItemCreator = new BitmapItemCreator();
    public void loadFile(Presentation presentation, String unusedFilename) 
    {
        presentation.setTitle("Demo Presentation.Presentation");
        Slide slide;
        slide = new Slide();
        slide.setTitle("Presentation.JabberPoint");
        slide.createSlideItem(1, "Het Java Presentatie Tool", textItemCreator);
        slide.createSlideItem(2, "Copyright (c) 1996-2000: Ian Darwin", textItemCreator);
        slide.createSlideItem(2, "Copyright (c) 2000-now:", textItemCreator);
        slide.createSlideItem(2, "Gert Florijn en Sylvia Stuurman", textItemCreator);
        slide.createSlideItem(4, "Presentation.JabberPoint aanroepen zonder bestandsnaam", textItemCreator);
        slide.createSlideItem(4, "laat deze presentatie zien", textItemCreator);
        slide.createSlideItem(1, "Navigeren:", textItemCreator);
        slide.createSlideItem(3, "Volgende slide: PgDn of Enter", textItemCreator);
        slide.createSlideItem(3, "Vorige slide: PgUp of up-arrow", textItemCreator);
        slide.createSlideItem(3, "Stoppen: q or Q", textItemCreator);
        presentation.append(slide);

        slide = new Slide();
        slide.setTitle("Demonstratie van levels en stijlen");
        slide.createSlideItem(1, "Level 1", textItemCreator);
        slide.createSlideItem(2, "Level 2", textItemCreator);
        slide.createSlideItem(1, "Nogmaals level 1", textItemCreator);
        slide.createSlideItem(1, "Level 1 heeft stijl nummer 1", textItemCreator);
        slide.createSlideItem(2, "Level 2 heeft stijl nummer 2", textItemCreator);
        slide.createSlideItem(3, "Zo ziet level 3 er uit", textItemCreator);
        slide.createSlideItem(4, "En dit is level 4", textItemCreator);
        presentation.append(slide);

        slide = new Slide();
        slide.setTitle("De derde slide");
        slide.createSlideItem(1, "Om een nieuwe presentatie te openen,", textItemCreator);
        slide.createSlideItem(2, "gebruik File->Open uit het menu.", textItemCreator);
        slide.createSlideItem(1, " ", textItemCreator);
        slide.createSlideItem(1, "Dit is het einde van de presentatie.", textItemCreator);
        slide.createSlideItem(1, "Presentation.JabberPoint.jpg", bitmapItemCreator);
        presentation.append(slide);
    }

    public void saveFile(Presentation presentation, String unusedFilename) 
    {
        throw new IllegalStateException("Save As->Demo! aangeroepen");
    }
}
