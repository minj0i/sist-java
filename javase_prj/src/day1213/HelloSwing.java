package day1213;

import java.awt.Button;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Swing�� ����� Window Application
 * @author owner
 */
//1.JFrame ���
@SuppressWarnings("serial")
public class HelloSwing extends JFrame implements ActionListener{

	public HelloSwing() {
		super("��������");
		//Component ����
		JButton jb = new JButton("�ȳ�! �� �����̶�� ��");
		Button btn = new Button("AWT�� ��ư");
		//��ġ������ ��ȯ
		setLayout(new GridLayout(1, 2));
		//��ġ
		add(jb);
		add(btn);
		
		//�̺�Ʈ ���
		jb.addActionListener(this);//�̺�Ʈó���� ���� �� Ŭ���� ��
		//ũ�⼳��
		setBounds(100,100,300,200);
		//����ȭ
		setVisible(true);
		//����������ó��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}//HelloSwing
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		dispose();
	}//actionPerformed
	
	public static void main(String[] args) {
		new HelloSwing();
	}//main

}//class
