package view;

import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import evt.MultiChatServerEvt;


/**
 * ü�ù� ������ ȭ��
 * @author owner
 */
@SuppressWarnings("serial")
public class MultiChatServerView extends JFrame{
//	private JList<String> jlChatList;
//	private JScrollPane jspList;
//	private DefaultListModel<String> dlmChatList; 
	private JList<String> jlChatList1, jlChatList2, jlChatList3, jlChatList4;
	private JScrollPane jspList1, jspList2, jspList3, jspList4;
	private DefaultListModel<String> dlmChatList1, dlmChatList2, dlmChatList3, dlmChatList4; 
	private JButton jbtOpenServer, jbtCloseServer;
	
	public MultiChatServerView() {
		super(":::::::ä�ù������:::::::");
		
//		dlmChatList = new DefaultListModel<String>();
//		jlChatList = new JList<String>(dlmChatList);
//		jspList = new JScrollPane(jlChatList);
		dlmChatList1 = new DefaultListModel<String>();
		jlChatList1 = new JList<String>(dlmChatList1);
		jspList1 = new JScrollPane(jlChatList1);
		
		dlmChatList2 = new DefaultListModel<String>();
		jlChatList2 = new JList<String>(dlmChatList2);
		jspList2 = new JScrollPane(jlChatList2);
		
		dlmChatList3 = new DefaultListModel<String>();
		jlChatList3 = new JList<String>(dlmChatList3);
		jspList3 = new JScrollPane(jlChatList3);
		
		dlmChatList4 = new DefaultListModel<String>();
		jlChatList4 = new JList<String>(dlmChatList4);
		jspList4 = new JScrollPane(jlChatList4);
		
		
		jbtOpenServer = new JButton("��������");
		jbtCloseServer = new JButton("��������");
		
		JPanel chatRoomPanel = new JPanel(new GridLayout(2, 2));//4�� �� ���� ���� 
		JPanel btnPanel = new JPanel();
		btnPanel.add(jbtOpenServer);
		btnPanel.add(jbtCloseServer);
		
		//jspList.setBorder(new TitledBorder("������ ����"));
		jspList1.setBorder(new TitledBorder("1��"));
		jspList2.setBorder(new TitledBorder("2��"));
		jspList3.setBorder(new TitledBorder("3��"));
		jspList4.setBorder(new TitledBorder("4��"));
		
		chatRoomPanel.add(jspList1);
		chatRoomPanel.add(jspList2);
		chatRoomPanel.add(jspList3);
		chatRoomPanel.add(jspList4);
		
		//add("Center", jspList);
		add("Center", chatRoomPanel);
		add("South", btnPanel);
		
		//�̺�Ʈ ���
		MultiChatServerEvt mcse = new MultiChatServerEvt(this);
		jbtOpenServer.addActionListener(mcse);
		jbtCloseServer.addActionListener(mcse);
		
		addWindowListener(mcse);
		
		setBounds(100, 100, 600, 800);
		setVisible(true);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

//	public JList<String> getJlChatList() {
//		return jlChatList;
//	}
//
//	public JScrollPane getJspList() {
//		return jspList;
//	}
//
//	public DefaultListModel<String> getDlmChatList() {
//		return dlmChatList;
//	}
	
	public JButton getJbtOpenServer() {
		return jbtOpenServer;
	}

	public JButton getJbtCloseServer() {
		return jbtCloseServer;
	}

	public JList<String> getJlChatList1() {
		return jlChatList1;
	}

	public JList<String> getJlChatList2() {
		return jlChatList2;
	}

	public JList<String> getJlChatList3() {
		return jlChatList3;
	}

	public JList<String> getJlChatList4() {
		return jlChatList4;
	}

	public JScrollPane getJspList1() {
		return jspList1;
	}

	public JScrollPane getJspList2() {
		return jspList2;
	}

	public JScrollPane getJspList3() {
		return jspList3;
	}

	public JScrollPane getJspList4() {
		return jspList4;
	}

	public DefaultListModel<String> getDlmChatList1() {
		return dlmChatList1;
	}

	public DefaultListModel<String> getDlmChatList2() {
		return dlmChatList2;
	}

	public DefaultListModel<String> getDlmChatList3() {
		return dlmChatList3;
	}

	public DefaultListModel<String> getDlmChatList4() {
		return dlmChatList4;
	}

	
	
	
}
