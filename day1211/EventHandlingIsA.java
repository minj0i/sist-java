package day1211;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ActionEvnet�� ����� is a ����� �̺�Ʈ�� ó���ϴ� ���<br>
 * �����ΰ� �̺�Ʈ ó���� �ϳ��� Ŭ���� �ȿ��� ó���Ѵ�.
 * (���� ���� ����� ����.)
 * @author owner
 */

//1.������� Frame�� ó���ϰ�, �������� Event ó����ü�� ó���Ѵ�.
@SuppressWarnings("serial")
public class EventHandlingIsA extends Frame implements ActionListener{

	//2.�̺�Ʈ ó���� ������ �ִ� ������Ʈ�� ����.
	//<(Field��� �ϰ� instance������ ��(��ü�� �Ǿ� �ڵ��ʱ�ȭ�Ǿ� heap�� �ö󰡴� ����))
	private Button btn;//<�ܺο��� ���ٰ����� (default�� ���� ��Ű��,���������� private �� ������ getter�� �����)

	public EventHandlingIsA() {
		super("is a ����� �̺�Ʈ�� ó���ϴ� ���");
		//<���� ���������� handling�� ����?
		//3.������Ʈ ����
		btn = new Button("Ŭ��");
		//4.������ ������Ʈ�� �̺�Ʈ�� �߻���ų �� �ֵ��� �̺�Ʈ�� ���
		btn.addActionListener(this);//������ ��ü�� �ּ� =���ν��Ͻ�
		//Arguments(�Ű�����)�� �Էµ� Override�� method�� ȣ��ȴ�. 
		Panel panel=new Panel();
		panel.add(btn);
		
		//5.������ ������Ʈ�� ��ġ
		add("Center",panel);
		//6.������������Ʈ�� ũ�� ����.
		setBounds(100,100,300,300);
		//7.����ڿ��� �����ֱ�
		setVisible(true);

	}//EvnetHandlingIsA
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		System.out.println("��ư�� Ŭ���Ǿ����ϴ�.!!!");
		dispose();
	}//actionPerformed
	
	public static void main(String[] args) {
		new EventHandlingIsA();
	}//main

}//class
