package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class MultiChatClientSelect extends JDialog implements ActionListener{
	private JRadioButton jtbGroup1;
	private JRadioButton jtbGroup2;
	private JRadioButton jtbGroup3;
	private JRadioButton jtbGroup4;
	private JButton jbtLogin;
	private int selectChatRoom;
	
	public MultiChatClientSelect() {
		JLabel jlbTitle = new JLabel("채팅방 선택", JLabel.CENTER);
		JPanel jpnCenter = new JPanel(new GridLayout(4, 1));
		ButtonGroup jrbChatRoomSelect = new ButtonGroup();
		jtbGroup1 = new JRadioButton("1조");
		jtbGroup2 = new JRadioButton("2조");
		jtbGroup3 = new JRadioButton("3조");
		jtbGroup4 = new JRadioButton("4조");
		jbtLogin = new JButton("접속");
		
		jrbChatRoomSelect.add(jtbGroup1);
		jrbChatRoomSelect.add(jtbGroup2);
		jrbChatRoomSelect.add(jtbGroup3);
		jrbChatRoomSelect.add(jtbGroup4);
		jtbGroup1.setSelected(true);
		selectChatRoom = 1;
		
		jpnCenter.add(jtbGroup1);
		jpnCenter.add(jtbGroup2);
		jpnCenter.add(jtbGroup3);
		jpnCenter.add(jtbGroup4);
		
		add("North", jlbTitle);
		add("Center", jpnCenter);
		add("South", jbtLogin);
		
		jtbGroup1.addActionListener(this);
		jtbGroup2.addActionListener(this);
		jtbGroup3.addActionListener(this);
		jtbGroup4.addActionListener(this);
		jbtLogin.addActionListener(this);
		
		setBounds(300, 200, 300, 200);
		setVisible(true);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
			
			@Override
			public void windowClosed(WindowEvent we) {
				//System.exit(0);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == jtbGroup1) {
			selectChatRoom = 1;
		}
		if(ae.getSource() == jtbGroup2) {
			selectChatRoom = 2;
		}
		if(ae.getSource() == jtbGroup3) {
			selectChatRoom = 3;
		}
		if(ae.getSource() == jtbGroup4) {
			selectChatRoom = 4;
		}
		if(ae.getSource() == jbtLogin) {
			new MultiChatClientView(selectChatRoom);
			dispose();
		}
	}
	
	
	
}
