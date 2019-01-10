package day0109;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import day0110.TestProcAllVO;
import day0110.TestProcOneVO;
import day0110.TestProcUpdateVO;
import kr.co.sist.connection.GetConnection;
import oracle.jdbc.OracleTypes;

/**
 * Procedure를 사용한 CRUD(create, read, update, delete: DB의 모든작업)
 * @author owner
 */
public class UseCallableStatementDAO {

	private static UseCallableStatementDAO ucs_dao;
	
	private UseCallableStatementDAO() {
	}
	
	/**
	 * private이니 밖에서 받아갈 수 있도록 getInstance함 //Singleton.
	 * 프레임워크에서는 빨리쓰려고 다 singleton으로 함
	 * 대신 객체가 값을 저장하도록 만들면 안됨 => 엉뚱한 값을 얻어갈 수도 있으므로
	 * @return
	 */
	public static UseCallableStatementDAO getInstance() {
		if(ucs_dao == null) {
			ucs_dao = new UseCallableStatementDAO();
		}//end if
		return ucs_dao;
	}//getInstance
	
	/**
	 * test_proc테이블에 사원번호, 사원명, 연봉, 직무를 추가하는 일
	 * @param tpvo
	 * @return
	 * @throws SQLException
	 */
	public String insertProc(TestProcVO tpvo) throws SQLException {
		String resultMsg = "";
		
		Connection con = null;
		CallableStatement cstmt = null;
		
		try {
		//1.
		//2.
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "scott";
			String pass = "tiger";
			con = GetConnection.getInstance().getConn(url, id, pass);
		//3.프로시저 실행 객체 얻기
			//굳이 밖에서 빼서 호출하는 코드를 만들지 않음
			cstmt = con.prepareCall("{call insert_test_proc(?,?,?,?,?,?) }");
		//4.
			//바인드변수에 값 설정
			//in parameter
			cstmt.setInt(1, tpvo.getEmpno());
			cstmt.setString(2, tpvo.getEname());
			cstmt.setInt(3, tpvo.getSal());
			cstmt.setString(4, tpvo.getJob());
			//out parameter : 프로시저가 처리한 결과를 저장할 데이터형을 설정
			cstmt.registerOutParameter(5, Types.VARCHAR);
			cstmt.registerOutParameter(6, Types.NUMERIC);
			
		//5.
			cstmt.executeQuery();
			//프로시저가 실행된 후 out parameter에 설정된 값 받기
			resultMsg = cstmt.getString(5); //cstmt.getNString하면 코드값이 나오기 때문에 저장할 수 없음
			int cnt=cstmt.getInt(6);
			System.out.println(cnt);
			System.out.println(resultMsg);
		
		}finally {
		//6.
			if(cstmt!=null) {cstmt.close();}//end if
			if(con!=null) {con.close();}//end if
		}//end finally
		
		return resultMsg;
		
	}//insertProc
	
	public String updateProc(TestProcUpdateVO t)throws SQLException{
		String msg = "";
		
		Connection con = null;
		CallableStatement cstmt = null;
		
		try {
		//1.
		//2.
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "scott";
			String pass = "tiger";
			con = GetConnection.getInstance().getConn(url, id, pass);
		//3.
			cstmt = con.prepareCall(" { call update_test_proc(?,?,?,?,?) } ");
		//4.
			//bind변수에 값 넣기 => procedure의 매개변수
			//in parameter
			cstmt.setInt(1,t.getEmpno());
			cstmt.setString(2, t.getJob());
			cstmt.setInt(3,t.getSal());
			
			//out parameter:procedure가 처리한 결과를 저장한 매개변수
			cstmt.registerOutParameter(4, Types.NUMERIC);
			cstmt.registerOutParameter(5, Types.VARCHAR);
			
		//5.
			cstmt.executeQuery();
			//부모의 method 사용 procedure를 실행=> 실행결과가 out paramter에 저장
			int cnt = cstmt.getInt(4);
			msg = cstmt.getString(5);
			
			System.out.println("update: "+cnt);
		}finally {
		//6.
			if(cstmt!=null) {cstmt.close();}//end if
			if(con!=null) {con.close();}//end if
		}//end finally
		return msg;
	}//updateProc
	
	public String deleteProc(int empno) throws SQLException{
		String msg ="";
		Connection con = null;
		CallableStatement cstmt = null;
		
		try {
		//1.
		//2.
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "scott";
			String pass = "tiger";
			con = GetConnection.getInstance().getConn(url, id, pass);
		//3.
			cstmt = con.prepareCall("{ call delete_test_proc(?,?,?)}");
		//4.
			//바인드 변수에 값 설정
			//in parameter
			cstmt.setInt(1, empno);
			//out parameter
			cstmt.registerOutParameter(2, Types.VARCHAR);
			cstmt.registerOutParameter(3, Types.NUMERIC);
			
		//5.
			cstmt.execute();
			//out parameter에 설정된 값 받기
			msg = cstmt.getString(2);
			int cnt = cstmt.getInt(3);
			
			System.out.println(cnt+"건 삭제");
			
		}finally {
		//6.
			if(cstmt!=null) {cstmt.close();}
			if(con!=null) {con.close();}
		}//end finally
		
		return msg;
	}//deleteProc
	
	public List<TestProcAllVO> searchAllTestProc() throws SQLException{
		List<TestProcAllVO> list = new ArrayList<TestProcAllVO>();
		
		Connection con = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;
		try {
		//1.
		//2.
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id ="scott";
			String pass ="tiger";
			
			con = GetConnection.getInstance().getConn(url, id, pass);
		//3.
			cstmt = con.prepareCall("{ call select_all_test_proc ( ?,?) }");
		//4.
			//바인드 변수에 값 넣기
			//out parameter : sys_refcursor
//			cstmt.registerOutParameter(1, Types.REF_CURSOR);//부적합한 열 유형: 2012 에러 - 자바에서 제공하지 않는것
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			
			//in parameter
			cstmt.setString(2, "mm-dd-yyyy day hh24:mi");
			
		//5.
			cstmt.executeQuery();
			//커서의 제어권 받기
			rs = (ResultSet)cstmt.getObject(1);
			
			//제어권을 받아 조회한 모든 컬럼값을 레코드를 VO에 할당하고 List에 추가
			TestProcAllVO tpavo = null;
			
			while(rs.next()) {
				tpavo = new TestProcAllVO(rs.getInt("empno"), rs.getInt("sal"), 
						rs.getString("ename"), rs.getString("hiredate"), rs.getString("job"));
				
				list.add(tpavo);
			}//end while
			
		}finally {
		//6.
			if(rs!=null) {rs.close();}//end if
			if(cstmt!=null) {cstmt.close();}//end if
			if(con!=null) {con.close();}//end if
		}//end finally
		
		return list;
	}//searchAllTestProc
	
	public TestProcOneVO searchOneTestProc(int empno) throws SQLException{
		TestProcOneVO tpovo = null;
		
		Connection con = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;
		try {
		//1.
		//2.
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id ="scott";
			String pass ="tiger";
			
			con = GetConnection.getInstance().getConn(url, id, pass);
		//3.
			cstmt = con.prepareCall("{ call select_one_test_proc ( ?,?,?) }");
		//4.
			//바인드 변수에 값 넣기
			//in parameter
			cstmt.setInt(1, empno);
			
			//out parameter : sys_refcursor
			cstmt.registerOutParameter(2, OracleTypes.CURSOR);
			cstmt.registerOutParameter(3, Types.VARCHAR);
			
		//5.
			cstmt.executeQuery();
			//커서의 제어권 받기
			rs = (ResultSet)cstmt.getObject(2);
			
			if(rs.next()) {
				tpovo = new TestProcOneVO(rs.getInt("sal"), rs.getString("ename"),
						rs.getString("job"), rs.getString("hiredate"));
			}//end if
			
		}finally {
		//6.
			if(rs!=null) {rs.close();}//end if
			if(cstmt!=null) {cstmt.close();}//end if
			if(con!=null) {con.close();}//end if
		}//end finally
		
		return tpovo;
	}//searchAllTestProc
	
	
	
	/**
	 * 단위테스트
	 * @param args
	 */
	public static void main(String[] args) {
		UseCallableStatementDAO u = new UseCallableStatementDAO();
//		TestProcVO t = new TestProcVO(2222, 4200, "공선의", "과장");
//		TestProcUpdateVO t = new TestProcUpdateVO(1234,3000,"과장");
		try {
//			u.insertProc(t);
//			System.out.println(u.updateProc(t));
//			System.out.println(u.deleteProc(1234));
//			List<TestProcAllVO> l = u.searchAllTestProc();
			System.out.println(u.searchOneTestProc(12345));
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
	}//main
	
}//class
