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
	
		//1.드라이버로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver"); //반드시 외우기
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
	
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
		//2.Connection얻기
			String url = "jdbc:oracle:thin:@localhost:1521:orcl"; //반드시 외우기
			String id ="scott";
			String pass="tiger";
			con=DriverManager.getConnection(url, id, pass);
	
		//3.쿼리문 생성 객체 얻기
			stmt = con.createStatement();
			
		//4.쿼리문 수행 후 결과 얻기
			StringBuilder selectName = new StringBuilder();
			
			selectName
			.append(" select tname ")
			.append(" from tab ");
			
			rs=stmt.executeQuery(selectName.toString());
			
			HwSelectTableVO tv = null;
			
			while(rs.next()) {//조회된 레코드가 존재한다면
				//VO에 값을 할당하고
				//같은 이름의 객체를 여러개 관리하기 위해 List추가
				tv = new HwSelectTableVO(rs.getString("TNAME"));
				
				list.add(tv);
			}//end while

			for(int i=0; i<list.size(); i++) {
				tv = list.get(i);
				hst.getJcombobox().addItem(tv.getTname());
			}
			
		}finally {
		//5.연결 끊기
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
