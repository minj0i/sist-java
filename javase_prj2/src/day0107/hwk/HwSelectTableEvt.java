package day0107.hwk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class HwSelectTableEvt extends WindowAdapter implements ActionListener {
	private HwSelectTableView hst;
	
	public HwSelectTableEvt(HwSelectTableView hst) {
		this.hst = hst;
		try {
			selectTable();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void windowClosing(WindowEvent we) {
		hst.dispose();
	}// windowClosing
	
	
	public List<HwSelectTableVO> selectTable() throws SQLException{
		List<HwSelectTableVO> list = new ArrayList<>();
	
		//1.����̹��ε�
		try {
			Class.forName("oracle.jdbc.OracleDriver"); //�ݵ�� �ܿ��
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
	
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
		//2.Connection���
			String url = "jdbc:oracle:thin:@localhost:1521:orcl"; //�ݵ�� �ܿ��
			String id ="scott";
			String pass="tiger";
			con=DriverManager.getConnection(url, id, pass);
	
		//3.������ ���� ��ü ���
			stmt = con.createStatement();
			
		//4.������ ���� �� ��� ���
			StringBuilder selectName = new StringBuilder();
			
			selectName
			.append(" select tname ")
			.append(" from tab ");
			
			rs=stmt.executeQuery(selectName.toString());
			
			HwSelectTableVO tv = null;
			
			while(rs.next()) {//��ȸ�� ���ڵ尡 �����Ѵٸ�
				//VO�� ���� �Ҵ��ϰ�
				//���� �̸��� ��ü�� ������ �����ϱ� ���� List�߰�
				tv = new HwSelectTableVO(rs.getString("TNAME"));
				
				list.add(tv);
			}//end while

			for(int i=0; i<list.size(); i++) {
				tv = list.get(i);
				hst.getJcombobox().addItem(tv.getTname());
			}
			
		}finally {
		//5.���� ����
			if (rs!=null) {rs.close();}//end if
			if (stmt!=null) {stmt.close();}//end if
			if (con!=null) {con.close();}//end if
		}//end finally
		
		return list;
	}

	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
	}

}//class
