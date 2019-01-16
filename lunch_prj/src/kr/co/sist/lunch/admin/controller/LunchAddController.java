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
import kr.co.sist.lunch.admin.view.LunchAddView;
import kr.co.sist.lunch.admin.vo.LunchAddVO;

public class LunchAddController extends WindowAdapter implements ActionListener{
	private LunchAddView lav;
	private String uploadImg; 
	private LunchMainController lmc;
	
	public LunchAddController(LunchAddView lav, LunchMainController lmc) {
		this.lav=lav;
		this.lmc=lmc;
		uploadImg="";
	}//생성자

	@Override
	public void windowClosing(WindowEvent e) {
		lav.dispose();
	}//windowClosing
	
	
	/**
	 * 입력값과 이미지를 선택한 후 유효성 검증(이미지, 도시락명, 가격, 특장점이 입력되었다면)
	 */
	private void addLunch() {
		if(uploadImg.equals("")) {
			JOptionPane.showMessageDialog(lav, "이미지를 선택해주세요");
			return;
		}//end if
		
		JTextField jtfName = lav.getJtfLunchName();
		JTextField jtfPrice = lav.getJtfLunchPrice();
		JTextArea jtaSpec = lav.getJtaLunchSpec();
		
		if(jtfName.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(lav, "도시락 명은 필수 입력!!!!");
			jtfName.setText("");
			jtfName.requestFocus();
			return;
		}//end if
		
		if(jtfPrice.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(lav, "도시락 가격은 필수 입력!!!!");
			jtfPrice.setText("");
			jtfPrice.requestFocus();
			return;
		}//end if
		
		//가격은 숫자만 입력되도록 try~catch
		int price = 0;
		try {
		price = Integer.parseInt(jtfPrice.getText().trim());
		}catch(NumberFormatException nfe) {
			JOptionPane.showMessageDialog(lav, "가격은 숫자만 입력가능합니다.");
			return;
		}//end catch
		
		if(jtaSpec.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(lav, "도시락 상세설명은 필수 입력!!!!");
			jtaSpec.setText("");
			jtaSpec.requestFocus();
			return;
		}//end if
//		System.out.println("--------------------");//값이 잘 들어가는지 확인용
		
		File file = new File(uploadImg);
		
		LunchAddVO lavo = new LunchAddVO(jtfName.getText().trim(),
				file.getName(), jtaSpec.getText().trim(), price);
		
		try {
			//이미지를, 사용하는 폴더로 복사 (=스트림 필요)
			uploadImg(file);
			//에러가 나면 catch로 빠져서 DB에 추가가 안됨
			LunchAdminDAO.getInstance().insertLunch(lavo);//에러가 나지 않는 경우 DB에 추가
			//리스트 갱신
			lmc.setLunch();
			
			JOptionPane.showMessageDialog(lav, "도시락이 추가되었습니다.");
		} catch (IOException ie) {
			JOptionPane.showMessageDialog(lav, "파일 업로드 실패");
			ie.printStackTrace();
		} catch (SQLException se) {
			JOptionPane.showMessageDialog(lav, "DB에서 문제가 발생하였습니다.");
			se.printStackTrace();
		}//end catch
		
	}//addLunch
	
	/**
	 * 큰 이미지명을 가진 File객체를 입력하여 업로드 폴더에 큰 이미지(ml_l1.gif)와 
	 * 작은 이미지(s_m1_l1.gif)를 업로드한다.
	 * @param file
	 */
	private void uploadImg(File file) throws IOException{
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
		
		}finally {
			if(fis!=null) {fis.close();}//end if
			if(fos!=null) {fos.close();}//end if
		}//end finally
	}//uploadImg

	
	private void setImg() {
		
		FileDialog fdOpen = new FileDialog(lav, "도시락이미지 선택", FileDialog.LOAD);
		fdOpen.setVisible(true);
		
		String path = fdOpen.getDirectory();
		String name=fdOpen.getFile();
		
		boolean flag = false;
		if(path!=null) {
			String[] extFlag = {"jpg","gif","jpeg","png","bmp"};
			for(String ext:extFlag) {
//				if(name.endsWith(ext.toLowerCase())) { //업로드 가능 확장자
				if(name.toLowerCase().endsWith(ext)) { //업로드 가능 확장자
					flag=true;
				}//end if
			}//end for
			if(flag) {
				uploadImg=path+name;
				lav.getJlLunchImg().setIcon(new ImageIcon(uploadImg));
				}else {
					JOptionPane.showMessageDialog(lav, name+"은 이미지가 아닙니다.");
				}//end else
					
		}//end if
	}//setImg
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==lav.getJbImg()) {
			setImg();
		}//end if
		if(ae.getSource()==lav.getJbAdd()) {
			addLunch();
		}//end if
		
		if(ae.getSource()==lav.getJbEnd()) {
			lav.dispose();
		}//end if
	}//actionPerformed
	
}//class
