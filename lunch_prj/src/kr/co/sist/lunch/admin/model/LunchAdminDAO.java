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
import kr.co.sist.lunch.admin.vo.CalcVO;
import kr.co.sist.lunch.admin.vo.LunchAddVO;
import kr.co.sist.lunch.admin.vo.LunchDetailVO;
import kr.co.sist.lunch.admin.vo.LunchUpdateVO;
import kr.co.sist.lunch.admin.vo.LunchVO;
import kr.co.sist.lunch.admin.vo.OrderVO;

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
	
	/**
	 * ���ö� �ڵ�, ���ö���, �̹���, ����, Ư������ �Է¹޾� ���ö��ڵ忡 �ش��ϴ�
	 * ���ö��� ����. �̹����� ""��� �̹����� �������� �ʴ´�.
	 * @param luvo
	 * @return
	 * @throws SQLException
	 */
	public boolean updateLunch(LunchUpdateVO luvo) throws SQLException{
		boolean flag = false;

		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
		//1.
		//2.
			con = getConn();
		//3.
			StringBuilder updateLunch=new StringBuilder();
			updateLunch
			.append(" update Lunch ")
			.append(" set lunch_name=?, ")
			.append(" 	price=?, spec=? ");
			
			if(!luvo.getImg().equals("")) {
				updateLunch.append(", img=? ");
			}//end if
			updateLunch.append("where lunch_code=?");
			pstmt=con.prepareStatement(updateLunch.toString());
		//4.
			pstmt.setString(1, luvo.getLunch_name());
			pstmt.setInt(2, luvo.getPrice());
			pstmt.setString(3, luvo.getSpec());
			
			int index=4; //index�� 3�� ������
			if(!luvo.getImg().equals("")) {
				pstmt.setString(index++,luvo.getImg()); //++index
			}//end if
			pstmt.setString(index, luvo.getLunch_code());

		//5.
			int cnt = pstmt.executeUpdate();
			if(cnt ==1) {
				flag=true;
			}//end if
		}finally {
		//6.
			if(pstmt!=null) {pstmt.close();}//end if
			if(con!=null) {con.close();}//end if
		}//end finally
		
		
		return flag;
	}//updateLunch
	
	public List<CalcVO> selectCalc(String date)throws SQLException{
		List<CalcVO> list = new ArrayList<CalcVO>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
		//1.
		//2.
			con = getConn();
		//3.
			StringBuilder selectCalc = new StringBuilder();
			selectCalc
			.append("	select l.LUNCH_NAME, l.Lunch_code, sum(o.quan) total, sum(o.quan)*l.price price		")
			.append("	from Lunch l, Ordering o	")
			.append("	where o.lunch_code=l.lunch_code	")
			.append("	and to_char(o.order_date,'yyyy-mm-dd')=to_char(to_date(?,'yyyy-mm-dd'), 'yyyy-mm-dd')	")
			.append("	and o.status='Y'	")//���ۿϷ��� �͸� ����
			.append("	group by l.lunch_name, l.lunch_code, l.price	")//�ڹٿ��� �����ȿ� ';'�� ������ �ȵ�		
			.append("   order by l.lunch_code ");
			pstmt=con.prepareStatement(selectCalc.toString());
		//4.
			pstmt.setString(1, date);
		//5.
			rs=pstmt.executeQuery();
			
			
			CalcVO cvo= null;
			while(rs.next()) {
				cvo=new CalcVO(rs.getString("lunch_code"), rs.getString("lunch_Name"), 
						rs.getInt("price"), rs.getInt("total"));
				list.add(cvo);
			}//end while
		}finally {
		//6.
			if(rs!=null) {rs.close();}//end if
			if(pstmt!=null) {pstmt.close();}//end if
			if(con!=null) {con.close();}//end if
		}//end finally
		
		return list;
		
	}//selectCalc
	
	/**
	 * ������ 13�� ���� �ֹ� ��Ȳ
	 * @return
	 * @throws SQLException
	 */
	public List<OrderVO> selectOrderList() throws SQLException{
		List<OrderVO> list = new ArrayList<OrderVO>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
		//1.
		//2.
			con = getConn();
		//3.
			StringBuilder selectOrder = new StringBuilder();
			selectOrder
			.append("	select o.order_num, o.lunch_code, l.LUNCH_NAME, ")
			.append("	o.quan, (o.quan)*l.price price,	o.order_name,				")
			.append("	to_char(o.order_date,'yyyy-mm-dd hh:mi:ss')	 	")
			.append("	order_date, o.phone, o.ip_address, o.status,		")
			.append("	o.request		")
			.append("	from   lunch l, ordering o		")
			.append("	where  o.lunch_code=l.lunch_code		")
			.append("	and to_char(o.order_date, 'yyyy-mm-dd')=to_char(sysdate,'yyyy-mm-dd')	")
//			.append("	and to_char(o.order_date, 'yyyy-mm-dd')='2019-01-15'	")
//			.append("	and to_char(o.order_date,'hh24')<=13		")
			.append("	order by o.order_num		");
		
			pstmt=con.prepareStatement(selectOrder.toString());
			//4.
//				pstmt.setString(1, date);
			//5.
				rs=pstmt.executeQuery();
				OrderVO ovo= null;
				while(rs.next()) {
					ovo=new OrderVO(rs.getString("order_num"), rs.getString("lunch_code"), rs.getString("lunch_name"), 
							rs.getString("order_name"), rs.getString("order_date"),
							rs.getString("phone"), rs.getString("ip_address"), 
							rs.getString("status"), rs.getString("request"), rs.getInt("quan"), rs.getInt("price"));

					list.add(ovo);
				}//end while
			}finally {
			//6.
				if(rs!=null) {rs.close();}//end if
				if(pstmt!=null) {pstmt.close();}//end if
				if(con!=null) {con.close();}//end if
			}//end finally
			
			return list;
	}//selectOrderList
	
	/**
	 * ���ö��� ���ۿϷ� ������ ȣ��Ǿ� �ش� �ֹ� ���ö��� �ϼ����¸� �����ϴ� ��
	 * @param orderNum
	 * @return
	 */
	public boolean updateStatus(String orderNum) throws SQLException {
		boolean flag=false;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
		//1.
		//2.
			con = getConn();
		//3.
			String updateOrder="update ordering set status='Y' where order_num = ?";
			pstmt=con.prepareStatement(updateOrder);
		//4.
			pstmt.setString(1, orderNum);
		//5.
			int cnt = pstmt.executeUpdate();
			if(cnt==1) {
				flag=true;
			}//end if
		}finally {
		//6.
			if(pstmt!=null) {pstmt.close();}//end if
			if(con!=null) {con.close();}//end if
		}//end finally
		return flag;
	}//updateStatus
	
	public boolean deleteOrder(String orderNum) throws SQLException {
		boolean flag = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
		//1.
		//2.
			con = getConn();
		//3.
			String deleteOrder="delete from ordering where order_num = ?";
			pstmt=con.prepareStatement(deleteOrder);
		//4.
			pstmt.setString(1, orderNum);
		//5.
			int cnt = pstmt.executeUpdate();
			if(cnt==1) {
				flag=true;
			}//end if
		}finally {
		//6.
			if(pstmt!=null) {pstmt.close();}//end if
			if(con!=null) {con.close();}//end if
		}//end finally
		return flag;
	}//deleteOrder
	
	
	public static void main(String[] args) {
		try {
//			System.out.println(getInstance().selectDetailLunch("L_000001"));
//			System.out.println(getInstance().deleteLunch("L_000022"));
			System.out.println(getInstance().selectOrderList());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}//main
	
}//class
