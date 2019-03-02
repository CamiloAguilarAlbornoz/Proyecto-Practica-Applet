package co.edu.uptc.prgr3.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import co.edu.uptc.prgr3.controller.ActionCommands;

class PanelChat extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtMessageToSend;
	private JButton btnSend;
	private JTextArea txtAMessgeGett;

	public PanelChat() {
		setLayout(new BorderLayout());
		initComponents();
	}

	private void initComponents() {
		// Campo de escritura y envio de mensajes
		txtMessageToSend = new JTextField();
		JPanel panelSend = new JPanel();
		btnSend = new JButton(new ImageIcon(getClass().getResource(ConstantsGUI.ICON_SEND)));
		btnSend.setContentAreaFilled(false);
		btnSend.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnSend.setBorder(BorderFactory.createEmptyBorder());
		panelSend.setLayout(new BorderLayout());
		panelSend.setBackground(Color.decode(ConstantsGUI.COLOR_CHAT));
		txtMessageToSend.setBorder(BorderFactory.createEmptyBorder(
				ConstantsGUI.TOP_TXT_WRITER, 
				ConstantsGUI.RIGHT_TXT_WRITER, 
				ConstantsGUI.DOWN_TXT_WRITER, 
				ConstantsGUI.LEFT_TXT_WRITER));
		panelSend.add(txtMessageToSend, BorderLayout.CENTER);
		panelSend.add(btnSend, BorderLayout.LINE_END);
		panelSend.setBorder(BorderFactory.createEmptyBorder(
				ConstantsGUI.TOP_TXT_WRITER, 
				ConstantsGUI.RIGHT_TXT_WRITER, 
				ConstantsGUI.DOWN_TXT_WRITER, 
				ConstantsGUI.LEFT_TXT_WRITER));
		add(panelSend, BorderLayout.PAGE_END);
		
		// Campo de actualizacion mensajes recibidos
		JPanel panelMessageGett = new JPanel();
		panelMessageGett.setLayout(new BorderLayout());
		panelMessageGett.setBackground(Color.decode(ConstantsGUI.COLOR_CHAT));
		txtAMessgeGett = new JTextArea();
		txtAMessgeGett.setEditable(false);
		panelMessageGett.setBorder(BorderFactory.createEmptyBorder(
				20, 
				10, 
				20, 
				10));
		panelMessageGett.add(txtAMessgeGett, BorderLayout.CENTER);
		add(panelMessageGett, BorderLayout.CENTER);
	}
	
	public String getTxtToWrite() {
		return txtMessageToSend.getText();
	}
	
	public void updateMessage(String message) {
		txtAMessgeGett.append(message + "\n");
		txtMessageToSend.setText("");
	}

	public void setActionListener(ActionListener actionListener) {
		btnSend.addActionListener(actionListener);
		btnSend.setActionCommand(ActionCommands.BTN_SEND.toString());
	}
}
