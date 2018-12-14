package day1214;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Icon Class를 사용한 이미지 사용 
 * @author owner
 */
@SuppressWarnings("serial")
public class UseImageIcon extends JFrame{
	
	public UseImageIcon() {
		super("ImageIcon사용");
		
		ImageIcon ii1 = new ImageIcon("C:/dev/workspace/javase_prj/src/day1214/images/img3.gif");
		ImageIcon ii2 = new ImageIcon("C:/dev/workspace/javase_prj/src/day1214/images/img4.gif");
		ImageIcon ii3 = new ImageIcon("C:/dev/workspace/javase_prj/src/day1214/images/img5.gif");
		
		JButton btn1 = new JButton("버튼1", ii1);
		JButton btn2 = new JButton("버튼2", ii2);
		JButton btn3 = new JButton("버튼3", ii3);
		
		//Tooltip Text설정 : 마우스를 올렸을 때 글자 뜨는 것
		btn1.setToolTipText("버튼1");
		btn2.setToolTipText("버튼을 클릭하세요");
		btn3.setToolTipText("오늘은 금요일입니다");
		
		//RollOvericon : 마우스를 올렸을때 아이콘이 바뀌게 하는 것
		btn3.setRolloverIcon(ii2);
		
		//버튼 라벨 위치 변경
		//이미지 위(3,3)으로 텍스트의 위치 바꿔주기
		//가로 위치 변경(Left, Center, Right//horizontal)
		btn1.setHorizontalTextPosition(JButton.RIGHT);
	
		//세로 위치 변경(Top, Center, Bottom //Vertical)
		btn2.setVerticalTextPosition(JButton.TOP);
		
		//혼합
		btn3.setHorizontalTextPosition(JButton.CENTER);
		btn3.setVerticalTextPosition(JButton.BOTTOM);

		
		
		setLayout(new GridLayout(1, 3));
		
		add(btn1);
		add(btn2);
		add(btn3);
		setBounds(100, 100, 1500, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}//UseImageIcon

	public static void main(String[] args) {
		new UseImageIcon();
	}//main

}//class
