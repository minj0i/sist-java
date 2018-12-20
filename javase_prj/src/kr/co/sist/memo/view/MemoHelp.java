package kr.co.sist.memo.view;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.TextArea;

import kr.co.sist.memo.evt.MemoHelpEvt;

@SuppressWarnings("serial")
public class MemoHelp extends Dialog {
	private JavaMemo jm;
	private TextArea taHelp;
	private Button btnConfirm;
	
	public MemoHelp(JavaMemo jm) {
		super(jm, "����", true);
		this.jm=jm;

		taHelp = new TextArea("�޸��� ����\n�� �޸����� Java�� �����������\r\n" + 
				"������ �ڵ� ���� �� ������ �� �� �ֽ��ϴ�.\r\n" + 
				"��, �� �ڵ带 ����Ͽ� �������� ������\r\n" + 
				"�ҽ������� ��Ģ���� �Ѵ�. (GNU)\r\n" + 
				"�ۼ���: ���ӽ� ���ü�\r\n" + 
				"Version: 0.9");
		btnConfirm = new Button("Ȯ��");
		
		setLayout(null);
		taHelp.setBounds(20,40,360,250);
		btnConfirm.setBounds(175,310,40,20);
		
		add(taHelp);
		add(btnConfirm);
		
	
		//�̺�Ʈ ���
		MemoHelpEvt mhe = new MemoHelpEvt(this);
		btnConfirm.addActionListener(mhe);

		addWindowListener(mhe);
		
		setBounds(jm.getX()+150,jm.getY()+80, 400, 350);
		setResizable(false);
		taHelp.setEditable(false);
		setVisible(true);
	}//MemoFormat

		
	public JavaMemo getJm() {
		return jm;
	}

	public TextArea getTaHelp() {
		return taHelp;
	}

	public Button getBtnConfirm() {
		return btnConfirm;
	}


}//class
