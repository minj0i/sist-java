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
		super("자동 배치-숙제1");
		//생성
		Label lblNorth= new Label(" 학 생 관 리	");
		
		Label lblName= new Label("이름");
		Label lblAge= new Label("나이");
		Label lblTel= new Label("전화번호");
		Label lblGen= new Label("성별");
		TextField tfName=new TextField();
		TextField tfAge=new TextField();
		TextField tfTel=new TextField();
		CheckboxGroup cg = new CheckboxGroup();
		//CheckboxGroup을 설정하면 Radio Button이 생성된다.
		Checkbox rb1 = new Checkbox("남자",false,cg);
		Checkbox rb2 = new Checkbox("여자",true,cg);
		
		TextArea taMemo=new TextArea();
		
		Button btnadd=new Button("추가");
		Button btnupdate=new Button("변경");
		Button btndelete=new Button("삭제");
		Button btnexit=new Button("종료");
		
		//일반 컴포넌트배치
		//성별 패널에 남, 여 넣기
		Panel panelsusub=new Panel();
		panelsusub.setLayout(new GridLayout(1,2));
		panelsusub.add(rb1);
		panelsusub.add(rb2);

		//왼쪽패널
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
		
		//센터 패널 1,2
		Panel panelCenter=new Panel();
		panelCenter.setLayout(new GridLayout(1, 2));
		panelCenter.add(panelCenSub);
		panelCenter.add(taMemo);
		
		//아래 패널
		Panel panelSouth=new Panel();
		panelSouth.add(btnadd);
		panelSouth.add(btnupdate);
		panelSouth.add(btndelete);
		panelSouth.add(btnexit);
		
		//배치
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
