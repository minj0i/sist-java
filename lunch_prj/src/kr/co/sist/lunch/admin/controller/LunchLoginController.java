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

		if(!checkIDEmpty()&&!checkPassEmpty()) {//���̵�� ��й�ȣ�� empty�� �ƴϸ�
			JTextField jtf = llv.getJtfId();
			JPasswordField jpf = llv.getJpfPass();
			
			String id =jtf.getText().trim();
			String pass=new String(jpf.getPassword());
			
			//adminName üũ
			//�Է��� ���̵�� ��й�ȣ�� ������
			AdminLoginVO alvo = new AdminLoginVO(id, pass); //�� ���� ������ �����͸� ����
			String adminName = login(alvo); //DB�α��� ������ ������ ����� ����
			
			if(adminName.equals("")) {//""�̸� �α����� �ȵ� ��
				JOptionPane.showMessageDialog(llv, "���̵� ��й�ȣ�� Ȯ���ϼ���");
				jtf.setText("");
				jpf.setText("");
				jtf.requestFocus();
			}else {
				new LunchMainView(adminName);
				LunchMainView.adminId=id;//�α��� �����ߴٸ� id�� 
				//��� ��ü���� ����� �� �ֵ��� static ������ �����Ѵ�.
				
				llv.dispose();
			}//end else
		}//end if

		
	}//actionPerformed

	/**
	 * �Է� ID ���� ""���� üũ
	 * @return
	 */
	private boolean checkIDEmpty() {
		boolean flag = false;
		JTextField jtfId = llv.getJtfId();
		if(jtfId.getText().trim().equals("")) {//JTextField�� ���� ���ٸ� Ŀ���� �̵�
			jtfId.setText("");//������ �Է��� �� enter�� ���� �� ó��
			jtfId.requestFocus();
			flag = true;
		}
		return flag;
	}//checkIDEmpty
	
	/**
	 * �Է� Password ���� ""���� üũ
	 * @return
	 */
	private boolean checkPassEmpty() {
		boolean flag = false;
		JPasswordField jpfPass = llv.getJpfPass();
		String pass = new String(jpfPass.getPassword());
		
		if(pass.equals("")) {
			jpfPass.setText("");//������ �Է��� �� enter�� ���� �� ó��
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
			JOptionPane.showMessageDialog(llv, "DB�ʿ� ������ �߻��Ͽ����ϴ�."); //�����׽�Ʈ�Ҷ��� ������ �������Ƿ� DB����
			e.printStackTrace();
		}//end catch
		
		return adminName;
	}
	
}//class
