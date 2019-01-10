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
 * DDL : (Data Definition Language) : create, drop, truncate을 사용하여
 * 테이블을 생성
 * @author owner
 */
public class CreateTable implements ActionListener{
	public TableCreateView tcv;
	
	public CreateTable() throws SQLException{
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; //테이블이 존재하면 지우고 만들기 위해 필요함
		
		try {
		//1.
		//2.
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "scott";
			String pass = "tiger";
			
			con = GetConnection.getInstance().getConn(url, id, pass);
			
			String tableName= tcv.getJtTableName().getText();
		//3. //테이블이 존재하는지 ?
			StringBuilder selectTname = new StringBuilder();
			selectTname.append("select tname from tab where tname=?");
		//4.	
			pstmt = con.prepareStatement(selectTname.toString());
			pstmt.setString(1, tableName.toUpperCase());
		//5.
			rs=pstmt.executeQuery();
			boolean flag = false;
			if(rs.next()) {
				flag = JOptionPane.showConfirmDialog(null, tableName+"테이블이 존재합니다. 삭제 후 생성하시겠습니까?")
						==JOptionPane.OK_OPTION;
			}//end if
			
			pstmt.close(); //안끊어주면 메모리가 샘
			
			if(flag) {//(위에서 OK누른 거니깐) 삭제한 후 테이블을 생성
				//3.
				StringBuilder dropTable = new StringBuilder();
				dropTable.append(" drop table ").append(tableName);
				pstmt = con.prepareStatement(dropTable.toString());
				//4.
				pstmt.executeQuery();
				
				pstmt.close();
			}//end if
			
		//3,4,5를 여러번 사용할 때는 rs를 끊어주기		
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
//			boolean flag = pstmt.execute(); //항상 false가 나오기 때문에 담아줄 필요가 없음
			pstmt.executeQuery(); //밑에 SQLException에서 showMessage해주면 됨
			JOptionPane.showMessageDialog(null, "테이블이 생성되었습니다.");
			
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
			JOptionPane.showMessageDialog(null, "테이블이 존재합니다.");
			e.printStackTrace();
		}//catch
	}//main




	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==tcv.getJbTableAdd()) {
		}
	}




}//class
