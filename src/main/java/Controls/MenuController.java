package Controls;

import Presentation.Presentation;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/** <p>De controller voor het menu</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */
public class MenuController extends MenuBar
{
	private Frame parent; // het frame, alleen gebruikt als ouder voor de Dialogs
	private Presentation presentation;

	private static final long serialVersionUID = 227L;

	protected static final String FILE = "File";
	protected static final String VIEW = "View";
	protected static final String HELP = "Help";

	protected static final String TESTFILE = "test.xml";
	protected static final String SAVEFILE = "dump.xml";

	protected static final String IOEX = "IO Exception: ";
	protected static final String LOADERR = "Load Error";
	protected static final String SAVEERR = "Save Error";

	public MenuController(Frame frame, Presentation presentation)
	{
		this.parent = frame;
		this.presentation = presentation;
		this.SetupMenuItems();
	}

	private void SetupMenuItems()
	{
		ArrayList<Command> fileCommands = new ArrayList<Command>();
		fileCommands.add(new OpenFileCommand(parent, presentation));
		fileCommands.add(new NewSlideCommand(parent, presentation));
		fileCommands.add(new SavePresenationCommand(parent, presentation));
		fileCommands.add(new ExitCommand(presentation));

		ArrayList<Command> viewCommands = new ArrayList<Command>();
		viewCommands.add(new PreviousSlideCommand(presentation));
		viewCommands.add(new NextSlideCommand(presentation));
		viewCommands.add(new GoToSlideCommand(parent, presentation));

		ArrayList<Command> helpCommands = new ArrayList<Command>();
		helpCommands.add(new OpenAboutCommand(parent));

		add(this.createMenu(FILE, fileCommands, true));
		add(this.createMenu(VIEW, viewCommands, true));
		setHelpMenu(this.createMenu(HELP, helpCommands, false));
	}

	private Menu createMenu(String menuTitle, ArrayList<Command> commands, boolean addSeperator)
	{
		Menu menu = new Menu(menuTitle);
		MenuItem menuItem;

		for (int i = 0; i < commands.size(); i++)
		{
			Command command = commands.get(i);

			if (i == commands.size() - 1 && addSeperator)
			{
				menu.addSeparator();
			}

			menu.add(menuItem = this.createMenuItem(command.getTitle()));

			menuItem.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					command.execute();
				}
			});
		}

		return menu;
	}

	// een menu-item aanmaken
	public MenuItem createMenuItem(String name)
	{
		return new MenuItem(name, new MenuShortcut(name.charAt(0)));
	}
}
