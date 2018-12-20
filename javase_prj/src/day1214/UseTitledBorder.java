package day1214;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import kr.co.sist.memo.view.JavaMemo;

@SuppressWarnings("serial")
public class UseTitledBorder extends JFrame implements ActionListener {
	private JTextField jtfId;
	private JPasswordField jpfPass;
	private JLabel jlOutput;

	public UseTitledBorder() {
		super("border ���");

		jtfId = new JTextField();
		jpfPass = new JPasswordField();
		jlOutput = new JLabel("���: ");

		jtfId.setBorder(new TitledBorder("���̵�"));
		jpfPass.setBorder(new TitledBorder("��й�ȣ"));
		jlOutput.setBorder(new TitledBorder("���"));

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 1));
		// �����̳� ������Ʈ
		panel.setBorder(new TitledBorder("�α���"));

		panel.add(jtfId);
		panel.add(jpfPass);
		panel.add(jlOutput);

		// �̺�Ʈ ���
		jtfId.addActionListener(this);
		jpfPass.addActionListener(this);

		add("Center", panel);
		setBounds(100, 100, 250, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}// UseTitledBorder

	@Override
	public void actionPerformed(ActionEvent ae) {
		String id=jtfId.getText().trim();
		String pass=new String(jpfPass.getPassword());
		//���̵� ���� ��
		if(id.equals("")) {
			jtfId.requestFocus();
			jlOutput.setText("���̵� �Է����ּ���");
		}//end if
		
		if (ae.getSource() == jtfId) {// ���̵𿡼� �̺�Ʈ�� �߻��ϸ�
			//���̵� ���� ����ִٸ� Ŀ���� ��й�ȣ�� �̵�
			if(!id.equals("")) {
				 jpfPass.requestFocus();
			}//end if
		} // end if
		
		if (ae.getSource() == jpfPass) {//��й�ȣ���� �̺�Ʈ�� �߻��ϸ�
			//���̵� ���� ���ٸ� Ŀ���� ���̵�� �̵�
			if(id.equals("")) {
				 jtfId.requestFocus();
				 jlOutput.setText("���̵� �Է����ּ���");
				 return;//��ȯ���� void�� method���� �ڵ��� ������ ���߰� ȣ���� ������ ���ư���
			}//end if
			
			//��й�ȣ�� ���� ���ٸ� ���â�� "����Է�"�� �����ְ� Ŀ����
			//��й�ȣ�� �̵�
			if(pass.trim().equals("")) {
				jlOutput.setText("��й�ȣ�� �Է����ּ���");
				jpfPass.requestFocus();
				return;
			}//end if
			
			//��й�ȣ�� ���� �ִٸ� ���̵� admin, ��й�ȣ�� 123�� ������
			//���Ͽ� ���ٸ� �ڹٸ޸��� Ŭ������ ����
			if(id.equals("admin")&&pass.equals("123")) {
				new JavaMemo();
				dispose();
			}else {
				jlOutput.setText("���̵� ��й�ȣ�� Ȯ���� �ּ���");
			}//end if else
			
		} // end if
	}//end actionPerformed

	public static void main(String[] args) {
		new UseTitledBorder();
	}// main

}// class
