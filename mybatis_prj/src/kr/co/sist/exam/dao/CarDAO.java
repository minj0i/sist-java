package kr.co.sist.exam.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.sist.exam.domain.CarModel;

public class CarDAO {
	
	public List<String> selectMaker(String country){
		List<String> list=null;
		//Handler얻기
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		
		list=ss.selectList("selectCarCountry", country);
		
		ss.close();
		return list;
	}//selectMaker
	
	public List<String> selectModel(String maker){
		List<String> list=null;
		//Handler얻기
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		
		list=ss.selectList("selectCarMaker", maker);
		
		ss.close();
		return list;
	}//selectModel
	
	public List<CarModel> selectDetailModel(String model){
		List<CarModel> list=null;
		//Handler얻기
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		
		list=ss.selectList("selectCarModel", model);
		
		ss.close();
		return list;
	}//selectModel
	
	
	public static void main(String[] args) {
		CarDAO cd=new CarDAO();
//		cd.selectMaker("국산");
//		cd.selectModel("현대");
	}//main

}//class
