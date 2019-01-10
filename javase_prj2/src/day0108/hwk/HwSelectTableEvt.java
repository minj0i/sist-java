package day0108.hwk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import day0107.hwk.HwSelectTableVO;
import kr.co.sist.connection.GetConnection;


public class HwSelectTableEvt extends WindowAdapter implements ActionListener {
	private HwSelectTableView hstv;
	private String selectTName;
	private HwSelectTableDAO hstdao;
	
	public HwSelectTableEvt(HwSelectTableView hstv) {
		this.hstv = hstv;
		
		List<String> tableNames = new ArrayList<String>();
		hstdao = new HwSelectTableDAO();
		
		try {
			tableNames = hstdao.getTableName();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		for(int i=0; i<tableNames.size(); i++) {
			hstv.getJcbTableSelect().addItem(tableNames.get(i));
		}
		
		selectTName = hstv.getJcbTableSelect().getItemAt(0);
	}

	//선택시 테이블 이름 저장하는 애
	public String selectTableName() {
		String selectTName = "";
		selectTName = hstv.getJcbTableSelect().getSelectedItem().toString();

		return selectTName;
	}
	
	//선택한 테이블 이름 적용하는 애
		public void applyTableContents() {
			try {
				//DB에서 조회한 결과를 받아 
				List<String[]> listTableColums = hstdao.getTableColumns(selectTName);
				//defaultTableModel에 추가 => Jtable 반영
				DefaultTableModel dtm = hstv.getDtmTable();
				//D.T.M 초기화
				dtm.setRowCount(0);
				
				String[] rowData = null;
				//조회된 결과를 가지고
				for(int i=0; i<listTableColums.size(); i++) {
					
					rowData = new String[4];
					rowData[0] = listTableColums.get(i)[0];
					rowData[1] = listTableColums.get(i)[1];
					rowData[2] = listTableColums.get(i)[2];
					rowData[3] = listTableColums.get(i)[3];
					dtm.addRow(rowData);
				}
				
				if(listTableColums.isEmpty()) {
					rowData=new String[4];
					rowData[0]="해당 테이블에";
					rowData[1]="값이";
					rowData[2]="존재하지";
					rowData[3]="않습니다.";
					
					dtm.addRow(rowData);
				}
				
			} catch (SQLException se) {
				JOptionPane.showMessageDialog(hstv, "DB에서 문제가 발생");
				se.printStackTrace();
			}	
		}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == hstv.getJcbTableSelect()) {
			selectTName = selectTableName();
		}
		if(ae.getSource() == hstv.getJbtSelect()) {
			// DAO에 매개변수로 테이블명 넣어줄 것 
			applyTableContents();
		}	
	}
	
	@Override
	public void windowClosing(WindowEvent we) {
		hstv.dispose();
	}// windowClosing

}//class
