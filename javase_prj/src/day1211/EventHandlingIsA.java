package day1211;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ActionEvnet를 사용한 is a 관계로 이벤트를 처리하는 방법<br>
 * 디자인과 이벤트 처리를 하나의 클래스 안에서 처리한다.
 * (값에 대한 사용이 편리함.)
 * @author owner
 */

//1.상속으로 Frame을 처리하고, 구현으로 Event 처리객체를 처리한다.
@SuppressWarnings("serial")
public class EventHandlingIsA extends Frame implements ActionListener{

	//2.이벤트 처리에 관련이 있는 컴포넌트를 선언.
	//<(Field라고 하고 instance변수가 됨(객체가 되어 자동초기화되어 heap에 올라가는 변수))
	private Button btn;//<외부에서 접근가능해 (default는 같은 패키지,나만쓰려고 private 값 쓰려면 getter로 써야함)

	public EventHandlingIsA() {
		super("is a 관계로 이벤트를 처리하는 방법");
		//<각종 여러군데의 handling에 쓰임?
		//3.컴포넌트 생성
		btn = new Button("클릭");
		//4.생성된 컴포넌트가 이벤트를 발생시킬 수 있도록 이벤트에 등록
		btn.addActionListener(this);//생성된 객체의 주소 =내인스턴스
		//Arguments(매개변수)로 입력된 Override된 method가 호출된다. 
		Panel panel=new Panel();
		panel.add(btn);
		
		//5.생성된 컴포넌트를 배치
		add("Center",panel);
		//6.윈도우컴포넌트의 크기 설정.
		setBounds(100,100,300,300);
		//7.사용자에게 보여주기
		setVisible(true);

	}//EvnetHandlingIsA
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		System.out.println("버튼이 클릭되었습니다.!!!");
		dispose();
	}//actionPerformed
	
	public static void main(String[] args) {
		new EventHandlingIsA();
	}//main

}//class
