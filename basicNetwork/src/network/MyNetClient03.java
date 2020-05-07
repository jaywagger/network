package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyNetClient03{
	public static void main(String[] args) {
		//서버와 통신할 수 있는 소켓객체를 생성
		Socket socket;
		InputStream is = null;//클라이언트와 input할 수 있는 스트림
		DataInputStream dis = null;//최종적으로 클라이언트와 DataInputStream
		                           //을 이용해서 클라이언트로 부터 전송되는 데이터를
		                           //읽기
		OutputStream os = null; //클라이언트와 output할 수 있는 스트림
		DataOutputStream dos = null;
		try {
			socket = new Socket("70.12.115.50", 12345);
			System.out.println("서버접속완료..."+socket);
			
			is = socket.getInputStream();
			dis = new DataInputStream(is);
			
			//OutputStream얻기
			os = socket.getOutputStream();
			dos = new DataOutputStream(os);
			
			//1. 클라이언트<-서버
			String msg = dis.readUTF();
			System.out.println(msg);//서버가 보내는 환영메시지 출력
			
			//2. 클라이언트<-서버
			int gugu = dis.readInt();
			for (int i = 1; i <=9; i++) {
				System.out.println(gugu+"*"+i+"="+(gugu*i));
			}
			
			//3. 클라이언트-> 서버
			String clientMsg = "";
			if(gugu%2==0) {
				clientMsg = "짝수";
			}else {
				clientMsg = "홀수";
			}
			dos.writeUTF(clientMsg);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		
		
	}
}
