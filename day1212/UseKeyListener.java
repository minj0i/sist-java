package day1212;

import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Keyboard Event ó��
 * @author owner
 */
//1. ������ ������Ʈ�� ���, �̺�Ʈó�� �����ʸ� ����
public class UseKeyListener extends Frame implements KeyListener{
	
	public static final int ENTER = 10;
//2.�̺�Ʈ�� �����ִ� ������Ʈ ����
	private TextField tf;
	private Label lbl;
	
	public UseKeyListener() {
		super("Ű���� �̺�Ʈ ����");
		//3.������Ʈ ����
		tf=new TextField();
		lbl=new Label("���â",Label.CENTER);
		
		//Frame�� Layout�� BoarderLayout
		//���� ��ġ�����ڸ� ���� �ٲ������ʾƵ� ��
		//4.��ġ
		add("North",tf);
		add("Center",lbl);
		
		//5.������Ʈ�� �̺�Ʈ�� ���
		tf.addKeyListener(this);
		
		//6.������ ũ�⼳��
		setBounds(100,100,400,150);
		
		//7.����ڿ��� �����ֱ�
		setVisible(true);
		
		//8.����������ó��
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});//addWindowListener
		
		
	}//UseKeyListener

	@Override
	public void keyTyped(KeyEvent e) {
		//2) Ű�� ���� ������ ���޵Ǵ� ����. ���� Ű�� ������ �� �� �ִ�.
//		System.out.println("keyTyped");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//1) Ű������ Ű�� ������ ������ �����̾ Ű�� ������ �� �� ����.
//		System.out.println("keyPressed");
	}

	@Override
	public void keyReleased(KeyEvent ke) {
		//3) ����Ű�� ������ �����ϰ� �ٽ� �ö���� ����. ���� Ű�� ������ �� �� �ִ�.
//		System.out.println("keyReleased");
		//����Ű�� ���ڿ� �ڵ尪�� ���
		char inputKey=ke.getKeyChar();
		int inputCode=ke.getKeyCode();
		//keycode�� Ű���� Ű�� ������: unicode�� �ٸ��� ���� ���� ���´�.
		//keycode�� �ƽ�Ű�� �����ڵ�� �ٸ� ��
//		System.out.println(inputKey+" "+inputCode);
		//��� Label�� �Ѹ���.
		StringBuilder output= new StringBuilder();
		output.append("����Ű ����: ").append(inputKey)
		.append(", ����Ű�� Ű�ڵ�:").append(inputCode);
		
		lbl.setText(output.toString());
		
		switch(inputCode) {
		case ENTER:
			//JDK1.7���� �߻��� ���� : TextField, TextArea��
			//setText(" ")�� �ٷ� ����ϸ� �ʱ�ȭ���� �ʴ´�.
			tf.getText();//���� �� �� �� ��
			tf.setText("");//�ʱ�ȭ�ϸ� �ʱ�ȭ�� �� �ȴ�.
			break;
			//ESC�� ������ ���α׷� ����
//		case 27:
		case KeyEvent.VK_ESCAPE:
			dispose();
			
		}//end switch
	}
	
	
	public static void main(String[] args) {
		new UseKeyListener();
	}//main

}//class
