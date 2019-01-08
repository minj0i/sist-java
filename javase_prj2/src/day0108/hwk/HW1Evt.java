package day0108.hwk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JTextArea;

import kr.co.sist.connection.GetConnection;

public class HW1Evt extends WindowAdapter implements ActionListener {

	private HW1 hw1;
	
	public HW1Evt(HW1 hw1) {
		this.hw1 = hw1;
	}
	
	public void tableView(String chosenTable) throws SQLException{
		JTextArea jta = hw1.getJta();
		StringBuilder jtaText = new StringBuilder();

		Connection con = null;
		PreparedStatement pstmt = null, pstmt2 = null;
		ResultSet rs = null,rs2 = null;
		ResultSetMetaData rsmd = null;
		
		try {
			GetConnection gc = GetConnection.getInstance();
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id ="scott";
			String pass="tiger";
			con = gc.getConn(url, id, pass);
			
			String selectTab = "select * from "+chosenTable;
			pstmt = con.prepareStatement(selectTab);
			// 4.바인드 변수에 값 설정
			// 5.쿼리 수행 후 결과 얻기
			rs = pstmt.executeQuery();
			rsmd = rs.getMetaData();
			
			String consColumn = "select uc.constraint_type,ucc.column_name,ucc.table_name "+ 
					"from user_cons_columns ucc , user_constraints uc " + 
					"where ucc.table_name = uc.table_name " +
					"and ucc.constraint_name = uc.constraint_name "+
					"and uc.table_name = '"+chosenTable+"'";
			
			pstmt2 = con.prepareStatement(consColumn);
			rs2 = pstmt2.executeQuery();
			
			Map<String, String> column = new HashMap<>();
			while (rs2.next()) {
				String key = rs2.getString("COLUMN_NAME");
				String value = rs2.getString("CONSTRAINT_TYPE");
				column.put(key, value);
			}
			
			
			int columnNum = rsmd.getColumnCount();
			jtaText.append("컬럼명\t데이터형\t크기\t제약사항\n");
			String columnName, dataType, constraints;
			int size=0;
			
			for (int i = 0; i < columnNum; i++) {

				columnName = rsmd.getColumnLabel(i+1);
				dataType = rsmd.getColumnTypeName(i+1);
				size = rsmd.getPrecision(i+1);
				constraints = column.get(columnName);
				if(constraints == null) {
					constraints = " ";
				}//NullPointException 회피
				switch (constraints) {
				case "P":
					constraints = "PrimaryKey";
					break;
				case "U":
					constraints = "UniqueKey";
					break;
				case "C":
					constraints = "check constraint on a table";
					break;
				case "R":
					constraints = "referential integrity";
					break;
				case "V":
					constraints = "with check option, on a view";
					break;
				case "O":
					constraints = "with read only, on a view";
					break;
		
				default:
					constraints = "제약사항 없음";
					break;
				}
				jtaText
				.append(columnName).append("\t")
				.append(dataType).append("\t")
				.append(size).append("\t")
				.append(constraints).append("\n")
				;
			}
			jta.setText(jtaText.toString());
			
		}finally {
			if (con != null) {
				con.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (pstmt2 != null) {
				pstmt2.close();
			}
			if (rs != null) {
				rs.close();
			}
			if (rs2 != null) {
				rs2.close();
			}
		}//end finally
		
		
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == hw1.getBtnChoice()) {
			String chosenTable = hw1.getCBtable().getSelectedItem().toString();
			try {
				tableView(chosenTable);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}

}
