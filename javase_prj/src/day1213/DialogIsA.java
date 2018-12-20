package day1213;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
//1.Dialog 상속
public class DialogIsA extends Dialog implements ActionListener {
	//2.이벤트와 관련있는 컴포넌트를 선언
	private Button btn;
	
	// 현재Dialog의 부모가 될 객체와 Has A 관계
	public DialogIsA(UseDialogIsA uda) {
		super(uda, "다이얼로그", true);
		
		//컴포넌트 생성
		Label lbl= new Label("오늘은 눈오는 목요일입니다(^.~).",Label.CENTER);
		
		btn = new Button("종료");
		
		add("Center", lbl);
		add("South", btn);
		
		btn.addActionListener(this);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
				//프레임에 들어있으면 프레임dispose, 다이얼로그 안이면 dialog
			}//windowClosing
		});
		
		//다이얼로그의 위치를 부모프레임안쪽에서 띄우기
		System.out.println("부모 x "+uda.getX()+", 부모 y "+uda.getY());
		setBounds(uda.getX()+100,uda.getY()+100,300,300);
		setVisible(true);
		
	}//DialogIsA

	@Override
	public void actionPerformed(ActionEvent e) {
		dispose();
	}//actionPerformed

	
}// class
