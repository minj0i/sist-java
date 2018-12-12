package kr.co.sist.memo.view;

import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.TextArea;


/**
 * 사용자가 간단한 메모를 작성, 파일로 저장, 파일에서 읽어들이는 기능이 구현된
 * 메모장 
 * @author owner
 */
@SuppressWarnings("serial")
public class JavaMemo extends Frame {
	private Menu MenuFile,menuEdit,menuHelp;
	private MenuItem miNew, miOpen, miSave, miNewSave, miEnd, miFormat, miHelp;
	private TextArea taNote;
	
	public JavaMemo() {
		
	}//JavaMemo
	
	public Menu getMenuFile() {
		return MenuFile;
	}
	public Menu getMenuEdit() {
		return menuEdit;
	}
	public Menu getMenuHelp() {
		return menuHelp;
	}
	public MenuItem getMiNew() {
		return miNew;
	}
	public MenuItem getMiOpen() {
		return miOpen;
	}
	public MenuItem getMiSave() {
		return miSave;
	}
	public MenuItem getMiNewSave() {
		return miNewSave;
	}
	public MenuItem getMiEnd() {
		return miEnd;
	}
	public MenuItem getMiFormat() {
		return miFormat;
	}
	public MenuItem getMiHelp() {
		return miHelp;
	}
	public TextArea getTaNote() {
		return taNote;
	}
	
	
}//class
