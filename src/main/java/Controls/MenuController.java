package Controls;

import Acces.Accessor;
import Acces.XMLAccessor;
import Presentation.Presentation;

import java.awt.MenuBar;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JOptionPane;

/** <p>De controller voor het menu</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */
public class MenuController extends MenuBar {
	
	private Frame parent; // het frame, alleen gebruikt als ouder voor de Dialogs
	private Presentation presentation; // Er worden commando's gegeven aan de presentatie
	
	private static final long serialVersionUID = 227L;
	
	protected static final String ABOUT = "About";
	protected static final String FILE = "File";
	protected static final String EXIT = "Exit";
	protected static final String GOTO = "Go to";
	protected static final String HELP = "Help";
	protected static final String NEW = "New";
	protected static final String NEXT = "Next";
	protected static final String OPEN = "Open";
	protected static final String PAGENR = "Page number?";
	protected static final String PREV = "Prev";
	protected static final String SAVE = "Save";
	protected static final String VIEW = "View";
	
	protected static final String TESTFILE = "test.xml";
	protected static final String SAVEFILE = "dump.xml";
	
	protected static final String IOEX = "IO Exception: ";
	protected static final String LOADERR = "Load Error";
	protected static final String SAVEERR = "Save Error";

	public MenuController(Frame frame, Presentation pres) // Voeg de items toe voor in het menu
	{
		parent = frame;
		presentation = pres;

		MenuItem menuItem;
		Menu fileMenu = new Menu(FILE);

		fileMenu.add(menuItem = mkMenuItem(OPEN)); // Open een presentatie

		menuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent actionEvent)
			{
				new OpenFileCommand(parent, presentation).execute();
			}
		} );

		fileMenu.add(menuItem = mkMenuItem(NEW)); // Maak een nieuwe presentatie aan

		menuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent actionEvent)
			{
				new NewSlideCommand(parent, presentation).execute();
			}
		});

		fileMenu.add(menuItem = mkMenuItem(SAVE)); // Sla een presentatie op

		menuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new SavePresenationCommand(parent, presentation).execute();
			}
		});

		fileMenu.addSeparator();

		fileMenu.add(menuItem = mkMenuItem(EXIT)); // Sluit de software af

		menuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent actionEvent)
			{
				new ExitCommand(presentation).execute();
			}
		});

		add(fileMenu);
		Menu viewMenu = new Menu(VIEW);

		viewMenu.add(menuItem = mkMenuItem(NEXT)); // Ga naar de volgende slide

		menuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent actionEvent)
			{
				new NextSlideCommand(presentation).execute();
			}
		});

		viewMenu.add(menuItem = mkMenuItem(PREV)); // ga naar de vorige slide

		menuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent actionEvent)
			{
				new PreviousSlideCommand(presentation).execute();
			}
		});

		viewMenu.add(menuItem = mkMenuItem(GOTO)); // Ga naar de ingevoerde slide

		menuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent actionEvent)
			{
				new GoToSlideCommand(parent, presentation).execute();
			}
		});

		add(viewMenu);
		Menu helpMenu = new Menu(HELP);

		helpMenu.add(menuItem = mkMenuItem(ABOUT)); // Open de about pagina

		menuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent actionEvent)
			{
				new OpenAboutCommand(parent).execute();
			}
		});

		setHelpMenu(helpMenu);		// nodig for portability (Motif, etc.).
	}

	// een menu-item aanmaken
	public MenuItem mkMenuItem(String name)
	{
		return new MenuItem(name, new MenuShortcut(name.charAt(0)));
	}
}
