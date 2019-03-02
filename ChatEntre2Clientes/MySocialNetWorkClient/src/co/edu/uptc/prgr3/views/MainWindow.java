package co.edu.uptc.prgr3.views;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private PanelChat panelChat;
	
	public MainWindow() {
		setTitle(ConstantsGUI.TITLE_WINDOW);
		setIconImage(new ImageIcon(getClass().getResource(ConstantsGUI.ICON_WINDOW)).getImage());
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(ConstantsGUI.WIDTH_WINDOW, ConstantsGUI.HIGHT_WINDOW);
		setLocationRelativeTo(null);
		initComponents();
		setVisible(true);
	}

	private void initComponents() {
		panelChat = new PanelChat();
		add(panelChat);
	}
	
	public String getTxtToWrite() {
		return panelChat.getTxtToWrite();
	}

	public void setActionListener(ActionListener actionListener) {
		panelChat.setActionListener(actionListener);
	}
	
	public void updateMessage(String message) {
		panelChat.updateMessage(message);
	}
}
