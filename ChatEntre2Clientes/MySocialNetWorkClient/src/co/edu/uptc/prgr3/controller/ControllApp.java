package co.edu.uptc.prgr3.controller;

import co.edu.uptc.prgr3.net.Client;
import co.edu.uptc.prgr3.views.MainWindow;

public class ControllApp {

	private MainWindow mainWindow;
	private Client client;

	public ControllApp() {
		client = new Client("localhost", 31510);
		mainWindow = new MainWindow();
		mainWindow.setActionListener(new ControllBtn(client, mainWindow));
	}
}
