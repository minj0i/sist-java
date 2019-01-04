package day0103;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC (Java DataBase Connectivity) 를 사용하여 DBMS의 Connection을 얻기
 * @author owner
 */
public class UseConnection {
	public UseConnection() throws SQLException {
		//1.드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");//패키지라고 불러야..
			System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
		
		//2.로딩된 드라이버를 사용하여 DB연동 얻기
		String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		String id="scott";
		String pass="tiger";
		
		Connection con=null;
		Statement stmt=null;
		
		try {
			con=DriverManager.getConnection(url, id, pass);
			System.out.println("DB연결 얻기 성공 : "+con);
			
			//3.쿼리문 생성객체 얻기
			stmt =con.createStatement();
			
			//4.쿼리문 실행후 결과 얻기
			String insertQuery="insert into cp_emp2(empno,ename,hiredate,sal) "
										+ "values(1234,'공선의',sysdate,3000)"/*;"넣지 않는다.Error*/;
			//<틀릴일이 없어진다.복사해 가져올수 있어서
			//<ctrl+shift+y 소문자
			int cnt=stmt.executeUpdate(insertQuery);
			System.out.println(cnt+"건 추가 성공");
		}finally {
			//5.연결 끊기=>꼬옥 해주기 위해서...finally
			if(stmt!=null) {stmt.close(); }//end if   //끊는 건 뒤에서 부터 
			if(con!=null) {con.close(); }//end if
		}//end finally
			
	}//UseConnection
	
	public static void main(String[] args) {
		try {
			new UseConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
	}//main
}//class
