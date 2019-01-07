package day0107.hwk;

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
				
				listTablenames.add(tableName);
			}
		} finally {
			//6.���� ����
			if(pstmt != null) {pstmt.close();}
			if(con != null) {con.close();}
		}
		
		return listTablenames;
	}
	
}
