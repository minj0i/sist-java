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
		super(jm, "도움말", true);
		this.jm=jm;

		taHelp = new TextArea("메모장 정보\n이 메모장은 Java로 만들어졌으며\r\n" + 
				"누구나 코드 수정 및 배포를 할 수 있습니다.\r\n" + 
				"단, 이 코드를 사용하여 개선했을 때에는\r\n" + 
				"소스공개를 원칙으로 한다. (GNU)\r\n" + 
				"작성자: 댄스머신 정택성\r\n" + 
				"Version: 0.9");
		btnConfirm = new Button("확인");
		
		setLayout(null);
		taHelp.setBounds(20,40,360,250);
		btnConfirm.setBounds(175,310,40,20);
		
		add(taHelp);
		add(btnConfirm);
		
	
		//이벤트 등록
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
