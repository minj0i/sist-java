package kr.co.sist.diary.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.co.sist.diary.vo.DiaryDetailVO;
import kr.co.sist.diary.vo.DiaryListVO;
import kr.co.sist.diary.vo.DiaryRemoveVO;
import kr.co.sist.diary.vo.DiaryUpdateVO;
import kr.co.sist.diary.vo.DiaryVO;
import kr.co.sist.diary.vo.ListRangeVO;
import kr.co.sist.diary.vo.MonthVO;
import kr.co.sist.diary.vo.SearchDataVO;

public class DiaryDAO {
	private static DiaryDAO d_dao;
	
	private DiaryDAO() {
		
	}//diaryDAO
	
	public static DiaryDAO getInstance() {
		if(d_dao==null) {
			d_dao=new DiaryDAO();
		}//end if
		return d_dao;
	}//getInstance
	
	private Connection getConn() throws SQLException{
		Connection con = null;
		
		try {
		//1. JNDI ��� ��ü ����
			Context ctx=new InitialContext();
		//2. DBCP�� ����� DataSource�� ��´�
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/jsp_dbcp");
		//3. Connection ���
			con=ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		}//end catch
		
		return con;
	}//getConn
	
	
	/**
	 * ��, ���� �Է¹޾� �ش� ���� ��� ������ �۹�ȣ, ������ �����迭�� �����Ͽ� ��ȯ�ϴ� ��
	 * @param year ��
	 * @param month ��
	 * @return �����迭
	 * @throws SQLException
	 */
	public MonthVO[][] selectMonthEvent(String year, String month) throws SQLException{
		MonthVO[][] mv = new MonthVO[31][];
		
		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		
		try {
		//1.
		//2.
		//3.
			con=getConn();
		//4.
			//�ԷµǴ� ��, ���� ���� ���ں� ������ �����Ͽ� Variable Array�� ����
			StringBuilder selectMonthData= new StringBuilder();
			selectMonthData
			.append(" select num, subject ")
			.append(" from diary ")
			.append(" where e_year=? and e_month=? and e_day=? ")
			.append(" order by num desc");
			
			pstmt=con.prepareStatement(selectMonthData.toString());
			pstmt.setString(1, year);
			pstmt.setString(2, month);
			
		//5.
			List<MonthVO> list=new ArrayList<MonthVO>();
			for(int i=0; i<32; i++) {//�ش� �� ����
				pstmt.setString(3, String.valueOf(i+1)); //1�Ϻ��� 31�ϱ��� ������ ����
				rs=pstmt.executeQuery();
				while(rs.next()) {//���� ����� �����Ѵٸ� �ش� ���ڿ� 
					//�̺�Ʈ ���� �����ϹǷ� ���� ���� �����Ѵ�.
					list.add(new MonthVO(rs.getInt("num"), rs.getString("subject")));
				}//end if
				rs.close();
				if(list.size()!=0) { //�ش� ���ڿ� ���� �����Ѵٸ�
					MonthVO[] mvoArr = new MonthVO[list.size()];//���� ������ �迭 ����
					list.toArray(mvoArr);//list�� �����ϴ� ���� ������ �迭�� ����
					mv[i]=mvoArr;//������ �迭�� ���� �����迭�� i�࿡ �߰�
				}//end if
				list.clear();//����Ʈ�� �ʱ�ȭ�Ѵ�.
			}//end for
		}finally {
		//6.
			if(rs!=null) {rs.close();}//end if
			if(pstmt!=null) {pstmt.close();}//end if
			if(con!=null) {con.close();}//end if
		}//end finally
		
		return mv;
	}//selectMonthEvent
	
	/**
	 * ���� �߰�
	 * @param d_vo
	 * @throws SQLException
	 */
	public void insertEvent(DiaryVO d_vo) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
		//1.
		//2.
		//3.
			con=getConn();
		//4.
			StringBuilder insertEvt= new StringBuilder();
			insertEvt
			.append("insert into diary ")
			.append("(NUM,WRITER,SUBJECT,CONTENTS,E_YEAR,E_MONTH,E_DAY,PASS,IP) ")
			.append("values(seq_diary.nextval,?,?,?,?,?,?,?,?) ");
			
			pstmt=con.prepareStatement(insertEvt.toString());
			pstmt.setString(1, d_vo.getWriter());
			pstmt.setString(2, d_vo.getSubject());
			pstmt.setString(3, d_vo.getContents());
			pstmt.setString(4, d_vo.getE_year());
			pstmt.setString(5, d_vo.getE_month());
			pstmt.setString(6, d_vo.getE_day());
			pstmt.setString(7, d_vo.getPass());
			pstmt.setString(8, d_vo.getIp());
		//5.
			pstmt.executeQuery();
		}finally {
		//6.
			if(pstmt!=null) {pstmt.close();}
			if(con!=null) {con.close();}
		}//end finally
		
	}//insertEvent
	
	/**
	 * �� ��ȣ�� �Է¹޾� �ش� �̺�Ʈ�� �� ���� ��ȸ
	 * @param num
	 * @return
	 * @throws SQLException
	 * @throws IOException 
	 */
	public DiaryDetailVO selectDetailEvent(int num)throws SQLException, IOException {
		DiaryDetailVO dd_vo = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BufferedReader br = null;
		try {
		//1.
		//2.
		//3.
			con=getConn();
		//4.
			StringBuilder selectOneEvt = new StringBuilder();
			selectOneEvt
			.append(" select WRITER,SUBJECT,CONTENTS,to_char(W_DATE,'YYYY-MM-DD DY HH24:MI') W_DATE ,IP ")
			.append(" from diary ")
			.append(" where num=? ");
			
			pstmt=con.prepareStatement(selectOneEvt.toString());
			pstmt.setInt(1, num);
		//5.
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				
				//CLOBó��(Character Large Object)
				Clob clob = rs.getClob("contents");
				//������ ��Ʈ���� ����
				br=new BufferedReader(clob.getCharacterStream());
				String temp="";
				StringBuilder contents=new StringBuilder();
				while((temp=br.readLine())!=null) {
					contents.append(temp);
				}//end while
				
				dd_vo= new DiaryDetailVO(rs.getString("writer"), 
						rs.getString("subject"), contents.toString(),
						rs.getString("w_date"), rs.getString("ip"));
			}//end if
			
		}finally {
		//6.
			if(br!=null) {br.close();}//end if
			if(rs!=null) {rs.close();}//end if
			if(pstmt!=null) {pstmt.close();}//end if
			if(con!=null) {con.close();}//end if
		}//end finally
		
		
		return dd_vo;
	}//selectDetailEvent
	
	/**
	 * �۹�ȣ, ����, ��й�ȣ�� �Է¹޾� ��й�ȣ�� ��ġ�ϸ� �ش� �۹�ȣ�� �̺�Ʈ ������ ����
	 * @param du_vo
	 * @return
	 * @throws SQLException
	 */
	public int updateEvent(DiaryUpdateVO du_vo) throws SQLException{
		int cnt = 0;
		
		Connection con =null;
		PreparedStatement pstmt= null;
		
		try {
		//1.	
		//2.	
		//3.	
			con=getConn();
		//4.
			StringBuilder updateEvt=new StringBuilder();
			updateEvt
			.append(" update diary ")
			.append(" set contents=? ")
			.append(" where num=? and pass=? ");
			
			pstmt=con.prepareStatement(updateEvt.toString());
			pstmt.setString(1, du_vo.getContents());
			pstmt.setInt(2, du_vo.getNum());
			pstmt.setString(3, du_vo.getPass());
		//5.	
			cnt=pstmt.executeUpdate();
			
		}finally {
			if(pstmt!=null) {pstmt.close();}//end if
			if(con!=null) {con.close();}//end if
		}//end if
		return cnt;
	}//updateEvent
	
	/**
	 * �� ��ȣ, ��й�ȣ�� �Է¹޾� ��й�ȣ�� ��ġ�ϸ� �ش� ���� ����
	 * @param dr_vo
	 * @return
	 * @throws SQLException
	 */
	public int deleteEvent(DiaryRemoveVO dr_vo) throws SQLException{
		int cnt=0;
		
		Connection con =null;
		PreparedStatement pstmt= null;
		
		try {
		//1.	
		//2.	
		//3.	
			con=getConn();
		//4.
			StringBuilder deleteEvt=new StringBuilder();
			deleteEvt
			.append(" delete from diary ")
			.append(" where num=? and pass=? ");
			pstmt=con.prepareStatement(deleteEvt.toString());
			
			pstmt.setInt(1, dr_vo.getNum());
			pstmt.setString(2, dr_vo.getPass());
		//5.	
			cnt=pstmt.executeUpdate();
			
		}finally {
			if(pstmt!=null) {pstmt.close();}//end if
			if(con!=null) {con.close();}//end if
		}//end if
		
		return cnt;
	}//deleteEvent
	
	public int selectEvtCnt(SearchDataVO sd_vo) throws SQLException{
		int cnt=0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		
		try {
		//1.
		//2.
		//3.
			con=getConn();
		//4.
			StringBuilder selectCnt=new StringBuilder();
			selectCnt.append(" select count(*) cnt from diary ");
			if(sd_vo !=null) {
				//Dynamic Query
				selectCnt.append(" where ").append(sd_vo.getFieldName())
				.append(" like '%'||?||'%'");
			}//end if
			pstmt=con.prepareStatement(selectCnt.toString());
			if(sd_vo !=null) {
			pstmt.setString(1, sd_vo.getKeyword());				
			}//end if
		//5.
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				cnt=rs.getInt("cnt");
			}//end if
		}finally {			
		//6.
			if(rs!=null) {rs.close();}
			if(pstmt!=null) {pstmt.close();}
			if(con!=null) {con.close();}
		}//end finally
		
		return cnt;
	}//selectCnt
	
	/**
	 * �Խ����� ����Ʈ�������� ��ȸ�ϴ� �� 
	 * @param sd_vo
	 * @return
	 * @throws SQLException
	 */
	public List<DiaryListVO> selectList(ListRangeVO lr_vo, SearchDataVO sd_vo) throws SQLException{
		List<DiaryListVO> list= new ArrayList<DiaryListVO>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		
		try {
		//1.
		//2.
		//3.
			con=getConn();
		//4.
			StringBuilder selectList = new StringBuilder();
			selectList
			.append("select r_num, num, subject, writer, e_year, e_month, e_day, to_char(w_date,'yyyy-mm-dd HH24:mi') w_date ")
			.append("from(select num, subject, writer, e_year, e_month, e_day, w_date, ")
			.append("row_number()over(order by w_date desc) r_num ")
			.append("from diary ");
			
			if(sd_vo!=null) {
				selectList.append(" where ").append(sd_vo.getFieldName())
				.append(" like '%'||?||'%' ");
			}//end if
			selectList.append(") ")
			.append("where r_num between ? and ? ");

			pstmt = con.prepareStatement(selectList.toString());
			
			int bindIdx=1;
			if(sd_vo!=null) {
				pstmt.setString(bindIdx++, sd_vo.getKeyword());
			}//end if
			
			pstmt.setInt(bindIdx++, lr_vo.getStartNum());
			pstmt.setInt(bindIdx++, lr_vo.getEndNum());
		//5.
			rs=pstmt.executeQuery();
			
			DiaryListVO dl_vo=null;
			while(rs.next()) {
				dl_vo=new DiaryListVO(rs.getInt("num"), 
						rs.getString("subject"), rs.getString("writer"), 
						rs.getString("e_year"), rs.getString("e_month"), 
						rs.getString("e_day"), rs.getString("w_date"));
				list.add(dl_vo);
			}//end while
			
		}finally {			
		//6.
			if(rs!=null) {rs.close();}
			if(pstmt!=null) {pstmt.close();}
			if(con!=null) {con.close();}
		}//end finally
		
		return list;
	}//selectList
	
}//class
