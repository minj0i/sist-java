package day1210.hwk;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class Autobatch extends Frame{

	public Autobatch() {
		super("�ڵ� ��ġ-����1");
		//����
		Label lblNorth= new Label(" �� �� �� ��	");
		
		Label lblName= new Label("�̸�");
		Label lblAge= new Label("����");
		Label lblTel= new Label("��ȭ��ȣ");
		Label lblGen= new Label("����");
		TextField tfName=new TextField();
		TextField tfAge=new TextField();
		TextField tfTel=new TextField();
		CheckboxGroup cg = new CheckboxGroup();
		//CheckboxGroup�� �����ϸ� Radio Button�� �����ȴ�.
		Checkbox rb1 = new Checkbox("����",false,cg);
		Checkbox rb2 = new Checkbox("����",true,cg);
		
		TextArea taMemo=new TextArea();
		
		Button btnadd=new Button("�߰�");
		Button btnupdate=new Button("����");
		Button btndelete=new Button("����");
		Button btnexit=new Button("����");
		
		//�Ϲ� ������Ʈ��ġ
		//���� �гο� ��, �� �ֱ�
		Panel panelsusub=new Panel();
		panelsusub.setLayout(new GridLayout(1,2));
		panelsusub.add(rb1);
		panelsusub.add(rb2);

		//�����г�
		Panel panelCenSub=new Panel();
		panelCenSub.setLayout(new GridLayout(4,2));
		panelCenSub.add(lblName);
		panelCenSub.add(tfName);
		panelCenSub.add(lblAge);
		panelCenSub.add(tfAge);
		panelCenSub.add(lblTel);
		panelCenSub.add(tfTel);
		panelCenSub.add(lblGen);
		panelCenSub.add(panelsusub);
		
		//���� �г� 1,2
		Panel panelCenter=new Panel();
		panelCenter.setLayout(new GridLayout(1, 2));
		panelCenter.add(panelCenSub);
		panelCenter.add(taMemo);
		
		//�Ʒ� �г�
		Panel panelSouth=new Panel();
		panelSouth.add(btnadd);
		panelSouth.add(btnupdate);
		panelSouth.add(btndelete);
		panelSouth.add(btnexit);
		
		//��ġ
		add("North",lblNorth);
		add("South",panelSouth);
		add("Center",panelCenter);
		
		
		setSize(400, 300);
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				dispose();
			}
		});
	}//Autobatch

	public static void main(String[] args) {
		new Autobatch();
	}//main

}//class
