package Presentation;

import java.util.ArrayList;

import Controls.Command;
import SlidePackage.Slide;
import SlideViewer.SlideViewerComponent;


/**
 * <p>Presentation.Presentation houdt de slides in de presentatie bij.</p>
 * <p>Er is slechts ��n instantie van deze klasse aanwezig.</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class Presentation
{
	private String showTitle; // de titel van de presentatie
	private ArrayList<Slide> showList = null; // een ArrayList met de Slides
	private int currentSlideNumber = 0; // het slidenummer van de huidige Slide.Slide
	private SlideViewerComponent slideViewComponent = null; // de viewcomponent voor de Slides

	private static final int BEGIN_SLIDE = 0;

	public Presentation()
	{
		this.slideViewComponent = null;
		this.clear();
	}

	public Presentation(SlideViewerComponent slideViewerComponent)
	{
		this.slideViewComponent = slideViewerComponent;
		this.clear();
	}

	public int getSize()
	{
		return this.showList.size();
	}

	public String getTitle()
	{
		return this.showTitle;
	}

	public void setTitle(String newTitle)
	{
		this.showTitle = newTitle;
	}

	public void setShowView(SlideViewerComponent slideViewerComponent)
	{
		this.slideViewComponent = slideViewerComponent;
	}

	// geef het nummer van de huidige slide
	public int getSlideNumber()
	{
		return this.currentSlideNumber;
	}

	// verander het huidige-slide-nummer en laat het aan het window weten.
	public void setSlideNumber(int number)
	{
		this.currentSlideNumber = number;

		if (this.slideViewComponent != null)
		{
			this.slideViewComponent.update(this, this.getCurrentSlide());
		}
	}

	// ga naar de vorige slide tenzij je aan het begin van de presentatie bent
	public void prevSlide()
	{
		if (this.currentSlideNumber > BEGIN_SLIDE)
		{
			this.setSlideNumber(this.currentSlideNumber - 1);
	    }
	}

	// Ga naar de volgende slide tenzij je aan het einde van de presentatie bent.
	public void nextSlide()
	{
		if (this.currentSlideNumber < (this.showList.size()-1))
		{
			this.setSlideNumber(this.currentSlideNumber + 1);
		}
	}

	// Verwijder de presentatie, om klaar te zijn voor de volgende
	public void clear()
	{
		this.showList = new ArrayList<Slide>();
//		this.setSlideNumber(-1);
	}

	// Voeg een slide toe aan de presentatie
	public void append(Slide slide)
	{
		this.showList.add(slide);
	}

	// Geef een slide met een bepaald slidenummer
	public Slide getSlide(int number)
	{
		if (number < 0 || number >= this.getSize())
		{
			return null;
	    }

		return (Slide) this.showList.get(number);
	}

	// Geef de huidige Slide
	public Slide getCurrentSlide()
	{
		return this.getSlide(currentSlideNumber);
	}

	// Sluit de applicatie af
	public void exit(int exitCode)
	{
		System.exit(exitCode);
	}
}
