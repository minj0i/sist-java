package day1217;
//���� �ϴ� ����
//��4�� 123�� ������ �̹����� �߰� Ʋ���� ��1�� ���ư���.
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class UseJTab extends JFrame implements MouseListener {
	ImageIcon ii2 = new ImageIcon("C:/dev/workspace/javase_prj/src/day1214/images/img2.jpg");
	JPanel tab4 = new JPanel();

	public UseJTab() {
		super("Tab");
//		//1. ���̺� �߰��� �� �ִ� ��ü ����
		JTabbedPane jtp = new JTabbedPane();
		// 2. �� �ǿ� �� ������Ʈ ����
		// ù��° �ǿ� �� ������Ʈ
		ImageIcon ii = new ImageIcon("C:/dev/workspace/javase_prj/src/day1214/images/img1.jpg");
		JLabel jl = new JLabel(ii);

		// �ι�° �ǿ� �� ������Ʈ
		JPanel jp = new JPanel();
		jp.add(new JLabel("�̸�"));
		jp.add(new JTextField(30));
		jp.add(new JButton("�Է�"));

		JPanel tab2 = new JPanel();
		tab2.setLayout(new BorderLayout());

		jp.setBorder(new TitledBorder("�Էµ�����"));

		JTextArea jta = new JTextArea();
		JScrollPane jsp = new JScrollPane(jta);
		jsp.setBorder(new TitledBorder("���â"));

		tab2.add("North", jp);
		tab2.add("Center", jsp);

		jtp.add("ó����", jl);
		jtp.add("�ι�° ��", tab2);
		jtp.add("����° ��", new JButton("Ŭ��"));

		// �׹�° �ǿ� �� ������Ʈ
		jtp.add("�׹�° ��", tab4);
		tab4.addMouseListener(this);
		
		// ��ġ
		add("Center", jtp);

		setBounds(100, 100, 600, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}// UseTab

	@Override
	public void mouseClicked(MouseEvent me) {
		String inputData = JOptionPane.showInputDialog("��й�ȣ�� �Է��ϼ���");
		// ��ȿ������
		if (inputData.equals("1234")) {
			JOptionPane.showInputDialog("��й�ȣ");
		} else {
		} // end if
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	////////////////////////// inner class ����///////////////////////////
//	public class MouseEvt extends MouseAdapter{
//		@Override
//		public void mouseClicked(MouseEvent me) {
//			String inputData = JOptionPane.showInputDialog("��й�ȣ�� �Է��ϼ���");	
//			//��ȿ������
//			if(inputData.equals("1234")) {
//				tab4.add(ii2);
//			}else {
//					jtp.requestFocus(jl);
//			}//end if
//		}//mouseClicked
	////////////////////////// inner class ��///////////////////////////

	public static void main(String[] args) {
		new UseJTab();
	}// main

}// class
