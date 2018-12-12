package day1210;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * GridLayout: 행과 열로 구성되며 모든 컴포넌트의 크기가 동일해야 할 때.
 * @author owner
 */
//1. 윈도우 컴포넌트 상속
@SuppressWarnings("serial")
public class UseGridLayout extends Frame{
	
	public UseGridLayout() {
	super("GridLayout연습");
	
	//2. 컴포넌트 생성
	Button btn1 = new Button("버튼1");
	Button btn2 = new Button("버튼2");
	Button btn3 = new Button("버튼3");
	Button btn4 = new Button("버튼4");
	Button btn5 = new Button("버튼5");
	Button btn6 = new Button("버튼6");
	Button btn7 = new Button("버튼7");
	Button btn8 = new Button("버튼8");	
	Button btn9 = new Button("버튼9");	
	
	//3.배치 관리자 설정 : Frame의 BorderLayout인데 GridLayout으로 변경
	setLayout(new GridLayout(3,3)); //생략하면 가장 마지막 버튼9가나옴
	//생략하면 BordLayout이 나오는 것
	//하나 넣으면 하나만 들어감
	//9개 넣으면 Board크기(4*2) 사라지고 3*3사이즈로 나옴
	//모든 행의 열의 크기가 같음
	
	//4.배치 : (L->R순서로 붙음)
	add(btn1);
	add(btn2);
	add(btn3);
	add(btn4);
	add(btn5);
	add(btn6);
	add(btn7);
	add(btn8);
	add(btn9);
	
	//5.윈도우크기설정
	setSize(300, 400);
	
	//6.사용자에게 보여주기
	setVisible(true);
	
	//종료처리
	addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent we) {
			dispose();
		}//windowClosing
	});//addWindowListener
	
	
	}//UseGridLayout
	
	public static void main(String[] args) {
		new UseGridLayout();
	}//main

}//class
