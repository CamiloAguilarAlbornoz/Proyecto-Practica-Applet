package co.edu.uptc.prgr3.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
	
	private Socket socket;

	public Client(String host, int port) {
		try {
			socket = new Socket(host, port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendAMessage(String message) throws IOException {
		DataOutputStream stream = new DataOutputStream(socket.getOutputStream());
		stream.writeUTF(message);
	}

	public String getMessage() throws IOException {
		DataInputStream stream = new DataInputStream(socket.getInputStream());
		return stream.readUTF();
	}
}
