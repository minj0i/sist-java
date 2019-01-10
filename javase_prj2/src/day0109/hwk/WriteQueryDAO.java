package day0109.hwk;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import kr.co.sist.connection.GetConnection;

public class WriteQueryDAO {

private static WriteQueryDAO wq_dao;
	
	private WriteQueryDAO() {

	}
	
	public static WriteQueryDAO getInstance() {
		if(wq_dao == null) {
			wq_dao = new WriteQueryDAO();
		}
		return wq_dao;
	}
	
	public void createTable(String query) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		query = query.substring(0, query.lastIndexOf(";"));
		System.out.println(query);
		
		try {
			//1.
			//2.
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String id = "scott";
			String pass = "tiger";
			con = GetConnection.getInstance().getConn(url, id, pass);
			
			//3.
			pstmt=con.prepareStatement(query);

			//4.
			//5.
			pstmt.execute();
			
		} finally {
			//6.
			if(rs != null) { rs.close(); }
			if(pstmt != null) { pstmt.close(); }
			if(con != null) { con.close(); }
		}
		
	}
	
	
}
