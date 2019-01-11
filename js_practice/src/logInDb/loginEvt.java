package logInDb;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

public class loginEvt extends WindowAdapter implements ActionListener {
	private loginView lv;
	private loginDAO l_dao;

	public loginEvt(loginView lv) {
		this.lv = lv;
	}

	public boolean chkNull(String id, String pass) {
		boolean flag = false;

		if (id.equals("")) {
			JOptionPane.showMessageDialog(lv, "아이디는 필수 입력");
			lv.getJfId().requestFocus();
			flag = true;
		} // end if
		if (pass.equals("")) {
			JOptionPane.showMessageDialog(lv, "비밀번호는 필수 입력");
			lv.getJfPass().requestFocus();
			flag = true;
		} // end if

		return !flag;
	}// chkNull

	public void login() {
			//DB에서 조회한 결과를 받아 
			List<String[]> listInfoColums;
			try {
				listInfoColums = l_dao.getInfo();
			
			
			String[] rowData = null;
			
			//조회된 결과를 가지고
			for(int i=0; i<listInfoColums.size(); i++) {
				rowData = new String[2];
				rowData[0] = listInfoColums.get(i)[0];
				rowData[1] = listInfoColums.get(i)[1];
			}
			
			if(listInfoColums.isEmpty()) {
				JOptionPane.showMessageDialog(lv, "값이 없습니다");
			}
			
			
				if(lv.getJfId().getText()==rowData[0] && lv.getJfPass().getText()==rowData[1]) {
					JOptionPane.showMessageDialog(null, "로그인성공");
				}else {
					JOptionPane.showMessageDialog(null, "로그인실패");
				}//end else
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	@Override
	public void windowClosing(WindowEvent e) {
		lv.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==lv.getJbtLogin()){
			login();
		}
	}
}
