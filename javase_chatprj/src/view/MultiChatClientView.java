package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import evt.MultiChatClientEvt;


@SuppressWarnings("serial")
public class MultiChatClientView extends JFrame {
	private JTextArea jtaTalkDisplay;
//	private JTextField jtfServerIp;
	private JTextField jtfNick, jtfTalk;
	private JButton jbtConnect, jbtCapture, jbtClose;
	private JButton jbtChatPersonCheck;//접속자확인 추가
	private JScrollPane jspTalkDisplay;
	private int selectChatRoom;
	
	public MultiChatClientView(int selectChatRoom) {
		super("채팅 클라이언트");
		this.selectChatRoom = selectChatRoom;
		
		jtaTalkDisplay = new JTextArea();
//		jtfServerIp = new JTextField("211.63.89.", 10);
		jtfNick = new JTextField(10);
		jtfTalk = new JTextField();
		jtfTalk.setBorder(new TitledBorder("대화"));
		
		jbtConnect = new JButton("접속");
		jbtCapture = new JButton("저장");
		jbtChatPersonCheck = new JButton("접속자");//접속자확인 추가
		jbtClose = new JButton("종료");
		
		
		jspTalkDisplay = new JScrollPane(jtaTalkDisplay);
		jspTalkDisplay.setBorder(new TitledBorder("대화내용"));
		
		jtaTalkDisplay.setEditable(false);
		
		JPanel jpNorth = new JPanel();
//		jpNorth.add(new JLabel("서버주소",JLabel.CENTER));
//		jpNorth.add(jtfServerIp);
		jpNorth.add(new JLabel("대화명",JLabel.CENTER));
		jpNorth.add(jtfNick);
		jpNorth.add(jbtConnect);
		jpNorth.add(jbtCapture);
		jpNorth.add(jbtChatPersonCheck);//접속자확인 추가
		jpNorth.add(jbtClose);
		
		add("North", jpNorth);
		add("Center", jspTalkDisplay);
		add("South", jtfTalk);

		MultiChatClientEvt mcce = new MultiChatClientEvt(this);
		addWindowListener(mcce);
		jbtConnect.addActionListener(mcce);
		jbtCapture.addActionListener(mcce);
		jbtChatPersonCheck.addActionListener(mcce);//접속자확인 추가
		jbtClose.addActionListener(mcce);
		jtfTalk.addActionListener(mcce);
		
		setBounds(100, 100, 600, 300);
		setVisible(true);
	}


	public JTextArea getJtaTalkDisplay() {
		return jtaTalkDisplay;
	}


//	public JTextField getJtfServerIp() {
//		return jtfServerIp;
//	}
	
	
	public int getSelectChatRoom() {
		return selectChatRoom;
	}


	public JTextField getJtfNick() {
		return jtfNick;
	}


	public JTextField getJtfTalk() {
		return jtfTalk;
	}


	public JButton getJbtConnect() {
		return jbtConnect;
	}


	public JButton getJbtCapture() {
		return jbtCapture;
	}

	public JButton getJbtChatPersonCheck() {//접속자확인 추가
		return jbtChatPersonCheck;
	}

	public JButton getJbtClose() {
		return jbtClose;
	}


	public JScrollPane getJspTalkDisplay() {
		return jspTalkDisplay;
	}

}
