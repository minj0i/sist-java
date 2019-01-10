package day0109;

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
public class CreateTable {

	public CreateTable() throws SQLException {
		
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
			
			String tableName= JOptionPane.showInputDialog("생성할 테이블 명을 입력");
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
			
			//thin드라이버에서는 테이블 만드는 것까지는 됨
			//함수를 만들거나 package를 만들거나 trigger를 만드는 것 등은 안됨
			
			createTable
			.append(" create table ").append(tableName).append("(")
			.append(" name varchar2(12) not null, ")
			.append(" age number(3) not null, ")
			.append(" id varchar2(20) constraint pk_").append(tableName).append(" primary key) ");
			
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
}//class
