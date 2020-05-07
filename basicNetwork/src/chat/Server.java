package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private Socket socket;
	ServerSocket serverSocket;
	private BufferedReader in;
	private PrintWriter out;
	public Server() {
		try {
			serverSocket = new ServerSocket(12345);
			System.out.println("서버준비됨...");
			//스레드가 멈춰있다가 연결 요청이 들어오면 연결
			socket = serverSocket.accept();
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());
			
			//클라이언트에서 보낸 문자열 추출
			System.out.println(in.readLine());
			
			//클라이언트 문자열 보내기 - print했다고 출력이 되는게 아니라 계속 쌓고 있는 거임 flush해줘야 나간다.
			out.println("전송완료");
			out.flush();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			/*try {
				if(socket!=null)socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}*/
		}
	}
	public static void main(String[] args) {
		Server server = new Server();
	}
}
