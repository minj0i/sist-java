package day0109.hwk;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class WriteQueryView extends JFrame{
	
	private JTextField jtfTableName, jtfColumnName, jtfDataSize, jtfConstraintName;//���̺��, �÷���, ������ ũ��, ��������
	private JComboBox<String> jcbDataTypeSelect, jcbConstraintSelect;//��������, �������
	//varchar2, char, number, date
	//null, primary key, unique, not null
	private JButton jbtTableAdd, jbtColumnAdd;//�߰�(���̺�), �߰�(�÷�)
	private JButton jbtTableCreate, jbtReset;//���̺����, �ʱ�ȭ
	private JTextArea jtaQueryView;
	
	
	public WriteQueryView() {
		jtfTableName = new JTextField(10);
		jbtTableAdd = new JButton("�߰�");
		JPanel firstNorth = new JPanel();
		firstNorth.add(new JLabel("���̺��"));
		firstNorth.add(jtfTableName);
		firstNorth.add(jbtTableAdd);
		
		jtfColumnName = new JTextField(10);
		jcbDataTypeSelect = new JComboBox<String>();
		jtfDataSize = new JTextField(5);
		JPanel secondNorth = new JPanel();
		
		secondNorth.add(new JLabel("�÷���"));
		secondNorth.add(jtfColumnName);
		secondNorth.add(new JLabel("��������"));
		secondNorth.add(jcbDataTypeSelect);
		secondNorth.add(new JLabel("ũ��"));
		secondNorth.add(jtfDataSize);
		
		jcbConstraintSelect = new JComboBox<String>();
		jtfConstraintName = new JTextField(10);
		jbtColumnAdd = new JButton("�߰�");
		JPanel thirdNorth = new JPanel();
		thirdNorth.add(new JLabel("�������"));
		thirdNorth.add(jcbConstraintSelect);
		thirdNorth.add(new JLabel("������׸�"));
		thirdNorth.add(jtfConstraintName);
		thirdNorth.add(jbtColumnAdd);
		
		JPanel jplNorth = new JPanel(new GridLayout(3, 1));
		jplNorth.add(firstNorth);
		jplNorth.add(secondNorth);
		jplNorth.add(thirdNorth);
		
		jtaQueryView = new JTextArea();
		jtaQueryView.setEditable(false);
		
		jbtTableCreate = new JButton("���̺����");
		jbtReset = new JButton("�ʱ�ȭ");
		JPanel jplSouth = new JPanel();
		jplSouth.add(jbtTableCreate);
		jplSouth.add(jbtReset);
		
		add("North", jplNorth);
		add("Center", jtaQueryView);
		add("South", jplSouth);
		
		WriteQueryEvt wqe = new WriteQueryEvt(this);
		jcbDataTypeSelect.addActionListener(wqe);
		jcbConstraintSelect.addActionListener(wqe);
		jbtTableAdd.addActionListener(wqe);
		jbtColumnAdd.addActionListener(wqe);
		jbtTableCreate.addActionListener(wqe);
		jbtReset.addActionListener(wqe);
		addWindowListener(wqe);
		
		setBounds(100, 100, 600, 700);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new WriteQueryView();
	}

	public JTextField getjtfTableName() {
		return jtfTableName;
	}

	public JTextField getjtfColumnName() {
		return jtfColumnName;
	}

	public JTextField getjtfDataSize() {
		return jtfDataSize;
	}

	public JTextField getjtfConstraintName() {
		return jtfConstraintName;
	}

	public JComboBox<String> getJcbDataTypeSelect() {
		return jcbDataTypeSelect;
	}

	public JComboBox<String> getJcbConstraintSelect() {
		return jcbConstraintSelect;
	}

	public JButton getJbtTableAdd() {
		return jbtTableAdd;
	}

	public JButton getJbtColumnAdd() {
		return jbtColumnAdd;
	}

	public JButton getJbtTableCreate() {
		return jbtTableCreate;
	}

	public JButton getJbtReset() {
		return jbtReset;
	}

	public JTextArea getJtaQueryView() {
		return jtaQueryView;
	}

	
}
