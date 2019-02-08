package admin.view;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class test extends JFrame{
	private JTabbedPane jtp;
	private PMProductView pmpv;
	
	public test() {
	super("抛胶飘");
	pmpv = new PMProductView();
	jtp = new JTabbedPane();
	jtp.add("惑前包府", pmpv);

	add("Center", jtp);
	
	setBounds(100, 100, 800, 600);
	setVisible(true);
	}//积己磊
	
	public static void main(String[] args) {
		new test();
	}//main

}//class
