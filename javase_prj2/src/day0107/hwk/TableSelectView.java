package day0107.hwk;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TableSelectView extends JFrame{

	private JComboBox<String> jcbTableSelect;
	private JButton jbtSelect;
	
	public TableSelectView() {
		super("테이블 선택");
		
		jcbTableSelect = new JComboBox<String>();
		jbtSelect = new JButton("선택");
		
		JPanel jplNorth = new JPanel();
		
		jplNorth.add(new JLabel("테이블 선택"));
		jplNorth.add(jcbTableSelect);
		jplNorth.add(jbtSelect);
		
		add("North", jplNorth);
		
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

}
