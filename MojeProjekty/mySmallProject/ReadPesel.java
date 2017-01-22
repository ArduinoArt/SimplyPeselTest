package mySmallProject;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.text.MaskFormatter;

public class ReadPesel extends JPanel {

	/**
	 * Create the panel.
	 */
	public ReadPesel() 
	{
		JMenu menu = new JMenu("Test");
		JMenuBar mbar = new JMenuBar();
		mbar.add(menu);
		add(mbar);
	}
	public static void main(String[] args)
	{
	SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
			makeGUI();
			}
		});
		
	}
	public static void makeGUI()
	{
	JFrame frame = new JFrame("Test");
	frame.setSize(500, 500);
	frame.setContentPane(new ReadPesel());
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	}

}
