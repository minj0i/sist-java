package logInDb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class loginDAO {
	
	public loginDAO() {
		
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
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "scott";
		String pass = "tiger";
		
		con = DriverManager.getConnection(url, id, pass);
		return con;
	}
	
	public List<String[]> getInfo() throws SQLException{
		List<String[]> listInfo = new ArrayList<String[]>();
		String[] idpass = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
		//1.
		//2.
			con = getConn();
		//3.
			String selectId = "select id, pass from ex_login";
			pstmt=con.prepareStatement(selectId);
		//4.
		//5.
			rs=pstmt.executeQuery();
			while(rs.next()) {
				idpass = new String[2];
				idpass[0]= rs.getString("ID");
				idpass[1]= rs.getString("PASS");

				
//				System.out.println(idpass[0] + idpass[1]);
				
				
				listInfo.add(idpass);
				
			}
		//6.
		}finally {
			if(rs !=null) {rs.close();}//end if
			if(pstmt!=null) {pstmt.close();}//end if
			if(con!=null) {con.close();}//end if
		}//end finally
	
		return listInfo;
	}//getInfo
	
//	public static void main(String[] args) {
//		loginDAO l = new loginDAO();
//		try {
//			l.getInfo();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
<<<<<<< HEAD
}//class
=======
}//class
>>>>>>> 5f87042d2a977fec754c70f1526bc603ee3c4584
