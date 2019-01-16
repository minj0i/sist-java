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
	}//������

	@Override
	public void windowClosing(WindowEvent e) {
		lav.dispose();
	}//windowClosing
	
	
	/**
	 * �Է°��� �̹����� ������ �� ��ȿ�� ����(�̹���, ���ö���, ����, Ư������ �ԷµǾ��ٸ�)
	 */
	private void addLunch() {
		if(uploadImg.equals("")) {
			JOptionPane.showMessageDialog(lav, "�̹����� �������ּ���");
			return;
		}//end if
		
		JTextField jtfName = lav.getJtfLunchName();
		JTextField jtfPrice = lav.getJtfLunchPrice();
		JTextArea jtaSpec = lav.getJtaLunchSpec();
		
		if(jtfName.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(lav, "���ö� ���� �ʼ� �Է�!!!!");
			jtfName.setText("");
			jtfName.requestFocus();
			return;
		}//end if
		
		if(jtfPrice.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(lav, "���ö� ������ �ʼ� �Է�!!!!");
			jtfPrice.setText("");
			jtfPrice.requestFocus();
			return;
		}//end if
		
		//������ ���ڸ� �Էµǵ��� try~catch
		int price = 0;
		try {
		price = Integer.parseInt(jtfPrice.getText().trim());
		}catch(NumberFormatException nfe) {
			JOptionPane.showMessageDialog(lav, "������ ���ڸ� �Է°����մϴ�.");
			return;
		}//end catch
		
		if(jtaSpec.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(lav, "���ö� �󼼼����� �ʼ� �Է�!!!!");
			jtaSpec.setText("");
			jtaSpec.requestFocus();
			return;
		}//end if
//		System.out.println("--------------------");//���� �� ������ Ȯ�ο�
		
		File file = new File(uploadImg);
		
		LunchAddVO lavo = new LunchAddVO(jtfName.getText().trim(),
				file.getName(), jtaSpec.getText().trim(), price);
		
		try {
			//�̹�����, ����ϴ� ������ ���� (=��Ʈ�� �ʿ�)
			uploadImg(file);
			//������ ���� catch�� ������ DB�� �߰��� �ȵ�
			LunchAdminDAO.getInstance().insertLunch(lavo);//������ ���� �ʴ� ��� DB�� �߰�
			//����Ʈ ����
			lmc.setLunch();
			
			JOptionPane.showMessageDialog(lav, "���ö��� �߰��Ǿ����ϴ�.");
		} catch (IOException ie) {
			JOptionPane.showMessageDialog(lav, "���� ���ε� ����");
			ie.printStackTrace();
		} catch (SQLException se) {
			JOptionPane.showMessageDialog(lav, "DB���� ������ �߻��Ͽ����ϴ�.");
			se.printStackTrace();
		}//end catch
		
	}//addLunch
	
	/**
	 * ū �̹������� ���� File��ü�� �Է��Ͽ� ���ε� ������ ū �̹���(ml_l1.gif)�� 
	 * ���� �̹���(s_m1_l1.gif)�� ���ε��Ѵ�.
	 * @param file
	 */
	private void uploadImg(File file) throws IOException{
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
		
		}finally {
			if(fis!=null) {fis.close();}//end if
			if(fos!=null) {fos.close();}//end if
		}//end finally
	}//uploadImg

	
	private void setImg() {
		
		FileDialog fdOpen = new FileDialog(lav, "���ö��̹��� ����", FileDialog.LOAD);
		fdOpen.setVisible(true);
		
		String path = fdOpen.getDirectory();
		String name=fdOpen.getFile();
		
		boolean flag = false;
		if(path!=null) {
			String[] extFlag = {"jpg","gif","jpeg","png","bmp"};
			for(String ext:extFlag) {
//				if(name.endsWith(ext.toLowerCase())) { //���ε� ���� Ȯ����
				if(name.toLowerCase().endsWith(ext)) { //���ε� ���� Ȯ����
					flag=true;
				}//end if
			}//end for
			if(flag) {
				uploadImg=path+name;
				lav.getJlLunchImg().setIcon(new ImageIcon(uploadImg));
				}else {
					JOptionPane.showMessageDialog(lav, name+"�� �̹����� �ƴմϴ�.");
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
