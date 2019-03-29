package json0328;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class JsonEmpSearchDAO {
	private static JsonEmpSearchDAO jes_dao;

	private JsonEmpSearchDAO() {

	}// JsonEmpSearchDAO

	public static JsonEmpSearchDAO getInstance() {
		if (jes_dao == null) {
			jes_dao = new JsonEmpSearchDAO();
		} // end if
		return jes_dao;
	}// getInstance

	private Connection getConn() throws SQLException {
		Connection con = null;

		try {
			// 1. JNDI 사용 객체 생성
			Context ctx = new InitialContext();
			// 2. DBCP에 저장된 DataSource를 얻는다
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/jsp_dbcp");
			// 3. Connection 얻기
			con = ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} // end catch

		return con;
	}// getConn

	public List<EmpVO> selectEmpList(int deptno) throws SQLException {
		List<EmpVO> list = new ArrayList<EmpVO>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 1. JNDI 사용 객체 얻기
			// 2. DataSource를 DBCP에서 꺼내온다.
			// 3. Connection 얻기
			con = getConn();
			// 4. 쿼리문 수행 객체 얻기
			String selectEmp = "select empno, sal, ename, job, to_char(hiredate,'yyyy-MM-dd dy') hiredate from emp where deptno=?";
			pstmt = con.prepareStatement(selectEmp);
			pstmt.setInt(1, deptno);
			// 5. 쿼리문 수행 후 결과 얻기
			rs = pstmt.executeQuery();
			EmpVO ev = null;
			while (rs.next()) {
				ev = new EmpVO(rs.getInt("empno"), rs.getInt("sal"), rs.getString("ename"), rs.getString("job"),
						rs.getString("hiredate"));
				list.add(ev);
			} // end while
		} finally {
			// 6. 연결 끊기
			if (rs != null) {rs.close();} // end rs
			if (rs != null) {pstmt.close();	} // end rs
			if (pstmt != null) {con.close();} // end rs
		} // end finally

		return list;

	}// selectEmpList
}// class
