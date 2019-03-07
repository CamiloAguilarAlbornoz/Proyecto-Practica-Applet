package views;

import javax.swing.JApplet;
import javax.swing.JLabel;

public class MainWindow extends JApplet {

	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() {
		JLabel jLabel = new JLabel("Ella no te ama");
		add(jLabel);
	}
}
