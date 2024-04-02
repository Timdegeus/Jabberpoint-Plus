package Controls;

import javax.swing.*;
import java.awt.*;

/**De Error-box voor Presentation.JabberPoint.*/

public class ErrorBox
{
	public static void show(Frame parent, String errorMessage)
	{
		JOptionPane.showMessageDialog(parent,

				errorMessage,
				"Error",

				JOptionPane.INFORMATION_MESSAGE
		);
	}
}
