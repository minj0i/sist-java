package day0107.hwk;


import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



	@SuppressWarnings("serial")
	public class HwSelectTableView extends JFrame{
		
		private JLabel jTableSelect;
		private JComboBox<String> jcombobox;
		private JButton jbtselect;
		
		public HwSelectTableView() {
			super("모든 테이블 조회");
			jTableSelect = new JLabel("테이블선택");
			jcombobox = new JComboBox<String>();
			jbtselect = new JButton("선택");
			
			
			setLayout(new GridLayout(3, 1));
			JPanel panel = new JPanel();
			panel.add(jTableSelect);
			panel.add(jcombobox);
			panel.add(jbtselect);
			add(panel);
			
			
			HwSelectTableEvt hst = new HwSelectTableEvt(this);
			jbtselect.addActionListener(hst);
			
			setBounds(100,100,500,150);
			setVisible(true);
			setResizable(false);
			
		}//HwSelectTable
		
				

		public JLabel getjTableSelect() {
			return jTableSelect;
		}



		public JComboBox<String> getJcombobox() {
			return jcombobox;
		}



		public JButton getJbtselect() {
			return jbtselect;
		}



		public static void main(String[] args) {
			new HwSelectTableView();
		}//main

}
