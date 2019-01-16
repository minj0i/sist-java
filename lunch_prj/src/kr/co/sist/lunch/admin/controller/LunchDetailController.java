package kr.co.sist.lunch.admin.controller;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import kr.co.sist.lunch.admin.model.LunchAdminDAO;
import kr.co.sist.lunch.admin.view.LunchDetailView;

public class LunchDetailController extends WindowAdapter implements ActionListener{

	private LunchDetailView ldv;
	private LunchMainController lmc;
	private LunchAdminDAO la_dao;
	private String originalImg;
	private String uploadImg;
	
	public LunchDetailController(LunchDetailView ldv, LunchMainController lmc, String originalImg) {
		this.ldv=ldv;
		this.lmc=lmc;
		la_dao=LunchAdminDAO.getInstance(); //DB�� ���� ���� �������
		this.originalImg=originalImg;
	}//LunchDetailController

	private void removeLunch(String code) {
		
		try {
			if(la_dao.deleteLunch(code)) {//���ö��� ����
				lmc.setLunch();//���ö� ����Ʈ�� �����Ѵ�.
				//������ ����
				File file = new File("C:/dev/workspace/lunch_prj/src/kr/co/sist/lunch/admin/img/"+originalImg);
				//�ϳ������� �ϸ� ���ϸ��� �о������ ���ϴ� ������ �߻��� ���� �ֱ� ������ ���� �ΰ��� ��
				File rmFile = new File(file.getAbsolutePath());//ū ����
				File rmFile2 = new File(file.getParent()+"/s_"+file.getName());//��������
				
				rmFile.delete();
				rmFile2.delete();
				
				JOptionPane.showMessageDialog(ldv, "���ö��� �����Ǿ����ϴ�.");
			}else{
				JOptionPane.showMessageDialog(ldv, "���ö��� �������� �ʽ��ϴ�.");
			}//end else
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(ldv, "DB���� ������ �߻��Ͽ����ϴ�.");
			e.printStackTrace();
		}//end catch
		
	}//removeLunch
	
	private void chgImg() {

		FileDialog fdOpen = new FileDialog(ldv, "���ö��̹��� ����", FileDialog.LOAD);
		fdOpen.setVisible(true);
		
		String path = fdOpen.getDirectory();
		String name=fdOpen.getFile();
		
		boolean flag = false;
		if(path!=null) {
			String[] extFlag = {"jpg","gif","jpeg","png","bmp"};
			for(String ext:extFlag) {
				if(name.toLowerCase().endsWith(ext)) { //���ε� ���� Ȯ����
					flag=true;
				}//end if
			}//end for
			if(flag) {
				uploadImg=path+name;
				ldv.getJlLunchImg().setIcon(new ImageIcon(uploadImg));
				}else {
					JOptionPane.showMessageDialog(ldv, name+"�� �̹����� �ƴմϴ�.");
				}//end else
		}//end if
		
	}//chgImg
	/////////////////////////////////////////////////////////////////////////////////
	//������ ������� !!!! ���� ���ö��� �����ϴ� �κ� ����!!!
	/////////////////////////////////////////////////////////////////////////////////
	private boolean modifyLunch() {
		boolean flag = false;
		
		
		
		return flag;
	}//modifyLunch
		
	@Override
	public void windowClosing(WindowEvent we) {
		ldv.dispose();
	}//windowClosing
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==ldv.getJbUpdate()) {//����			
		}//end if
		if(ae.getSource()==ldv.getJbDelete()) {//����
			StringBuilder deleteMsg = new StringBuilder();
			deleteMsg.append(ldv.getJtfLunchName().getText()).append("(")
			.append(ldv.getJtfLunchCode().getText()).append(")�� �����Ͻðڽ��ϱ�?");
			
			switch(JOptionPane.showConfirmDialog(ldv, deleteMsg.toString())){
				case JOptionPane.OK_OPTION :
					removeLunch(ldv.getJtfLunchCode().getText());
			}//end switch
			
		}//end if
		if(ae.getSource()==ldv.getJbEnd()) {//����	
			ldv.dispose();
		}//end if
		if(ae.getSource()==ldv.getJbImg()) {//�̹�������		
			chgImg();
		}//end if
	}//actionPerformed
	
	
}//class
