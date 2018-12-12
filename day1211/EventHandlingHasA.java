package day1211;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Has a ����� �̺�Ʈ ó���ϴ� ���.
 * @author owner
 */

//1.�̺�Ʈ ó�� ��ü�� ����
public class EventHandlingHasA implements ActionListener{

	//EventHandlingHasA�� Design�� ������ �ִ�.
	//2.has a ���踦 �����ϰ� ����� ��ü ����
	private Design design;//<null�� �� ���·� �ּҸ� �־��ٰ�.
	
	public EventHandlingHasA(Design design) {
		this.design=design;
		//<��� �� ������ �׻� �޾ƾ�?
	}//EventHandlingHasA
	
	//3.�߻�abstract method Override
	@Override
	public void actionPerformed(ActionEvent ae) {
		//�̺�Ʈ�� �߻������� ó���� �ڵ�.
		System.out.println("���޹��� Design��ü "+design);
		design.dispose();//window�� �ִ� method�� design.�� ���־�� �����ϴ�.
	}//actionPerformed
	
}//class
