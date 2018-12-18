package day1217;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * 성적 관리 시스템 View<br>
 * @author owner
 */
@SuppressWarnings("serial")
public class GradeManagementView extends JFrame {
	private JButton btnInput;
	private JTextField jtfInput;
	
	public GradeManagementView() {
		super("성적 관리 시스템");
		
		JLabel jlMenuSelect = new JLabel("메뉴 선택");
		jlMenuSelect.setBounds(50, 40, 100, 80);
		
		JLabel jlInput = new JLabel("1. 입력");
		jlInput.setBounds(50, 80, 100, 80);
		
		JLabel jlOutput = new JLabel("2. 출력");
		jlOutput.setBounds(100, 80, 100, 80);
		
		JLabel jlExit = new JLabel("3. 종료");
		jlExit.setBounds(150, 80, 100, 80);
		
		jtfInput = new JTextField();
		jtfInput.setBounds(50, 150, 140, 25);
		
		btnInput = new JButton("입력");
		btnInput.setBounds(200, 150, 75, 25);
		
		// 컴포넌트 배치
		setLayout(null);
		
		add(jlMenuSelect);
		add(jlInput);
		add(jlOutput);
		add(jlExit);
		add(jtfInput);
		add(btnInput);
		
		// 이벤트 등록
		GradeManagementProcess gmp = new GradeManagementProcess(this);
		
		btnInput.addActionListener(gmp);
		jtfInput.addActionListener(gmp);
		
		jtfInput.addKeyListener(gmp);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(200, 200, 340, 260);
		
		setVisible(true);
	} // GradeManagementSystem

	public JButton getBtnInput() {
		return btnInput;
	} // getBtnInput

	public JTextField getJtfInput() {
		return jtfInput;
	} // getJtfInput

} // class
