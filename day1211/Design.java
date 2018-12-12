package day1211;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;

/**
 * has a ������ �̺�Ʈ ó��<br>
 * �����ΰ� �̺�Ʈó�� �ڵ带 �и��Ͽ� �ڵ��� ���⵵�� ���� �� �ִ�.(���� ���� �� �ִ�.)
 * @author owner
 */

//1.������ ������Ʈ�� ���.
@SuppressWarnings("serial")
public class Design extends Frame{
	//2.�̺�Ʈ ó���� �����ִ� Component(��ü,����(�ȵ�))�� ����
	private Button btn;//�ۿ��� �޾ư����� method�� ���� �ʿ�������. (getter)
	
	public Design() {
		super("������");
		//3.������Ʈ ����
		btn=new Button("Ŭ��");
		
		//4.��ġ
		Panel panel = new Panel();
		panel.add(btn);
		
		add("Center",panel);
		
		//5.�̺�Ʈ ���(EHHA�ϰ�)
		//�̺�Ʈ ó�� ��ü �����ϰ� has a ����.
		EventHandlingHasA ehha=new EventHandlingHasA(this);
		System.out.println("������ ������ ��ü"+this);
		//������Ʈ�� �̺�Ʈ�� ���(EHHA�ϰ�)
		btn.addActionListener(ehha);//��ư���� �̺�Ʈ�� �߻��ϸ� ehha��ü�� 
		//Override �� method���� �̺�Ʈ�� ó��
		//������ü?
		
		//6.������ ũ�� ����
		setBounds(100, 100, 400, 300);
		//7.����ȭ(����ڿ��� �����ֱ�)
		setVisible(true);
		//8.����..�̵�..
		
	}//Design
	
	public Button getBtn() {
		return btn;
	}//getBtn
	
	public static void main(String[] args) {
		new Design();
	}//main
}//class
