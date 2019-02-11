package admin.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import admin.vo.PMProductVO;


public class PMProductDAO {

	private static PMProductDAO pmp_dao;
	
	private PMProductDAO() {
	//드라이브 로딩은 생성자에서
		//DB 1. 드라이브 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
	}//PMProductDAO
	
	public static PMProductDAO getInstance() {
		if(pmp_dao==null) {//최초호출 또는 객체가 죽었을때
			//생성된 la_dao를 반환한다.
			pmp_dao = new PMProductDAO();
		}//end if
		return pmp_dao;
	}//getInstance

	private Connection getConn() throws SQLException{
		//DB 2.
		String url = "jdbc:oracle:thin:@211.63.89.152:1521:orcl"; /*프로젝트할때는 DB서버의 IP*/
		String id = "zizon";
		String pass = "darkness";
		Connection con = DriverManager.getConnection(url, id, pass);
		return con;
	}//getConn
	
	/**
	 * 입력된 상품의 내용 조회
	 * @return
	 * @throws SQLException
	 */
	public List<PMProductVO> selectPrd() throws SQLException {
		List<PMProductVO> list = new ArrayList<PMProductVO>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
		//1.
		//2.
			con=getConn();
		//3.
			String selectAllPrd = "SELECT MENU_CODE, MENU_NAME, MENU_IMG, PRICE, QUAN, PRICE*QUAN TOTAL FROM MENU ORDER BY MENU_CODE DESC";
			pstmt=con.prepareStatement(selectAllPrd);
		//4.
		//5.
			rs=pstmt.executeQuery();
			
			PMProductVO pmp_vo=null;
			while(rs.next()) {
				pmp_vo = new PMProductVO(rs.getString("MENU_CODE"), rs.getString("MENU_NAME"),
							rs.getString("IMG"), rs.getInt("price"), rs.getInt("QUAN"), rs.getInt("total"));
				list.add(pmp_vo);
			}//end while
		}finally {
			if(rs!=null) {rs.close(); }//end if
			if(pstmt!=null) {pstmt.close(); }//end if
			if(con!=null) {con.close(); }//end if
		}//finally
		
		return list;
	}//selectPrd
}//class
