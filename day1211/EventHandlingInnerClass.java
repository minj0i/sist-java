package day1211;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Inner class 를 사용한 이벤트 처리 )
 * 디자인에 해당하는 이벤트처리 코드가 매우 적거나, 특정 디자인에 해당하는 이벤트만 처리할 때.
 * @author owner
 */

//1.윈도우 컴포넌트를 상속
@SuppressWarnings("serial")
public class EventHandlingInnerClass extends Frame{

	//2.이벤트처리 관련 컴포넌트를 객체화
	private Button btn;
		
	public EventHandlingInnerClass() {
		super("Inner class로 이벤트 처리");
		//3.컴포넌트 생성
		btn=new Button("클릭");
		//4.배치
		Panel panel = new Panel();
		panel.add(btn);
		
		add("Center",panel);
		//5.이벤트 등록(innner 만들고)
		//Inner Class 생성.
		EventHandlingInnerClass.InnerActionImpl iai=this.new InnerActionImpl();
		//컴포넌트를 이벤트에 등록
		btn.addActionListener(iai);
		
		//6.윈도우 크기 설정
		setBounds(100, 100, 300, 300);
		//7.사용자에게 보여주기
		setVisible(true);

	}//EventHandlingInnerClass
	
	//////////////////////////inner class 시작///////////////////////
	//순서상 먼저 만들어져 있어야 함..5-1
	//5-1.Inner Class로 이벤트처리 리스너를 구현.
	public class InnerActionImpl implements ActionListener{

		//5-2.추상 method Override
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("버튼을 클릭하였습니다.o(>.<)o");
			dispose();//안쪽클래스에서는 바깥클래스의 자원을 내것처럼 사용할 수 있다.
		
		}//actionPerformed

	}//class
	
	//////////////////////////inner class 끝///////////////////////
	public Button getBtn() {
		return btn;
	}//getBtn
	//종료할꺼면 필요는 없지만.
	
	public static void main(String[] args) {
		new EventHandlingInnerClass();
	}//main

}//class
