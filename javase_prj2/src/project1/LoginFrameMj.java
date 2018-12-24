package project1;

import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class LoginFrameMj extends JFrame implements ActionListener {
	private JTextField jtfId;
	private JPasswordField jpfPass;
	private JButton loginOk;
	private JLabel loginId, loginPass, jlOutput;
	private FileOpenMj fo;

	public LoginFrameMj() {
		super("�α���");
		jtfId = new JTextField();
		jpfPass = new JPasswordField();
		loginId = new JLabel("���̵�: ");
		loginPass = new JLabel("��й�ȣ: ");
		jlOutput = new JLabel("���: ");
		loginOk = new JButton("�α���");

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4, 2));
		// �����̳� ������Ʈ
		panel.setBorder(new TitledBorder("�α���"));
		panel.add(loginId);
		panel.add(jtfId);
		panel.add(loginPass);
		panel.add(jpfPass);
		panel.add(jlOutput);
		panel.add(loginOk);
		
		// �̺�Ʈ ���
		jtfId.addActionListener(this);
		jpfPass.addActionListener(this);
		
		add("Center", panel);
		setBounds(100, 100, 250, 300);
		loginId.setBounds(150,300,200,50);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}// LoginFrame

	@Override
	public void actionPerformed(ActionEvent ae) {
		String id = jtfId.getText().trim();
		String pass = new String(jpfPass.getPassword());
		// ���̵� ���� ��
		if (id.equals("")) {
			jtfId.requestFocus();
			jlOutput.setText("���̵� �Է����ּ���");
		} // end if

		if (ae.getSource() == jtfId) {// ���̵𿡼� �̺�Ʈ�� �߻��ϸ�
			// ���̵� ���� ����ִٸ� Ŀ���� ��й�ȣ�� �̵�
			if (!id.equals("")) {
				jpfPass.requestFocus();
			} // end if
		} // end if

		if (ae.getSource() == jpfPass) {// ��й�ȣ���� �̺�Ʈ�� �߻��ϸ�
			// ���̵� ���� ���ٸ� Ŀ���� ���̵�� �̵�
			if (id.equals("")) {
				jtfId.requestFocus();
				jlOutput.setText("���̵� �Է����ּ���");
				return;// ��ȯ���� void�� method���� �ڵ��� ������ ���߰� ȣ���� ������ ���ư���
			} // end if

			// ��й�ȣ�� ���� ���ٸ� ���â�� "����Է�"�� �����ְ� Ŀ����
			// ��й�ȣ�� �̵�
			if (pass.trim().equals("")) {
				jlOutput.setText("��й�ȣ�� �Է����ּ���");
				jpfPass.requestFocus();
				return;
			} // end if

			// ��й�ȣ�� ���� �ִٸ� ���̵� admin, ��й�ȣ�� 123�� ������
			// ���Ͽ� ���ٸ� �ڹٸ޸��� Ŭ������ ����
			if (id.equals("admin") && pass.equals("123")) {
				try {
					fo.openFile();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				dispose();
			} else {
				jlOutput.setText("���̵� ��й�ȣ�� Ȯ���� �ּ���");
			} // end if else

		} // end if

	}//ActionEvent

	public JButton getloginOk() {
		return loginOk;
	}//loginOk

	
}//class
