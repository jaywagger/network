package single.console.chat;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ConsoleChatClient {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("70.12.115.63",12345);
			new ClientReceiveThread(socket).start();
			new ClientSenderThread(socket).start();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
