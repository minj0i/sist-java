package day1214;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class UseJOptionPane extends JFrame implements ActionListener {

	private JButton btn1, btn2, btn3;
	private JLabel jlOutput;

	public UseJOptionPane() {
		super("JOptionPane ���");
		btn1 = new JButton("Input Dialog");
		btn2 = new JButton("Message Dialog");
		btn3 = new JButton("Confirm Dialog");

		jlOutput = new JLabel("���");
		jlOutput.setBorder(new TitledBorder("���â"));

		JPanel panel = new JPanel();
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);

		add("Center", panel);
		add("South", jlOutput);

		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);

		setBounds(100, 100, 400, 180);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}// UseJOptionPane

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == btn1) {
			// JOptionPane.showInputDialog("�޼���", "�ʱⰪ")
			String name = JOptionPane.showInputDialog("�̸��Է�", "ȫ�浿");
			jlOutput.setText(name + "�� �ȳ��ϼ���?");
		} // end if
		if (ae.getSource() == btn2) {
			JOptionPane.showMessageDialog(this, "������ �ݿ����Դϴ�.", "���Ͼȳ�", JOptionPane.QUESTION_MESSAGE);
			//PLAIN : �ƹ��͵� �ȶ�, Error : ����
//			JOptionPane.showMessageDialog(this, "������ �ݿ����Դϴ�.", "���Ͼȳ�", JOptionPane.ERROR_MESSAGE);
		} // end if
		if (ae.getSource() == btn3) {
			//int�� �޾Ƽ� switch���� 0, 1, 2�� �ص� ��.
			int flag = JOptionPane.showConfirmDialog(this, "���� ���ְ� ��̾��?");
			switch (flag) {
			case JOptionPane.OK_OPTION:
				JOptionPane.showMessageDialog(this, "�ູ�� ���� �Ǽ���!");
				break;
			case JOptionPane.NO_OPTION:
				String menu = JOptionPane.showInputDialog("� ���� �޴������?");
				if(menu!=null) {
				JOptionPane.showMessageDialog(this, menu + "�� �� �׷��� ��!");
				}else {
					JOptionPane.showMessageDialog(this, "�ϱ� ������?");
				}
				break;
			case JOptionPane.CANCEL_OPTION:
				JOptionPane.showMessageDialog(this, "�ϱ� ������?");
				break;
			}//switch end
		} // end if
	}// actionPerformed

	public static void main(String[] args) {
		new UseJOptionPane();
	}// main

}// class
