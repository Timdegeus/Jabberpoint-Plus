package Controls;

import Presentation.Presentation;

import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

/** <p>This is the Controls.KeyController (KeyListener)</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
*/

public class KeyController extends KeyAdapter
{
	private final Presentation presentation; // Er worden commando's gegeven aan de presentatie

	private final Command NEXT_SLIDE_COMMAND;
	private final Command PREVIOUS_SLIDE_COMMAND;
	private final Command EXIT_COMMAND;

	public KeyController(Presentation p)
	{
		this.presentation = p;
		this.NEXT_SLIDE_COMMAND = new NextSlideCommand(this.presentation);
		this.PREVIOUS_SLIDE_COMMAND = new PreviousSlideCommand(this.presentation);
		this.EXIT_COMMAND = new ExitCommand(this.presentation);
	}

	public void keyPressed(KeyEvent keyEvent)
	{
		switch(keyEvent.getKeyCode())
		{
			case KeyEvent.VK_PAGE_DOWN:
			case KeyEvent.VK_DOWN:
			case KeyEvent.VK_ENTER:
			case '+':
				NEXT_SLIDE_COMMAND.execute();
				break;

			case KeyEvent.VK_PAGE_UP:
			case KeyEvent.VK_UP:
			case '-':
				PREVIOUS_SLIDE_COMMAND.execute();
				break;

			case 'q':
			case 'Q':
				EXIT_COMMAND.execute();
				break; // wordt nooit bereikt als het goed is

			default:
				break;
		}
	}
}
