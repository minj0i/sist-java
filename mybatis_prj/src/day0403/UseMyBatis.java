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
		//1.ȯ�漳�� xml�� stream ���� - �����δ� �ʿ���� package���� ���ָ� �ȴ�
		Reader reader=Resources.getResourceAsReader("day0403/mybatis_config.xml");
		//2. MyBatis Framework ����
		SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
		//3. MyBatis Framework�� DB������ ��ü ��� (��ü�� �ϳ��� ����)
		SqlSessionFactory ssf=ssfb.build(reader);
		if(reader!=null) {
			reader.close();
		}//end if
		return ssf;

	}//getSessionFactory
	
	public void insertCpDept(DeptVO dv) throws IOException, SQLException{
		//4. MyBatis Handdler ���
		SqlSession ss = getSessionFactory().openSession();
		//5. Handler ����Ͽ� DB�۾��� ����
		int cnt=ss.insert("insertCpDept", dv);
		ss.commit();
		System.out.println("�߰� �۾�" + cnt);
		
	}
	
	public void updateCpDept(DeptVO dv)throws IOException, SQLException{
		//4. MyBatis Handdler ���
		SqlSession ss = getSessionFactory().openSession();
		//5. ������ ����
		int cnt=ss.insert("updateCpDept", dv);
		System.out.println("���� ����" + cnt);
		ss.commit();
		
	}//updateCpDept
	
	public void deleteCpDept(int deptno)throws IOException, SQLException{
		//4. MyBatis Handdler ���
		SqlSession ss = getSessionFactory().openSession();
		//5. ������ ����
		int cnt=ss.insert("deleteCpDept", deptno);
		ss.commit();
		if(cnt==1) {
			System.out.println(deptno+ "�� �μ� ���� ���� ����" + cnt);
		}else {
			System.out.println("�ش� �μ��� �������� �ʽ��ϴ�.");
		}
	}//updateCpDept
	
	
	
	
	public void selectAllDept() throws IOException {
		/*//1.ȯ�漳�� xml�� stream ����
		//�����δ� �ʿ���� package���� ���ָ� �ȴ�
		Reader reader=Resources.getResourceAsReader("day0403/mybatis_config.xml");
		//2. MyBatis Framework ����
		SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
		//3. MyBatis Framework�� DB������ ��ü ��� (��ü�� �ϳ��� ����)
		SqlSessionFactory ssf=ssfb.build(reader);
		//System.out.println(ssf);
		if(reader!=null) {
			reader.close();
		}//end if
		//4. MyBatis Handler ���
		SqlSession ss = ssf.openSession();*/
		
		//���������� ������ getSessionFactory()�޼ҵ�� ����� return �޾Ƽ� ���� ��
		SqlSession ss = getSessionFactory().openSession();
		//5. Handler�� ����Ͽ� DB�۾� ����
		//namespace�� �ٿ��� �ᵵ �ǰ�
		List<DeptDomain> list= ss.selectList("kr.co.sist.selectAllDept");
		//id�� �ᵵ ��
		//List<DeptDomain> list= ss.selectList("selectAllDept");
		DeptDomain dd= null;
		for(int i=0; i<list.size(); i++) {
			dd=list.get(i);
			System.out.println(dd.getDeptno()+" / "+dd.getDname()+" / "+dd.getLoc());
		}//end for
		//6. ����� ����� SqlSession�� �ݴ´�.
		ss.close();
		
	}//selectAllDept
	
	public static void main(String[] args) {
		UseMyBatis umb = new UseMyBatis();
		try {
			DeptVO dv = new DeptVO(11, "SM���ߺ�", "����");
			//umb.insertCpDept(dv);
			//�̴�� ���ุ �Ѵٸ� commit�� �ȵǱ� ������ ���� �� �ɷ� ������ ����
			//insert�� ss.commit();�� �־��ش�.
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


