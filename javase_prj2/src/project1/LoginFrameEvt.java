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
				JOptionPane.showMessageDialog(null, "���̵� Ȥ�� ��й�ȣ�� Ȯ���� �ּ���");
			} // end else
		} // EnterBtn

		if (ae.getSource() == lf.getInforBtn()) {
			JOptionPane.showMessageDialog(null, "�غ���");
			// ���� ���̾�α� ���
		} // InforBtn

		if (ae.getSource() == lf.getExitBtn()) {

			int exitButton;
			exitButton = JOptionPane.showConfirmDialog(null, "���� �����Ͻðڽ��ϱ�?", "����", 2);

			if (exitButton == 0) {
				lf.dispose();
			} else {
				return;
			} // end else
		} // ExitBtn

	}// ActionEvent

} // class
