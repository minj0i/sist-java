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
	
	//����̹��ε��� Ŀ�ؼǾ�⸦ �Ź����� �ʱ� ���ؼ�
	private Connection getConn() throws SQLException{
		Connection con = null;
		//1.����̹��ε�
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//2.Connection ���
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String id="scott";
		String pass="tiger";
		
		con = DriverManager.getConnection(url, id, pass);
		
		return con;
	}//getConn ->������ Ŀ�ؼ��� �ʿ��ϸ� �θ��� ��
	
	public void insertCpEmp2(CpEmp2VO cevo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
		//1.����̹��ε�
		//2.Connection���
			con = getConn();
		//3. ������ ���� ��ü ��� : PreparedStatment��ü�� ����Ǵ� �������� �˰� ���� 
			String insertCpEmp="insert into cp_emp2(empno, ename, hiredate, sal) values(?,?,sysdate,?)";
			pstmt=con.prepareStatement(insertCpEmp);
		//4. bind ������ �� ���� //���� ? �� ���� ���� �־��ִ� ��
			pstmt.setInt(1, cevo.getEmpno());
			pstmt.setString(2, cevo.getEname());
			pstmt.setInt(3, cevo.getSal());
		//5. ������ ���� �� ��� ���
			pstmt.executeUpdate();
			//pstmt.execute();�� �ᵵ �������
		}finally {
		//6. ���� ����
			if(pstmt!=null) {pstmt.close();}//end if
			if(con!=null) {con.close();}//end if	
		}//end finally
	}//insertCpEmp2
	
//	/**
//	 * �����׽�Ʈ : �޼ҵ尡 ����� �����ϴ��� �������� �޼ҵ�/Ŭ����/��� �׽�Ʈ
//	 * �ϰ� ������ ��
//	 * QA���� �ϴ� ������� �ַ� ��
//	 * (ȭ��Ʈ�ڽ��׽���: �ڵ带 � �߶� �м��ؼ� �����غ�(��������� ������ ���� - �ڵ带 ���� �� �ƴϱ�) / ���ڽ� : üũ����Ʈ�� ���� üũ)
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		UsePreparedStatementDAO u = new UsePreparedStatementDAO();
//		CpEmp2VO c = new CpEmp2VO(9876, 3000, "����ö");
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
