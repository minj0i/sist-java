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
			return !flag;
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
		String id = lv.getJfId().getText().trim();
		String pass = new String(lv.getJfPass().getText()).trim();
		String realpass;
		try {
			listInfoColums = l_dao.getInfo();

			// 회원 값이 없다면
			if (listInfoColums.isEmpty()) {
				JOptionPane.showMessageDialog(lv, "회원 값을 불러들일 수  없습니다");
			}

			List<String> realId = new ArrayList<String>();
			// 조회된 결과를 가지고
			for (int i = 0; i < listInfoColums.size(); i++) {
				realId.add(listInfoColums.get(i)[0]);
				// 아이디에 맞는 비밀번호를 realpass에 넣고
				if (id.equals(listInfoColums.get(i)[0])) {
					realpass = listInfoColums.get(i)[1];
					if (pass.equals(realpass)) {
						JOptionPane.showMessageDialog(null, "로그인성공");
						break;
					} else {
						JOptionPane.showMessageDialog(null, "로그인실패");
						boolean checkId = (realId.contains(id) ? true : false);
						System.out.println(checkId);
						if (checkId) {
							JOptionPane.showMessageDialog(null, "비밀번호를 확인해주세요.");
							break;
						} // end if
					} // end else
					//여기에 넣으면 아이디가 이상하면 아무것도 안나옴
					}//end if
			//여기에 넣으면 root가 체크가 안됨
			}//end for
			//여기에 넣으면 로그인 실패가 안뜨고 먼저 뜸
//			System.out.println(realId);
//			if(!realId.contains(id)) {
//				JOptionPane.showMessageDialog(null, "아이디를 확인해주세요.");
//			}//end if
			
		} catch (SQLException e) {
			e.printStackTrace();
		} // end catch
	}

	@Override
	public void windowClosing(WindowEvent e) {
		lv.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == lv.getJbtLogin()) {
			String id = lv.getJfId().getText().trim();
			String pass = new String(lv.getJfPass().getText()).trim();
			if (chkNull(id, pass)) { // 빈 값이 없도록 유도
				login();
			} // end if
		} // end if
	}// actionPerformed
}
