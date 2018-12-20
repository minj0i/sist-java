package kr.co.sist.memo.evt;

import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import kr.co.sist.memo.view.MemoFormat;

public class MemoFormatEvt extends WindowAdapter implements ActionListener, ItemListener {

	private MemoFormat mf;
	
	public MemoFormatEvt(MemoFormat mf) {
		this.mf=mf;
	}//MemoFormatEvt
	
	@Override
	public void windowClosing(WindowEvent we) {
		mf.dispose();
	}//windowClosing
	
	@Override
	public void itemStateChanged(ItemEvent ie) {
		String selectedValue = ((List)ie.getSource()).getSelectedItem();//List�� �޾ƿ;ߵ����� �ѹ��� �ذ�
		
//		System.out.println(selectedValue);
		Font temp = mf.getLblPreview().getFont();
		String font = temp.getFamily();
		int style=temp.getStyle();
		int size=temp.getSize();
		
		//������ �������� T.F�� ������ �����Ѵ�.
		//�̸����� ���� ����
		if(ie.getSource()==mf.getListFont()) {
			mf.getTfFontText().setText(selectedValue);
			font = selectedValue;
		}//end if
		if(ie.getSource()==mf.getListStyle()) {
			mf.getTfStyleText().setText(selectedValue);
			style = ((List)ie.getSource()).getSelectedIndex();
		}//end if
		if(ie.getSource()==mf.getListSize()) {
			mf.getTfSizeText().setText(selectedValue);
			size=Integer.parseInt(selectedValue);
		}//end if
		//������ ���� �� ����� ������ ������ Preview�� �۲� ������ �����Ѵ�.
		mf.getLblPreview().setFont(new Font(font, style, size));
	}//itemStateChanged

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==mf.getBtnYes()) {//������ �۲� ������ �����ϰڽ��ϴ�.
			setTaNoteFont();
		}//end if
		if(ae.getSource()==mf.getBtnNo()) {//����
			mf.dispose();
		}//end if
	}//actionPerformed

	/**
	 * MemoFormat Ŭ������ �̸����� Label�� Font������
	 * JavaMemoŬ������ TextArea�� ����
	 */
	public void setTaNoteFont() {
		mf.getJm(/*JavaMemo*/).getTaNote().setFont(mf.getLblPreview().getFont());
		try {
			fontStatusSave();//������ �۲� ���������� ����
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
		mf.dispose();
	}//setTaNoteFont
	
	/**
	 * ������ ��Ʈ�� ���¸� ���Ϸ� ���� - �������� ���α׷��� ����Ǹ�
	 * ���� ����� ��Ʈ���� �����Ͽ� TA�� �����ϸ� ������°� �����ȴ�.
	 */
	private void fontStatusSave() throws IOException {
		BufferedWriter bw = null;
		try {
			//�̸������� �󺧿� ������ ��Ʈ������ ��´�.
			Font fontTemp = mf.getLblPreview().getFont();
			
			StringBuilder fontData = new StringBuilder();
			fontData.append(fontTemp.getFamily())
			.append(",").append(fontTemp.getStyle()).append(",")
			.append(fontTemp.getSize());
			
			bw = new BufferedWriter(new FileWriter("c:/dev/temp/memo.dat"));
			bw.write(fontData.toString());
			bw.flush();
			
		}finally {
			if(bw!=null) {bw.close();}//end if
		}//end finally
	}//fontStatusSave
	
}//class
