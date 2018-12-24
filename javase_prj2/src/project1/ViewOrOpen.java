package project1;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class ViewOrOpen extends JFrame implements ActionListener{
	private JButton VIEW, REPORT;
	private FileOpen fo;
	
	public ViewOrOpen() {
		super("작업을 선택하세요");
		VIEW = new JButton("VIEW");
		REPORT = new JButton("REPORT");
		setLayout(null);
		
		add(VIEW);
		add(REPORT);
		
		VIEW.setBounds(30, 50, 150, 80);
		REPORT.setBounds(200, 50, 150, 80);
		
		VIEW.addActionListener(this);
		REPORT.addActionListener(this);
		
		setBounds(30,30,400,200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}//ViewOrOpen

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == VIEW) {
			new FileOpen();
		}//VIEW
		if (ae.getSource() == REPORT) {
			//나중에 report만드는 것으로 바꿀 것
			dispose();
		}//end if
	}// actionPerformed

	
}//class
