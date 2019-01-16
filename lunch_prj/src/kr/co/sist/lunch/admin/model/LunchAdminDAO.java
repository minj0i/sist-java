package kr.co.sist.lunch.admin.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.lunch.admin.view.LunchMainView;
import kr.co.sist.lunch.admin.vo.AdminLoginVO;
import kr.co.sist.lunch.admin.vo.LunchAddVO;
import kr.co.sist.lunch.admin.vo.LunchDetailVO;
import kr.co.sist.lunch.admin.vo.LunchVO;

public class LunchAdminDAO {
//DB에 대한 작업을 Singleton으로
	
	private static LunchAdminDAO la_dao;
	
	private LunchAdminDAO() {
	//드라이브 로딩은 생성자에서
		//DB 1. 드라이브 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
	}//LunchAdminDAO
	
	public static LunchAdminDAO getInstance() {
		if(la_dao==null) {//최초호출 또는 객체가 죽었을때
			//생성된 la_dao를 반환한다.
			la_dao = new LunchAdminDAO();
		}//end if
		return la_dao;
	}//getInstance

	private Connection getConn() throws SQLException{
		//DB 2.
		String url = "jdbc:oracle:thin:@211.63.89.149:1521:orcl"; /*프로젝트할때는 DB서버의 IP*/
		String id = "scott";
		String pass = "tiger";
		Connection con = DriverManager.getConnection(url, id, pass);
		return con;
	}//getConn
	
	/**
	 * ID와 PASSWORD를 입력받아 lunch_admin에서 이름을 조회하는 일
	 * @param alvo
	 * @return
	 * @throws SQLException
	 */
	public String login(AdminLoginVO alvo) throws SQLException{
		String adminName = ""; //초기화값이 ""이기 때문에 없는 아이디를 넣으면 ""이 반환됨
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		
		try {
		//1.
		//2.
			con = getConn();
		//3.
			String selectName = "SELECT NAME FROM LUNCH_ADMIN WHERE ID=? AND PASS=?";
			pstmt = con.prepareStatement(selectName);
		//4.
			pstmt.setString(1, alvo.getId());
			pstmt.setString(2, alvo.getPass());
		//5.
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				adminName = rs.getString("NAME");
			}//end if
			
		}finally {
		//6.
			if(rs!=null) {rs.close();}
			if(pstmt!=null) {pstmt.close();}
			if(con!=null) {con.close();}
		}//end fianlly
		
		return adminName;
	}//login
	
	/**
	 * 입력된 도시락의 코드, 이미지, 도시락명, 단가 조회
	 * @return
	 * @throws SQLException
	 */
	public List<LunchVO> selectLunch() throws SQLException{
		List<LunchVO> list = new ArrayList<LunchVO>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
		//1.
		//2.
			con=getConn();
		//3.
			String selectAllLunch = "SELECT LUNCH_CODE, LUNCH_NAME, IMG, PRICE FROM LUNCH ORDER BY LUNCH_CODE DESC";
			pstmt = con.prepareStatement(selectAllLunch);
		//4.
		//5.
			rs = pstmt.executeQuery();
			
			LunchVO lv= null;
			while(rs.next()) {
				lv = new LunchVO(rs.getString("LUNCH_CODE"), rs.getString("LUNCH_NAME"), 
						rs.getString("IMG"), rs.getInt("PRICE"));
				list.add(lv);
			}//end while
			
		}finally {
		//6.
			if(rs!=null) {rs.close(); }//end if
			if(pstmt!=null) {pstmt.close(); }//end if
			if(con!=null) {con.close(); }//end if
		}//finally
		
		return list;
	}//selectLunch
	
	/**
	 * 입력되는 코드에 의한 도시락 상세정보를 조회
	 * @param code
	 * @return
	 * @throws SQLException
	 */
	public LunchDetailVO selectDetailLunch(String code) throws SQLException {
		LunchDetailVO ldvo = null; //여기다가 new로 하면 조회되지않아도 객체를 만듬
		//필요한게 아니면 new로 만들지 말아야 한다.
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
		//1.
		//2.
			con = getConn();
		//3.
			String selectLunchCode = 
					"SELECT LUNCH_NAME,IMG,PRICE,SPEC,TO_CHAR(INPUT_DATE,'YYYY-MM-DD') INPUT_DATE FROM LUNCH WHERE LUNCH_CODE=?";
			pstmt=con.prepareStatement(selectLunchCode);
		//4.
			pstmt.setString(1, code);
		//5.
			rs = pstmt.executeQuery();
			//입력된 코드로 조회된 레코드가 존재할 때 VO를 생성하고 값을 추가한다.
			if(rs.next()) {
				ldvo=new LunchDetailVO(code, rs.getString("lunch_name"), 
						rs.getString("img"),rs.getString("spec"), 
						rs.getString("input_date"), rs.getInt("price"));
			}//end if
		}finally {
		//6.
			if(rs!=null) {rs.close();}
			if(pstmt!=null) {pstmt.close();}
			if(con!=null) {con.close();}
		}//end finally
		
		
		return ldvo;
	}//selectDetailLunch
	
	/**
	 * 도시락 정보를 추가하는 일
	 * @param lav
	 * @throws SQLException
	 */
	public void insertLunch(LunchAddVO lav) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
		//1.
		//2.
			con = getConn();
		//3.
			StringBuilder insertLunch =new StringBuilder();
			insertLunch.append("insert into lunch")
			.append("(LUNCH_CODE, LUNCH_NAME, IMG, Price, spec, id)")
			.append("values(lunch_code, ?,?,?,?,? )");
			pstmt=con.prepareStatement(insertLunch.toString());
			
		//4. 바인드 변수에 값넣기
			pstmt.setString(1,lav.getLunch_name());
			pstmt.setString(2,lav.getImg());
			pstmt.setInt(3,lav.getPrice());
			pstmt.setString(4,lav.getSpec());
			pstmt.setString(5,LunchMainView.adminId);
		//5.
			pstmt.executeUpdate(); //insert되거나 예외이거나 둘 중 하나 
		}finally {
		//6.
			if(pstmt!=null) {pstmt.close();}//end if
			if(con!=null) {con.close();}//end if
		}//end finally
		
	}//insertLunch
	
	public boolean deleteLunch(String code) throws SQLException {
		boolean flag = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		//DB를 여러번 써야 해서 위에서 DAO 선언함
		try {
			//1.
			//2.
				con = getConn();  
			//3.
				String deleteLunch = "DELETE FROM LUNCH WHERE LUNCH_CODE = ? ";
				pstmt=con.prepareStatement(deleteLunch);
			//4.
				pstmt.setString(1, code);
			//5.
				int cnt = pstmt.executeUpdate();
				if(cnt == 1) {
					flag = true;
				}//end if
				
			}finally {
			//6.
				if(pstmt!=null) {pstmt.close();}
				if(con!=null) {con.close();}
			}//end finally
		return flag;
	}//deleteLunch
	
	public static void main(String[] args) {
		try {
			System.out.println(getInstance().selectDetailLunch("L_000001"));
//			System.out.println(getInstance().deleteLunch("L_000022"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}//main
	
}//class
