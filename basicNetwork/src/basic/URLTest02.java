package basic;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

//URL클래스
//=> 인터넷에서 확인할 수 있는 자원을 추출
public class URLTest02 {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		try {
			URL url =
				new URL("http://cafefiles.naver.net/20120209_226/pododumok_13287752996753FNE4_jpg/%C0%E5%B5%BF%B0%C7_5_pododumok.jpg");
			
			//BufferedInputStream으로 읽어서
			//FileOutputStream으로 copy
			BufferedInputStream bis =
					new BufferedInputStream(url.openStream());
			fos = new FileOutputStream("src/image/jangImg.jpg");
			while(true) {
				int data_byte =bis.read();
				if(data_byte==-1) { //스트림의 끝을 만나면
					break;           //while을 빠져나가기
				}
				fos.write(data_byte);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fos!=null)fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	

}
