package day0109.hwk;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.co.sist.connection.GetConnection;

public class TableCreateViewDAO {
	
	private static TableCreateViewDAO tcv_dao;
	
	private TableCreateViewDAO() {
	}

	private static TableCreateViewDAO getInstance() {
		if(tcv_dao ==null) {
			tcv_dao = new TableCreateViewDAO();
		}//end if
		return tcv_dao;
	}//getInstance
	
	
	public void createTable(String query) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		query = query.substring(0, query.lastIndexOf(";"));
		
		try {
		//1.
		//2.
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "scott";
			String pass = "tiger";
			con = GetConnection.getInstance().getConn(url, id, pass);
		//3.
			pstmt = con.prepareStatement(query);
		//4.
		//5.
			pstmt.executeQuery();
		
		}finally {
		//6.
			if(rs!=null) {rs.close();}
			if(pstmt!=null) {pstmt.close();}//end if
			if(con!=null) {con.close();}//end if
		}//end finally
		
	}
	
	
}//class
