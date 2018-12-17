package day1217;

import java.awt.BorderLayout;

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
public class UseJTab2 extends JFrame implements MouseListener {
	ImageIcon ii2= new ImageIcon("C:\\dev\\workspace\\javase_prj\\src\\day1214\\images\\img3.gif");
	JLabel lblTap4= new JLabel();
	private JTabbedPane jtp;
	public UseJTab2() {
		super("Tab");
		//1.탭을 추가할 수 있는 객체를 생성
		jtp = new JTabbedPane();
		
		//2.각 탭에 들어갈 컴포넌트를 생성
		//처음 탭에 들어갈 컴포넌트
		ImageIcon ii = new ImageIcon("C:\\dev\\workspace\\javase_prj\\src\\day1214\\images\\img1.png");
		JLabel jl= new JLabel(ii);
		
		
		//두번쨰 탭에 들어갈 컴포넌트
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
		
		tab2.add("North",jp);
		tab2.add("Center",jsp);
		
		jtp.addTab("처음탭", jl);
		jtp.addTab("두번째 탭", tab2);
		jtp.addTab("세번째 탭", new JButton("클릭"));
		jtp.addTab("네번째 탭",lblTap4);		
		//배치
		add("Center",jtp);
		
		//이벤트 등록
		jtp.addMouseListener(this);
		

		setBounds(100,100,600,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//UseJTab2
	public void Tab4(){
		String s = JOptionPane.showInputDialog("비밀번호 입력");
		if(s.equals("123")) {
			lblTap4.setIcon(ii2);
		}
		else {
			jtp.setSelectedIndex(0);
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int index = jtp.getSelectedIndex();
		if(index==3) {
			Tab4();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	public static void main(String[] args) {
		new UseJTab2();
	}//main

}//class
