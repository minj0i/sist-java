package day1214;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Icon Class�� ����� �̹��� ��� 
 * @author owner
 */
@SuppressWarnings("serial")
public class UseImageIcon extends JFrame{
	
	public UseImageIcon() {
		super("ImageIcon���");
		
		ImageIcon ii1 = new ImageIcon("C:/dev/workspace/javase_prj/src/day1214/images/img3.gif");
		ImageIcon ii2 = new ImageIcon("C:/dev/workspace/javase_prj/src/day1214/images/img4.gif");
		ImageIcon ii3 = new ImageIcon("C:/dev/workspace/javase_prj/src/day1214/images/img5.gif");
		
		JButton btn1 = new JButton("��ư1", ii1);
		JButton btn2 = new JButton("��ư2", ii2);
		JButton btn3 = new JButton("��ư3", ii3);
		
		//Tooltip Text���� : ���콺�� �÷��� �� ���� �ߴ� ��
		btn1.setToolTipText("��ư1");
		btn2.setToolTipText("��ư�� Ŭ���ϼ���");
		btn3.setToolTipText("������ �ݿ����Դϴ�");
		
		//RollOvericon : ���콺�� �÷����� �������� �ٲ�� �ϴ� ��
		btn3.setRolloverIcon(ii2);
		
		//��ư �� ��ġ ����
		//�̹��� ��(3,3)���� �ؽ�Ʈ�� ��ġ �ٲ��ֱ�
		//���� ��ġ ����(Left, Center, Right//horizontal)
		btn1.setHorizontalTextPosition(JButton.RIGHT);
	
		//���� ��ġ ����(Top, Center, Bottom //Vertical)
		btn2.setVerticalTextPosition(JButton.TOP);
		
		//ȥ��
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
