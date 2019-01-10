package day0109;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import kr.co.sist.connection.GetConnection;

/**
 * DDL : (Data Definition Language) : create, drop, truncate�� ����Ͽ�
 * ���̺��� ����
 * @author owner
 */
public class CreateTable {

	public CreateTable() throws SQLException {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; //���̺��� �����ϸ� ����� ����� ���� �ʿ���
		
		try {
		//1.
		//2.
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "scott";
			String pass = "tiger";
			
			con = GetConnection.getInstance().getConn(url, id, pass);
			
			String tableName= JOptionPane.showInputDialog("������ ���̺� ���� �Է�");
		//3. //���̺��� �����ϴ��� ?
			StringBuilder selectTname = new StringBuilder();
			selectTname.append("select tname from tab where tname=?");
		//4.	
			pstmt = con.prepareStatement(selectTname.toString());
			pstmt.setString(1, tableName.toUpperCase());
		//5.
			rs=pstmt.executeQuery();
			boolean flag = false;
			if(rs.next()) {
				flag = JOptionPane.showConfirmDialog(null, tableName+"���̺��� �����մϴ�. ���� �� �����Ͻðڽ��ϱ�?")
						==JOptionPane.OK_OPTION;
			}//end if
			
			pstmt.close(); //�Ȳ����ָ� �޸𸮰� ��
			
			if(flag) {//(������ OK���� �Ŵϱ�) ������ �� ���̺��� ����
				//3.
				StringBuilder dropTable = new StringBuilder();
				dropTable.append(" drop table ").append(tableName);
				pstmt = con.prepareStatement(dropTable.toString());
				//4.
				pstmt.executeQuery();
				
				pstmt.close();
			}//end if
			
		//3,4,5�� ������ ����� ���� rs�� �����ֱ�		
		//3.
			StringBuilder createTable = new StringBuilder();
			
			//thin����̹������� ���̺� ����� �ͱ����� ��
			//�Լ��� ����ų� package�� ����ų� trigger�� ����� �� ���� �ȵ�
			
			createTable
			.append(" create table ").append(tableName).append("(")
			.append(" name varchar2(12) not null, ")
			.append(" age number(3) not null, ")
			.append(" id varchar2(20) constraint pk_").append(tableName).append(" primary key) ");
			
			pstmt = con.prepareStatement(createTable.toString());
			
		//4.
			
		//5.
//			boolean flag = pstmt.execute(); //�׻� false�� ������ ������ ����� �ʿ䰡 ����
			pstmt.executeQuery(); //�ؿ� SQLException���� showMessage���ָ� ��
			JOptionPane.showMessageDialog(null, "���̺��� �����Ǿ����ϴ�.");
			
		}finally {
		//6.
			if(rs!=null) {rs.close();}//end if
			if(pstmt!=null) {pstmt.close();}//end if
			if(con!=null) {con.close();}//end if
		}//end finally
		
		
	}//createTable
	
	public static void main(String[] args) {
		try {
			new CreateTable();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "���̺��� �����մϴ�.");
			e.printStackTrace();
		}//catch
	}//main
}//class