package kr.co.sist.lunch.admin.controller;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import kr.co.sist.lunch.admin.model.LunchAdminDAO;
import kr.co.sist.lunch.admin.view.LunchDetailView;
import kr.co.sist.lunch.admin.vo.LunchUpdateVO;

public class LunchDetailController extends WindowAdapter implements ActionListener {

	private LunchDetailView ldv;
	private LunchMainController lmc;
	private LunchAdminDAO la_dao;
	private String originalImg;
	private String uploadImg;

	public LunchDetailController(LunchDetailView ldv, LunchMainController lmc, String originalImg) {
		this.ldv = ldv;
		this.lmc = lmc;
		la_dao = LunchAdminDAO.getInstance(); // DB�� ���� ���� �������
		this.originalImg = originalImg;
		uploadImg = "";
	}// LunchDetailController

	private void removeLunch(String code) {

		try {
			if (la_dao.deleteLunch(code)) {// ���ö��� ����
				lmc.setLunch();// ���ö� ����Ʈ�� �����Ѵ�.
				// ������ ����
				File file = new File("C:/dev/workspace/lunch_prj/src/kr/co/sist/lunch/admin/img/" + originalImg);
				// �ϳ������� �ϸ� ���ϸ��� �о������ ���ϴ� ������ �߻��� ���� �ֱ� ������ ���� �ΰ��� ��
				File rmFile = new File(file.getAbsolutePath());// ū ����
				File rmFile2 = new File(file.getParent() + "/s_" + file.getName());// ��������

				rmFile.delete();
				rmFile2.delete();

				JOptionPane.showMessageDialog(ldv, "���ö��� �����Ǿ����ϴ�.");
			} else {
				JOptionPane.showMessageDialog(ldv, "���ö��� �������� �ʽ��ϴ�.");
			} // end else
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(ldv, "DB���� ������ �߻��Ͽ����ϴ�.");
			e.printStackTrace();
		} // end catch

	}// removeLunch

	private void chgImg() {

		FileDialog fdOpen = new FileDialog(ldv, "���ö��̹��� ����", FileDialog.LOAD);
		fdOpen.setVisible(true);

		String path = fdOpen.getDirectory();
		String name = fdOpen.getFile();

		boolean flag = false;
		if (path != null) {
			String[] extFlag = { "jpg", "gif", "jpeg", "png", "bmp" };
			for (String ext : extFlag) {
				if (name.toLowerCase().endsWith(ext)) { // ���ε� ���� Ȯ����
					flag = true;
				} // end if
			} // end for
			if (flag) {
				uploadImg = path + name;
				ldv.getJlLunchImg().setIcon(new ImageIcon(uploadImg));
			} else {
				JOptionPane.showMessageDialog(ldv, name + "�� �̹����� �ƴմϴ�.");
			} // end else
		} // end if

	}// chgImg

	/**
	 * ���ö� �ڵ�, ���ö���, ����, Ư������ �Է¹޾� �ڵ忡 �ش��ϴ� ���ö��� ������ ����
	 * 
	 * @return
	 */
	private void modifyLunch() { // void�� �ϰ� DB���� T/F ������ ���� ��
		// ��ȿ�� ���� : ���ö���, ����, Ư������ ""�� �ƴ� ��, ������ ��������,
		// �̹����� ����Ǿ��ٸ� �̹����� s_�� ���� �̹����� �����ϴ� �̹�������
		JTextField tfName = ldv.getJtfLunchName();
		JTextField tfPrice = ldv.getJtfLunchPrice();
		JTextArea taSpec = ldv.getJtaLunchSpec();

		// ��ĭ���� �켱 Ȯ��
		if (tfName.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(ldv, "���ö����� �Է����ּ���.");
			tfName.setText("");
			tfName.requestFocus();
		} // end if
		if (tfPrice.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(ldv, "���ö� ������ �Է����ּ���.");
			tfPrice.setText("");
			tfPrice.requestFocus();
		} // end if
		if (taSpec.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(ldv, "���ö�Ư¡�� �Է����ּ���.");
			taSpec.setText("");
			taSpec.requestFocus();
		} // end if

		int price = 0;
		try {
			price = Integer.parseInt(tfPrice.getText().trim());
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(ldv, "���ö��� ������ ���ڸ� �Է°����մϴ�");
			nfe.printStackTrace();
		} // end catch

		// ������ �̹��� �տ� s_�� ���� �̹����� ���� ��� : �̹��� �۾��� �Ǿ����� ���� ��� uploadImg�� ���
		if (!uploadImg.equals("")) {// �̹��� ������ ���� �� �� ���� ���
			File tempFile = new File(uploadImg); // ū�̹���
			File smallFile = new File(tempFile.getParent() + "/s_" + tempFile.getName()); // �����̹���
			if (!smallFile.exists()) {
				JOptionPane.showMessageDialog(ldv, "�����Ͻ� ������ ���� �̹����� �������� �ʽ��ϴ�.");
				uploadImg = "";
				return;
			} // end if
		} // end if

		StringBuilder updateMsg = new StringBuilder();
		updateMsg.append("�������� \n").append("���ö� �� : ").append(tfName.getText()).append("\n").append("���� : ")
				.append(tfPrice.getText()).append("\n").append("Ư���� : ").append(taSpec.getText()).append("\n")
				.append("���� ������ ���ö��� ������ �����Ͻðڽ��ϱ�?");

		switch (JOptionPane.showConfirmDialog(ldv, updateMsg)) {
		case JOptionPane.OK_OPTION:
			// ����� ������ VO�� �����ϰ�
			File file = new File(uploadImg);
			LunchUpdateVO luvo = new LunchUpdateVO(ldv.getJtfLunchCode().getText(), tfName.getText().trim(),
					file.getName(), taSpec.getText(), price);
			try {
				if (la_dao.updateLunch(luvo)) {// DB Table���� update�� ����
					JOptionPane.showMessageDialog(ldv, "���ö� ������ ����Ǿ����ϴ�.");
					if (!uploadImg.equals("")) {// ������ �̹����� �����ϴ� ���
						try {
							//���� �̹����� ������ ��.
							// ������ ���� 
							File originfile = new File("C:/dev/workspace/lunch_prj/src/kr/co/sist/lunch/admin/img/" + originalImg);
							// �ϳ������� �ϸ� ���ϸ��� �о������ ���ϴ� ������ �߻��� ���� �ֱ� ������ ���� �ΰ��� ��
							File rmFile = new File(originfile.getAbsolutePath());// ū ����
							File rmFile2 = new File(originfile.getParent() + "/s_" + originfile.getName());// ��������

							rmFile.delete();
							rmFile2.delete();
							
							uploadImg(file);// ������ �̹����� ������ ������ ���ε��Ѵ�.
						} catch (IOException e) {
							e.printStackTrace();
						} // end catch
					} // end if
					lmc.setLunch();// �θ�â�� ����Ʈ�� ������Ʈ �Ѵ�.
				} else {
					JOptionPane.showMessageDialog(ldv, "���ö� ������ ������� �ʾҽ��ϴ�.");
				} // end else
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(ldv, "DB���� ���� �߻�!!");
				e.printStackTrace();
			} // end catch
			break;
		}// end switch
	}// modifyLunch

	/**
	 * ū �̹������� ���� File��ü�� �Է��Ͽ� ���ε� ������ ū �̹���(ml_l1.gif)�� ���� �̹���(s_m1_l1.gif)�� ���ε��Ѵ�.
	 * 
	 * @param file
	 */
	private void uploadImg(File file) throws IOException {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			byte[] readData = new byte[512];
			String uploadPath = "C:/dev/workspace/lunch_prj/src/kr/co/sist/lunch/admin/img/";

			int len =0;
			//���� �̹��� ���ε�
			fis = new FileInputStream(file.getParent()+"/s_"+file.getName());//getParent�� ���� ���������� ����
			fos=new FileOutputStream(uploadPath+"s_"+file.getName());
			while((len=fis.read(readData))!=-1) {
				fos.write(readData,0,len);
				fos.flush();
			}//end while
			
			fis.close();
			fos.close();
			
		//ū �̹��� ���ε�
		fis = new FileInputStream(file);
		len =0; //len�� 0���� �ʱ�ȭ
		fos=new FileOutputStream(uploadPath+file.getName());
		
		while((len=fis.read(readData))!=-1) {
			fos.write(readData,0,len);
			fos.flush();
		}//end while

		} finally {
			if (fis != null) {fis.close();} // end if
			if (fos != null) {fos.close();} // end if
		} // end finally
	}// uploadImg

	@Override
	public void windowClosing(WindowEvent we) {
		ldv.dispose();
	}// windowClosing

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == ldv.getJbUpdate()) {// ����
			modifyLunch();
		} // end if

		if (ae.getSource() == ldv.getJbDelete()) {// ����
			StringBuilder deleteMsg = new StringBuilder();
			deleteMsg.append(ldv.getJtfLunchName().getText()).append("(").append(ldv.getJtfLunchCode().getText())
					.append(")�� �����Ͻðڽ��ϱ�?");

			switch (JOptionPane.showConfirmDialog(ldv, deleteMsg.toString())) {
			case JOptionPane.OK_OPTION:
				removeLunch(ldv.getJtfLunchCode().getText());
			}// end switch
		} // end if

		if (ae.getSource() == ldv.getJbEnd()) {// ����
			ldv.dispose();
		} // end if

		if (ae.getSource() == ldv.getJbImg()) {// �̹�������
			chgImg();
		} // end if

	}// actionPerformed

}// class
