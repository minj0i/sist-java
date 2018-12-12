package day1211;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Has a 관계로 이벤트 처리하는 방법.
 * @author owner
 */

//1.이벤트 처리 객체를 구현
public class EventHandlingHasA implements ActionListener{

	//EventHandlingHasA는 Design을 가지고 있다.
	//2.has a 관계를 저장하고 사용할 객체 선언
	private Design design;//<null이 들어간 상태로 주소를 넣어줄것.
	
	public EventHandlingHasA(Design design) {
		this.design=design;
		//<어디에 뭘 쓰는지 항상 받아야?
	}//EventHandlingHasA
	
	//3.추상abstract method Override
	@Override
	public void actionPerformed(ActionEvent ae) {
		//이벤트가 발생했을때 처리할 코드.
		System.out.println("전달받은 Design객체 "+design);
		design.dispose();//window에 있는 method라 design.을 해주어야 가능하다.
	}//actionPerformed
	
}//class
