package day1211;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * XxxAdapter class가 사용되어야 하는 이유.
 * @author owner
 */
@SuppressWarnings("serial")
public class UseWindowEvent extends Frame {
	
	public UseWindowEvent() {
		super("윈도우 이벤트 연습");
		
		setBounds(100,100,400,400);
		setVisible(true);
		
		UseWindowEvent.WindowImpl wi = this.new WindowImpl();
		addWindowListener(wi);
		
		
	}//UseWindowEvent
	
	public static void main(String[] args) {
		new UseWindowEvent();
	}//main

	//WindowListener interface를 구현한 class는 사용하지 않는 method 일지라도 
	//모두 Override해야한다. <<추상메소드니까? 구현의 강제성.
	//편하게 쓰라고 Adapter class
	public class WindowImpl implements WindowListener{
		
	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("Window Opened");
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("Window Closing");
		dispose();
	}

	@Override
	public void windowClosed(WindowEvent e) {
		//WidnowClosing 에서 dispose() 가 호출되면 그떄 window closed가 호출.
		System.out.println("Window Closed");
	}

	@Override
	public void windowIconified(WindowEvent e) {
		System.out.println("Window Iconified");
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		System.out.println("Window Deiconified");
	}

	@Override
	public void windowActivated(WindowEvent e) {
		System.out.println("Window Activated");
	}

	@Override
	public void windowDeactivated(WindowEvent e) {//비활성화
		System.out.println("Window Deactivated");
	}
	}//Inner class 종료
	
}//class
