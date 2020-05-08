package chat.step09;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ClientChatListener implements ActionListener{
	ClientChatView view;

	public ClientChatListener(ClientChatView view) {
		super();
		this.view = view;
	}

	//버튼을 누를때, 텍스트상자에서 엔터키를 입력할때 actionPerformed가 호출된다.
	@Override
	public void actionPerformed(ActionEvent e) {
		//1. 채팅대화를 전송하는 경우 프로토콜, 대화내용,nickname=====================
		if(e.getSource() ==view.txtinput | e.getSource()==view.btnsend) {
			view.sendMsg("chatting/"+view.txtinput.getText().trim()
													+"/"+view.nickname);
		//==================================================================	
			view.txtinput.setText("");
		}
		
	}
	
	
}
