package co.edu.uptc.prgr3.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import co.edu.uptc.prgr3.net.Client;
import co.edu.uptc.prgr3.views.MainWindow;

class ControllBtn extends Thread implements ActionListener {
	
	private static final String ME_SEND = "Yo envie : ";
	private static final String HE_SEND = "Tu amigo/a te envio : ";
	
	private Client client;
	private MainWindow mainWindow;

	public ControllBtn(Client client, MainWindow mainWindow) {
		this.client = client;
		this.mainWindow = mainWindow;
		start();
	}
	
	@Override
	public void run() {
		while(true) {
			getMessage();
		}
	}

	private void getMessage() {
		try {
			mainWindow.updateMessage(HE_SEND + client.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (ActionCommands.valueOf(e.getActionCommand())) {
		case BTN_SEND:
			btnSend();
			break;
		}
	}

	private void btnSend() {
		String messageToSend = mainWindow.getTxtToWrite();
		mainWindow.updateMessage(ME_SEND + messageToSend);
		try {
			client.sendAMessage(messageToSend);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
