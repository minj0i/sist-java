package day0109;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import kr.co.sist.connection.GetConnection;

/**
 * �÷����� �������� ����Ǵ� ���<br>
 * �÷����� �Է¹޾� �ش� �÷������� ��ȸ<br>
 * EMP���̺� ��ȸ �����ȣ�� �÷���(�޶��� �� ����)�� �Է¹޾� ��ȸ
 * @author owner
 */
public class DynamicColumn {
	
	public DynamicColumn() throws SQLException{
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String[]columnName = {"ename", "job", "mgr", "hiredate", "sal", "comn", "deptno"};
		
		String input = JOptionPane.showInputDialog("�����ȣ�� �÷��� �ϳ��� �Է����ּ���\n ��)�����ȣ,�÷���");
		//csv : comma separated value 
		String[]temp = input.split(",");
		
		if(temp.length !=2) {
			JOptionPane.showMessageDialog(null, "�Է������� Ȯ���ϼ���.");
			return;
		}//end if

		try {
		int empno = Integer.parseInt(temp[0].trim());
	
		String inputColumn = temp[1].trim();
		
		boolean columnFlag = false;
		for(String column : columnName) {
			if(column.equals(inputColumn.toLowerCase())) { //DB���̺��� �÷����� ���� �÷����̶��
				columnFlag = true;
			}//end if
		}//end for
		
		if(!columnFlag) {
			JOptionPane.showMessageDialog(null, inputColumn+"�� EMP���̺��� �÷����� �������� �ʽ��ϴ�.");
			return; //�Ʒ������� �귯���� ���ϰ�
		}
		
		try {
		//1.
		//2.
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "scott";
			String pass = "tiger";
			con = GetConnection.getInstance().getConn(url, id, pass);
		//3.
			//�÷����� hiredate�� ��� ���ڿ��� ó���ϱ� ���ؼ�
			if(inputColumn.equals("hiredate")) {
				inputColumn="to_char(hiredate, 'yyyy-mm-dd day hh24:mi:ss') hiredate ";
			}
			
			StringBuilder selectEmp = new StringBuilder();
			//�÷���, ���̺����� ���ε� ������ ó������ �ʴ´�. �������� ���� �־� ����Ѵ�.
//			selectEmp.append("select ").append(inputColumn).append(" from emp ")
			selectEmp.append("select ?  from emp ")
			.append(" where empno=?");
			
			pstmt = con.prepareStatement(selectEmp.toString());
			
		//4.
//			pstmt.setInt(1, empno);
			pstmt.setString(1, inputColumn);
			pstmt.setInt(2, empno);
		//5.
			rs = pstmt.executeQuery();
			if(rs.next()) {//�����ȣ�� ��ȸ�� ���ڵ尡 �����Ѵٸ�
				
				String stringData = null;
				int intData = 0;
				if(temp[1].trim().equals("ename")||temp[1].trim().equals("job")||
						temp[1].trim().equals("hiredate")) {
//					stringData = rs.getString(1); //�Ʒ��� ���� �����پ˾����� ...ù��° �÷��� ������ �־ ������ �Ȱɷ���
					stringData = rs.getString(temp[1].trim());
				}else {
					intData = rs.getInt(temp[1].trim());
				}//end else
				JOptionPane.showMessageDialog(null, temp[1]+"���� ��ȸ�� ��: "
						+(intData == 0? stringData:intData));
			}else{
				JOptionPane.showMessageDialog(null, "�Է��� �����ȣ�� �������� �ʽ��ϴ�.");
			}//end if
			
		}finally {
		//6.
			if(rs!=null) {rs.close();}//end if
			if(pstmt!=null) {pstmt.close();}//end if
			if(con!=null) {con.close();}//end if
		}//end finally
		}catch(NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "�����ȣ�� �����̾�� �մϴ�.");
		}//end catch
	}//DynamicColumn

	
	public static void main(String[] args) {
		try {
			new DynamicColumn();
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
	}//main

}//class