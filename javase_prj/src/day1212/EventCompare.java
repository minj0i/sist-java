package day1212;

import java.awt.Button;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 같은 종류의 이벤트가 여러개 발생하면, 그 이벤트를 비교하여 처리하는 방법<br>
 * 이벤트를 발생시킨 주소를 비교 - 모든 이벤트에서 사용가능:getSource()<br>
 * 이벤트를 발생시킨 객체의 Label을 비교 - ActionEvent에서만 사용가능: getActionCommand()
 * 
 * @author owner
 */
@SuppressWarnings("serial")
//1. Window Component를 상속, Event처리 Listener를 구현
public class EventCompare extends Frame implements ActionListener {
//2. 이벤트와 관련있는 Component를 선언 - 위에 올리는 이유는 method안에서 비교하기 위해서
	private Button btnOpen;
	private Button btnSave;
	private Label lblOutput;

	public EventCompare() {
		super("파일다이얼로그 사용");
		// 3.생성
		btnOpen = new Button("열기모드");
		btnSave = new Button("저장모드");
		lblOutput = new Label("출력창 : ");
		// 4.배치
		Panel panel = new Panel();// Contianer Component
		panel.add(btnOpen);
		panel.add(btnSave);

		add("Center", panel);
		add("South", lblOutput);

		// 이벤트 등록
		btnOpen.addActionListener(this);
		btnSave.addActionListener(this);

		// 6.윈도우 크기 설정
		setBounds(100, 100, 500, 100);

		// 7.가시화
		setVisible(true);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}// windowClosing
		});
	}// EventCompare생성자

	@Override
	public void actionPerformed(ActionEvent ae) {
//		System.out.println("이벤트발생"+ae);
		/////////////////// 주소비교/////////////////////
//		if(ae.getSource()==btnOpen) {
//			System.out.println("열기");
//		}//end if
//		
//		if(ae.getSource()==btnSave) {
//			System.out.println("저장");
//		}//end if
//		System.out.println("이벤트 발생 객체의 Label"+ae.getActionCommand());
		//////////////// Label비교////////////////////
		String label = ae.getActionCommand();
		if (label.equals("열기모드")) {
//			System.out.println("열기!!!!");
			// window Component로 생성과 동시에 사용자에게 보여지지 않는다.
			FileDialog fdOpen = new FileDialog(this, "열기", FileDialog.LOAD);
			// 가시화
			fdOpen.setVisible(true);

			String path = fdOpen.getDirectory();
			String name = fdOpen.getFile();
			//선택한 파일이 있을때만 
			if (name != null) {
				lblOutput.setText("열기 파일: " + path + name);
				// 타이틀바의 내용 변경
				setTitle("파일다이얼로그 사용 - 열기: " + name);
				} // end if
		}
		if (label.equals("저장모드")) {
//			System.out.println("저장!!!!");
			FileDialog fdSave = new FileDialog(this, "저장", FileDialog.SAVE);
			// 가시화
			fdSave.setVisible(true);

			String path = fdSave.getDirectory();
			String name = fdSave.getFile();
			if (name!= null) {
			lblOutput.setText("저장 파일: " + path + name);
			// 타이틀바의 내용 변경
			setTitle("파일다이얼로그 사용 - 저장: " + name);
			}//end if !=
		} // end if

	}// actionPerformed

	public static void main(String[] args) {
		new EventCompare();
	}// main

}// class
