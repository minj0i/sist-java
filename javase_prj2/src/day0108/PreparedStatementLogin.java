package day0108;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;


@SuppressWarnings("serial")
public class PreparedStatementLogin extends JFrame{

	private JTextField jtfId;
	private JPasswordField jpfPass;
	private JButton jbtLogin;
	private JButton jbtCancel;
	
	public PreparedStatementLogin() {
		super("Statement ��ü�� ����� �α���");
		jtfId = new JTextField();
		jpfPass = new JPasswordField();
		jbtLogin = new JButton("�α���");
		jbtCancel = new JButton("���");
		
		setLayout(new GridLayout(3, 1));
		JPanel panel = new JPanel();
		panel.add(jbtLogin);
		panel.add(jbtCancel);
		
		jtfId.setBorder(new TitledBorder("���̵�"));
		jpfPass.setBorder(new TitledBorder("��й�ȣ"));
		
		add(jtfId);
		add(jpfPass);
		add(panel);
		
		PreparedStatementLoginEvt sle = new PreparedStatementLoginEvt(this);
		jtfId.addActionListener(sle);
		jpfPass.addActionListener(sle);
		jbtLogin.addActionListener(sle);
		jbtCancel.addActionListener(sle);
		
		addWindowListener(sle);
				
		setBounds(100,100,300,150);
		setVisible(true);
		setResizable(false);
		
		
	}//StatementLogin
	
	
	public JTextField getJtfId() {
		return jtfId;
	}

	public JPasswordField getJpfPass() {
		return jpfPass;
	}

	public JButton getJbtLogin() {
		return jbtLogin;
	}

	public JButton getJbtCancel() {
		return jbtCancel;
	}

	public static void main(String[] args) {
		new PreparedStatementLogin();
	}//main

}//class
