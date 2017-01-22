import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Moj extends JPanel {

	/**
	 * Create the panel.
	 */
	public Moj() {
		

	}
	public static void makeGUI()
	{
		JFrame frame = new JFrame();
		JComponent contentPanel = new Moj();
		frame.setVisible(true);
		frame.setContentPane(contentPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		
	}
	public static void main(String args[])
	{
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
			makeGUI();
			}
		});
	}

}
