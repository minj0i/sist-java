package day1217;
//내가 하다 만것
//탭4에 123을 넣으면 이미지가 뜨고 틀리면 탭1로 돌아간다.
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class UseJTab extends JFrame implements MouseListener {
	ImageIcon ii2 = new ImageIcon("C:/dev/workspace/javase_prj/src/day1214/images/img2.jpg");
	JPanel tab4 = new JPanel();

	public UseJTab() {
		super("Tab");
//		//1. 테이블 추가할 수 있는 객체 생성
		JTabbedPane jtp = new JTabbedPane();
		// 2. 각 탭에 들어갈 컴포넌트 생성
		// 첫번째 탭에 들어갈 컴포넌트
		ImageIcon ii = new ImageIcon("C:/dev/workspace/javase_prj/src/day1214/images/img1.jpg");
		JLabel jl = new JLabel(ii);

		// 두번째 탭에 들어갈 컴포넌트
		JPanel jp = new JPanel();
		jp.add(new JLabel("이름"));
		jp.add(new JTextField(30));
		jp.add(new JButton("입력"));

		JPanel tab2 = new JPanel();
		tab2.setLayout(new BorderLayout());

		jp.setBorder(new TitledBorder("입력데이터"));

		JTextArea jta = new JTextArea();
		JScrollPane jsp = new JScrollPane(jta);
		jsp.setBorder(new TitledBorder("결과창"));

		tab2.add("North", jp);
		tab2.add("Center", jsp);

		jtp.add("처음탭", jl);
		jtp.add("두번째 탭", tab2);
		jtp.add("세번째 탭", new JButton("클릭"));

		// 네번째 탭에 들어갈 컴포넌트
		jtp.add("네번째 탭", tab4);
		tab4.addMouseListener(this);
		
		// 배치
		add("Center", jtp);

		setBounds(100, 100, 600, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}// UseTab

	@Override
	public void mouseClicked(MouseEvent me) {
		String inputData = JOptionPane.showInputDialog("비밀번호를 입력하세요");
		// 유효성검증
		if (inputData.equals("1234")) {
			JOptionPane.showInputDialog("비밀번호");
		} else {
		} // end if
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

	////////////////////////// inner class 시작///////////////////////////
//	public class MouseEvt extends MouseAdapter{
//		@Override
//		public void mouseClicked(MouseEvent me) {
//			String inputData = JOptionPane.showInputDialog("비밀번호를 입력하세요");	
//			//유효성검증
//			if(inputData.equals("1234")) {
//				tab4.add(ii2);
//			}else {
//					jtp.requestFocus(jl);
//			}//end if
//		}//mouseClicked
	////////////////////////// inner class 끝///////////////////////////

	public static void main(String[] args) {
		new UseJTab();
	}// main

}// class
