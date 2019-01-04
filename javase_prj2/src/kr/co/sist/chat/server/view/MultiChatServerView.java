package kr.co.sist.chat.server.view;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import kr.co.sist.chat.server.evt.MultiChatServerEvt;

/**
 * ä�ù� ������ ȭ��
 * @author owner
 */
@SuppressWarnings("serial")
public class MultiChatServerView extends JFrame{
	private JList<String> jlChatList;
	private JScrollPane jspList;
	private JButton jbtOpenServer,jbtCloseServer;
	private DefaultListModel<String> dlmChatList;
	
	public MultiChatServerView() {
		super("::::::::ä�ù� ������::::::::");
		dlmChatList=new DefaultListModel<String>();//�ν��Ͻ�ȭ
		jlChatList = new JList<String>(dlmChatList);
		jspList=new JScrollPane(jlChatList);
		
		jbtOpenServer=new JButton("���� ����");
		jbtCloseServer=new JButton("���� ����");
		
		JPanel btnPanel =new JPanel();
		btnPanel.add(jbtOpenServer);
		btnPanel.add(jbtCloseServer);
		
		jspList.setBorder(new TitledBorder("������ ����"));
		
		add("Center",jspList);
		add("South",btnPanel);
		
		//�̺�Ʈ ���
		MultiChatServerEvt mcse=new MultiChatServerEvt(this);
		jbtOpenServer.addActionListener(mcse);
		jbtCloseServer.addActionListener(mcse);
		
		addWindowListener(mcse);
		
		setBounds(100, 100, 400, 700);
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
