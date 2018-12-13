package day1213;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.WindowConstants;

/**
 * Frame클래스에서 Dialog클래스를 Has A 사용
 * 
 * @author owner
 */
@SuppressWarnings("serial")
public class UseDialogHasA extends Frame implements ActionListener {

	private Button btn1/* Frame에 배치 */, btn2/* Dialog에 배치 */;
	private Dialog d;
	
	public UseDialogHasA() {
		super("다이얼로그 사용");

		btn1 = new Button("다이얼로그 사용");
		Panel panel = new Panel();
		panel.add(btn1);

		add("Center", panel);

		btn1.addActionListener(this);

		setBounds(100, 100, 300, 400);
		setVisible(true);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});// addWindowListener 닫기

	}// UseDialogHasA

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == btn1) {
			createDialog();
		} // end if

		if (ae.getSource() == btn2) {
			//d.dispose를 써주기 위해 createDialog에 있던 Dialog d를 지역변수로 두는 것이 아니라 인스턴스변수로 줌
			d.dispose();
		} // end if
	}// actionPerformed

	public void createDialog() {
		// 1.생성
		d = new Dialog(this, "다이얼로그", false);//true-modal, flase-비modal

		// 2.Dialog에 배치될 Component 생성
		Label lbl = new Label("오늘은 눈오는 목요일입니다.(^.~)");
		btn2 = new Button("닫기");

		d.add("Center", lbl);
		d.add("South", btn2);
		btn2.addActionListener(this);// 이벤트처리할건 나야

		// 크기설정
		d.setBounds(200, 200, 300, 300);

		// 이벤트처리는 가시화 전에 나와야함
		d.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
//				dispose();//이렇게주면 다이얼로그창 끄면 부모창까지 같이 죽음
				d.dispose();
			}
		});
		// 가시화
		d.setVisible(true);

	}// createDialog

	public static void main(String[] args) {
		new UseDialogHasA();
	}// main

}// main
