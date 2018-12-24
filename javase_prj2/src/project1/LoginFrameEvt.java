package project1;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import project1.LoginFrame;

public class LoginFrameEvt implements ActionListener {
	private LoginFrame lf;
	public LoginFrameEvt(LoginFrame lf) {
		this.lf = lf;
	}//LoginFrameEvt

	@Override
	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == lf.getEnterBtn()) {

			String id = lf.idTf.getText().trim();
			String pass = new String(lf.pwTf.getPassword());
			if ((id.equals("admin") && pass.equals("1234")) || id.equals("root") && pass.equals("1111")) {
				new ViewOrOpen();
				lf.dispose();
			} else {
				JOptionPane.showMessageDialog(null, "아이디 혹은 비밀번호를 확인해 주세요");
			} // end else
		} // EnterBtn

		if (ae.getSource() == lf.getInforBtn()) {
			JOptionPane.showMessageDialog(null, "준비중");
			// 정보 다이어로그 출력
		} // InforBtn

		if (ae.getSource() == lf.getExitBtn()) {

			int exitButton;
			exitButton = JOptionPane.showConfirmDialog(null, "정말 종료하시겠습니까?", "종료", 2);

			if (exitButton == 0) {
				lf.dispose();
			} else {
				return;
			} // end else
		} // ExitBtn

	}// ActionEvent

} // class
