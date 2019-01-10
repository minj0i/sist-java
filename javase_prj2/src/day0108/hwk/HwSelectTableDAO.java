package day0108.hwk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HwSelectTableDAO {

	
	public HwSelectTableDAO() {
	}//�⺻ ������
	
	/**
	 * DB����
	 * @return
	 * @throws SQLException
	 */
	private Connection getConn() throws SQLException{
		Connection con = null;
		//1.
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//2.
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		String id = "scott";
		String pass = "tiger";
		
		con = DriverManager.getConnection(url, id, pass);
		return con;
	}
	
	/**
	 * Table�̸��� List�� �ޱ� => combobox�� �ֱ�
	 * @return
	 * @throws SQLException
	 */
	public List<String> getTableName() throws SQLException {
		List<String> listTablenames = new ArrayList<String>();
		String tableName = "";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//1.����̹��ε�
			//2.Connection���
			con = getConn();
			//3.������ ���� ��ü ���
			//PreparedStatement ��ü�� ����Ǵ� �������� �˰��ִ�.
			String selectTab="select tname from tab";
			pstmt=con.prepareStatement(selectTab);
			//4.���ε� ������ �� ����
			//5.���� ���� �� ��� ���
			rs = pstmt.executeQuery();
			while(rs.next()) {
				tableName = rs.getString("tname");
				listTablenames.add(tableName);
			}
		} finally {
			//6.���� ����
			if(pstmt != null) {pstmt.close();}
			if(con != null) {con.close();}
		}
		
		return listTablenames;
	}
	
	/**
	 * �������� ���� ���ϴ� ���� Jtable�� �ֱ� ���� ���
	 * @param tableName
	 * @return
	 * @throws SQLException
	 */
	public List<String[]> getTableColumns(String tableName) throws SQLException {
		List<String[]> listTableColumns = new ArrayList<String[]>();
		String[] tableColumns = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//1.����̹��ε�
			//2.Connection���
			con = getConn();
			//3.������ ���� ��ü ���
			//PreparedStatement ��ü�� ����Ǵ� �������� �˰��ִ�.		
			StringBuilder selectJoinTab = new StringBuilder();
			selectJoinTab
			.append("select utc.column_name cname, utc.data_type dtype, utc.data_length dlength, ucc.constraint_name conName ")
			.append("from user_tab_cols utc, user_cons_columns ucc ")
			.append("where utc.table_name = ucc.table_name(+) ")
			.append("and utc.column_name = ucc.column_name(+) ")
			.append("and utc.table_name=? ");

			pstmt=con.prepareStatement(selectJoinTab.toString());
			//4.���ε� ������ �� ����
			pstmt.setString(1, tableName);
			//5.���� ���� �� ��� ���
			rs = pstmt.executeQuery();
			while(rs.next()) {
				tableColumns = new String[4];
				tableColumns[0] = rs.getString("cname");
				tableColumns[1] = rs.getString("dtype");
				tableColumns[2] = rs.getString("dlength");
				tableColumns[3] = rs.getString("conName");
				
				if(tableColumns[3]!=null && !tableColumns[3].equals("")) {
				switch(tableColumns[3].substring(0, 2)) {
				case "FK" :tableColumns[3] = "Foreign Key"; break;
				case "PK" :tableColumns[3] = "Primary Key"; break;
				case "SY" :tableColumns[3] = "������� ���� Ȯ��"; break;
				default : tableColumns[3] = rs.getString("conName"); break;
					}
				}
				
				listTableColumns.add(tableColumns);
			}
		} finally {
			//6.���� ����
			if(pstmt != null) {pstmt.close();}
			if(con != null) {con.close();}
		}
		
		return listTableColumns;
	}
	
}