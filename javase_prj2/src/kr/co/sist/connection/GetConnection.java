package kr.co.sist.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Singleton pattern으로 만드는 클래스<br>
 * DB Connection을 반환하는 일
 * @author owner
 */
public class GetConnection {
	private static GetConnection gc;
	
	private GetConnection() {
	}//생성자
	
	public static GetConnection getInstance() {
		if(gc ==null) {
			gc = new GetConnection();
		}//end if
		return gc;
	}//getInstance
	
	//매개변수로 받아서 쓰는게 나중에 편리함
	public Connection getConn(String url, String id, String pass) throws SQLException{
		Connection con = null;
		//1.드라이버로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
		
		//2.Connection 얻기
		con = DriverManager.getConnection(url, id, pass);
		
		//String url,id, pass 넣으면 다른데서 아래처럼 그냥 쓸 수 있음.
		//GetConnection gc = GetConnection.getInstance();
		//con = gc.getConn();
		
		return con;
	}//getConn
	
	
}//class
