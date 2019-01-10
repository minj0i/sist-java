package day0109.hwk;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TableCreateView extends JFrame{
	
	private JLabel jlTableName, jlColumnName, jlDataType, jlDataLength, jlConstraint, jlConName;
	private JTextField jtTableName, jtColumnName, jtDataLength, jtConstraintName;
	private JButton jbTableAdd, jbConstraintAdd, jbTableCreate, jbClear;
	private JComboBox<String> jcDatatype, jcConstraint;
	private JTextArea QueryView;
	public CreateTable ct;
	
	public TableCreateView() {
		super("테이블 생성");
		
		jlTableName = new JLabel("테이블명");
		jlColumnName = new JLabel("컬럼명");
		jlDataType = new JLabel("데이터형");
		jlDataLength = new JLabel("크기");
		jlConstraint = new JLabel("제약사항");
		jlConName = new JLabel("제약사항명");
		
		jtTableName = new JTextField(10);
		jtColumnName = new JTextField(10);
		jtDataLength = new JTextField(5);
		jtConstraintName = new JTextField(20);
		
		jbTableAdd = new JButton("추가");
		jbConstraintAdd = new JButton("추가");
		jbTableCreate = new JButton("테이블생성");
		jbClear = new JButton("초기화");
		
		
		jcDatatype = new JComboBox<>();
		jcConstraint = new JComboBox<>();
		QueryView = new JTextArea();
		
		JScrollPane jsp = new JScrollPane(QueryView);
		JPanel jplNorth = new JPanel();
		jplNorth.setLayout(new GridLayout(3, 1));
		
		JPanel jplNorth1 = new JPanel();
		jplNorth1.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel jplNorth2 = new JPanel();
		jplNorth2.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel jplNorth3 = new JPanel();
		jplNorth3.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel jplSouth = new JPanel();
		jplSouth.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		jplNorth1.add(jlTableName);
		jplNorth1.add(jtTableName);
		jplNorth1.add(jbTableAdd);
		
		jplNorth2.add(jlColumnName);
		jplNorth2.add(jtColumnName);
		jplNorth2.add(jlDataType);
		jplNorth2.add(jcDatatype);
		jplNorth2.add(jlDataLength);
		jplNorth2.add(jtDataLength);
		
		jplNorth3.add(jlConstraint);
		jplNorth3.add(jcConstraint);
		jplNorth3.add(jlConName);
		jplNorth3.add(jtConstraintName);
		jplNorth3.add(jbConstraintAdd);
		
		jplNorth.add(jplNorth1);
		jplNorth.add(jplNorth2);
		jplNorth.add(jplNorth3);
		
		jplSouth.add(jbTableCreate);
		jplSouth.add(jbClear);
		
		add("North", jplNorth);
		add("Center",QueryView);
		add("South", jplSouth);
		
		TableCreateViewEvt tcve = new TableCreateViewEvt(this);
		jcDatatype.addActionListener(tcve);
		jcConstraint.addActionListener(tcve);
		jbTableAdd.addActionListener(tcve);
		jbConstraintAdd.addActionListener(tcve);
		jbTableCreate.addActionListener(tcve);
		jbClear.addActionListener(tcve);
		
		
		addWindowListener(tcve);
		setBounds(100,100,800,800);
		setVisible(true);
	}//TableCreateView
	
	


	public JTextField getJtTableName() {
		return jtTableName;
	}

	public void setJtTableName(JTextField jtTableName) {
		this.jtTableName = jtTableName;
	}

	public JTextField getJtColumnName() {
		return jtColumnName;
	}

	public void setJtColumnName(JTextField jtColumnName) {
		this.jtColumnName = jtColumnName;
	}


	public JTextField getJtDataLength() {
		return jtDataLength;
	}

	public void setJtDataLength(JTextField jtDataLength) {
		this.jtDataLength = jtDataLength;
	}

	public JTextField getJtConstraintName() {
		return jtConstraintName;
	}

	public void setJtConstraintName(JTextField jtConstraintName) {
		this.jtConstraintName = jtConstraintName;
	}

	public JButton getJbTableAdd() {
		return jbTableAdd;
	}


	public void setJbTableAdd(JButton jbTableAdd) {
		this.jbTableAdd = jbTableAdd;
	}

	public JButton getJbConstraintAdd() {
		return jbConstraintAdd;
	}

	public void setJbConstraintAdd(JButton jbConstraintAdd) {
		this.jbConstraintAdd = jbConstraintAdd;
	}

	public JButton getJbTableCreate() {
		return jbTableCreate;
	}

	public void setJbTableCreate(JButton jbTableCreate) {
		this.jbTableCreate = jbTableCreate;
	}


	public JButton getJbClear() {
		return jbClear;
	}


	public void setJbClear(JButton jbClear) {
		this.jbClear = jbClear;
	}


	public JComboBox<String> getJcDatatype() {
		return jcDatatype;
	}

	public void setJcDatatype(JComboBox<String> jcDatatype) {
		this.jcDatatype = jcDatatype;
	}

	public JComboBox<String> getJcConstraint() {
		return jcConstraint;
	}

	public void setJcConstraint(JComboBox<String> jcConstraint) {
		this.jcConstraint = jcConstraint;
	}

	public JTextArea getQueryView() {
		return QueryView;
	}

	public void setQueryView(JTextArea queryView) {
		QueryView = queryView;
	}


	public static void main(String[] args) {
		new TableCreateView();
	}//main
	
}//class
