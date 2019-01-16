package kr.co.sist.lunch.admin.controller;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import kr.co.sist.lunch.admin.model.LunchAdminDAO;
import kr.co.sist.lunch.admin.view.LunchDetailView;

public class LunchDetailController extends WindowAdapter implements ActionListener{

	private LunchDetailView ldv;
	private LunchMainController lmc;
	private LunchAdminDAO la_dao;
	

	public LunchDetailController(LunchDetailView ldv, LunchMainController lmc ) {
		this.ldv=ldv;
		this.lmc=lmc;
		la_dao=LunchAdminDAO.getInstance(); //DB를 쓰기 위해 만들어줌
	}//LunchDetailController

	private void removeLunch(String code) {
		
		try {
			if(la_dao.deleteLunch(code)) {//도시락을 삭제
				lmc.setLunch();//도시락 리스트를 갱신한다.
				//파일을 삭제
				File file = new File(ldv.getJlLunchImg().getIcon().toString());
				//하나가지고 하면 파일명을 읽어들이지 못하는 문제가 발생할 수도 있기 때문에 따로 두개를 줌
				File rmFile = new File(file.getAbsolutePath());//큰 파일
				File rmFile2 = new File(file.getParent()+"/s_"+file.getName());//작은파일
				
				rmFile.delete();
				rmFile2.delete();
				
				JOptionPane.showMessageDialog(ldv, "도시락이 삭제되었습니다.");
			}else{
				JOptionPane.showMessageDialog(ldv, "도시락이 존재하지 않습니다.");
			}//end else
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(ldv, "DB에서 문제가 발생하였습니다.");
			e.printStackTrace();
		}//end catch
		
	}//removeLunch
	
	@Override
	public void windowClosing(WindowEvent we) {
		ldv.dispose();
	}//windowClosing
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==ldv.getJbUpdate()) {//수정			
		}//end if
		if(ae.getSource()==ldv.getJbDelete()) {//삭제
			StringBuilder deleteMsg = new StringBuilder();
			deleteMsg.append(ldv.getJtfLunchName().getText()).append("(")
			.append(ldv.getJtfLunchCode().getText()).append(")을 삭제하시겠습니까?");
			
			switch(JOptionPane.showConfirmDialog(ldv, deleteMsg.toString())){
				case JOptionPane.OK_OPTION :
					removeLunch(ldv.getJtfLunchCode().getText());
			}//end switch
			
		}//end if
		if(ae.getSource()==ldv.getJbEnd()) {//종료	
			ldv.dispose();
		}//end if
		if(ae.getSource()==ldv.getJbImg()) {//이미지변경		
			
		}//end if
	}//actionPerformed
	
	
}//class
