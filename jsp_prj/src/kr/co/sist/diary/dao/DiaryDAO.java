package kr.co.sist.diary.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.diary.vo.DiaryDetailVO;
import kr.co.sist.diary.vo.DiaryListVO;
import kr.co.sist.diary.vo.DiaryRemoveVO;
import kr.co.sist.diary.vo.DiaryUpdateVO;
import kr.co.sist.diary.vo.DiaryVO;
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
	
	/**
	 * 년, 월을 입력받아 해당 월의 모든 일자의 글번호, 제목을 가변배열에 저장하여 반환하는 일
	 * @param year 년
	 * @param month 월
	 * @return 가변배열
	 * @throws SQLException
	 */
	public MonthVO[][] selectMonthEvent(String year, String month) throws SQLException{
		MonthVO[][] mv = new MonthVO[31][];
		
		return mv;
	}//monthVO
	
	/**
	 * 일정 추가
	 * @param d_vo
	 * @throws SQLException
	 */
	public void insertEvent(DiaryVO d_vo) throws SQLException{
		
	}//insertEvent
	
	/**
	 * 글 번호를 입력받아 해당 이벤트의 상세 정보 조회
	 * @param num
	 * @return
	 * @throws SQLException
	 */
	public DiaryDetailVO selectDetailEvent(int num)throws SQLException {
		DiaryDetailVO dd_vo = null;
		
		return dd_vo;
	}//selectDetailEvent
	
	/**
	 * 글번호, 내용, 비밀번호를 입력받아 비밀번호가 일치하면 해당 글번호의 이벤트 내용을 변경
	 * @param du_vo
	 * @return
	 * @throws SQLException
	 */
	public int updateEvent(DiaryUpdateVO du_vo) throws SQLException{
		int cnt = 0;
		
		return cnt;
	}//updateEvent
	
	/**
	 * 글 번호, 비밀번호를 입력받아 비밀번호가 일치하면 해당 글을 삭제
	 * @param dr_vo
	 * @return
	 * @throws SQLException
	 */
	public int deleteEvent(DiaryRemoveVO dr_vo) throws SQLException{
		int cnt=0;
		
		return cnt;
	}//deleteEvent
	
	/**
	 * 게시판의 리스트형식으로 조회하는 일 
	 * @param sd_vo
	 * @return
	 * @throws SQLException
	 */
	public List<DiaryListVO> selectList(SearchDataVO sd_vo) throws SQLException{
		List<DiaryListVO> list= new ArrayList<DiaryListVO>();
		
		return list;
	}//selectList
	
}//class
