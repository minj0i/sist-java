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
	private JButton jbtChatPersonCheck;//������Ȯ�� �߰�
	private JScrollPane jspTalkDisplay;
	private int selectChatRoom;
	
	public MultiChatClientView(int selectChatRoom) {
		super("ä�� Ŭ���̾�Ʈ");
		this.selectChatRoom = selectChatRoom;
		
		jtaTalkDisplay = new JTextArea();
//		jtfServerIp = new JTextField("211.63.89.", 10);
		jtfNick = new JTextField(10);
		jtfTalk = new JTextField();
		jtfTalk.setBorder(new TitledBorder("��ȭ"));
		
		jbtConnect = new JButton("����");
		jbtCapture = new JButton("����");
		jbtChatPersonCheck = new JButton("������");//������Ȯ�� �߰�
		jbtClose = new JButton("����");
		
		
		jspTalkDisplay = new JScrollPane(jtaTalkDisplay);
		jspTalkDisplay.setBorder(new TitledBorder("��ȭ����"));
		
		jtaTalkDisplay.setEditable(false);
		
		JPanel jpNorth = new JPanel();
//		jpNorth.add(new JLabel("�����ּ�",JLabel.CENTER));
//		jpNorth.add(jtfServerIp);
		jpNorth.add(new JLabel("��ȭ��",JLabel.CENTER));
		jpNorth.add(jtfNick);
		jpNorth.add(jbtConnect);
		jpNorth.add(jbtCapture);
		jpNorth.add(jbtChatPersonCheck);//������Ȯ�� �߰�
		jpNorth.add(jbtClose);
		
		add("North", jpNorth);
		add("Center", jspTalkDisplay);
		add("South", jtfTalk);

		MultiChatClientEvt mcce = new MultiChatClientEvt(this);
		addWindowListener(mcce);
		jbtConnect.addActionListener(mcce);
		jbtCapture.addActionListener(mcce);
		jbtChatPersonCheck.addActionListener(mcce);//������Ȯ�� �߰�
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

	public JButton getJbtChatPersonCheck() {//������Ȯ�� �߰�
		return jbtChatPersonCheck;
	}

	public JButton getJbtClose() {
		return jbtClose;
	}


	public JScrollPane getJspTalkDisplay() {
		return jspTalkDisplay;
	}

}
