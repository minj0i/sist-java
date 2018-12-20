package day1212;

import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Keyboard Event 처리
 * @author owner
 */
//1. 윈도우 컴포넌트를 상속, 이벤트처리 리스너를 구현
public class UseKeyListener extends Frame implements KeyListener{
	
	public static final int ENTER = 10;
//2.이벤트와 관련있는 컴포넌트 선언
	private TextField tf;
	private Label lbl;
	
	public UseKeyListener() {
		super("키보드 이벤트 연습");
		//3.컴포넌트 생성
		tf=new TextField();
		lbl=new Label("출력창",Label.CENTER);
		
		//Frame의 Layout은 BoarderLayout
		//따라서 배치관리자를 굳이 바꿔주지않아도 됨
		//4.배치
		add("North",tf);
		add("Center",lbl);
		
		//5.컴포넌트를 이벤트에 등록
		tf.addKeyListener(this);
		
		//6.윈도우 크기설정
		setBounds(100,100,400,150);
		
		//7.사용자에게 보여주기
		setVisible(true);
		
		//8.윈도우종료처리
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});//addWindowListener
		
		
	}//UseKeyListener

	@Override
	public void keyTyped(KeyEvent e) {
		//2) 키가 눌려 정보가 전달되는 순간. 눌린 키의 정보를 알 수 있다.
//		System.out.println("keyTyped");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//1) 키보드의 키가 눌리는 정보를 순간이어서 키의 정보를 알 수 없다.
//		System.out.println("keyPressed");
	}

	@Override
	public void keyReleased(KeyEvent ke) {
		//3) 눌린키가 정보를 전달하고 다시 올라오는 순간. 눌린 키의 정보를 알 수 있다.
//		System.out.println("keyReleased");
		//눌린키의 문자와 코드값을 얻어
		char inputKey=ke.getKeyChar();
		int inputCode=ke.getKeyCode();
		//keycode는 키보드 키의 고유값: unicode와 다르게 같은 값이 나온다.
		//keycode는 아스키나 유니코드와 다른 것
//		System.out.println(inputKey+" "+inputCode);
		//출력 Label에 뿌린다.
		StringBuilder output= new StringBuilder();
		output.append("눌린키 문자: ").append(inputKey)
		.append(", 눌린키의 키코드:").append(inputCode);
		
		lbl.setText(output.toString());
		
		switch(inputCode) {
		case ENTER:
			//JDK1.7에서 발생한 버그 : TextField, TextArea는
			//setText(" ")를 바로 사용하면 초기화되지 않는다.
			tf.getText();//값을 한 번 얻어낸 후
			tf.setText("");//초기화하면 초기화가 잘 된다.
			break;
			//ESC를 누르면 프로그램 종료
//		case 27:
		case KeyEvent.VK_ESCAPE:
			dispose();
			
		}//end switch
	}
	
	
	public static void main(String[] args) {
		new UseKeyListener();
	}//main

}//class
