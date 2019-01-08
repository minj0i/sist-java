package day0108.hwk;



import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


	@SuppressWarnings("serial")
	public class HwSelectTableView extends JFrame{
		
		private JLabel jTableSelect;
		private JComboBox<String> jcbTableSelect;
		private JButton JbtSelect;
		private DefaultTableModel dtmTable;
		
		public HwSelectTableView() {
			super("모든 테이블 조회");
			
			jTableSelect = new JLabel("테이블선택");
			jcbTableSelect = new JComboBox<String>();
			JbtSelect = new JButton("선택");
			
			String[] columnNames = {"컬럼명", "데이터형", "크기", "제약사항"};
			dtmTable = new DefaultTableModel(columnNames, 5);
			JTable tabTable = new JTable(dtmTable);
			
			tabTable.getTableHeader().setReorderingAllowed(false);
			
			tabTable.setRowHeight(24);
			
			tabTable.getColumnModel().getColumn(0).setPreferredWidth(60);
			tabTable.getColumnModel().getColumn(1).setPreferredWidth(60);
			tabTable.getColumnModel().getColumn(2).setPreferredWidth(60);
			tabTable.getColumnModel().getColumn(3).setPreferredWidth(60);
			
			JScrollPane jsp = new JScrollPane(tabTable);
			
			
			JPanel panelNorth = new JPanel();
			panelNorth.add(jTableSelect);
			panelNorth.add(jcbTableSelect);
			panelNorth.add(JbtSelect);
			
			add("North", panelNorth);
			add("Center", jsp);
			
			
			HwSelectTableEvt hst = new HwSelectTableEvt(this);
			jcbTableSelect.addActionListener(hst);
			JbtSelect.addActionListener(hst);
			addWindowListener(hst);
			
			setBounds(100,100,500,600);
			setVisible(true);
			setResizable(false);
			
		}//HwSelectTable
		
		public JLabel getjTableSelect() {
			return jTableSelect;
		}

		public JComboBox<String> getJcbTableSelect() {
			return jcbTableSelect;
		}

		public JButton getJbtSelect() {
			return JbtSelect;
		}

		public DefaultTableModel getDtmTable() {
			return dtmTable;
		}

		public static void main(String[] args) {
			new HwSelectTableView();
		}//main

}
