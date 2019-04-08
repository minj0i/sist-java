package day0403;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class UseMyBatis {
	public UseMyBatis() {
		org.apache.ibatis.logging.LogFactory.useLog4JLogging();
	}//UseMyBatis
	
	public SqlSessionFactory getSessionFactory() throws IOException{
		//1.환경설정 xml에 stream 연결 - 절대경로는 필요없고 package부터 써주면 된다
		Reader reader=Resources.getResourceAsReader("day0403/mybatis_config.xml");
		//2. MyBatis Framework 생성
		SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
		//3. MyBatis Framework과 DB연동한 객체 얻기 (객체를 하나로 관리)
		SqlSessionFactory ssf=ssfb.build(reader);
		if(reader!=null) {
			reader.close();
		}//end if
		return ssf;

	}//getSessionFactory
	
	public void insertCpDept(DeptVO dv) throws IOException, SQLException{
		//4. MyBatis Handdler 얻기
		SqlSession ss = getSessionFactory().openSession();
		//5. Handler 사용하여 DB작업을 수행
		int cnt=ss.insert("insertCpDept", dv);
		ss.commit();
		System.out.println("추가 작업" + cnt);
		
	}
	
	public void updateCpDept(DeptVO dv)throws IOException, SQLException{
		//4. MyBatis Handdler 얻기
		SqlSession ss = getSessionFactory().openSession();
		//5. 쿼리문 수행
		int cnt=ss.insert("updateCpDept", dv);
		System.out.println("변경 성공" + cnt);
		ss.commit();
		
	}//updateCpDept
	
	public void deleteCpDept(int deptno)throws IOException, SQLException{
		//4. MyBatis Handdler 얻기
		SqlSession ss = getSessionFactory().openSession();
		//5. 쿼리문 수행
		int cnt=ss.insert("deleteCpDept", deptno);
		ss.commit();
		if(cnt==1) {
			System.out.println(deptno+ "번 부서 정보 삭제 성공" + cnt);
		}else {
			System.out.println("해당 부서는 존재하지 않습니다.");
		}
	}//updateCpDept
	
	
	
	
	public void selectAllDept() throws IOException {
		/*//1.환경설정 xml에 stream 연결
		//절대경로는 필요없고 package부터 써주면 된다
		Reader reader=Resources.getResourceAsReader("day0403/mybatis_config.xml");
		//2. MyBatis Framework 생성
		SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
		//3. MyBatis Framework과 DB연동한 객체 얻기 (객체를 하나로 관리)
		SqlSessionFactory ssf=ssfb.build(reader);
		//System.out.println(ssf);
		if(reader!=null) {
			reader.close();
		}//end if
		//4. MyBatis Handler 얻기
		SqlSession ss = ssf.openSession();*/
		
		//위에까지의 내용을 getSessionFactory()메소드로 만들고 return 받아서 쓰면 됨
		SqlSession ss = getSessionFactory().openSession();
		//5. Handler를 사용하여 DB작업 수행
		//namespace를 붙여서 써도 되고
		List<DeptDomain> list= ss.selectList("kr.co.sist.selectAllDept");
		//id만 써도 됨
		//List<DeptDomain> list= ss.selectList("selectAllDept");
		DeptDomain dd= null;
		for(int i=0; i<list.size(); i++) {
			dd=list.get(i);
			System.out.println(dd.getDeptno()+" / "+dd.getDname()+" / "+dd.getLoc());
		}//end for
		//6. 사용이 종료된 SqlSession을 닫는다.
		ss.close();
		
	}//selectAllDept
	
	public static void main(String[] args) {
		UseMyBatis umb = new UseMyBatis();
		try {
			DeptVO dv = new DeptVO(11, "SM개발부", "원주");
			//umb.insertCpDept(dv);
			//이대로 실행만 한다면 commit이 안되기 때문에 값이 들어간 걸로 보이지 않음
			//insert에 ss.commit();을 넣어준다.
			//umb.updateCpDept(dv);
			umb.deleteCpDept(11);
			umb.selectAllDept();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}//main

}//class


