package logInDb;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class loginEvt extends WindowAdapter implements ActionListener {
	private loginView lv;
	private loginDAO l_dao;

	public loginEvt(loginView lv) {
		this.lv = lv;
		l_dao = new loginDAO();
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
 
		// DB에서 조회한 결과를 받아
		List<String[]> listInfoColums;
		try {
			listInfoColums = l_dao.getInfo();
						
			String[] rowData = null;

			// 조회된 결과를 가지고
			rowData = new String[2];
			for (int i = 0; i < listInfoColums.size(); i++) {
				rowData[0] = listInfoColums.get(i)[0];
				rowData[1] = listInfoColums.get(i)[1];//굳이
			}
			
			
			System.out.println(listInfoColums.get(0)[0]);//admin
			System.out.println(listInfoColums.get(0)[1]);//1234
			
			System.out.println(listInfoColums.get(1)[0]);//root
			System.out.println(listInfoColums.get(1)[1]);//1111
			
			if (listInfoColums.isEmpty()) {
				JOptionPane.showMessageDialog(lv, "값이 없습니다");
			}

			if (lv.getJfId().getText().equals(rowData[0])&& lv.getJfPass().getText().equals(rowData[1])) {
				JOptionPane.showMessageDialog(null, "로그인성공");
			} else {
				JOptionPane.showMessageDialog(null, "로그인실패");
			} // end else
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
		if (ae.getSource() == lv.getJbtLogin()) {
			login();
		}
	}
}
