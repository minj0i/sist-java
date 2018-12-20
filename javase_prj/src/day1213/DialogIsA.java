package day1213;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
//1.Dialog ���
public class DialogIsA extends Dialog implements ActionListener {
	//2.�̺�Ʈ�� �����ִ� ������Ʈ�� ����
	private Button btn;
	
	// ����Dialog�� �θ� �� ��ü�� Has A ����
	public DialogIsA(UseDialogIsA uda) {
		super(uda, "���̾�α�", true);
		
		//������Ʈ ����
		Label lbl= new Label("������ ������ ������Դϴ�(^.~).",Label.CENTER);
		
		btn = new Button("����");
		
		add("Center", lbl);
		add("South", btn);
		
		btn.addActionListener(this);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
				//�����ӿ� ��������� ������dispose, ���̾�α� ���̸� dialog
			}//windowClosing
		});
		
		//���̾�α��� ��ġ�� �θ������Ӿ��ʿ��� ����
		System.out.println("�θ� x "+uda.getX()+", �θ� y "+uda.getY());
		setBounds(uda.getX()+100,uda.getY()+100,300,300);
		setVisible(true);
		
	}//DialogIsA

	@Override
	public void actionPerformed(ActionEvent e) {
		dispose();
	}//actionPerformed

	
}// class
