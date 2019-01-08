package day0107;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	
	/**
	 * 삽입, 추가하는 기능
	 * @param cevo
	 * @throws SQLException
	 */
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
	

	/**
	 * 사원번호, 사원명, 연봉을 입력받아 사원번호에 해당하는 사원명, 연봉을 변경하는 일
	 * @param cevo
	 * @return
	 * @throws SQLException
	 */
	public boolean updateCpEmp2(CpEmp2VO cevo) throws SQLException {
		boolean flag = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		
		try {
		//1.드라이버 로딩
		//2.connection 얻기
			con = getConn();
		//3.쿼리문 생성 객체 얻기
			//쿼리가 ''가 안붙어서 간단해짐
			String updateCpEmp2="update cp_emp2 set ename=?,sal=? where empno=?";
			pstmt = con.prepareStatement(updateCpEmp2);
		//4.바인드 변수에 값 넣기
			pstmt.setString(1, cevo.getEname());
			pstmt.setInt(2, cevo.getSal());
			pstmt.setInt(3, cevo.getEmpno());
			
		//5.쿼리문 수행 후 결과 얻기
			int cnt = pstmt.executeUpdate();
			if(cnt!=0) {
				flag =true;
			}//end if
		}finally {
		//6.연결 종료
			if(pstmt!=null) {pstmt.close();}//end if
			if(con!=null) {con.close();}//end if	
		}//end finally
		return flag;
	}//updateCpEmp2
	
	/**
	 * 사원번호를 입력받아 사원번호에 해당하는 사원을 삭제
	 * @param empno
	 * @return
	 * @throws SQLException
	 */
	public boolean deleteCpEmp2(int empno) throws SQLException{
		boolean flag = false;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
		//1.드라이버로딩
		//2.connection연결
			con = getConn();
		//3.쿼리문 생성객체 얻기
			String deleteCpEmp2 = "delete from cp_emp2 where empno=?";
			pstmt = con.prepareStatement(deleteCpEmp2);
		//4.바인드변수에 값 설정
			pstmt.setInt(1, empno);
			
		//5.쿼리 수행 후 결과 얻기
			int cnt = pstmt.executeUpdate();
			
			if(cnt !=0) {
				flag = true;
			}
		}finally {
		//6.연결 종료
			if(pstmt!=null) {pstmt.close();}//end if
			if(con!=null) {con.close();}//end if
		}//end finally
		return flag;
	}//deleteCpEmp2
	
	
	/**
	 * 모든 부서 사원정보를 조회
	 * @return
	 * @throws SQLException
	 */
	public List<CpEmp2AllVO> selectAllCpEmp2() throws SQLException{
		List<CpEmp2AllVO> list = new ArrayList<CpEmp2AllVO>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
		//1. 드라이버로딩
		//2. Connection얻기
			con = getConn();
		//3. 쿼리문 생성객체 얻기
			String selectAllCpEmp2="select empno, ename, sal, to_char(hiredate, 'yyyy-mm-dd') hiredate from cp_emp2 ";
			pstmt=con.prepareStatement(selectAllCpEmp2);
		//4. 바인드변수에 값 넣기
			//물음표가 없으므로 없음
		//5. 쿼리문 수행 후 결과 얻기
			rs = pstmt.executeQuery(); //rs는 커서의 제어권을 가지고 있음
			
			//조회결과를 VO에 할당
			CpEmp2AllVO cda_vo = null;
			while(rs.next()) {
				cda_vo = new CpEmp2AllVO(rs.getInt("empno"),rs.getInt("sal"), 
						rs.getString("ename"), rs.getString("hiredate"));
				//가장 마지막 레코드만 가지게 될 것임
				list.add(cda_vo);
			}//end while
			
		}finally {
		//6. 연결 종료
			if(rs!=null) {rs.close();}//end if
			if(pstmt!=null) {pstmt.close();}//end if
			if(con!=null) {con.close();}//end if
		}//end finally
		return list;
	}//selectAllCpEmp2
	
	
	
	/**
	 * 입력되는 사원번호에 해당하는 사원정보 조회 
	 * @param empno
	 * @return
	 * @throws SQLException
	 */
	public CpEmp2OneVO selectOneCpEmp2(int empno) throws SQLException {
		CpEmp2OneVO cevo = null;
		
		
		Connection con = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		
		try {
		//1.드라이버로딩
		//2.Connection 얻기
			con = getConn();
		//3.쿼리문 생성객체 얻기
			//hiredate에 to_char안쓰면 java의 Date로 읽어들임
			String selectOneCpEmp2="select ename, sal, hiredate from cp_emp2 where empno=?";
			pstmt = con.prepareStatement(selectOneCpEmp2);
		//4.바인드 변수에 값 설정
			pstmt.setInt(1, empno);
		//5.쿼리문 수행 후 결과얻기
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				cevo=new CpEmp2OneVO(rs.getInt("sal"), rs.getString("ename"), rs.getDate("hiredate"));
			}//end if
			
		}finally {
		//6.연결 끊기
			if(rs!=null) {rs.close();}//end if
			if(pstmt!=null) {pstmt.close();}//end if
			if(con!=null) {con.close();}//end if
		}//end finally
		return cevo;
	}//selectOneCpEmp2
	
//	/**
//	 * 단위테스트 : 메소드가 제대로 동작하는지 보기위해 메소드/클래스/모듈 테스트
//	 * 하고 지워야 함
//	 * QA업무 하는 사람들이 주로 함
//	 * (화이트박스테스터: 코드를 까서 잘라서 분석해서 실행해봄(기술적으로 우위에 있음 - 코드를 읽을 줄 아니까) / 블랙박스 : 체크리스트를 만들어서 체크)
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		UsePreparedStatementDAO u = new UsePreparedStatementDAO();
//		try {
////		CpEmp2VO c = new CpEmp2VO(4545, 4000, "공선의");
////			List<CpEmp2AllVO> list= u.selectAllCpEmp2();
////			System.out.println(list);
//			CpEmp2OneVO c = u.selectOneCpEmp2(2222);
//			System.out.println(c);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}//main 
}//class
