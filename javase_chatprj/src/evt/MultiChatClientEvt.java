package evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import view.MultiChatClientJoinPerson;
import view.MultiChatClientView;

public class MultiChatClientEvt extends WindowAdapter implements ActionListener, Runnable {
	private MultiChatClientView mccv;
	private Socket client;
	private DataInputStream readStram;
	private DataOutputStream writeStream;
	private Thread threadMsg;
	private String nick;
	private String[] joinPeoples;

	public MultiChatClientEvt(MultiChatClientView mccv) {
		this.mccv = mccv;
	}

	@Override
	public void run() {
		if (readStram != null) {
			try {
				String revMsg = "";
				JScrollPane jsp = mccv.getJspTalkDisplay();
				while (true) {// 서버에서 보내오는 메세지를 읽어들여
					revMsg = readStram.readUTF();

					if (!joinPeoples(revMsg)) {// 접속자 식별 서버 메세지라면 체팅을 읽어오지 않는다.
						// 채팅창에 뿌린다.
						mccv.getJtaTalkDisplay().append(revMsg + "\n");
						// 스크롤바를 가장 아래로 이동
						jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
					}
				}
			} catch (IOException ie) {
				JOptionPane.showMessageDialog(mccv, "서버가 종료되었습니다.");
				ie.printStackTrace();
			}
		}
	}

	public void connectToServer() throws UnknownHostException, IOException {
		if (client == null) {
			nick = mccv.getJtfNick().getText().trim();
			if (nick.equals("")) {
				JOptionPane.showMessageDialog(mccv, "대화명을 입력해 주세요.");
				mccv.getJtfNick().requestFocus();
				return;
			}
			if (nick.contains(",")) {
				JOptionPane.showMessageDialog(mccv, "대화명에 ,는 사용할 수 없습니다");
				mccv.getJtfNick().requestFocus();
				return;
			}

			int selectCharRoomForServerPort = mccv.getSelectChatRoom();// 클라이언트 실행시 라디오버튼으로 받아온 조 선택 버튼
			String serverIp = "211.63.89.135"; // 고정 서버 IP
//			String serverIp = mccv.getJtfServerIp().getText().trim();
//			client = new Socket(serverIp, 35001); // 입력한 ip address의 컴퓨터에 연결.
			switch (selectCharRoomForServerPort) {
			case 1:// 1조선택
				client = new Socket(serverIp, 35000); // 입력한 ip address의 컴퓨터에 연결.
				break;
			case 2:// 2조선택
				client = new Socket(serverIp, 35001);
				break;
			case 3:// 3조선택
				client = new Socket(serverIp, 35002);
				break;
			case 4:// 4조선택
				client = new Socket(serverIp, 35003);
				break;
			}

			// 스트림
			readStram = new DataInputStream(client.getInputStream());
			writeStream = new DataOutputStream(client.getOutputStream());

			// 대화명을 서버로 보낸다.
			writeStream.writeUTF(nick);
			writeStream.flush();

			mccv.getJtaTalkDisplay().setText("서버에 접속하였습니다.\n즐거운 채팅되세요.\n");

			// 메세지 읽기
			threadMsg = new Thread(this);
			threadMsg.start();

		} else {
			JOptionPane.showMessageDialog(mccv, client.getInetAddress().getHostAddress() + "서버에 이미 접속 중입니다.");
		}
	}

	/**
	 * 서버로 메세지를 보내는 일
	 * 
	 * @throws IOException
	 */
	public void sendMsg() throws IOException {
		if (writeStream != null) {
			JTextField jtf = mccv.getJtfTalk();
			// JTF에 입력한 메세지를 읽어들인다.
			String msg = jtf.getText().trim();
			// String nick = mccv.getJtfNick().getText().trim();
			if (!msg.equals("")) {
				// 스트림에 쓰고
				writeStream.writeUTF("[ " + nick + " ] : " + msg);
				// 목적지 분출
				writeStream.flush();
			}
			jtf.setText("");
		}
	}

	public void capture() throws IOException {
		switch (JOptionPane.showConfirmDialog(mccv, "대화 내용을 저장하시겠습니까?")) {
		case JOptionPane.OK_OPTION:
			// 스트림을 사용하여 저장
			File saveDir = new File("c:/dev/chat");
			saveDir.mkdirs();
			File saveFile = new File(saveDir.getAbsolutePath() + "/java_chat[" + System.currentTimeMillis() + "].dat");
			BufferedWriter bw = null;
			try {
				bw = new BufferedWriter(new FileWriter(saveFile));
				bw.write(mccv.getJtaTalkDisplay().getText());// 스트림에 대화내용 기록
				bw.flush();// 스트림에 기록된 내용을 분출
				JOptionPane.showMessageDialog(mccv, saveDir + "에 대화내용이 기록 되었습니다.");
			} finally {
				if (bw != null) {
					bw.close();
				}
			}
			break;
		}
	}

	/**
	 * 접속자 리스트 작성 메서드 서버에서 받은 메세지중 " a^2d&3#"이 포함되어 있다면 체팅을 읽어오지 않고 접속자리스트 작성
	 * 
	 * @return
	 */
	public boolean joinPeoples(String msg) {
		boolean flag = false;
		String tempJoinPeoples = "";
		tempJoinPeoples = msg.substring(0, 9);
		if (tempJoinPeoples.equals("  a^2d&3#")) {
			tempJoinPeoples = msg.substring(9, msg.length());
//			System.out.println("접속자 출력 서버 메세지 : " + tempJoinPeoples);
			joinPeoples = tempJoinPeoples.split(",");
			flag = true;
		}
		return flag;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == mccv.getJbtConnect()) {
			try {
				connectToServer();
			} catch (UnknownHostException uhe) {
				JOptionPane.showMessageDialog(mccv, "서버를 알 수 없습니다.");
				uhe.printStackTrace();
			} catch (IOException ie) {
				JOptionPane.showMessageDialog(mccv, "연결 실패.");
				ie.printStackTrace();
			}
		}
		if (ae.getSource() == mccv.getJbtCapture()) {
			try {
				if (!mccv.getJtaTalkDisplay().getText().equals("")) {
					capture();
				} else {
					JOptionPane.showMessageDialog(mccv, "저장할 내화내용이 없습니다.");
				}
			} catch (IOException ie) {
				JOptionPane.showMessageDialog(mccv, "파일로 저장하는 중 문제가 발생하였습니다.");
				ie.printStackTrace();
			}
		}
		
		if (ae.getSource() == mccv.getJbtChatPersonCheck()) {
			new MultiChatClientJoinPerson(this);
		}

		if (ae.getSource() == mccv.getJbtClose()) {
			mccv.dispose();
		}

		if (ae.getSource() == mccv.getJtfTalk()) {
			try {
				sendMsg();
			} catch (IOException ie) {
				JOptionPane.showMessageDialog(mccv, "서버가 종료되어 메세지를 전송할 수 없습니다.");
				ie.printStackTrace();
			}
		}
	}

	@Override
	public void windowClosing(WindowEvent we) {
		mccv.dispose();
	}

	@Override
	public void windowClosed(WindowEvent we) {
		try {
			if (readStram != null) {readStram.close();}
			if (writeStream != null) {writeStream.close();}
			if (client != null) {client.close();}
		} catch (IOException ie) {
			ie.printStackTrace();
		} finally {
			System.exit(0);
		}
	}

	public String[] getJoinPeoples() {
		return joinPeoples;
	}

	public MultiChatClientView getMccv() {
		return mccv;
	}
	
	
}
