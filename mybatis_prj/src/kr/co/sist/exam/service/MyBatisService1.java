package kr.co.sist.exam.service;

import java.util.List;

import kr.co.sist.exam.dao.MyBatisDAO1;
import kr.co.sist.exam.domain.DiaryList;
import kr.co.sist.exam.domain.Emp;
import kr.co.sist.exam.domain.EmpJoin;
import kr.co.sist.exam.domain.Union;
import kr.co.sist.exam.domain.Zipcode;
import kr.co.sist.exam.vo.DiaryListParamVO;
import kr.co.sist.exam.vo.EmpVO;

public class MyBatisService1 {
	public List<Emp> multiParam(EmpVO ev){
		List<Emp> list=null;
		
		MyBatisDAO1 mb_dao1=new MyBatisDAO1();
		list = mb_dao1.multiParam(ev);
		
		return list;
	}//multiColumnRow
	
	public List<Emp> lessThan(int sal){
		List<Emp> list=null;
		
		if(sal<0) {
			sal=-sal;
		}//end if
		MyBatisDAO1 mb_dao1=new MyBatisDAO1();
		list = mb_dao1.lessThan(sal);
		
		return list;
	}//lessThan
	
	public List<Emp> greaterThan(int sal){
		List<Emp> list=null;
		MyBatisDAO1 mb_dao1=new MyBatisDAO1();
		list = mb_dao1.greaterThan(sal);
		return list;
	}//greaterThan
	
	public List<Zipcode> like (String dong){
		List<Zipcode> list = null;
		
		MyBatisDAO1 mb_dao1=new MyBatisDAO1();
		list=mb_dao1.like(dong);
		
		return list;
	}//like
	
	//////////////////////�Խ����� ����Ʈ //////////////////////////
	////�Խ����� �� ����
	public int totalCount() {
		int cnt=0;
		MyBatisDAO1 mb_dao=new MyBatisDAO1();
		cnt=mb_dao.diaryTotalCount();
		return cnt;
	}//totalCount
	
	//�� ȭ�鿡 ������ �Խù��� ����
	public int pageScale() {
		return 10;
	}//pageScale
	
	//�� �������� 
	public int totalPage(int totalCnt, int pageScale) {
		int totalPage=0;
		totalPage=(int) Math.ceil((double)totalCnt/pageScale);
		return totalPage;
	}//totalPage
	
	//���۹�ȣ
	public int startNum(String currentPage, int pageScale) {
		int startNum = 1;
		
		if(currentPage!=null) {
			int tempPage = Integer.parseInt(currentPage);	
			startNum= tempPage*pageScale-pageScale+1;
		}//end if
		return startNum;
	}//startNum
	
	//����ȣ
	public int endNum(int startNum, int pageScale) {
		return startNum+pageScale-1;
	}//endNum
	
	public List<DiaryList> diaryList(DiaryListParamVO dlp_vo){
		List<DiaryList> list = null;
		
		MyBatisDAO1 mb_dao = new MyBatisDAO1();
		list= mb_dao.subquery(dlp_vo);
		return list;
	}//diaryList
	
	public List<Union> union(){
		List<Union> list=null;
		
		MyBatisDAO1 mb_dao=new MyBatisDAO1();
		list=mb_dao.union();
		return list;
	}//union
	
	public List<EmpJoin> join(int mgr){
		List<EmpJoin> list = null;
		
		MyBatisDAO1 mb_dao=new MyBatisDAO1();
		list=mb_dao.join(mgr);
		return list;
	}
	
	
}//MyBatisSerivce
