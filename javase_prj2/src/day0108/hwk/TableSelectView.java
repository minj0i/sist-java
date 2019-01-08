package day0108.hwk;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TableSelectView extends JFrame{

	private JComboBox<String> jcbTableSelect;
	private JButton jbtSelect;
	private DefaultTableModel dtmTableContents;
	
	public TableSelectView() {
		super("���̺� ����");
		
		jcbTableSelect = new JComboBox<String>();
		jbtSelect = new JButton("����");
		
		String[] columnNames = {"�÷���","��������","ũ��","�������"};
		dtmTableContents = new DefaultTableModel(columnNames, 5);
		JTable tabTableContents = new JTable(dtmTableContents);
		
		tabTableContents.getTableHeader().setReorderingAllowed(false);//�÷� �̵� ����
		tabTableContents.setRowHeight(24);
//		tabTableContents.getColumnModel().getColumn(0).setPreferredWidth(60);
//		tabTableContents.getColumnModel().getColumn(1).setPreferredWidth(400);
		
		JScrollPane jsp = new JScrollPane(tabTableContents);
		JPanel jplNorth = new JPanel();
		
		jplNorth.add(new JLabel("���̺� ����"));
		jplNorth.add(jcbTableSelect);
		jplNorth.add(jbtSelect);
		
		add("North", jplNorth);
		add("Center", jsp);
		
		TableSelectViewEvt tve = new TableSelectViewEvt(this);
		jcbTableSelect.addActionListener(tve);
		jbtSelect.addActionListener(tve);
		addWindowListener(tve);
		
		setBounds(100, 100, 500, 300);
		setVisible(true);

	}

	public JComboBox<String> getJcbTableSelect() {
		return jcbTableSelect;
	}

	public JButton getJbtSelect() {
		return jbtSelect;
	}

	public static void main(String[] args) {
		new TableSelectView();
	}

	public DefaultTableModel getDtmTableContents() {
		return dtmTableContents;
	}

}
