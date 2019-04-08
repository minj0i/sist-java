package kr.co.sist.exam.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;


import kr.co.sist.exam.domain.DiaryList;
import kr.co.sist.exam.domain.Emp;
import kr.co.sist.exam.domain.EmpJoin;
import kr.co.sist.exam.domain.Union;
import kr.co.sist.exam.domain.Zipcode;
import kr.co.sist.exam.vo.DiaryListParamVO;
import kr.co.sist.exam.vo.EmpVO;

public class MyBatisDAO1 {
	public List<Emp> multiParam(EmpVO ev){
		List<Emp> list=null;
		//4.Handler 얻기
		SqlSession ss=MyBatisDAO.getInstance().getSessionFactory().openSession();
		
		list=ss.selectList("multiParam", ev);
		
		ss.close();
		return list;
	}//multiParam

	
	public List<Emp> lessThan(int sal){
		List<Emp> list=null;
		SqlSession ss=MyBatisDAO.getInstance().getSessionFactory().openSession();
		list=ss.selectList("lessThan", sal);
		ss.close();
		return list;
	}//lessThan
	
	public List<Emp> greaterThan(int sal){
		List<Emp> list=null;
		SqlSession ss=MyBatisDAO.getInstance().getSessionFactory().openSession();
		list=ss.selectList("greaterThan", sal);
		ss.close();
		return list;
	}//moreThan
	
	public List<Zipcode> like(String dong){
		List<Zipcode> list = null;
		
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		list=ss.selectList("like", dong);
		
		ss.close();
		return list;
	}//like
	
	public int diaryTotalCount() {
		int cnt=0;
		
		SqlSession ss=MyBatisDAO.getInstance().getSessionFactory().openSession();
		cnt = ss.selectOne("diaryCnt");
		
		return cnt;
	}//diaryTotalCount

	public List<DiaryList> subquery(DiaryListParamVO dlpvo){
		List<DiaryList> list = null;
		
		SqlSession ss=MyBatisDAO.getInstance().getSessionFactory().openSession();
		list=ss.selectList("subquery", dlpvo);

		return list;
	}//subquery
	
	public List<Union> union(){
		List<Union> list= null;
		
		SqlSession ss= MyBatisDAO.getInstance().getSessionFactory().openSession();
		list=ss.selectList("union");
		
		return list;
	}//union
	
	public List<EmpJoin> join(int mgr){
		List<EmpJoin> list = null;
		
		SqlSession ss= MyBatisDAO.getInstance().getSessionFactory().openSession();
		list=ss.selectList("join", mgr);
		
		return list;
	}//join
	
	public static void main(String[] args) {
		MyBatisDAO1 md=new MyBatisDAO1();
		//md.multiParam(new EmpVO(30, "SALESMAN"));
		//md.lessThan(3000);
		//md.greaterThan(3000);
		//md.like("청림동");
		//md.diaryTotalCount();
		//md.union();
		md.join(7698);
	}//main

}//class
