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
		super("JOptionPane 사용");
		btn1 = new JButton("Input Dialog");
		btn2 = new JButton("Message Dialog");
		btn3 = new JButton("Confirm Dialog");
		
		jlOutput = new JLabel("출력");
		jlOutput.setBorder(new TitledBorder("출력창"));

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
			// JOptionPane.showInputDialog("메세지", "초기값")
			String name = JOptionPane.showInputDialog("이름입력", "홍길동");
			jlOutput.setText(name + "님 안녕하세요?");
		} // end if
		if (ae.getSource() == btn2) {
			JOptionPane.showMessageDialog(this, "오늘은 금요일입니다.", "요일안내", JOptionPane.QUESTION_MESSAGE);
			//PLAIN : 아무것도 안뜸, Error : 에러
//			JOptionPane.showMessageDialog(this, "오늘은 금요일입니다.", "요일안내", JOptionPane.ERROR_MESSAGE);
		} // end if
		if (ae.getSource() == btn3) {
			//int로 받아서 switch에서 0, 1, 2로 해도 됨.
			int flag = JOptionPane.showConfirmDialog(this, "점심 맛있게 드셨어요?");
			switch (flag) {
			case JOptionPane.OK_OPTION:
				JOptionPane.showMessageDialog(this, "행복한 오후 되세요!");
				break;
			case JOptionPane.NO_OPTION:
				String menu = JOptionPane.showInputDialog("어떤 점심 메뉴였어요?");
				if(menu!=null) {
				JOptionPane.showMessageDialog(this, menu + "가 다 그렇죠 뭐!");
				}else {
					JOptionPane.showMessageDialog(this, "하기 싫으냐?");
				}
				break;
			case JOptionPane.CANCEL_OPTION:
				JOptionPane.showMessageDialog(this, "하기 싫으냐?");
				break;
			}//switch end
		} // end if
	}// actionPerformed
	
	public static void main(String[] args) {
		new UseJOptionPane();
	}// main

}// class
