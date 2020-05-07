package single.console.chat;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ConsoleChatServer {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(12345);
			System.out.println("서버접속완료.....");
			while(true) {
				Socket socket = server.accept();
				InetAddress clientInfo = socket.getInetAddress();
				System.out.println("접속한 클라이언트:"+
						clientInfo.getHostAddress());
				ServerSenderThread senderThread = 
							new ServerSenderThread(socket);
				senderThread.start();
				
				new ServerReceiveThread(socket).start();
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
