package day0104;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Statement ��ü�� ����Ͽ� CRUD�� �����ϴ� Ŭ����
 * CRUD(Create Read Update Delete)�� ����
 * @author owner
 */
public class UseStatementCRUD {
	
	/**
	 * VO�� �Է¹޾� VO�� ���� CP_DEPT���̺� �߰�
	 * @param cdvo �μ���ȣ, �μ���, ��ġ�� ���� VO 
	 * @throws SQLException �������� 
	 */
	public void insertCpDept(CpDeptVO cdvo) throws SQLException {
		//1. ����̹��ε�
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
		
		Connection con = null;
		Statement stmt = null;
		
		try {
		//2. Connection ���
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String id = "scott";
			String pwd = "tiger";
			
			con = DriverManager.getConnection(url, id, pwd);
		//3. ������ ������ü ���
			stmt = con.createStatement();
		//4. �������� �� ��� ���
//			String insertCpdept = "insert into cp_dept(deptno, dname, loc) values("+
//					cdvo.getDeptno()+",'"+cdvo.getDname()+"','"+cdvo.getLoc()+"')";
			//���ڿ��� +�� ������ �� ���ڿ�
			//�乮�ڿ��� ��� StringBuffer�� StringBuilder���
			//.�� �ٿ����� �� : method chain
			StringBuilder insertCpdept = new StringBuilder();
			insertCpdept.append("insert into cp_dept(deptno, dname, loc) values(")
			.append(cdvo.getDeptno()).append(",'")
			.append(cdvo.getDname()).append("','")
			.append(cdvo.getLoc()).append("')");
			
			int cnt = stmt.executeUpdate(insertCpdept.toString());
			System.out.println(cnt);
			
		}finally {
		//5. ���� ����
		if(stmt!=null) {stmt.close();}//end if
		if(con!=null) {stmt.close();}//end if
		}
	}//insertCpDept
	
	public boolean updateCpDept(CpDeptVO cdvo) throws SQLException {
		boolean flag = false;
		
		//1. ����̹��ε�
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
		
		Connection con = null;
		Statement stmt = null;
		try {
		//2. Connection���
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String id = "scott";
			String pwd = "tiger";
			con = DriverManager.getConnection(url, id, pwd);
		//3. ������ ������ü���
			stmt = con.createStatement();
		//4. ���� ���� �� ��� ���
			StringBuilder updateCpDept = new StringBuilder();
			updateCpDept
			.append("update cp_dept set ")
			.append("dname='").append(cdvo.getDname()).append("',")
			.append("loc='").append(cdvo.getLoc()).append("' ")
			.append("where deptno=").append(cdvo.getDeptno());
			
			int cnt = stmt.executeUpdate(updateCpDept.toString());
			//���̺��� ������ �μ���ȣ�� PK�̹Ƿ� ���ุ ����ȴ�.
			if(cnt !=0 /*cnt==1���� �ص� �������. update���ݻ� ������ �ٲ���� �־ !=0�� ���*/) {
				flag = true;
			}//end if
		}finally {
		//5. ���� ����
			if(stmt!=null) {stmt.close();}//end if
			if(con!=null) {stmt.close();}//end if
			}//end finally
		return flag;
	}//updateCpDept
	
	public boolean deleteCpDept(int deptno) throws SQLException {
		boolean flag = false;
		//1.����̹� �ε�
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
		
		Connection con = null;
		Statement stmt= null;
		try {
		//2.Connection ���
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String id = "scott";
			String pass="tiger";
			con=DriverManager.getConnection(url, id, pass);
		
		//3.������ ���� ��ü ���
			stmt = con.createStatement();
		//4.���� ���� �� ��� ���
			StringBuilder deleteCpDept = new StringBuilder();
			deleteCpDept.append("delete from cp_dept where deptno =").append(deptno);
			
			int cnt=stmt.executeUpdate(deleteCpDept.toString());
			
			if(cnt ==1) {/*deptno�� primarykey�̱� ������ �������� 1���� ������*/
				flag=true; 
			}//end if
			
		}finally {
			//5.���� ����
			if(stmt!=null) {stmt.close();}//end if
			if(con!=null) {stmt.close();}//end if
		}//end finally
		return flag;
	}//deleteCpDept
	
	public List<CpDeptVO> selectAllCpDept() throws SQLException{
		List<CpDeptVO> list = new ArrayList<CpDeptVO>();
		//1. ����̹��ε�
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		//2. Connection���
		//3. ������ ������ü���
		//4. ������ ���� �� ��� ���
		//5. ���� ����
		return list;
	}//selectAllCpDept
	
	public OneCpDeptVO selectCpDept(int deptno) {
		OneCpDeptVO ocdvo = null;
		
		return ocdvo;
	}//selectCpDept
	
}//class
