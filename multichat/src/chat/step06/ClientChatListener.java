package chat.step06;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ClientChatListener implements ActionListener{
	ClientChatView view;

	public ClientChatListener(ClientChatView view) {
		super();
		this.view = view;
	}

	//onClick이랑 같은 메소드
	//버튼을 누를 때, 텍스트상자에서 enter키를 입력할 때 actionPerformed호출
	@Override
	public void actionPerformed(ActionEvent e) {
		//4. =========클라이언트가 메세지를 입력하고 Enter 또는 전송 버튼을 누르면
		//============서버에 전송
		//ActionEvent를 발생시킨 객체가 텍스트상자거나 버튼이면 실행하라는 의미
		if(e.getSource()==view.txtinput|e.getSource()==view.btnsend) {
			view.sendMsg(view.txtinput.getText());
			//보낸 후에 공백
			view.txtinput.setText("");
		}
		
	}
	
	
}
