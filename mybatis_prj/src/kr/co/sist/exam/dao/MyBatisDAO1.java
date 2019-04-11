package kr.co.sist.exam.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.sist.exam.domain.Car;
import kr.co.sist.exam.domain.DEmp;
import kr.co.sist.exam.domain.DiaryList;
import kr.co.sist.exam.domain.DynamicIf;
import kr.co.sist.exam.domain.Emp;
import kr.co.sist.exam.domain.EmpJoin;
import kr.co.sist.exam.domain.Union;
import kr.co.sist.exam.domain.Zipcode;
import kr.co.sist.exam.vo.CarVO;
import kr.co.sist.exam.vo.CursorVO;
import kr.co.sist.exam.vo.DeptnoVO;
import kr.co.sist.exam.vo.DiaryListParamVO;
import kr.co.sist.exam.vo.EmpVO;
import kr.co.sist.exam.vo.TestProcVO;
import kr.co.sist.exam.vo.TnameVO;
import kr.co.sist.exam.vo.TransactionVO;

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
		ss.close();
		return cnt;
	}//diaryTotalCount

	public List<DiaryList> subquery(DiaryListParamVO dlpvo){
		List<DiaryList> list = null;
		
		SqlSession ss=MyBatisDAO.getInstance().getSessionFactory().openSession();
		list=ss.selectList("subquery", dlpvo);
		ss.close();
		return list;
	}//subquery
	
	public List<Union> union(){
		List<Union> list= null;
		
		SqlSession ss= MyBatisDAO.getInstance().getSessionFactory().openSession();
		list=ss.selectList("union");
		ss.close();
		return list;
	}//union
	
	public List<EmpJoin> join(int mgr){
		List<EmpJoin> list = null;
		
		SqlSession ss= MyBatisDAO.getInstance().getSessionFactory().openSession();
		list=ss.selectList("join", mgr);
		ss.close();
		return list;
	}//join
	
	public List<Car> joinSubQuery(){
		List<Car> list = null;
		
		SqlSession ss= MyBatisDAO.getInstance().getSessionFactory().openSession();
		list=ss.selectList("joinSubQuery");
		ss.close();		
		return list;
	}//joinSubQuery
	
	public List<DEmp> dynamicTable(TnameVO tname){
		List<DEmp> list = null;
		
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		list = ss.selectList("dtable", tname);
		ss.close();
		return list;
	}//dynamicTable
	
/*	public List<DynamicIf> dynamicIf(int deptno){
		List<DynamicIf> list = null;
		
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		list = ss.selectList("dynamicIf", deptno);
		
		return list;
	}//dynamicIf
*/
	public List<DynamicIf> dynamicIf(DeptnoVO dvo){
		List<DynamicIf> list = null;
		
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		list = ss.selectList("dynamicIf", dvo);
		ss.close();
		return list;
	}//dynamicIf
	
	public List<DynamicIf> dynamicChoose(DeptnoVO dvo){
		List<DynamicIf> list = null;
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		list = ss.selectList("kr.co.sist.exam2.dynamicChoose", dvo);
		ss.close();
		return list;
	}//dynamicChoose
	
	public List<Car> dynamicForEach(CarVO cv){
		List<Car> list = null;
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		list = ss.selectList("kr.co.sist.exam2.dynamicForeach", cv);
		ss.close();
		return list;
	}//dynamicForEach
	
	public TestProcVO insertProc(TestProcVO tpvo){
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		System.out.println("-----"+tpvo.getmsg());
		ss.selectOne("insertProcedure", tpvo);
		System.out.println("-----"+tpvo.getmsg());
		ss.close();
		return tpvo;
	}//insertProc
	
	public void selectProc(CursorVO c_vo) {
		
		SqlSession ss=MyBatisDAO.getInstance().getSessionFactory().openSession();
		ss.selectOne("selectProcedure", c_vo);
		ss.close();
	}//selectProc
	
	public int insertTransaction(TransactionVO t_vo) {
		int cnt=0, cnt1=0;
		SqlSession ss=MyBatisDAO.getInstance().getSessionFactory().openSession();
		cnt=ss.insert("tr1", t_vo);
		cnt1=ss.insert("tr2", t_vo);
		
		if((cnt+cnt1)==2) {
			ss.commit();
		}else {
			ss.rollback();
		}
		ss.close();
		return cnt+cnt1;
	}//class
	
	
	public static void main(String[] args) {
		MyBatisDAO1 md=new MyBatisDAO1();
		//md.multiParam(new EmpVO(30, "SALESMAN"));
		//md.lessThan(3000);
		//md.greaterThan(3000);
		//md.like("청림동");
		//md.diaryTotalCount();
		//md.union();
		//md.join(7698);
		//md.joinSubQuery();
		
		//mapper에서 #{tname}인경우
		//### SQL: select EMPNO, ENAME, HIREDATE, SAL    from ?
		//### Cause: java.sql.SQLSyntaxErrorException: ORA-00903: 테이블명이 부적합합니다 에러 발생
		//mapper에서 ${tname}으로 고침. 생성되는 쿼리문에 반영이 됨.
		//md.dynamicTable(new TnameVO("CP_EMP2"));
		
		//mapper에서 <select id="dynamicIf" resultMap="ifResult" parameterType="int">인 경우
		//There is no getter for property named 'deptno' in 'class java.lang.Integer' 에러 발생
		//<select id="dynamicIf" resultMap="ifResult" parameterType="kr.co.sist.exam.vo.DeptnoVO">로 수정해야 함
		//md.dynamicIf(new DeptnoVO(20));
		//md.dynamicChoose(new DeptnoVO(1));
		//List<String> list=null;
		/*List<String> list=new ArrayList<String>();
		list.add("현대");
		list.add("기아");
		list.add("BMW");
		list.add("삼성");*/
		//md.dynamicForEach(new CarVO(list));
		/*TestProcVO tpvo=new TestProcVO(1111, 3000, 0, "김희철", "대리", "");
		md.insertProc(tpvo);*/
		
/*		CursorVO c_vo = new CursorVO();
		c_vo.setDeptno(10);
		md.selectProc(c_vo);
		System.out.println(c_vo.getEmpList());*/
		
		TransactionVO tv=new TransactionVO("어쩐지 오늘은", "김정윤");
		System.out.println(md.insertTransaction(tv));
	}//main

}//class
