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
			insertCpdept.append("insert into cp_dept(deptno, dname, loc) values( ")
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
			deleteCpDept.append("delete from cp_dept where deptno = ").append(deptno);
			
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
		
		try {
		//2. Connection���
		String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		String id = "scott";
		String pass="tiger";
		
		con=DriverManager.getConnection(url, id, pass);
		//3. ������ ������ü���
		stmt=con.createStatement();
		//4. ������ ���� �� ��� ���
		String selectCpdept="select deptno,dname,loc from cp_dept ";
		
		rs = stmt.executeQuery(selectCpdept);
		CpDeptVO cdvo = null;
		
		while(rs.next()) {//��ȸ�� ���ڵ尡 �����Ѵٸ�
			//�÷��� �ε����� ��ȸ (������ ������ ������ ���� �������� ���� ����)
			//���ν��� �θ��� ��¿������ �ε����� ��ȸ
//			System.out.println(/*rs.getInt(0):java.sql.SQLException: �������� �� �ε���, Ŀ���ڸ��̱� ������*/
//					rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
			
			//�÷��� �̸����� �θ��°� �������� �� ����
//			System.out.println(rs.getInt("deptno")+" "+rs.getString("dname")+" "+rs.getString("loc"));
			
			//��ȸ ����� VO�� ����
			cdvo = new CpDeptVO(rs.getInt("deptno"),rs.getString("dname"),rs.getString("loc"));
			//���� �̸����� ������ cdvo��ü�� ������� �ʵ��� �����ϱ� ���� List�� �߰�
			list.add(cdvo);
			
		}//end while
		
		}finally {
			//5. ���� ����
			if(rs!=null) {rs.close();}//end if
			if(stmt!=null) {stmt.close();}//end if
			if(con!=null) {con.close();}//end if
		}//end finally
		return list;
	}//selectAllCpDept
	
//	public static void main(String[] args) {//Ȯ�ο�
//		UseStatementCRUD u = new UseStatementCRUD();
//		try {
//			u.selectAllCpDept();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}//end catch
//	}
	
	public OneCpDeptVO selectCpDept(int deptno) throws SQLException {
		OneCpDeptVO ocdvo = null;
		//1.����̹� �ε�
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
		//2.Connection ���
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		String id = "scott";
		String pass = "tiger";
		
		con=DriverManager.getConnection(url, id, pass);
		//3.������ ���� ��ü ���
		stmt=con.createStatement();
		//4.������ ���� �� ��� ���
		StringBuilder selectCpDept = new StringBuilder();
		selectCpDept.append("select dname,loc from cp_dept where deptno= ")
		.append(deptno);
		
		rs = stmt.executeQuery(selectCpDept.toString());
		
		if(rs.next()) {//��ȸ�� ���ڵ尡 �����Ѵٸ� //������ key�� �Ѱ�. �ƴϸ� while�����
			ocdvo = new OneCpDeptVO(rs.getString("dname"),rs.getString("loc"));
		}//end if
		
		}finally {
		//5.���� ����
			if(rs!=null) {rs.close();}//end if
			if(stmt!=null) {stmt.close();}
			if(con!=null) {con.close();}
		}//end finally
		return ocdvo;
	}//selectCpDept
	
	/**
	 * CP_DEPT ���̺��� ��� �μ���ȣ�� ��ȸ
	 * @return
	 * @throws SQLException
	 */
	public List<Integer> selectAllCpDeptNo() throws SQLException{
		List<Integer> list = new ArrayList<Integer>();
		//1.����̹� �ε�
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
	
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
		//2.Connection���
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		String id = "scott";
		String pass = "tiger";
		
		con = DriverManager.getConnection(url, id, pass);
		//3.������ ���� ��ü ���
		stmt = con.createStatement();	
		//4.������ ���� �� ��� ���
		StringBuilder allCpDept = new StringBuilder();
		allCpDept.append("select deptno from cp_dept");
		
		rs = stmt.executeQuery(allCpDept.toString());
		
		while(rs.next()) {
			list.add(rs.getInt("deptno"));
			}//end while
		}finally {
		//5.���� ����
			if(rs!=null) {rs.close();}//end if
			if(stmt!=null) {stmt.close();}
			if(con!=null) {con.close();}
		}//end finally
		
		return list;
	}//selectAllCpDeptNo
	
	
}//class
