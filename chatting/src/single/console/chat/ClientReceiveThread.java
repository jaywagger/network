package single.console.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

//클라이언트에서 서버가 전송하는 데이터를 읽는 작업을 수행하는 쓰레드
public class ClientReceiveThread extends Thread{
	Socket socket;
	public ClientReceiveThread(Socket socket) {
		super();
		this.socket = socket;
	}
	//서버가 전달한 데이터를 읽어서 출력
	@Override
	public void run() {
		BufferedReader in = null;
		try {
			in = new BufferedReader(
						new InputStreamReader(socket.getInputStream()));
			String resMsg = ""; //서버에서 받은 데이터
			while(true) {
				resMsg = in.readLine();
				if(resMsg==null) {
					break;
				}
				System.out.println("서버>>"+resMsg);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}









