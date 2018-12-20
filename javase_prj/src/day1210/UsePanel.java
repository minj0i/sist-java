package day1210;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


/**
 * Container Component: 일반컴포넌트와 Container 컴포넌트를 저장할 수 있는 Component 사용
 * 
 * @author owner
 */
//1.window component 상속
@SuppressWarnings("serial")
public class UsePanel extends Frame {

	public UsePanel() {
		super("Container Component의 사용");
		Label lblName = new Label("이름");
		//색설정: Field
		lblName.setBackground(Color.pink);
		lblName.setForeground(Color.magenta);
		TextField tfName = new TextField(20);
		//색설정: RGB를 사용한 생성자를 사용 -> 다양한 색을 사용할 수 있다.
//		tfName.setForeground(new Color(0xFFFFFF));
		//여러번 사용할거라면 객체를 만들어서 인스턴스를 넣어주는 게 편함
		Color back = new Color(0x4374D9);
		Color fore = new Color(0xFFFFFF);
		tfName.setBackground(back);
		tfName.setForeground(fore);
		
		Button btnAdd = new Button("추가");
		btnAdd.setBackground(back);
		btnAdd.setForeground(fore);
		
		Button btnClose = new Button("종료");
		TextArea taDisplay = new TextArea();
		//글꼴 : Dialog, DialogInput,Monospaced, Serif, or SansSerif
		//Style: PLAIN, BOLD, ITALIC, BOLD|ITALIC
		taDisplay.setFont(new Font("Dialog", Font.BOLD|Font.ITALIC, 20));
		

		//일반컴포넌트를 배치할 수 있는 컨테이너컴포넌트를 생성
		Panel panelNorth = new Panel(); //기본 : FlowLayout
		//생성된 컨테이너컴포넌트에 일반 컴포넌트 배치
		panelNorth.add(lblName);
		panelNorth.add(tfName);
		panelNorth.add(btnAdd);
		panelNorth.add(btnClose);
		
		// 3.배치관리자 설정
		setLayout(new BorderLayout());

		// 4.배치 BorderLayout 특징: 하나의 지역에는 하나의 컴포넌트만 저장 가능
		add("North", panelNorth); //North에 하나씩 넣지 말고 panel을 넣으면 같이 들어감
//		add("North", tfName);
//		add("North", btnAdd);
//		add("North", btnClose);
		add("Center", taDisplay);

		// 5.윈도우 크기 설정
		setBounds(200, 150, 400, 250);
		
		//6.사용자에게 보여주기
		setVisible(true);
		
		//윈도우 종료 이벤트 처리
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				dispose();
			}//WindowClosing
		});//addWindowListener

	}// UsePanel

	public static void main(String[] args) {
		new UsePanel();
	}// main

}// class
