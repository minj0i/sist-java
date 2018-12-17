package day1217;

import java.awt.BorderLayout;

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
public class UseJTab2 extends JFrame implements MouseListener {
	ImageIcon ii2= new ImageIcon("C:\\dev\\workspace\\javase_prj\\src\\day1214\\images\\img3.gif");
	JLabel lblTap4= new JLabel();
	private JTabbedPane jtp;
	public UseJTab2() {
		super("Tab");
		//1.���� �߰��� �� �ִ� ��ü�� ����
		jtp = new JTabbedPane();
		
		//2.�� �ǿ� �� ������Ʈ�� ����
		//ó�� �ǿ� �� ������Ʈ
		ImageIcon ii = new ImageIcon("C:\\dev\\workspace\\javase_prj\\src\\day1214\\images\\img1.png");
		JLabel jl= new JLabel(ii);
		
		
		//�ι��� �ǿ� �� ������Ʈ
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
		
		tab2.add("North",jp);
		tab2.add("Center",jsp);
		
		jtp.addTab("ó����", jl);
		jtp.addTab("�ι�° ��", tab2);
		jtp.addTab("����° ��", new JButton("Ŭ��"));
		jtp.addTab("�׹�° ��",lblTap4);		
		//��ġ
		add("Center",jtp);
		
		//�̺�Ʈ ���
		jtp.addMouseListener(this);
		

		setBounds(100,100,600,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//UseJTab2
	public void Tab4(){
		String s = JOptionPane.showInputDialog("��й�ȣ �Է�");
		if(s.equals("123")) {
			lblTap4.setIcon(ii2);
		}
		else {
			jtp.setSelectedIndex(0);
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int index = jtp.getSelectedIndex();
		if(index==3) {
			Tab4();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	public static void main(String[] args) {
		new UseJTab2();
	}//main

}//class
