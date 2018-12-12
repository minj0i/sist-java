package day1211;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Anonymous Inner Class로 이벤트 처리)
 * @author owner
 */

//1.윈도우 컴포넌트 상속
@SuppressWarnings("serial")
public class EventHandlingAnonymous extends Frame{

	//2.이벤트 처리에 사용할 Component 선언
	private Button btn;
	
	public EventHandlingAnonymous() {
		super();
		//3.컴포넌트 생성
		btn=new Button("클릭");
		//4.배치
		Panel panel = new Panel();
		panel.add(btn);
		
		add("Center",panel);
		
		//5.이벤트 등록 : annonymous inner class
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼 클릭!!!");
				dispose();
				
			}//actionPerformed
		});
		
		//6.윈도우 크기 설정
		setBounds(100,100,400,200);
		//7.사용자에게 보여주기
		setVisible(true);
		
	}//EventHandlingAnonymous
	
	public Button getBtn() {
		return btn;
	}//getBtn
	
	public static void main(String[] args) {
		new EventHandlingAnonymous();
	}//main

}//class
