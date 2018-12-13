package kr.co.sist.memo.view;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Label;
import java.awt.List;
import java.awt.TextField;

import kr.co.sist.memo.evt.MemoFormatEvt;

@SuppressWarnings("serial")
public class MemoFormat extends Dialog {
	private JavaMemo jm;
	private TextField tfFontText,tfStyleText,tfSizeText;
	private Label lblPreview;
	private Button btnYes, btnNo;
	private List listFont, listStyle, listSize;
	
	public MemoFormat(JavaMemo jm) {
		super(jm, "글꼴", true);
		this.jm=jm;

		//부모창 JavaMemo에 T.A의 글꼴 정보를 가져와서 TextField에 설정
		Font fontTa = jm.getTaNote().getFont();//부모창의 T.A글꼴정보를 가져와 담음
		Label lblFont = new Label("글꼴");
		Label lblStyle = new Label("글꼴 스타일");
		Label lblSize = new Label("크기");
		Label lblSee = new Label("보기");
		lblPreview = new Label("AaBbYyZz");
		lblPreview.setFont(fontTa);
				
		String[] arrStyle = {"일반","굵게","기울임꼴","굵은 기울임꼴"}; 
		tfFontText = new TextField(fontTa.getFamily());
		tfStyleText = new TextField(arrStyle[fontTa.getStyle()]);
		tfSizeText = new TextField(String.valueOf(fontTa.getSize()));
		
		btnYes = new Button("확인");
		btnNo = new Button("취소");

		listFont = new List();
		listStyle = new List();
		listSize = new List();
		//ListFont추가
		listFont.add("Dialog");
		listFont.add("Serif");
		listFont.add("SansSerif");
		listFont.add("Monospaced");
		listFont.add("DialogInput");
		
		//ListStyle추가 - 위랑 정보일치 시켜줌
		for(String style:arrStyle) {
			listStyle.add(style);
		}
	
		//ListSize추가
		int i = 0;
		String temp = "";
		for (i = 2; i < 11; i++) {
			temp = String.valueOf(i);
			listSize.add(temp);
			i = i + 1;
		}//end for
		for (i = 11; i < 81; i++) {
			temp = String.valueOf(i);
			listSize.add(temp);
		}//end for

		setLayout(null);

		lblFont.setBounds(27, 50, 80, 20);
		tfFontText.setBounds(30, 70, 90, 20);

		lblStyle.setBounds(155, 50, 80, 20);
		tfStyleText.setBounds(155, 70, 90, 20);

		lblSize.setBounds(280, 50, 80, 20);
		tfSizeText.setBounds(280, 70, 90, 20);

		lblSee.setBounds(160, 210, 80, 20);
		lblPreview.setBounds(160, 230, 120, 70);

		listFont.setBounds(30, 100, 90, 85);
		listStyle.setBounds(155, 100, 90, 85);
		listSize.setBounds(280, 100, 90, 85);

		btnYes.setBounds(230, 305, 45, 30);
		btnNo.setBounds(300, 305, 45, 30);

		add(lblFont);
		add(tfFontText);
		add(listFont);

		add(lblStyle);
		add(tfStyleText);
		add(listStyle);

		add(lblSize);
		add(tfSizeText);
		add(listSize);

		add(lblSee);
		add(lblPreview);

		add(btnYes);
		add(btnNo);

		//이벤트 등록
		MemoFormatEvt mfe = new MemoFormatEvt(this);
		btnYes.addActionListener(mfe);
		btnNo.addActionListener(mfe);
		
		listFont.addItemListener(mfe);
		listStyle.addItemListener(mfe);
		listSize.addItemListener(mfe);
		
		addWindowListener(mfe);
		
		setBounds(jm.getX()+150,jm.getY()+80, 400, 350);
		setResizable(false);
		setVisible(true);

	}//MemoFormat

	public JavaMemo getJm() {
		return jm;
	}

	public TextField getTfFontText() {
		return tfFontText;
	}

	public TextField getTfStyleText() {
		return tfStyleText;
	}

	public TextField getTfSizeText() {
		return tfSizeText;
	}

	public Label getLblPreview() {
		return lblPreview;
	}

	public Button getBtnYes() {
		return btnYes;
	}

	public Button getBtnNo() {
		return btnNo;
	}

	public List getListFont() {
		return listFont;
	}

	public List getListStyle() {
		return listStyle;
	}

	public List getListSize() {
		return listSize;
	}

}//class
