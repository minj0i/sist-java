package day1211;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;

/**
 * has a 관계의 이벤트 처리<br>
 * 디자인과 이벤트처리 코드를 분리하여 코드의 복잡도를 낮출 수 있다.(일을 나눌 수 있다.)
 * @author owner
 */

//1.윈도우 컴포넌트를 상속.
@SuppressWarnings("serial")
public class Design extends Frame{
	//2.이벤트 처리와 관련있는 Component(객체,위젯(안드))을 선언
	private Button btn;//밖에서 받아가려면 method가 따로 필요해진다. (getter)
	
	public Design() {
		super("디자인");
		//3.컴포넌트 생성
		btn=new Button("클릭");
		
		//4.배치
		Panel panel = new Panel();
		panel.add(btn);
		
		add("Center",panel);
		
		//5.이벤트 등록(EHHA하고)
		//이벤트 처리 객체 생성하고 has a 관계.
		EventHandlingHasA ehha=new EventHandlingHasA(this);
		System.out.println("생성된 디자인 객체"+this);
		//컴포넌트에 이벤트를 등록(EHHA하고)
		btn.addActionListener(ehha);//버튼에서 이벤트가 발생하면 ehha객체의 
		//Override 된 method에서 이벤트를 처리
		//같은객체?
		
		//6.윈도우 크기 설정
		setBounds(100, 100, 400, 300);
		//7.가시화(사용자에게 보여주기)
		setVisible(true);
		//8.종료..이따..
		
	}//Design
	
	public Button getBtn() {
		return btn;
	}//getBtn
	
	public static void main(String[] args) {
		new Design();
	}//main
}//class
