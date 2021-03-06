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
		la_dao = LunchAdminDAO.getInstance(); // DB를 쓰기 위해 만들어줌
		this.originalImg = originalImg;
		uploadImg = "";
	}// LunchDetailController

	private void removeLunch(String code) {

		try {
			if (la_dao.deleteLunch(code)) {// 도시락을 삭제
				lmc.setLunch();// 도시락 리스트를 갱신한다.
				// 파일을 삭제
				File file = new File("C:/dev/workspace/lunch_prj/src/kr/co/sist/lunch/admin/img/" + originalImg);
				// 하나가지고 하면 파일명을 읽어들이지 못하는 문제가 발생할 수도 있기 때문에 따로 두개를 줌
				File rmFile = new File(file.getAbsolutePath());// 큰 파일
				File rmFile2 = new File(file.getParent() + "/s_" + file.getName());// 작은파일

				rmFile.delete();
				rmFile2.delete();

				JOptionPane.showMessageDialog(ldv, "도시락이 삭제되었습니다.");
			} else {
				JOptionPane.showMessageDialog(ldv, "도시락이 존재하지 않습니다.");
			} // end else
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(ldv, "DB에서 문제가 발생하였습니다.");
			e.printStackTrace();
		} // end catch

	}// removeLunch

	private void chgImg() {

		FileDialog fdOpen = new FileDialog(ldv, "도시락이미지 선택", FileDialog.LOAD);
		fdOpen.setVisible(true);

		String path = fdOpen.getDirectory();
		String name = fdOpen.getFile();

		boolean flag = false;
		if (path != null) {
			String[] extFlag = { "jpg", "gif", "jpeg", "png", "bmp" };
			for (String ext : extFlag) {
				if (name.toLowerCase().endsWith(ext)) { // 업로드 가능 확장자
					flag = true;
				} // end if
			} // end for
			if (flag) {
				uploadImg = path + name;
				ldv.getJlLunchImg().setIcon(new ImageIcon(uploadImg));
			} else {
				JOptionPane.showMessageDialog(ldv, name + "은 이미지가 아닙니다.");
			} // end else
		} // end if

	}// chgImg

	/**
	 * 도시락 코드, 도시락명, 가격, 특장점을 입력받아 코드에 해당하는 도시락의 정보를 변경
	 * 
	 * @return
	 */
	private void modifyLunch() { // void로 하고 DB에서 T/F 가지고 오면 됨
		// 유효성 검증 : 도시락명, 가격, 특장점이 ""가 아닐 때, 가격은 숫자인지,
		// 이미지가 변경되었다면 이미지가 s_가 붙은 이미지가 존재하는 이미지인지
		JTextField tfName = ldv.getJtfLunchName();
		JTextField tfPrice = ldv.getJtfLunchPrice();
		JTextArea taSpec = ldv.getJtaLunchSpec();

		// 빈칸인지 우선 확인
		if (tfName.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(ldv, "도시락명을 입력해주세요.");
			tfName.setText("");
			tfName.requestFocus();
		} // end if
		if (tfPrice.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(ldv, "도시락 가격을 입력해주세요.");
			tfPrice.setText("");
			tfPrice.requestFocus();
		} // end if
		if (taSpec.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(ldv, "도시락특징을 입력해주세요.");
			taSpec.setText("");
			taSpec.requestFocus();
		} // end if

		int price = 0;
		try {
			price = Integer.parseInt(tfPrice.getText().trim());
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(ldv, "도시락의 가격은 숫자만 입력가능합니다");
			nfe.printStackTrace();
		} // end catch

		// 선택한 이미지 앞에 s_가 붙은 이미지가 없는 경우 : 이미지 작업이 되어있지 않은 경우 uploadImg를 사용
		if (!uploadImg.equals("")) {// 이미지 변경을 수행 할 수 없는 경우
			File tempFile = new File(uploadImg); // 큰이미지
			File smallFile = new File(tempFile.getParent() + "/s_" + tempFile.getName()); // 작은이미지
			if (!smallFile.exists()) {
				JOptionPane.showMessageDialog(ldv, "선택하신 파일의 작은 이미지가 존재하지 않습니다.");
				uploadImg = "";
				return;
			} // end if
		} // end if

		StringBuilder updateMsg = new StringBuilder();
		updateMsg.append("수정정보 \n").append("도시락 명 : ").append(tfName.getText()).append("\n").append("가격 : ")
				.append(tfPrice.getText()).append("\n").append("특장점 : ").append(taSpec.getText()).append("\n")
				.append("위의 정보로 도시락의 정보가 변경하시겠습니까?");

		switch (JOptionPane.showConfirmDialog(ldv, updateMsg)) {
		case JOptionPane.OK_OPTION:
			// 변경된 값으로 VO를 생성하고
			File file = new File(uploadImg);
			LunchUpdateVO luvo = new LunchUpdateVO(ldv.getJtfLunchCode().getText(), tfName.getText().trim(),
					file.getName(), taSpec.getText(), price);
			try {
				if (la_dao.updateLunch(luvo)) {// DB Table에서 update를 수행
					JOptionPane.showMessageDialog(ldv, "도시락 정보가 변경되었습니다.");
					if (!uploadImg.equals("")) {// 변경한 이미지가 존재하는 경우
						try {
							//이전 이미지를 삭제한 후.
							// 파일을 삭제 
							File originfile = new File("C:/dev/workspace/lunch_prj/src/kr/co/sist/lunch/admin/img/" + originalImg);
							// 하나가지고 하면 파일명을 읽어들이지 못하는 문제가 발생할 수도 있기 때문에 따로 두개를 줌
							File rmFile = new File(originfile.getAbsolutePath());// 큰 파일
							File rmFile2 = new File(originfile.getParent() + "/s_" + originfile.getName());// 작은파일

							rmFile.delete();
							rmFile2.delete();
							
							uploadImg(file);// 변경한 이미지를 지정한 폴더에 업로드한다.
						} catch (IOException e) {
							e.printStackTrace();
						} // end catch
					} // end if
					lmc.setLunch();// 부모창의 리스트를 업데이트 한다.
				} else {
					JOptionPane.showMessageDialog(ldv, "도시락 정보가 변경되지 않았습니다.");
				} // end else
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(ldv, "DB에서 문제 발생!!");
				e.printStackTrace();
			} // end catch
			break;
		}// end switch
	}// modifyLunch

	/**
	 * 큰 이미지명을 가진 File객체를 입력하여 업로드 폴더에 큰 이미지(ml_l1.gif)와 작은 이미지(s_m1_l1.gif)를 업로드한다.
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
			//작은 이미지 업로드
			fis = new FileInputStream(file.getParent()+"/s_"+file.getName());//getParent를 쓰면 폴더까지가 나옴
			fos=new FileOutputStream(uploadPath+"s_"+file.getName());
			while((len=fis.read(readData))!=-1) {
				fos.write(readData,0,len);
				fos.flush();
			}//end while
			
			fis.close();
			fos.close();
			
		//큰 이미지 업로드
		fis = new FileInputStream(file);
		len =0; //len을 0으로 초기화
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
		if (ae.getSource() == ldv.getJbUpdate()) {// 수정
			modifyLunch();
		} // end if

		if (ae.getSource() == ldv.getJbDelete()) {// 삭제
			StringBuilder deleteMsg = new StringBuilder();
			deleteMsg.append(ldv.getJtfLunchName().getText()).append("(").append(ldv.getJtfLunchCode().getText())
					.append(")을 삭제하시겠습니까?");

			switch (JOptionPane.showConfirmDialog(ldv, deleteMsg.toString())) {
			case JOptionPane.OK_OPTION:
				removeLunch(ldv.getJtfLunchCode().getText());
			}// end switch
		} // end if

		if (ae.getSource() == ldv.getJbEnd()) {// 종료
			ldv.dispose();
		} // end if

		if (ae.getSource() == ldv.getJbImg()) {// 이미지변경
			chgImg();
		} // end if

	}// actionPerformed

}// class
