package kr.co.sist.lunch.user.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.lunch.user.vo.LunchDetailVO;
import kr.co.sist.lunch.user.vo.LunchListVO;
import kr.co.sist.lunch.user.vo.OrderAddVO;

/**
 * 도시락 주문자에 대한 DB처리
 * @author owner
 */
public class LunchClientDAO {
	private static LunchClientDAO lc_dao;
	
	private LunchClientDAO() {
		//1.
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}//end catch
		//2.
	}//LunchClientDAO
	
	public static LunchClientDAO getInstance() {
		if(lc_dao==null) {
			lc_dao=new LunchClientDAO();
		}//end if
		return lc_dao;
	}//getInstance
	
	private Connection getConn() throws SQLException {
		//2.
		Connection con = null;
		String url ="jdbc:oracle:thin:@211.63.89.149:1521:orcl";
		String id = "scott";
		String password = "tiger";
		con = DriverManager.getConnection(url, id, password);
		return con;
	}//getConn
	
	/**
	 * DB에 추가된 모든 도시락 목록 조회
	 * @return
	 * @throws SQLException
	 */
	public List<LunchListVO> selectLunchList() throws SQLException{
		List<LunchListVO> list = new ArrayList<LunchListVO>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
		//1.
		//2.
			con = getConn();
		//3.
			String selectLunch = "select Lunch_code, lunch_name, img, spec from lunch order by lunch_code desc ";
			pstmt = con.prepareStatement(selectLunch);
		//4.
		//5.
			rs=pstmt.executeQuery();
			
			LunchListVO llv = null;
			while(rs.next()) {
				llv=new LunchListVO(rs.getString("img"), rs.getString("lunch_Code")
						, rs.getString("lunch_Name"), rs.getString("Spec"));
				list.add(llv);
			}//end while
		}finally {
		//6.
			if(rs!=null) {rs.close();}//end if
			if(pstmt!=null) {pstmt.close();}//end if
			if(con!=null) {con.close();}//end if
		}
		return list;
	}//selectLunchList
	
	/**
	 * 도시락의 상세 정보 조회
	 * @param lunchCode
	 * @return
	 * @throws SQLException
	 */
	public LunchDetailVO selectDetailLunch(String lunchCode) throws SQLException{
		LunchDetailVO ldvo = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
		//1.
		//2.
			con = getConn();
		//3.
			String selectLunch="select img, lunch_name, spec, price from lunch where lunch_code=?";
			pstmt=con.prepareStatement(selectLunch);
		//4.
			pstmt.setString(1, lunchCode);
		//5.
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				ldvo= new LunchDetailVO(lunchCode, rs.getString("lunch_Name"), rs.getString("spec"), 
						rs.getString("img"), rs.getInt("price"));
			}//end while
			
		}finally {
		//6.
			if(rs!=null) {rs.close();}//end if
			if(pstmt!=null) {pstmt.close();}//end if
			if(con!=null) {con.close();}//end if
		}//end finally
		
		return ldvo;
	}//selectDetailLunch
	
	public void insertOrder(OrderAddVO oavo) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt =null;
		
		try {
		//1.
		//2.
			con = getConn();
		//3.
			String insertOrder = "insert into ordering(order_num, quan, order_name, phone, ip_address, lunch_code) values (order_code,?,?,?,?,?)";
			pstmt=con.prepareStatement(insertOrder);
		//4.
			pstmt.setInt(1, oavo.getQuan());
			pstmt.setString(2, oavo.getOrderName());
			pstmt.setString(3, oavo.getPhone());
			pstmt.setString(4, oavo.getIpAddress());
			pstmt.setString(5, oavo.getLunchCode());
		//5.
			pstmt.executeUpdate();
		}finally {
		//6.
			if(pstmt!=null) {pstmt.close();}//end if
			if(con!=null) {con.close();}//end if
		}//end finally
	}//insertOrder
	
	public static void main(String[] args) {
		try {
			System.out.println(LunchClientDAO.getInstance().selectDetailLunch("L_000001"));
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
	}//main
	
	
}//class
