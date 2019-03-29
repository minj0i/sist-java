package kr.co.sist.diary.service;

import java.sql.SQLException;
import java.util.List;

import kr.co.sist.diary.dao.DiaryDAO;
import kr.co.sist.diary.vo.DiaryListVO;
import kr.co.sist.diary.vo.ListRangeVO;
import kr.co.sist.diary.vo.SearchDataVO;

/**
 * 게시판 리스트에 관한 업무 처리 클래스
 * @author owner
 */
public class ListService {
	private static ListService ls;
	 private ListService() {
		 
	 }//ListService
	 
	 public static ListService getInstance() {
		 if(ls==null) {
			 ls=new ListService();
		 }//
		 return ls;
	 }//getInstance
	 
	 public int totalCount(SearchDataVO sd_vo) {
		 int totalCount=0;
		 DiaryDAO d_dao=DiaryDAO.getInstance();
		 try {
			totalCount=d_dao.selectEvtCnt(sd_vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		 return totalCount;
	 }//totalCount
	 
	 public int pageScale() {
		 int pageScale=10;
		 return pageScale;
	 }//pageScale
	 
	 public int totalPage(int totalCount) {
		int totalPage = totalCount/pageScale();
		if(totalCount % pageScale() !=0){
			totalPage++;
		}//end if
		return totalPage;
	 }//totalPage
	 
	 public int startNum(String currentPage) {
		int startNum=1;
		if(currentPage!=null){
			int tempPage=Integer.parseInt(currentPage);
			startNum=tempPage*pageScale()-pageScale()+1;
		}//end if
		 return startNum;
	 }//startNum
	 
	 public int endNum(int startNum) {
		 int endNum = startNum+pageScale()-1;
		 return endNum;
	 }//endNum
	 
	 public List<DiaryListVO> searchList(ListRangeVO lr_vo, SearchDataVO sd_vo) {
		 List<DiaryListVO> list = null;
		 DiaryDAO d_dao = DiaryDAO.getInstance();
		 
		 try {
			list=d_dao.selectList(lr_vo, sd_vo);
			
			//글의 제목은 24자까지만 보여준다.
			DiaryListVO dl_vo = null;
			String subject="";
			for(int i=0; i<list.size(); i++) {
				dl_vo=list.get(i);
				subject=dl_vo.getSubject();
				if(subject.length()>25) {
					subject=subject.substring(0, 24)+"...";
					dl_vo.setSubject(subject);
				}//end if
			}//end for
			
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		 
		 return list;
	 }//searchList
	 
	 public String indexList(String url, SearchDataVO sd_vo, int totalPage) {
		 StringBuilder indexList = new StringBuilder();
		
		 for(int i=1; i<=totalPage; i++) {
			 indexList.append("[").append(" <a href='").append(url)
			 .append("?current_page=").append(i);
			 if(sd_vo!=null) {
			 indexList.append("&fieldName=").append(sd_vo.getFieldName())
			 .append("&keyword=").append(sd_vo.getKeyword());
			 }//end if
			 indexList.append("'>")
			 .append(i).append("</a>]");
		 }//end for
		 return indexList.toString();
		}//indexList
	 
}//ListService
