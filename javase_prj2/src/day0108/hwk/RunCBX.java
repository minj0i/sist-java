package day0108.hwk;

import java.awt.Color;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class RunCBX extends JFrame {
	private JLabel jlblSelect;
	private UseCBXDAO ucbx_dao;
	private JComboBox<String> jcbTable;
	private JButton jbtSearch;
	private DefaultTableModel dtmSelectedTable;
	
	public RunCBX() {
		super("Table Search");
		
		jlblSelect = new JLabel("테이블 선택");
		
		jcbTable = new JComboBox<String>();
		
		jbtSearch = new JButton("선택");
		
		String[] columnNames = {"컬럼명", "데이터형", "크기", "제약사항"};
		
		dtmSelectedTable = new DefaultTableModel(columnNames, 0);
		
		JTable jtabSelectedTable = new JTable(dtmSelectedTable);
		jtabSelectedTable.getColumnModel().getColumn(0).setPreferredWidth(80);
		jtabSelectedTable.getColumnModel().getColumn(1).setPreferredWidth(40);
		jtabSelectedTable.getColumnModel().getColumn(2).setPreferredWidth(40);
		jtabSelectedTable.getColumnModel().getColumn(3).setPreferredWidth(200);
		jtabSelectedTable.getTableHeader().setReorderingAllowed(false);	
		jtabSelectedTable.setRowHeight(24);
		
		JScrollPane jsp = new JScrollPane(jtabSelectedTable);
		
		JPanel jpNorth = new JPanel();
		jpNorth.setBackground(Color.WHITE);
		
		jpNorth.add(jlblSelect);
		jpNorth.add(jcbTable);
		jpNorth.add(jbtSearch);
		
		add("North", jpNorth);
		add("Center", jsp);
		
		ucbx_dao = new UseCBXDAO(this);
		
		jcbTable.addActionListener(ucbx_dao);
		jbtSearch.addActionListener(ucbx_dao);
		
		addWindowListener(ucbx_dao);
		
		setSize(600, 400);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
	} // RunCBX
	
	public void searchAllTable() {
		try {
			List<CBXVO> list = ucbx_dao.selectAllTable();
			
			CBXVO cbx_vo = null;
			
			for (CBXVO vo : list) {
				cbx_vo = vo;
				
				jcbTable.addItem(cbx_vo.getTname());
			} // end for
			
			if (list.isEmpty()) {
				JOptionPane.showMessageDialog(null, "테이블이 존재하지 않습니다.");
			} // end if
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "DB 작업 중 문제가 발생했습니다.");
			sqle.printStackTrace();
		} // end catch
	} // searchAllTable
	
	public static void main(String[] args) {
		RunCBX rcbx = new RunCBX();
		
		rcbx.searchAllTable();
		
	} // main
	
	public JLabel getJlblSelect() {
		return jlblSelect;
	}

	public JComboBox<String> getJcbTable() {
		return jcbTable;
	}

	public JButton getJbtSearch() {
		return jbtSearch;
	}

	public DefaultTableModel getDtmSelectedTable() {
		return dtmSelectedTable;
	}
	
} // class
