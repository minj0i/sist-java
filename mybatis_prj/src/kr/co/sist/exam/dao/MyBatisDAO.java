package kr.co.sist.exam.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.co.sist.exam.domain.DeptInfo;
import kr.co.sist.exam.domain.Emp;

public class MyBatisDAO {
	private static MyBatisDAO mb_dao;
	SqlSessionFactory ssf=null;
	
	private MyBatisDAO() {
		
	}//MyBatisDAO
	
	public static MyBatisDAO getInstance() {
		if(mb_dao==null) {
			mb_dao=new MyBatisDAO();
		}//end if
		return mb_dao;
	}//getInstance
	
	public synchronized SqlSessionFactory getSessionFactory() {
		if(ssf==null) {
			org.apache.ibatis.logging.LogFactory.useLog4JLogging();
			Reader reader= null;
			try {
				//1. 설정용 xml로딩
				reader=Resources.getResourceAsReader("kr/co/sist/exam/dao/mybatis_config.xml");
				//2. MyBatis Frmaework생성
				SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
				//3. DB와 연동된 객체 받기
				ssf=ssfb.build(reader);
				if(reader!=null) {reader.close();}//end if
				
			} catch (IOException ie) {
				ie.printStackTrace();
			}//end catch
		}//end if
		return ssf;
	}//getSessionFactory
	
	public String singleColumn() {
		//MyBatis Handler를 사용하여 Mapper(xml)에 있는 ID 찾고 Parsing하여
		//조회된 결과를 얻는다.
		String dname="";
		SqlSession ss=getSessionFactory().openSession();
		dname=ss.selectOne("singleColumn");
		ss.close();
		return dname;
	}//singleColumn
	
	public DeptInfo multiColumn() {
		DeptInfo di=null;
		
		MyBatisDAO mb_dao=MyBatisDAO.mb_dao;
		SqlSession ss=mb_dao.getSessionFactory().openSession();
		
		di=ss.selectOne("multiColumn");
		ss.close();
		
		return di;
	}//multiColumn
	
	public List<Integer> multiRow(){
		List<Integer> list=null;
		
		SqlSession ss=getInstance().getSessionFactory().openSession();
		list=ss.selectList("multiRow");
		ss.close();
		return list;
	}//multiRow
	
	public List<Emp> multiColumnRow(int deptno){
		List<Emp> list=null;
		//4.Handler 얻기
		SqlSession ss=getSessionFactory().openSession();
		
		//5. mapper에서 쿼리가 존재하는 id를 찾아 실행
		list=ss.selectList("multiColumnRow",deptno);
		ss.close();
		return list;
	}//multiColumnRow
	
	
	public static void main(String[] args) {
		MyBatisDAO m=MyBatisDAO.getInstance();
		//System.out.println(m.singleColumn());
		//System.out.println(m.multiColumn());
		System.out.println(m.multiColumnRow(10));
		
	}//main
	
}//class
