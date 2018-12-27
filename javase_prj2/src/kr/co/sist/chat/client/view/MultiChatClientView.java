package kr.co.sist.chat.client.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class MultiChatClientView extends JFrame {

	private JTextArea jtaTalkDisplay;
	private JTextField jtfServerIp, jtfNick, jtfTalk;
	private JButton jbtConnect, jbtCapture, jbtClose;
	private JScrollPane jspTalkDisplay;
	
	public MultiChatClientView() {
		super("ä�� Ŭ���̾�Ʈ");
		
		jtaTalkDisplay = new JTextArea();
		
		jtfServerIp = new JTextField("211.63.89.",10); //""���� ���� �̸� TextField�� �־��ִ� ��
		jtfNick = new JTextField(10);
		jtfTalk= new JTextField();
		jtfTalk.setBorder(new TitledBorder("��ȭ"));
		
		jbtConnect = new JButton("����");
		jbtCapture = new JButton("����");
		jbtClose = new JButton("����");
		
		jspTalkDisplay = new JScrollPane(jtaTalkDisplay);
		jspTalkDisplay.setBorder(new TitledBorder("��ȭ����"));
		
		jtaTalkDisplay.setEditable(false);
		
		JPanel jpNorth=new JPanel();
		jpNorth.add(new JLabel("�����ּ�",JLabel.CENTER));
		jpNorth.add(jtfServerIp);
		jpNorth.add(new JLabel("��ȭ��",JLabel.CENTER));
		jpNorth.add(jtfNick);
		jpNorth.add(jbtConnect);
		jpNorth.add(jbtCapture);
		jpNorth.add(jbtClose);
		
		add("North", jpNorth);
		add("Center", jspTalkDisplay);
		add("South", jtfTalk);
		
		setBounds(100,100,600,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}//MultiChatClientView

	public JTextArea getJtaTalkDisplay() {
		return jtaTalkDisplay;
	}

	public JTextField getJtfServerIp() {
		return jtfServerIp;
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

	public JButton getJbtClose() {
		return jbtClose;
	}

	public JScrollPane getJspTalkDisplay() {
		return jspTalkDisplay;
	}
	
	
}//class
