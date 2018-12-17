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
	String answer = JOptionPane.showInputDialog("메뉴선택\n 1.입력 2.출력 3.종료");
	private JList<String> jl;
	private DefaultListModel<String> dlm;
	private String inputdata;
	public Program() {
		jl = new JList(dlm);
		
		if(answer.equals("1")) {
			inputdata = JOptionPane.showInputDialog("데이터입력\n 예)이름,자바점수,오라클점수");
			String[] tempData=inputdata.split(",");
			if(tempData.length!=3) {
				JOptionPane.showMessageDialog(this,"데이터입력을 제대로 하세요");
			}else {
				//데이터입력
				}//end if~else
			}//end answer.equals("1")
					
		
		//이벤트 등록
		jl.addMouseListener(this);
		
		setBounds(100,100,600,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		//1. JTextArea생성(행수, 컬럼수)
		JTextArea jta = new JTextArea(10, 80);
		jta.setEditable(false);
		//2. 
		JScrollPane jsp = new JScrollPane(jta);
		//3.Message Dialog의 두번째 매개변수에 컴포넌트를 할당
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
