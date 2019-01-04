package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

import evt.MultiChatClientEvt;

public class MultiChatClientJoinPerson extends JDialog implements ActionListener {
	private MultiChatClientEvt mcce;
	private JList<String> jlChatList;
	private JScrollPane jspList;
	private DefaultListModel<String> dlmChatList;
	private JButton jbtClose;

	public MultiChatClientJoinPerson(MultiChatClientEvt mcce) {
		this.mcce = mcce;
		JLabel jlbTitle = new JLabel(
				mcce.getMccv().getSelectChatRoom() + "�� ä�ù� - ���� ������", 
				JLabel.CENTER);
		dlmChatList = new DefaultListModel<String>();
		jlChatList = new JList<String>(dlmChatList);
		jspList = new JScrollPane(jlChatList);
		jbtClose = new JButton("�ݱ�");

		add("North", jlbTitle);
		add("Center", jspList);
		add("South", jbtClose);

		addJoinPeoples();

		jbtClose.addActionListener(this);

		setBounds(mcce.getMccv().getX()+100, mcce.getMccv().getY()+100, 300, 200);
		setVisible(true);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});

	}

	public void addJoinPeoples() {
		try {
			String tempPersons[] = mcce.getJoinPeoples();
			for (int i = 0; i < tempPersons.length; i++) {
				dlmChatList.addElement(tempPersons[i]);
			}
		} catch (NullPointerException npe) {
			dlmChatList.addElement("���� �� �� �ش� ä�ù���");
			dlmChatList.addElement("�����ڸ� Ȯ���� �� �ֽ��ϴ�.");
		}

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == jbtClose) {
			dispose();
		}
	}

}
