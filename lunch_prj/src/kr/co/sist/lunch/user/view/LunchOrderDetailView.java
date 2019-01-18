package kr.co.sist.lunch.user.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.lunch.admin.controller.LunchDetailController;
import kr.co.sist.lunch.user.controller.LunchOrderDetailController;
import kr.co.sist.lunch.user.vo.LunchDetailVO;
@SuppressWarnings("serial")
public class LunchOrderDetailView extends JDialog{
	
	private JLabel jlLunchImg;
	private JTextField jtfLunchName, jtfLunchPrice, jtfOrderName, jtfPhone, jtfTotalPrice;
	private JTextArea jtaLunchSpec;
	private JButton jbOrder, jbEnd;
	private JComboBox<Integer> jbQuan;
	
	public LunchOrderDetailView(LunchClientView lcv, LunchDetailVO ldvo) {
		super(lcv, ldvo.getLunchName()+"도시락 상세 정보", true);
		
		ImageIcon iiLunch = new ImageIcon("C:/dev/workspace/lunch_prj/src/kr/co/sist/lunch/user/img/"+ldvo.getImg());
		jlLunchImg = new JLabel(iiLunch);
		
		jtfLunchName = new JTextField(ldvo.getLunchName());
		jtfLunchPrice = new JTextField(String.valueOf(ldvo.getPrice()));
		jtfOrderName = new JTextField();
		jtfPhone = new JTextField();
		jtfTotalPrice = new JTextField(String.valueOf(ldvo.getPrice()));
		
		jtaLunchSpec = new JTextArea(ldvo.getSpec());
		jtaLunchSpec.setEditable(false);
		jtaLunchSpec.setBackground(Color.WHITE);
		
		jtaLunchSpec.setLineWrap(true);
		
		jbOrder = new JButton("주문");
		jbEnd = new JButton("창 닫기");
		
		JScrollPane jspTaSpec = new JScrollPane(jtaLunchSpec);
		setLayout(null);
		
		JLabel jlDetailTitle = new JLabel("도시락 상세정보");
		jlDetailTitle.setFont(new Font("Dialog", Font.BOLD, 25));
		
		JLabel jlLunchName  = new JLabel("도시락명");
		JLabel jlLunchPrice  = new JLabel("가격");
		JLabel jlLunchQuan  = new JLabel("수량");
		JLabel jlOrderName  = new JLabel("주문자명");
		JLabel jlOrderTel  = new JLabel("전화번호");
		JLabel jlLunchTotalPrice  = new JLabel("총가격");
		JLabel jlLunchSpec = new JLabel("특장점");
		
		
		DefaultComboBoxModel<Integer> dlmQuan = new DefaultComboBoxModel<Integer>();
		for(int i=1; i<11; i++) {
			dlmQuan.addElement(new Integer(i));
		}//end for
		jbQuan = new JComboBox<Integer>(dlmQuan);
		jbQuan.setBackground(Color.WHITE);
		
		//배치
		jlDetailTitle.setBounds(10,25,250,30);
		jlLunchImg.setBounds(10,60,244,220);
		
		jlLunchName.setBounds(270,65,80,25);
		jlLunchPrice.setBounds(270,95,80,25);
		jlLunchQuan.setBounds(270,125,80,25);
		jlLunchTotalPrice.setBounds(270,155,80,25);
		jlLunchSpec.setBounds(270,185,80,25);
		jlOrderName.setBounds(270,250,80,25);
		jlOrderTel.setBounds(270,285,80,25);
		
		jtfLunchName.setBounds(340,65,185,25);
		jtfLunchName.setEditable(false);
		jtfLunchName.setBackground(Color.WHITE);
		
		jtfLunchPrice.setBounds(340,95,95,25);
		jtfLunchPrice.setEditable(false);
		jtfLunchPrice.setBackground(Color.WHITE);
		
		jbQuan.setBounds(340,125,185,25);
		
		jtfTotalPrice.setBounds(340,155,185,25);
		jtfTotalPrice.setEditable(false);
		jtfTotalPrice.setBackground(Color.WHITE);
		
		jspTaSpec.setBounds(340, 185, 185, 60);
		
		jtfOrderName.setBounds(340, 250, 185, 30);
		jtfPhone.setBounds(340, 285, 185, 30);
		
		jbOrder.setBounds(320,350,80,30);
		jbEnd.setBounds(410,350,80,30);
		
		add(jlDetailTitle); 		add(jlLunchImg);
		add(jlLunchName);		add(jtfLunchName);
		add(jlLunchPrice);		add(jtfLunchPrice);
		add(jlLunchQuan); 		add(jbQuan);
		add(jlLunchTotalPrice);		add(jtfTotalPrice);
		add(jlLunchSpec);		add(jspTaSpec);
		add(jlOrderName);		add(jtfOrderName);
		add(jlOrderTel);		add(jtfPhone);
		add(jbOrder);
		add(jbEnd);
		
		//이벤트추가
		LunchOrderDetailController lodc = new LunchOrderDetailController(this, ldvo.getLunchCode());
		addWindowListener(lodc);
		
		jbQuan.addActionListener(lodc);
		jbOrder.addActionListener(lodc);
		jbEnd.addActionListener(lodc);
		
		setBounds(lcv.getX(), lcv.getY(), 550, 450);
		setVisible(true);
	}//LunchOrderDetailView

	public JLabel getJlLunchImg() {
		return jlLunchImg;
	}

	public JTextField getJtfLunchName() {
		return jtfLunchName;
	}

	public JTextField getJtfLunchPrice() {
		return jtfLunchPrice;
	}

	public JTextField getJtfOrderName() {
		return jtfOrderName;
	}

	public JTextField getJtfPhone() {
		return jtfPhone;
	}

	public JTextField getJtfTotalPrice() {
		return jtfTotalPrice;
	}

	public JTextArea getJtaLunchSpec() {
		return jtaLunchSpec;
	}

	public JButton getJbOrder() {
		return jbOrder;
	}

	public JButton getJbEnd() {
		return jbEnd;
	}

	public JComboBox<Integer> getJbQuan() {
		return jbQuan;
	}
	
	
}//class
