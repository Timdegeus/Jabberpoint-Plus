package Presentation;

import SlidePackage.Slide;
import SlideViewer.SlideViewerComponent;

import java.util.ArrayList;


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

public class PresentationControl
{
	private Presentation presentation;

	public PresentationControl()
	{
	}

	public Presentation getPresentation()
	{
		return this.presentation;
	}

	public void setPresentation(Presentation presentation)
	{
		this.presentation = presentation;
	}

	// ga naar de vorige slide tenzij je aan het begin van de presentatie bent
	public void prevSlide()
	{
		if (this.presentation.getSlideNumber() > 0)
		{
			setSlideNumber(this.presentation.getSlideNumber() - 1);
		}
	}

	// Ga naar de volgende slide tenzij je aan het einde van de presentatie bent.
	public void nextSlide()
	{
		if (this.presentation.getSlideNumber() < (this.presentation.getShowList().size() - 1))
		{
			setSlideNumber(this.presentation.getSlideNumber() + 1);
		}
	}

	// verander het huidige-slide-nummer en laat het aan het window weten.
	public void setSlideNumber(int slideNumber)
	{
		if (slideNumber >= 0 && slideNumber < presentation.getShowList().size())
		{
			setSlideNumber(slideNumber);
		}
	}

	// Verwijder de presentatie, om klaar te zijn voor de volgende
	public void clear()
	{
		this.presentation.clear();
	}
}
