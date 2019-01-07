package day0107.hwk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TableSelectViewEvt extends WindowAdapter implements ActionListener{
	private TableSelectView tv;
	
	public TableSelectViewEvt(TableSelectView tv) {
		this.tv = tv;
		List<String> tableNames = new ArrayList<String>();
		
		TableSelectDAO tsdao = new TableSelectDAO();
		
		try {
			tableNames = tsdao.getTableName();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		for(int i=0; i<tableNames.size(); i++) {
			tv.getJcbTableSelect().addItem(tableNames.get(i));
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		tv.dispose();
	}
}

