package project1;

import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class LoginFrameMj extends JFrame implements ActionListener {
	private JTextField jtfId;
	private JPasswordField jpfPass;
	private JButton loginOk;
	private JLabel loginId, loginPass, jlOutput;
	private FileOpenMj fo;

	public LoginFrameMj() {
		super("로그인");
		jtfId = new JTextField();
		jpfPass = new JPasswordField();
		loginId = new JLabel("아이디: ");
		loginPass = new JLabel("비밀번호: ");
		jlOutput = new JLabel("결과: ");
		loginOk = new JButton("로그인");

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4, 2));
		// 컨테이너 컴포넌트
		panel.setBorder(new TitledBorder("로그인"));
		panel.add(loginId);
		panel.add(jtfId);
		panel.add(loginPass);
		panel.add(jpfPass);
		panel.add(jlOutput);
		panel.add(loginOk);
		
		// 이벤트 등록
		jtfId.addActionListener(this);
		jpfPass.addActionListener(this);
		
		add("Center", panel);
		setBounds(100, 100, 250, 300);
		loginId.setBounds(150,300,200,50);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}// LoginFrame

	@Override
	public void actionPerformed(ActionEvent ae) {
		String id = jtfId.getText().trim();
		String pass = new String(jpfPass.getPassword());
		// 아이디가 없을 때
		if (id.equals("")) {
			jtfId.requestFocus();
			jlOutput.setText("아이디를 입력해주세요");
		} // end if

		if (ae.getSource() == jtfId) {// 아이디에서 이벤트가 발생하면
			// 아이디에 값이 들어있다면 커서를 비밀번호로 이동
			if (!id.equals("")) {
				jpfPass.requestFocus();
			} // end if
		} // end if

		if (ae.getSource() == jpfPass) {// 비밀번호에서 이벤트가 발생하면
			// 아이디에 값이 없다면 커서를 아이디로 이동
			if (id.equals("")) {
				jtfId.requestFocus();
				jlOutput.setText("아이디를 입력해주세요");
				return;// 반환형이 void인 method에서 코드의 실행을 멈추고 호출한 곳으로 돌아가라
			} // end if

			// 비밀번호에 값이 없다면 출력창에 "비번입력"을 보여주고 커서를
			// 비밀번호에 이동
			if (pass.trim().equals("")) {
				jlOutput.setText("비밀번호를 입력해주세요");
				jpfPass.requestFocus();
				return;
			} // end if

			// 비밀번호에 값이 있다면 아이디가 admin, 비밀번호가 123과 같은지
			// 비교하여 같다면 자바메모장 클래스를 실행
			if (id.equals("admin") && pass.equals("123")) {
				try {
					fo.openFile();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				dispose();
			} else {
				jlOutput.setText("아이디나 비밀번호를 확인해 주세요");
			} // end if else

		} // end if

	}//ActionEvent

	public JButton getloginOk() {
		return loginOk;
	}//loginOk

	
}//class
