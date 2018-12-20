package day1210.hwk;

import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class ManualBatch extends Frame {
	public ManualBatch() {
		super("수동배치 숙제");
		// 1.컴포넌트 생성
		Label lbl1 = new Label("글꼴");
		TextField tf1 = new TextField();
		List list1 = new List();
		list1.add("Dialog");
		list1.add("Serif");
		list1.add("SansSerf");
		list1.add("Monospared");
		list1.add("DialogInput");
		
		Label lbl2 = new Label("글꼴스타일");
		TextField tf2 = new TextField();
		List list2 = new List();
		list2.add("일반");
		list2.add("굵게");
		list2.add("기울임꼴");
		list2.add("굵게기울임꼴");
		
		Label lbl3 = new Label("크기");
		TextField tf3= new TextField();
		List list3 = new List();
		
		for(int i=1; i<81; i++) {
			if(i<=10) {
				i=i+1;
			}
			String style = String.valueOf(i);
			list3.add(style);
			
			
		}//end for
		
		Label lbl4 = new Label("보기");
		Label lbl5 = new Label("AaBbYyZz");
		lbl5.setFont(new Font("Dialog", Font.BOLD, 20));
		Button btn1 = new Button("확인");
		Button btn2 = new Button("취소");
		
		// 2.배치관리자 설정(해제) : BorderLayout
		setLayout(null);
		
		//3.배치
		//컴포넌트의 좌표, 크기 설정
		lbl1.setLocation(30, 30);//배치 좌표
		lbl1.setSize(30,35);//배치 크기
		tf1.setLocation(30, 65);
		tf1.setSize(100,20);
		list1.setLocation(30, 95);
		list1.setSize(100,80);
		
		lbl2.setLocation(160, 30);//배치 좌표
		lbl2.setSize(80,35);//배치 크기
		tf2.setLocation(160,65);
		tf2.setSize(100,20);
		list2.setLocation(160,95);
		list2.setSize(100,80);
		
		lbl3.setLocation(290, 30);//배치 좌표
		lbl3.setSize(80,35);//배치 크기
		tf3.setLocation(290,65);
		tf3.setSize(100,20);
		list3.setLocation(290,95);
		list3.setSize(100,80);
		
		lbl4.setLocation(150, 180);
		lbl4.setSize(80, 35);
		lbl5.setLocation(150, 220);
		lbl5.setSize(120, 40);
		
		btn1.setLocation(280, 280);
		btn1.setSize(40, 35);
		btn2.setLocation(330, 280);
		btn2.setSize(40, 35);
		
		add(lbl1);//Frame에 배치
		add(tf1);
		add(list1);
		
		add(lbl2);//Frame에 배치
		add(tf2);
		add(list2);
		
		add(lbl3);
		add(tf3);
		add(list3);
		
		add(lbl4);
		add(lbl5);
		
		add(btn1);
		add(btn2);
		
		
		//5.윈도우 크기 설정
		setBounds(200, 100, 450, 350);
		
		//6.사용자에게 보여주기
		setVisible(true);
		
		//7.종료처리
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				dispose();
			}//windowClosing
		});
		

	}// ManualBatch

	public static void main(String[] args) {
		new ManualBatch();
	}// main

}// class
