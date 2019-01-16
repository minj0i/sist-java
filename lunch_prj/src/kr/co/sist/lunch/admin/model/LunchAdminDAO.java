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
//DB�� ���� �۾��� Singleton����
	
	private static LunchAdminDAO la_dao;
	
	private LunchAdminDAO() {
	//����̺� �ε��� �����ڿ���
		//DB 1. ����̺� �ε�
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
	}//LunchAdminDAO
	
	public static LunchAdminDAO getInstance() {
		if(la_dao==null) {//����ȣ�� �Ǵ� ��ü�� �׾�����
			//������ la_dao�� ��ȯ�Ѵ�.
			la_dao = new LunchAdminDAO();
		}//end if
		return la_dao;
	}//getInstance

	private Connection getConn() throws SQLException{
		//DB 2.
		String url = "jdbc:oracle:thin:@211.63.89.149:1521:orcl"; /*������Ʈ�Ҷ��� DB������ IP*/
		String id = "scott";
		String pass = "tiger";
		Connection con = DriverManager.getConnection(url, id, pass);
		return con;
	}//getConn
	
	/**
	 * ID�� PASSWORD�� �Է¹޾� lunch_admin���� �̸��� ��ȸ�ϴ� ��
	 * @param alvo
	 * @return
	 * @throws SQLException
	 */
	public String login(AdminLoginVO alvo) throws SQLException{
		String adminName = ""; //�ʱ�ȭ���� ""�̱� ������ ���� ���̵� ������ ""�� ��ȯ��
		
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
	 * �Էµ� ���ö��� �ڵ�, �̹���, ���ö���, �ܰ� ��ȸ
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
	 * �ԷµǴ� �ڵ忡 ���� ���ö� �������� ��ȸ
	 * @param code
	 * @return
	 * @throws SQLException
	 */
	public LunchDetailVO selectDetailLunch(String code) throws SQLException {
		LunchDetailVO ldvo = null; //����ٰ� new�� �ϸ� ��ȸ�����ʾƵ� ��ü�� ����
		//�ʿ��Ѱ� �ƴϸ� new�� ������ ���ƾ� �Ѵ�.
		
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
			//�Էµ� �ڵ�� ��ȸ�� ���ڵ尡 ������ �� VO�� �����ϰ� ���� �߰��Ѵ�.
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
	 * ���ö� ������ �߰��ϴ� ��
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
			
		//4. ���ε� ������ ���ֱ�
			pstmt.setString(1,lav.getLunch_name());
			pstmt.setString(2,lav.getImg());
			pstmt.setInt(3,lav.getPrice());
			pstmt.setString(4,lav.getSpec());
			pstmt.setString(5,LunchMainView.adminId);
		//5.
			pstmt.executeUpdate(); //insert�ǰų� �����̰ų� �� �� �ϳ� 
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
		//DB�� ������ ��� �ؼ� ������ DAO ������
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
