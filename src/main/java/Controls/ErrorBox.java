package Controls;

import javax.swing.*;
import java.awt.*;

/**De Error-box voor Presentation.JabberPoint.*/

public class ErrorBox
{
	public static void show(Frame parent, String errorMessage, String title)
	{
		JOptionPane.showMessageDialog(parent, errorMessage, title, JOptionPane.ERROR_MESSAGE);
	}
}
