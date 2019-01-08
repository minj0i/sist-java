package day0108.hwk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TableSelectDAO {
	
	public TableSelectDAO() {
	
	}
	
	private Connection getConn() throws SQLException{
		Connection con = null;
		//1.
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//2.
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		String id = "scott";
		String pass = "tiger";
		
		con = DriverManager.getConnection(url, id, pass);
		return con;
	}
	
	public List<String> getTableName() throws SQLException {
		List<String> listTablenames = new ArrayList<String>();
		String tableName = "";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//1.����̹��ε�
			//2.Connection���
			con = getConn();
			//3.������ ���� ��ü ���
			//PreparedStatement ��ü�� ����Ǵ� �������� �˰��ִ�.
			String selectTab="select tname from tab";
			pstmt=con.prepareStatement(selectTab);
			//4.���ε� ������ �� ����
			//5.���� ���� �� ��� ���
			rs = pstmt.executeQuery();
			while(rs.next()) {
				tableName = rs.getString("tname");
				
				//tv.getJcbTableSelect().addItem(tableName);
				listTablenames.add(tableName);
			}
		} finally {
			//6.���� ����
			if(pstmt != null) {pstmt.close();}
			if(con != null) {con.close();}
		}
		
		return listTablenames;
	}
	
	public List<String[]> getTableColums(String tableName) throws SQLException {
		List<String[]> listTablenames = new ArrayList<String[]>();
		String[] tableColums = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//1.����̹��ε�
			//2.Connection���
			con = getConn();
			//3.������ ���� ��ü ���
			//PreparedStatement ��ü�� ����Ǵ� �������� �˰��ִ�.		
			StringBuilder selectJoinTab = new StringBuilder();
			selectJoinTab
			.append("select utc.column_name cname, utc.data_type dtype, utc.data_length dlength, ucc.constraint_name conName ")
			.append("from user_tab_cols utc, user_cons_columns ucc ")
			.append("where utc.table_name = ucc.table_name(+) ")
			.append("and utc.column_name = ucc.column_name(+) ")
			.append("and utc.table_name=? ");

			pstmt=con.prepareStatement(selectJoinTab.toString());
			//4.���ε� ������ �� ����
			pstmt.setString(1, tableName);
			//5.���� ���� �� ��� ���
			rs = pstmt.executeQuery();
			while(rs.next()) {
				tableColums = new String[4];
				tableColums[0] = rs.getString("cname");
				tableColums[1] = rs.getString("dtype");
				tableColums[2] = rs.getString("dlength");
				tableColums[3] = rs.getString("conName");
				listTablenames.add(tableColums);
			}
		} finally {
			//6.���� ����
			if(pstmt != null) {pstmt.close();}
			if(con != null) {con.close();}
		}
		
		return listTablenames;
	}
	
}
