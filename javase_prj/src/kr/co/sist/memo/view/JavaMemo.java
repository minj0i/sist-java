package kr.co.sist.memo.view;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;

import kr.co.sist.memo.evt.JavaMemoEvt;


/**
 * ����ڰ� ������ �޸� �ۼ�, ���Ϸ� ����, ���Ͽ��� �о���̴� ����� ������
 * �޸��� 
 * @author owner
 */
@SuppressWarnings("serial")
public class JavaMemo extends Frame {
	private Menu menuFile,menuEdit,menuHelp;
	private MenuItem miNew, miOpen, miSave, miNewSave, miEnd, miFormat, miHelp;
	private TextArea taNote;
	
	public JavaMemo(Font font) {
		super("�޸��� - �������");
		
		//�޴� ���� - add�Ǳ� ������ ������ָ� ��
		menuFile = new Menu("����");
		menuEdit = new Menu("����");
		menuHelp = new Menu("����");
		
		//�޴������� ����
		miNew=new MenuItem("����");
		miOpen=new MenuItem("����");
		miSave=new MenuItem("����");
		miNewSave=new MenuItem("�ٸ� �̸����� ����");
		miEnd=new MenuItem("����");
		miFormat=new MenuItem("�۲�");
		miHelp=new MenuItem("����");
		
		//TextArea����
		taNote = new TextArea(); 
		//�Ű������� ������ Font�� �����Ͽ� TextArea�� Font�� �����Ѵ�.
		if(font!=null) {
			taNote.setFont(font);
		}//end if
		
		//��ġ
		//�޴��������� �޴��� ��ġ
		menuFile.add(miNew);
		menuFile.addSeparator();
		menuFile.add(miOpen);
		menuFile.add(miSave);
		menuFile.add(miNewSave);
		menuFile.addSeparator();
		menuFile.add(miEnd);
		
		menuEdit.add(miFormat);
		
		menuHelp.add(miHelp);
		
		//�޴��� �޴��ٿ� ��ġ
		MenuBar mb = new MenuBar();
		mb.add(menuFile);
		mb.add(menuEdit);
		mb.add(menuHelp);
		
		//�޴��ٸ� Frame ��ġ
		setMenuBar(mb);
		//T.A�� BorderLayout�� center�� ��ġ
		add("Center",taNote);
		
		JavaMemoEvt jme = new JavaMemoEvt(this);
		//�����������̺�Ʈ ���
		addWindowListener(jme);
		//�޴��������̺�Ʈ ���
		miNew.addActionListener(jme);
		miOpen.addActionListener(jme);
		miSave.addActionListener(jme);
		miNewSave.addActionListener(jme);
		miEnd.addActionListener(jme);
		miFormat.addActionListener(jme);
		miHelp.addActionListener(jme);
		
		//������ ũ�� ����
		setBounds(10,10,900,600);
		setVisible(true);
			
	}//JavaMemo
	
	//�޴��� �ۿ��� ����� �ʿ䰡 ���� ������ ����
//	public Menu getMenuFile() {
//		return menuFile;
//	}
//	public Menu getMenuEdit() {
//		return menuEdit;
//	}
//	public Menu getMenuHelp() {
//		return menuHelp;
//	}
	
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
