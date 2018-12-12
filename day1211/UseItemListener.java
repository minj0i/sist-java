package day1211;


import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * ItemEvent�� ó���ϴ� ItemListener�� ���.
 * @author owner
 */

//1.Frame ���, �̺�Ʈ�� ó���� �� �ִ� itemListener����.
@SuppressWarnings("serial")
public class UseItemListener extends Frame implements ItemListener{
	private List list;
	private Label lblResult;

	public UseItemListener() {
		list = new List();
		list.add("���ü�/26");
		list.add("������/26");
		list.add("������/27");
		list.add("������/30");
		list.add("������/27");
		list.add("�谳����/120");

		lblResult = new Label("�̸� :                     ���� : ");

		add("Center", list);
		add("South", lblResult);
		
		//�̺�Ʈ ���
		list.addItemListener(this);
		

		setBounds(200, 200, 400, 300);
		setVisible(true);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				dispose();
			}//windowClosing
		});//addWindowListener
	}//UseItemListener

	public static void main(String[] args) {
		new UseItemListener();
	}//main

	@Override
	public void itemStateChanged(ItemEvent e) {
		//����Ʈ�� �������� ���õǸ� ������ �������� �����ͼ� Label�� ���� ����.
		
		String[] readItem=list.getSelectedItem().split("/");//<Tokenizer�� ����
//		readItem.split("/");
		String name = readItem[0];
		String age = readItem[1];
		
		
		StringBuilder viewData = new StringBuilder();
		viewData.append("�̸� : ").append(name).append("    ���� : ")
										.append(age);
//		lblResult.setText("�̸� : "+name+"        ���� : "+age);
		lblResult.setText(viewData.toString());
		//<���� �ȸ±⶧���� string�� ��ȯ.�ּҰ� �ƴ϶� ���ڿ��� �߳��´�.
		//<�乮�ڿ��̱� ������ StringBuilder�ΰ� ����.
	}//itemStateChanged
}//class
