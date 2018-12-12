package day1211;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class Work26 extends Frame implements ItemListener{
	Choice choColor;
	Label lblColor;
	
	public Work26() {
		
		lblColor = new Label("오늘은 화요일");
		lblColor.setFont(new Font("Dialog",Font.BOLD,15));
		choColor = new Choice();
		choColor.add("색선택");
		choColor.add("검은색");
		choColor.add("파란색");
		choColor.add("빨간색");
		choColor.add("녹색");
		choColor.add("심홍색");
		
		setLayout(null);
		
		lblColor.setBounds(40,50,100,25);
		choColor.setBounds(160,50,100,25);
		add(lblColor);
		add(choColor);
		
		//이벤트 등록
		choColor.addItemListener(this);
		
		
		setBounds(200, 200, 400, 300);
		setVisible(true);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				dispose();
			}//windowClosing
		});//addWindowListener
		
	}//Work26

	public static void main(String[] args) {
		new Work26();
	}//main

	@Override
	public void itemStateChanged(ItemEvent e) {
		switch (choColor.getSelectedIndex()) {
		case 1 : lblColor.setForeground(Color.BLACK); break;
		case 2 : lblColor.setForeground(Color.BLUE); break;
		case 3 : lblColor.setForeground(Color.RED); break;
		case 4 : lblColor.setForeground(Color.GREEN); break;
		case 5 : lblColor.setForeground(Color.MAGENTA); break;
		}
		
	}

}//class
