package kr.co.sist.lunch.admin.view;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import kr.co.sist.lunch.admin.controller.LunchAddController;
import kr.co.sist.lunch.admin.controller.LunchMainController;

/**
 * 도시락 테이블에서 선택된 도시락의 상세 정보를 출력하고 수정, 삭제를 할 수 있는 창
 * @author owner
 */
@SuppressWarnings("serial")
public class LunchAddView extends JDialog {

	private JLabel jlLunchImg;
	private JTextField jtfLunchName, jtfLunchPrice;
	private JTextArea jtaLunchSpec;
	private JButton jbImg, jbAdd, jbEnd;
	
	public LunchAddView(LunchMainView lmv, LunchMainController lmc) {//LunchDetailView와 다른점 : 정보를 가지고 오는 것이 아니기 때문에 LunchDetailVO ldvo를 지움
		super(lmv, "도시락 정보 추가", true);//모달
		
		ImageIcon iiLunch = new ImageIcon("C:/dev/workspace/lunch_prj/src/kr/co/sist/lunch/admin/img/no_img.jpg");
		jlLunchImg = new JLabel(iiLunch);
		jtfLunchName = new JTextField();
		jtfLunchPrice = new JTextField();
		
		jtaLunchSpec = new JTextArea();
		
		jbImg = new JButton("이미지 선택");
		jbAdd = new JButton("추가");
		jbEnd = new JButton("창 닫기");
		
		JScrollPane jspTaSpec = new JScrollPane(jtaLunchSpec);
		
		setLayout(null);	
		
		JLabel jlDetailTitle = new JLabel("도시락 정보 추가");
		jlDetailTitle.setFont(new Font("Dialog", Font.BOLD, 25));
		
		//배치
		jlDetailTitle.setBounds(10,25,250,30);
		jlLunchImg.setBounds(10,60,244,220);
		jbImg.setBounds(80, 290, 120, 25);
		
		JLabel jlLunchName  = new JLabel("도시락명");
		JLabel jlLunchPrice  = new JLabel("가격");
		JLabel jlLunchSpec  = new JLabel("특장점");
		
		jlLunchName.setBounds(270,65,80,25);
		jlLunchPrice.setBounds(270,95,80,25);
		jlLunchSpec.setBounds(270,125,80,25);
		
		jtfLunchName.setBounds(340,65,185,25);
		jtfLunchPrice.setBounds(340,95,185,25);
		jspTaSpec.setBounds(340,125,185,100);
		
		jbAdd.setBounds(320,300,80,30);
		jbEnd.setBounds(410,300,80,30);
		
		add(jlDetailTitle);
		add(jlLunchImg);
		add(jbImg);
		add(jlLunchName);
		add(jlLunchPrice);
		add(jlLunchSpec);
		add(jtfLunchName);
		add(jtfLunchPrice);
		add(jspTaSpec);
		add(jbAdd);
		add(jbEnd);
		
		//이벤트등록
		LunchAddController lac = new LunchAddController(this, lmc);
		addWindowListener(lac);
		jbImg.addActionListener(lac);
		jbAdd.addActionListener(lac);
		jbEnd.addActionListener(lac);
		
		setBounds(lmv.getX()+100, lmv.getY()+50, 550, 380);
		setVisible(true);
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Dialog를 넣을 때는 EXIT_ON_CLOSE가 아님
		//다이얼로그를 종료할 때는 JFrame과 다르게 DISPOSE_ON_CLOSE로 닫는다.
		//defaultCloseOperation must be one of: DO_NOTHING_ON_CLOSE, HIDE_ON_CLOSE, or DISPOSE_ON_CLOSE
		//디자인 다 하고나서는 윈도우 종료이벤트 처리
//		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}//LunchDetailView(lmv)

	public JLabel getJlLunchImg() {
		return jlLunchImg;
	}

	public JTextField getJtfLunchName() {
		return jtfLunchName;
	}

	public JTextField getJtfLunchPrice() {
		return jtfLunchPrice;
	}

	public JTextArea getJtaLunchSpec() {
		return jtaLunchSpec;
	}

	public JButton getJbImg() {
		return jbImg;
	}

	public JButton getJbAdd() {
		return jbAdd;
	}

	public JButton getJbEnd() {
		return jbEnd;
	}

	
}//class
