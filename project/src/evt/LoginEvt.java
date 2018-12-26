package evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import view.LoginView;
import view.MainControlView;

public class LoginEvt extends WindowAdapter implements ActionListener {

	private LoginView lv;

	public LoginEvt(LoginView lv) {
		this.lv = lv;
	} // LoginFrameEvt

	public void closing() {

		int exitButton = 0;
		exitButton = JOptionPane.showOptionDialog(lv, "정말 종료하시겠습니까?", "종료", 0, 2, null, null, exitButton);

		if (exitButton == JOptionPane.OK_OPTION) {
			lv.dispose();
		} else if (exitButton == JOptionPane.CANCEL_OPTION) {

		}
	} // closing

	public void identifyIDPW() {

		String id = lv.idTf.getText().trim();
		String pass = new String(lv.pwTf.getPassword());

		if ((id.equals("admin") && pass.equals("1234")) || id.equals("root") && pass.equals("1111")) {
			new MainControlView(); // 메인 컨트롤으로 연결
			lv.dispose();
		} else {
			JOptionPane.showMessageDialog(lv, "아이디 혹은 비밀번호를 확인해 주세요", "Error", 0);
			lv.idTf.setText("");
			lv.pwTf.setText("");
			lv.idTf.requestFocus();
		}
	} // login

	@Override
	public void windowClosing(WindowEvent we) {
		closing();
	} // windowClosing

	@Override
	public void actionPerformed(ActionEvent ae) {

		String id = lv.idTf.getText();
		String idTemp = "";
		char[] pw = lv.pwTf.getPassword();
		String pws=String.valueOf(pw);

		if (ae.getSource() == lv.idTf) {
			if (!id.equals(idTemp)) {
				lv.pwTf.requestFocus();
			}
		}

		if (ae.getSource() == lv.pwTf) {
			if (!pws.equals("")) {
				identifyIDPW();
			}
		}
		
		if (ae.getSource() == lv.getEnterBtn()) {
			identifyIDPW();
		}

//		if (ae.getSource() == lv.getInforBtn()) {
//			JOptionPane.showMessageDialog(lv, "준비중");
//			// 정보 다이어로그 출력
//		}

		if (ae.getSource() == lv.getExitBtn()) {
			closing();
		}
	} // actionPerformed

} // class
