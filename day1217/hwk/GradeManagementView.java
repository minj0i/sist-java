package day1217;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * ���� ���� �ý��� View<br>
 * @author owner
 */
@SuppressWarnings("serial")
public class GradeManagementView extends JFrame {
	private JButton btnInput;
	private JTextField jtfInput;
	
	public GradeManagementView() {
		super("���� ���� �ý���");
		
		JLabel jlMenuSelect = new JLabel("�޴� ����");
		jlMenuSelect.setBounds(50, 40, 100, 80);
		
		JLabel jlInput = new JLabel("1. �Է�");
		jlInput.setBounds(50, 80, 100, 80);
		
		JLabel jlOutput = new JLabel("2. ���");
		jlOutput.setBounds(100, 80, 100, 80);
		
		JLabel jlExit = new JLabel("3. ����");
		jlExit.setBounds(150, 80, 100, 80);
		
		jtfInput = new JTextField();
		jtfInput.setBounds(50, 150, 140, 25);
		
		btnInput = new JButton("�Է�");
		btnInput.setBounds(200, 150, 75, 25);
		
		// ������Ʈ ��ġ
		setLayout(null);
		
		add(jlMenuSelect);
		add(jlInput);
		add(jlOutput);
		add(jlExit);
		add(jtfInput);
		add(btnInput);
		
		// �̺�Ʈ ���
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
