package kr.co.sist.memo.evt;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import kr.co.sist.memo.view.JavaMemo;
import kr.co.sist.memo.view.MemoFormat;
import kr.co.sist.memo.view.MemoHelp;

public class JavaMemoEvt extends WindowAdapter implements ActionListener {

	private JavaMemo jm;

	public JavaMemoEvt(JavaMemo jm) {
		this.jm = jm;
	}// JavaMemoEvt

	@Override
	public void windowClosing(WindowEvent we) {
		jm.dispose();
	}// windowClosing

	@Override
	public void actionPerformed(ActionEvent ae) {
		//miNew, miOpen, miSave, miNewSave
		//miEnd, miFormat, miHelp
		
		//���� �޴������ۿ��� �̺�Ʈ�� �߻����� ��
		if(ae.getSource()==jm.getMiNew()) {
			newMemo();
		}//end if
		
		//���� �޴������ۿ��� �̺�Ʈ�� �߻����� ��
		if(ae.getSource()==jm.getMiOpen()) {
			openMemo();
		}//end if
		
		//���� �޴������ۿ��� �̺�Ʈ�� �߻����� ��
		if(ae.getSource()==jm.getMiSave()) {
			saveMemo();
		}//end if
		
		//�ٸ��̸��������� �޴������ۿ��� �̺�Ʈ�� �߻����� ��
		if(ae.getSource()==jm.getMiNewSave()) {
			newSaveMemo();
		}//end if
		
		//���� �޴������ۿ��� �̺�Ʈ�� �߻����� ��
		if(ae.getSource()==jm.getMiEnd()) {
			jm.dispose();
		}//end if

		//���� �޴������ۿ��� �̺�Ʈ�� �߻����� ��
		if(ae.getSource()==jm.getMiFormat()) {
			formatDialog();
		}//end if
		
		//���� �޴������ۿ��� �̺�Ʈ�� �߻����� ��
		if(ae.getSource()==jm.getMiHelp()) {
			helpDialog();
		}//end if
		
		
	}// actionPerformed

	/**
	 * ���� : TextArea�� �ʱ�ȭ
	 */
	public void newMemo() {
		jm.getTaNote().getText();
		jm.getTaNote().setText("");
		
		jm.setTitle("�޸��� - ����");
	}// newMemo

	/**
	 * txt���� ����
	 */
	public void openMemo() {
		FileDialog fdOpen = new FileDialog(jm, "��������", FileDialog.LOAD);
		fdOpen.setVisible(true);
		
		String filePath=fdOpen.getDirectory();
		String fileName=fdOpen.getFile();
		
		if(filePath!=null) {//������������ ����
			//������ ��ο� �̸��� Frame�� TitleBar�� ����
			jm.setTitle("�޸��� - ���� "+filePath+fileName);			
		}//end if
	}// openMemo
	
	/**
	 * �ۼ��� �޸� ���� - ������ ���ϸ��� �״�� �����ϴ� ���ϸ� ����
	 */
	public void saveMemo() {
		newSaveMemo();
	}//saveMemo
	
	/**
	 * ���ϸ��� �Է¹޾� ���̸����� ����
	 */
	public void newSaveMemo() {
		FileDialog fdSave = new FileDialog(jm, "��������", FileDialog.SAVE);
		fdSave.setVisible(true);
		
		String filePath=fdSave.getDirectory();
		String fileName=fdSave.getFile();
		
		if(filePath!=null) {//������������ ����
			//������ ��ο� �̸��� Frame�� TitleBar�� ����
			jm.setTitle("�޸��� - ���� "+filePath+fileName);			
		}//end if
	}//newSaveMemo
	
	/**
	 * �۲��� �����ϴ� ���̾�α׸� �����ϴ� ��
	 */
	public void formatDialog() {
		new MemoFormat(jm);
	}//formatDialog
	
	/**
	 * �޸��� ������ �����ϴ� ���̾�α׸� ����
	 */
	public void helpDialog() {
		new MemoHelp(jm);
	}//helpDialog
	
}// class
