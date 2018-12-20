package day1211;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * XxxAdapter class�� ���Ǿ�� �ϴ� ����.
 * @author owner
 */
@SuppressWarnings("serial")
public class UseWindowEvent extends Frame {
	
	public UseWindowEvent() {
		super("������ �̺�Ʈ ����");
		
		setBounds(100,100,400,400);
		setVisible(true);
		
		UseWindowEvent.WindowImpl wi = this.new WindowImpl();
		addWindowListener(wi);
		
		
	}//UseWindowEvent
	
	public static void main(String[] args) {
		new UseWindowEvent();
	}//main

	//WindowListener interface�� ������ class�� ������� �ʴ� method ������ 
	//��� Override�ؾ��Ѵ�. <<�߻�޼ҵ�ϱ�? ������ ������.
	//���ϰ� ����� Adapter class
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
		//WidnowClosing ���� dispose() �� ȣ��Ǹ� �׋� window closed�� ȣ��.
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
	public void windowDeactivated(WindowEvent e) {//��Ȱ��ȭ
		System.out.println("Window Deactivated");
	}
	}//Inner class ����
	
}//class
