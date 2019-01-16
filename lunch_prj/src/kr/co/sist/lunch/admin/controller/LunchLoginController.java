package kr.co.sist.lunch.admin.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import kr.co.sist.lunch.admin.model.LunchAdminDAO;
import kr.co.sist.lunch.admin.view.LunchLoginView;
import kr.co.sist.lunch.admin.view.LunchMainView;
import kr.co.sist.lunch.admin.vo.AdminLoginVO;

public class LunchLoginController extends WindowAdapter implements ActionListener{

	private LunchLoginView llv;
	
	public LunchLoginController(LunchLoginView llv) {
		this.llv = llv;
	}//LunchLoginController
	
	@Override
	public void windowClosing(WindowEvent we) {
		llv.dispose();
	}//windowClosing
	
	@Override
	public void actionPerformed(ActionEvent ae) {

		if(!checkIDEmpty()&&!checkPassEmpty()) {//아이디와 비밀번호가 empty가 아니면
			JTextField jtf = llv.getJtfId();
			JPasswordField jpf = llv.getJpfPass();
			
			String id =jtf.getText().trim();
			String pass=new String(jpf.getPassword());
			
			//adminName 체크
			//입력한 아이디와 비밀번호를 가지고
			AdminLoginVO alvo = new AdminLoginVO(id, pass); //두 개의 값으로 데이터를 만듬
			String adminName = login(alvo); //DB로그인 인증을 수행한 결과를 받음
			
			if(adminName.equals("")) {//""이면 로그인이 안된 것
				JOptionPane.showMessageDialog(llv, "아이디나 비밀번호를 확인하세요");
				jtf.setText("");
				jpf.setText("");
				jtf.requestFocus();
			}else {
				new LunchMainView(adminName);
				LunchMainView.adminId=id;//로그인 성공했다면 id를 
				//모든 객체에서 사용할 수 있도록 static 변수에 설정한다.
				
				llv.dispose();
			}//end else
		}//end if

		
	}//actionPerformed

	/**
	 * 입력 ID 값이 ""인지 체크
	 * @return
	 */
	private boolean checkIDEmpty() {
		boolean flag = false;
		JTextField jtfId = llv.getJtfId();
		if(jtfId.getText().trim().equals("")) {//JTextField의 값이 없다면 커서를 이동
			jtfId.setText("");//공백을 입력한 후 enter를 쳤을 때 처리
			jtfId.requestFocus();
			flag = true;
		}
		return flag;
	}//checkIDEmpty
	
	/**
	 * 입력 Password 값이 ""인지 체크
	 * @return
	 */
	private boolean checkPassEmpty() {
		boolean flag = false;
		JPasswordField jpfPass = llv.getJpfPass();
		String pass = new String(jpfPass.getPassword());
		
		if(pass.equals("")) {
			jpfPass.setText("");//공백을 입력한 후 enter를 쳤을 때 처리
			jpfPass.requestFocus();
			flag = true;
		}//end if
		
		return flag;
	}//checkPassEmpty
	
	private String login(AdminLoginVO alvo) {
		String adminName="";
		
		LunchAdminDAO la_dao=LunchAdminDAO.getInstance();
		try {
			adminName = la_dao.login(alvo);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(llv, "DB쪽에 문제가 발생하였습니다."); //쿼리테스트할때는 문제가 없었으므로 DB문제
			e.printStackTrace();
		}//end catch
		
		return adminName;
	}
	
}//class
