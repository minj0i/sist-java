package kr.co.sist.chat.server.view;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

/**
 * 채팅방 관리자 화면
 * @author owner
 */
@SuppressWarnings("serial")
public class MultiChatServerView extends JFrame {
	private JList<String> jlChatList;
	private JScrollPane jspList;
	private JButton jbtOpenServer, jbtCloseServer;
	private DefaultListModel<String> dlmChatList;
	
	public MultiChatServerView() {
		super(":::::::::::::: 채팅방 관리자 :::::::::::::::");
		
		dlmChatList = new DefaultListModel<String>();
		jlChatList= new JList<String>(dlmChatList);
		jspList = new JScrollPane(jlChatList);
		
		jbtOpenServer = new JButton("서버시작");
		jbtCloseServer = new JButton("서버중지");
		
		JPanel btnPanel = new JPanel();
		btnPanel.add(jbtOpenServer);
		btnPanel.add(jbtCloseServer);
		
		jspList.setBorder(new TitledBorder("접속자 정보"));
		
		add("Center",jspList);
		add("South",btnPanel);
		
		setBounds(100,100,300,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//MultiChatServerView

	public JList<String> getJlChatList() {
		return jlChatList;
	}

	public JScrollPane getJspList() {
		return jspList;
	}

	public JButton getJbtOpenServer() {
		return jbtOpenServer;
	}

	public JButton getJbtCloseServer() {
		return jbtCloseServer;
	}

	public DefaultListModel<String> getDlmChatList() {
		return dlmChatList;
	}
	

}//class
