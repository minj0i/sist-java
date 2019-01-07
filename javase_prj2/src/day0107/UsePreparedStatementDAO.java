package day0107;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsePreparedStatementDAO {
	public UsePreparedStatementDAO() {
		
	}//UsePreparedStatementDAO
	
	//드라이버로딩과 커넥션얻기를 매번하지 않기 위해서
	private Connection getConn() throws SQLException{
		Connection con = null;
		//1.드라이버로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//2.Connection 얻기
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String id="scott";
		String pass="tiger";
		
		con = DriverManager.getConnection(url, id, pass);
		
		return con;
	}//getConn ->앞으로 커넥션이 필요하면 부르면 됨
	
	public void insertCpEmp2(CpEmp2VO cevo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
		//1.드라이버로딩
		//2.Connection얻기
			con = getConn();
		//3. 쿼리문 생성 객체 얻기 : PreparedStatment객체는 실행되는 쿼리문을 알고 있음 
			String insertCpEmp="insert into cp_emp2(empno, ename, hiredate, sal) values(?,?,sysdate,?)";
			pstmt=con.prepareStatement(insertCpEmp);
		//4. bind 변수에 값 설정 //위에 ? 에 대한 값을 넣어주는 것
			pstmt.setInt(1, cevo.getEmpno());
			pstmt.setString(2, cevo.getEname());
			pstmt.setInt(3, cevo.getSal());
		//5. 쿼리문 수행 후 결과 얻기
			pstmt.executeUpdate();
			//pstmt.execute();로 써도 상관없음
		}finally {
		//6. 연결 종료
			if(pstmt!=null) {pstmt.close();}//end if
			if(con!=null) {con.close();}//end if	
		}//end finally
	}//insertCpEmp2
	
//	/**
//	 * 단위테스트 : 메소드가 제대로 동작하는지 보기위해 메소드/클래스/모듈 테스트
//	 * 하고 지워야 함
//	 * QA업무 하는 사람들이 주로 함
//	 * (화이트박스테스터: 코드를 까서 잘라서 분석해서 실행해봄(기술적으로 우위에 있음 - 코드를 읽을 줄 아니까) / 블랙박스 : 체크리스트를 만들어서 체크)
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		UsePreparedStatementDAO u = new UsePreparedStatementDAO();
//		CpEmp2VO c = new CpEmp2VO(9876, 3000, "김희철");
//		try {
//			u.insertCpEmp2(c);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}//main 
	
	public boolean updateCpEmp2(CpEmp2VO cevo) throws SQLException {
		boolean flag = false;
		
		return flag;
	}//updateCpEmp2
	
	public boolean deleteCpEmp2(int empno) throws SQLException{
		boolean flag = false;
		
		return flag;
	}//deleteCpEmp2
	
	public List<CpEmp2AllVO> seletAllCpEmp2() throws SQLException{
		List<CpEmp2AllVO> list = new ArrayList<CpEmp2AllVO>();
		
		return list;
	}//selectAllCpEmp2
	
	public CpEmp2OneVO selectOneCpEmp2(int empno) throws SQLException {
		CpEmp2OneVO cevo = null;
		
		return cevo;
	}
}//class
