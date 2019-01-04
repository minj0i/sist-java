package kr.co.sist.chat.server.run;

import kr.co.sist.chat.server.view.MultiChatServerView;

public class MultiChatServerRun {

	public static void main(String[] args) {
		new MultiChatServerView();
		//<accept이 걸려있기때문에 닫기와 서버중지가 되지 않는다 따라서 쓰레드로 무한루프 돌려주어야 한다.
	}//main
}//class