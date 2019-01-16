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
 * ���ö� ���̺��� ���õ� ���ö��� �� ������ ����ϰ� ����, ������ �� �� �ִ� â
 * @author owner
 */
@SuppressWarnings("serial")
public class LunchAddView extends JDialog {

	private JLabel jlLunchImg;
	private JTextField jtfLunchName, jtfLunchPrice;
	private JTextArea jtaLunchSpec;
	private JButton jbImg, jbAdd, jbEnd;
	
	public LunchAddView(LunchMainView lmv, LunchMainController lmc) {//LunchDetailView�� �ٸ��� : ������ ������ ���� ���� �ƴϱ� ������ LunchDetailVO ldvo�� ����
		super(lmv, "���ö� ���� �߰�", true);//���
		
		ImageIcon iiLunch = new ImageIcon("C:/dev/workspace/lunch_prj/src/kr/co/sist/lunch/admin/img/no_img.jpg");
		jlLunchImg = new JLabel(iiLunch);
		jtfLunchName = new JTextField();
		jtfLunchPrice = new JTextField();
		
		jtaLunchSpec = new JTextArea();
		
		jbImg = new JButton("�̹��� ����");
		jbAdd = new JButton("�߰�");
		jbEnd = new JButton("â �ݱ�");
		
		JScrollPane jspTaSpec = new JScrollPane(jtaLunchSpec);
		
		setLayout(null);	
		
		JLabel jlDetailTitle = new JLabel("���ö� ���� �߰�");
		jlDetailTitle.setFont(new Font("Dialog", Font.BOLD, 25));
		
		//��ġ
		jlDetailTitle.setBounds(10,25,250,30);
		jlLunchImg.setBounds(10,60,244,220);
		jbImg.setBounds(80, 290, 120, 25);
		
		JLabel jlLunchName  = new JLabel("���ö���");
		JLabel jlLunchPrice  = new JLabel("����");
		JLabel jlLunchSpec  = new JLabel("Ư����");
		
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
		
		//�̺�Ʈ���
		LunchAddController lac = new LunchAddController(this, lmc);
		addWindowListener(lac);
		jbImg.addActionListener(lac);
		jbAdd.addActionListener(lac);
		jbEnd.addActionListener(lac);
		
		setBounds(lmv.getX()+100, lmv.getY()+50, 550, 380);
		setVisible(true);
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Dialog�� ���� ���� EXIT_ON_CLOSE�� �ƴ�
		//���̾�α׸� ������ ���� JFrame�� �ٸ��� DISPOSE_ON_CLOSE�� �ݴ´�.
		//defaultCloseOperation must be one of: DO_NOTHING_ON_CLOSE, HIDE_ON_CLOSE, or DISPOSE_ON_CLOSE
		//������ �� �ϰ����� ������ �����̺�Ʈ ó��
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
