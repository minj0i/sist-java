package admin.view;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class test extends JFrame{
	private JTabbedPane jtp;
	private PMProductView pmpv;
	
	public test() {
	super("�׽�Ʈ");
	pmpv = new PMProductView();
	jtp = new JTabbedPane();
	jtp.add("��ǰ����", pmpv);

	add("Center", jtp);
	
	setBounds(100, 100, 800, 600);
	setVisible(true);
	}//������
	
	public static void main(String[] args) {
		new test();
	}//main

}//class
