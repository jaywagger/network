package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
//바이너리데이터를 읽고 쓰지 않는 경우 - 문자열
public class MyNetClient04 {
	public static void main(String[] args) {
		Socket socket = null;
		BufferedReader in = null;
		PrintWriter out = null;
		try {
			socket = new Socket("70.12.115.50", 12345);
			System.out.println("서버접속완료..."+socket);
			in = new BufferedReader(
						new InputStreamReader(
								socket.getInputStream()));
			//생성할때 autoflush옵션을 설정
			out = new PrintWriter(socket.getOutputStream(),true);
			
			//*****통신시작********
			//1. 클라이언트 <- 서버
			String msg = in.readLine();
			System.out.println("서버가 보내온 메시지:"+msg);
			
			//2. 클라이언트-> 서버
			out.println("서버야 안녕...나는 클라이언트");
			//out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
			
		
	}

}
