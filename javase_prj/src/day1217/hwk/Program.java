package day1217.hwk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class Program extends JFrame implements MouseListener{
	String answer = JOptionPane.showInputDialog("�޴�����\n 1.�Է� 2.��� 3.����");
	private JList<String> jl;
	private DefaultListModel<String> dlm;
	private String inputdata;
	public Program() {
		jl = new JList(dlm);
		
		if(answer.equals("1")) {
			inputdata = JOptionPane.showInputDialog("�������Է�\n ��)�̸�,�ڹ�����,����Ŭ����");
			String[] tempData=inputdata.split(",");
			if(tempData.length!=3) {
				JOptionPane.showMessageDialog(this,"�������Է��� ����� �ϼ���");
			}else {
				//�������Է�
				}//end if~else
			}//end answer.equals("1")
					
		
		//�̺�Ʈ ���
		jl.addMouseListener(this);
		
		setBounds(100,100,600,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		//1. JTextArea����(���, �÷���)
		JTextArea jta = new JTextArea(10, 80);
		jta.setEditable(false);
		//2. 
		JScrollPane jsp = new JScrollPane(jta);
		//3.Message Dialog�� �ι�° �Ű������� ������Ʈ�� �Ҵ�
		JOptionPane.showMessageDialog(null, jsp);

		
	}//Program

	public static void main(String[] args) {
		new Program();
	}//main

	@Override
	public void mouseClicked(MouseEvent me) {
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}//class
