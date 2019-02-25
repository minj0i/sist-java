package admin.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.pcbang.manager.product.add.PMProductAddVO;
import kr.co.sist.pcbang.manager.product.detail.PMProductDetailVO;

public class PMProductDAO {

	private static PMProductDAO pmp_dao;

	private PMProductDAO() {
		// ����̺� �ε��� �����ڿ���
		// DB 1. ����̺� �ε�
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} // end catch
	}// PMProductDAO

	public static PMProductDAO getInstance() {
		if (pmp_dao == null) {// ����ȣ�� �Ǵ� ��ü�� �׾�����
			// ������ la_dao�� ��ȯ�Ѵ�.
			pmp_dao = new PMProductDAO();
		} // end if
		return pmp_dao;
	}// getInstance

	private Connection getConn() throws SQLException {
		// DB 2.
		String url = "jdbc:oracle:thin:@211.63.89.152:1521:orcl";
		String id = "zizon";
		String pass = "darkness";
		Connection con = DriverManager.getConnection(url, id, pass);
		return con;
	}// getConn

	/**
	 * �Էµ� ��ǰ�� �ڵ�, �̸�, �̹���, ����, �Ǹŷ�, ���Ǹŷ� ��ȸ
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<PMProductVO> selectPrd() throws SQLException {
		List<PMProductVO> list = new ArrayList<PMProductVO>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 1.
			// 2.
			con = getConn();
			// 3.
			StringBuilder selectAllPrd = new StringBuilder();
			selectAllPrd.append(
					"	select m.menu_code, m.menu_name, m.img, m.menu_price, o.quan, (m.menu_price)*(o.quan) total ")
					.append("	from menu m, ordering o ").append("	where o.menu_code=m.menu_code ")
					.append("	order by m.menu_code desc ");

			pstmt = con.prepareStatement(selectAllPrd.toString());
			// 4.
			// 5.
			rs = pstmt.executeQuery();

			PMProductVO pmp_vo = null;
			while (rs.next()) {
				pmp_vo = new PMProductVO(rs.getString("MENU_CODE"), rs.getString("MENU_NAME"), rs.getString("IMG"),
						rs.getInt("menu_price"), rs.getInt("QUAN"), rs.getInt("total"));
				list.add(pmp_vo);
			} // end while
		} finally {
			if (rs != null) {
				rs.close();
			} // end if
			if (pstmt != null) {
				pstmt.close();
			} // end if
			if (con != null) {
				con.close();
			} // end if
		} // finally

		return list;
	}// selectPrd

	/**
	 * �ԷµǴ� �ڵ忡 ���� ǰ���� �������� ��ȸ
	 * @param code
	 * @return
	 * @throws SQLException
	 */
	public PMProductDetailVO selectDetailPrd(String code) throws SQLException {
		PMProductDetailVO pmpdvo = null; // ����ٰ� new�� �ϸ� ��ȸ�����ʾƵ� ��ü�� ����
		// �ʿ��Ѱ� �ƴϸ� new�� ������ ���ƾ� �Ѵ�.

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 1.
			// 2.
			con = getConn();
			// 3.
			String selectMenuCode = "select menu_name, img, price, category from menu where menu_code=?";
			pstmt = con.prepareStatement(selectMenuCode);
			// 4.
			pstmt.setString(1, code);
			// 5.
			rs = pstmt.executeQuery();
			// �Էµ� �ڵ�� ��ȸ�� ���ڵ尡 ������ �� VO�� �����ϰ� ���� �߰��Ѵ�.
			if (rs.next()) {
				pmpdvo = new PMProductDetailVO(rs.getString("menu_Name"), rs.getString("category"), rs.getString("img"), rs.getInt("price"));
			} // end if
		} finally {
			// 6.
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		} // end finally

		return pmpdvo;
	}// selectDetailPrd

	
	/////////////////PMProductVO�� �ʿ䰡 ����?////
	/**
	 * ��ǰ�� ī�װ����� �ڵ�� �˻��ϴ� ��
	 * @return
	 * @throws SQLException
	 */
	public List<PMSchProductVO> searchPrd(String category, String menuName) throws SQLException{
		List<PMSchProductVO> listsearch = new ArrayList<PMSchProductVO>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
		//1.
		//2.
			con = getConn();
		//3.
			StringBuilder searchPrd = new StringBuilder();
			searchPrd
			.append("	select m.menu_code, m.menu_name, m.img, m.menu_price, o.quan, (m.menu_price)*(o.quan) total ")
			.append("	from menu m, ordering o				")
			.append("	where o.menu_code=m.menu_code		")
			.append("	and m.category=	?")
			.append("	and m.menu_name= ?	")
			.append("	order by m.menu_code	");
		
			pstmt=con.prepareStatement(searchPrd.toString());
			//4.
				pstmt.setString(1, category);
				pstmt.setString(2, menuName);
			//5.
				rs=pstmt.executeQuery();
				PMSchProductVO pmspvo=null;
				while(rs.next()) {
					pmspvo = new PMSchProductVO(rs.getString("MENU_CODE"), rs.getString("MENU_NAME"), rs.getString("IMG"),
							rs.getInt("menu_price"), rs.getInt("QUAN"), rs.getInt("total"));
					listsearch.add(pmspvo);
				}//end while
			}finally {
			//6.
				if(rs!=null) {rs.close();}//end if
				if(pstmt!=null) {pstmt.close();}//end if
				if(con!=null) {con.close();}//end if
			}//end finally
			
			return listsearch;
	}//searchPrd
	
	/**
	 * ��ǰ ������ �߰��ϴ� ��
	 * 
	 * @param pmpav
	 * @throws SQLException
	 */
	public void insertPrd(PMProductAddVO pmpav) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			// 1.
			// 2.
			con = getConn();
			// 3.
			StringBuilder insertPrd = new StringBuilder();
			insertPrd.append("insert into menu")
			.append("(menu_CODE, category, menu_NAME, menu_price, img, menu_input_date, admin_id)")
			.append("values(lunch_code, ?,?,?,?,?,? )");
			pstmt = con.prepareStatement(insertPrd.toString());

			// 4. ���ε� ������ ���ֱ�
			pstmt.setString(1, pmpav.getCategory());
			pstmt.setString(2, pmpav.getMenuName());
			pstmt.setInt(3, pmpav.getPrice());
			pstmt.setString(4, pmpav.getImg());
			pstmt.setString(6, PMProductView.adminId);
			// 5.
			pstmt.executeUpdate(); // insert�ǰų� �����̰ų� �� �� �ϳ�
		} finally {
			// 6.
			if (pstmt != null) {
				pstmt.close();
			} // end if
			if (con != null) {
				con.close();
			} // end if
		} // end finally

	}// insertLunch

	/**
	 * ��ǰ�� �����Ѵ�
	 * @param code
	 * @return
	 * @throws SQLException
	 */
	public boolean deletePrd(String code) throws SQLException {
		boolean flag = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		// DB�� ������ ��� �ؼ� ������ DAO ������
		try {
			// 1.
			// 2.
			con = getConn();
			// 3.
			String deleteMenu = "DELETE FROM menu WHERE LUNCH_CODE = ? ";
			pstmt = con.prepareStatement(deleteMenu);
			// 4.
			pstmt.setString(1, code);
			// 5.
			int cnt = pstmt.executeUpdate();
			if (cnt == 1) {
				flag = true;
			} // end if

		} finally {
			// 6.
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		} // end finally
		return flag;
	}// deleteLunch

	
	/**
	 * ��ǰ���� �Է¹޾� ������Ʈ
	 * @param pmpuvo
	 * @return
	 * @throws SQLException
	 */
	public boolean updatePrd(PMProductUpdateVO pmpuvo) throws SQLException {
		boolean flag = false;

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			// 1.
			// 2.
			con = getConn();
			// 3.
			StringBuilder updatePrd = new StringBuilder();
			updatePrd.append(" update menu ").append(" set menu_name=?, ").append(" 	price=?, category=? ");

			if (!pmpuvo.getImg().equals("")) {
				updatePrd.append(", img=? ");
			} // end if
			updatePrd.append("where menu_name=?");
			pstmt = con.prepareStatement(updatePrd.toString());
			// 4.
			pstmt.setString(1, pmpuvo.getMenuName());
			pstmt.setInt(2, pmpuvo.getPrice());
			pstmt.setString(3, pmpuvo.getCategory());

			int index = 4; // index�� 3�� ������
			if (!pmpuvo.getImg().equals("")) {
				pstmt.setString(index++, pmpuvo.getImg()); // ++index
			} // end if
			pstmt.setString(index, pmpuvo.getMenuName());

			// 5.
			int cnt = pstmt.executeUpdate();
			if (cnt == 1) {
				flag = true;
			} // end if
		} finally {
			// 6.
			if (pstmt != null) {
				pstmt.close();
			} // end if
			if (con != null) {
				con.close();
			} // end if
		} // end finally

		return flag;
	}// updatePrd

}// class