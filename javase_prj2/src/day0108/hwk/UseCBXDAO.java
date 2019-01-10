package day0108.hwk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JOptionPane;

public class UseCBXDAO extends WindowAdapter implements ActionListener {
	private RunCBX rcbx;
	
	public UseCBXDAO(RunCBX rcbx) {
		this.rcbx = rcbx;
		
	} // UseCBXDAO
	
	@Override
	public void windowClosing(WindowEvent we) {
		rcbx.dispose();
	} // windowClosing
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == rcbx.getJbtSearch()) {
			if (!rcbx.getJcbTable().getSelectedItem().toString().equals("")) {
				try {
					String tname = rcbx.getJcbTable().getSelectedItem().toString();
					
					rcbx.getDtmSelectedTable().setRowCount(0);
					
					getSelectedTableInfo(tname);
				} catch (SQLException sqle) {
					sqle.printStackTrace();
				} // end catch
			} // end if
		} // end if
	} // actionPerformed
	
	public Connection getConn() throws SQLException {
		Connection con = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} // end catch
		
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "scott";
		String password = "tiger";
		
		con = DriverManager.getConnection(url, user, password);
		
		return con;
	} // getConn
	
	public List<CBXVO> selectAllTable() throws SQLException {
		List<CBXVO> list = new ArrayList<CBXVO>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = this.getConn();
			
			String selectAllTable = 
					"select * from tab";
			
			pstmt = con.prepareStatement(selectAllTable);
			
			rs = pstmt.executeQuery();
			
			CBXVO cbx_vo = null;
			
			while (rs.next()) {
				cbx_vo = new CBXVO(rs.getString("tname"));
				
				list.add(cbx_vo);
			} // end while
		} finally {
			if (rs != null) { rs.close(); } // end if
			if (pstmt != null) { pstmt.close(); } // end if
			if (con != null) { con.close(); } // end if
		} // end finally
		
		return list;
	} // selectAllTable
	
	@SuppressWarnings("resource")
	public void getSelectedTableInfo(String tname) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		Map<String, String> map = null;
		
		try {
			con = this.getConn();
			
			String getConstraint = 
					"select column_name, constraint_name from user_cons_columns where table_name = ?";
			
			pstmt = con.prepareStatement(getConstraint);
			
			pstmt.setString(1, tname);
			
			rs = pstmt.executeQuery();
			
			map = new HashMap<String, String>();
			
			String key = "", value = "";
			
			while (rs.next()) {
				key = rs.getString("column_name");
				value = rs.getString("constraint_name");
				
				map.put(key, value);
			} // end while
			
			Set<String> set = map.keySet();
			
			String selectedTable = 
					"select * from " + tname;
			
			pstmt = con.prepareStatement(selectedTable);
			
			rs = pstmt.executeQuery();
			
			rsmd = rs.getMetaData();
			
			int columnCount = rsmd.getColumnCount();
			
			String columnName = "", columnTypeName = "";
			
			int columnPrecision = 0;
			
			for (int i = 1; i < columnCount + 1; i++) {
				columnName = rsmd.getColumnLabel(i);
				columnTypeName = rsmd.getColumnTypeName(i);
				columnPrecision = rsmd.getPrecision(i);
				
				for (String temp : set) {
					if (temp.equals(columnName)) {
						value = map.get(temp);
					} // end if
				} // end for
				
				Object[] rowData = {columnName, columnTypeName, columnPrecision, value};
				
				rcbx.getDtmSelectedTable().addRow(rowData);
				
				value = "";
			} // end for
			
			if (rcbx.getDtmSelectedTable().getRowCount() == 0) {
				JOptionPane.showMessageDialog(rcbx, "컬럼이 존재하지 않습니다.");
			} // end if
		} finally {
			if (rs != null) { rs.close(); } // end if
			if (pstmt != null) { pstmt.close(); } // end if
			if (con != null) { con.close(); } // end if
		} // end finally
	} // getSelectedTableInfo
	
} // class

