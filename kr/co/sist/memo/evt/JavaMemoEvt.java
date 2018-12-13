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
		
		//새글 메뉴아이템에서 이벤트가 발생했을 때
		if(ae.getSource()==jm.getMiNew()) {
			newMemo();
		}//end if
		
		//열기 메뉴아이템에서 이벤트가 발생했을 때
		if(ae.getSource()==jm.getMiOpen()) {
			openMemo();
		}//end if
		
		//저장 메뉴아이템에서 이벤트가 발생했을 때
		if(ae.getSource()==jm.getMiSave()) {
			saveMemo();
		}//end if
		
		//다른이름으로저장 메뉴아이템에서 이벤트가 발생했을 때
		if(ae.getSource()==jm.getMiNewSave()) {
			newSaveMemo();
		}//end if
		
		//종료 메뉴아이템에서 이벤트가 발생했을 때
		if(ae.getSource()==jm.getMiEnd()) {
			jm.dispose();
		}//end if

		//서식 메뉴아이템에서 이벤트가 발생했을 때
		if(ae.getSource()==jm.getMiFormat()) {
			formatDialog();
		}//end if
		
		//도움말 메뉴아이템에서 이벤트가 발생했을 때
		if(ae.getSource()==jm.getMiHelp()) {
			helpDialog();
		}//end if
		
		
	}// actionPerformed

	/**
	 * 새글 : TextArea를 초기화
	 */
	public void newMemo() {
		jm.getTaNote().getText();
		jm.getTaNote().setText("");
		
		jm.setTitle("메모장 - 새글");
	}// newMemo

	/**
	 * txt파일 열기
	 */
	public void openMemo() {
		FileDialog fdOpen = new FileDialog(jm, "문서열기", FileDialog.LOAD);
		fdOpen.setVisible(true);
		
		String filePath=fdOpen.getDirectory();
		String fileName=fdOpen.getFile();
		
		if(filePath!=null) {//선택한파일이 있음
			//파일의 경로와 이름을 Frame에 TitleBar에 설정
			jm.setTitle("메모장 - 열기 "+filePath+fileName);			
		}//end if
	}// openMemo
	
	/**
	 * 작성한 메모 저장 - 기존의 파일명을 그대로 저장하는 파일명에 저장
	 */
	public void saveMemo() {
		newSaveMemo();
	}//saveMemo
	
	/**
	 * 파일명을 입력받아 새이름으로 저장
	 */
	public void newSaveMemo() {
		FileDialog fdSave = new FileDialog(jm, "문서저장", FileDialog.SAVE);
		fdSave.setVisible(true);
		
		String filePath=fdSave.getDirectory();
		String fileName=fdSave.getFile();
		
		if(filePath!=null) {//선택한파일이 있음
			//파일의 경로와 이름을 Frame에 TitleBar에 설정
			jm.setTitle("메모장 - 저장 "+filePath+fileName);			
		}//end if
	}//newSaveMemo
	
	/**
	 * 글꼴을 설정하는 다이얼로그를 실행하는 일
	 */
	public void formatDialog() {
		new MemoFormat(jm);
	}//formatDialog
	
	/**
	 * 메모장 정보를 제공하는 다이얼로그를 실행
	 */
	public void helpDialog() {
		new MemoHelp(jm);
	}//helpDialog
	
}// class
