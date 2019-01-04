package day0104;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Statement 객체를 사용하여 CRUD를 구현하는 클래스
 * CRUD(Create Read Update Delete)의 약자
 * @author owner
 */
public class UseStatementCRUD {
	
	/**
	 * VO를 입력받아 VO의 값을 CP_DEPT테이블에 추가
	 * @param cdvo 부서번호, 부서명, 위치를 가진 VO 
	 * @throws SQLException 쿼리문이 
	 */
	public void insertCpDept(CpDeptVO cdvo) throws SQLException {
		//1. 드라이버로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
		
		Connection con = null;
		Statement stmt = null;
		
		try {
		//2. Connection 얻기
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String id = "scott";
			String pwd = "tiger";
			
			con = DriverManager.getConnection(url, id, pwd);
		//3. 쿼리문 생성객체 얻기
			stmt = con.createStatement();
		//4. 쿼리수행 후 결과 얻기
//			String insertCpdept = "insert into cp_dept(deptno, dname, loc) values("+
//					cdvo.getDeptno()+",'"+cdvo.getDname()+"','"+cdvo.getLoc()+"')";
			//문자열에 +가 붙으면 긴 문자열
			//긴문자열인 경우 StringBuffer나 StringBuilder사용
			//.찍어서 붙여쓰는 것 : method chain
			StringBuilder insertCpdept = new StringBuilder();
			insertCpdept.append("insert into cp_dept(deptno, dname, loc) values(")
			.append(cdvo.getDeptno()).append(",'")
			.append(cdvo.getDname()).append("','")
			.append(cdvo.getLoc()).append("')");
			
			int cnt = stmt.executeUpdate(insertCpdept.toString());
			System.out.println(cnt);
			
		}finally {
		//5. 연결 끊기
		if(stmt!=null) {stmt.close();}//end if
		if(con!=null) {stmt.close();}//end if
		}
	}//insertCpDept
	
	public boolean updateCpDept(CpDeptVO cdvo) throws SQLException {
		boolean flag = false;
		
		//1. 드라이버로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
		
		Connection con = null;
		Statement stmt = null;
		try {
		//2. Connection얻기
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String id = "scott";
			String pwd = "tiger";
			con = DriverManager.getConnection(url, id, pwd);
		//3. 쿼리문 생성객체얻기
			stmt = con.createStatement();
		//4. 쿼리 수행 후 결과 얻기
			StringBuilder updateCpDept = new StringBuilder();
			updateCpDept
			.append("update cp_dept set ")
			.append("dname='").append(cdvo.getDname()).append("',")
			.append("loc='").append(cdvo.getLoc()).append("' ")
			.append("where deptno=").append(cdvo.getDeptno());
			
			int cnt = stmt.executeUpdate(updateCpDept.toString());
			//테이블의 구조상 부서번호는 PK이므로 한행만 변경된다.
			if(cnt !=0 /*cnt==1으로 해도 상관없음. update성격상 여러개 바뀔수도 있어서 !=0을 사용*/) {
				flag = true;
			}//end if
		}finally {
		//5. 연결 끊기
			if(stmt!=null) {stmt.close();}//end if
			if(con!=null) {stmt.close();}//end if
			}//end finally
		return flag;
	}//updateCpDept
	
	public boolean deleteCpDept(int deptno) throws SQLException {
		boolean flag = false;
		//1.드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
		
		Connection con = null;
		Statement stmt= null;
		try {
		//2.Connection 얻기
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String id = "scott";
			String pass="tiger";
			con=DriverManager.getConnection(url, id, pass);
		
		//3.쿼리문 생성 객체 얻기
			stmt = con.createStatement();
		//4.쿼리 수행 후 결과 얻기
			StringBuilder deleteCpDept = new StringBuilder();
			deleteCpDept.append("delete from cp_dept where deptno =").append(deptno);
			
			int cnt=stmt.executeUpdate(deleteCpDept.toString());
			
			if(cnt ==1) {/*deptno가 primarykey이기 때문에 지워져도 1개가 지워짐*/
				flag=true; 
			}//end if
			
		}finally {
			//5.연결 끊기
			if(stmt!=null) {stmt.close();}//end if
			if(con!=null) {stmt.close();}//end if
		}//end finally
		return flag;
	}//deleteCpDept
	
	public List<CpDeptVO> selectAllCpDept() throws SQLException{
		List<CpDeptVO> list = new ArrayList<CpDeptVO>();
		//1. 드라이버로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		//2. Connection얻기
		//3. 쿼리문 생성객체얻기
		//4. 쿼리문 수행 후 결과 얻기
		//5. 연결 끊기
		return list;
	}//selectAllCpDept
	
	public OneCpDeptVO selectCpDept(int deptno) {
		OneCpDeptVO ocdvo = null;
		
		return ocdvo;
	}//selectCpDept
	
}//class
