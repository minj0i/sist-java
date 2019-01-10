package day0109.hwk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class CreateTable implements ActionListener{
	public TableCreateView tcv;
	
	public CreateTable() throws SQLException{
		
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
			
			String tableName= tcv.getJtTableName().getText();
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
			createTable.append(" create table ").append(tableName);
			
			String columnName = tcv.getJtColumnName().getText();
			String dataType = tcv.getJcDatatype().getSelectedItem().toString();
			String dataLength = tcv.getJtDataLength().getText();
			String constraint = tcv.getJcConstraint().getSelectedItem().toString();
			String conName = tcv.getJtConstraintName().getText();
			
			StringBuilder column = new StringBuilder();
			column
			.append("( \n").append(columnName).append(" ")
			.append(dataType).append("(").append(dataLength);
			
			if(columnName!=null&&!columnName.equals("")) {
			createTable.insert(createTable.lastIndexOf(")")-1,column)
			.append(column).append(")");
			}
			
			StringBuilder constraintN = new StringBuilder();
			createTable.append(conName).append(" ").append(constraint);
			if(constraint.equals("primary key")||constraint.equals("foreign key")) {
				createTable.insert(createTable.lastIndexOf(")")-1, constraintN);
			}
			
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




	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==tcv.getJbTableAdd()) {
		}
	}




}//class
