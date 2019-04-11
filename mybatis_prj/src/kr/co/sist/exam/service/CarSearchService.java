package kr.co.sist.exam.service;

import java.util.List;

import kr.co.sist.exam.dao.CarDAO;
import kr.co.sist.exam.domain.CarModel;

public class CarSearchService {
	private CarDAO cd;
	public List<String> list=null;
	
	public CarSearchService() {
		cd=new CarDAO();
	}//CarSearchService
	
	public List<String> searchMaker(String country){
		list = cd.selectMaker(country);
		return list;
	}//serachMaker
	
	public List<String> searchModel(String maker){
		list = cd.selectModel(maker);
		return list;
	}//serachMaker
	
	public List<CarModel> searchDetailModel(String model){
		List<CarModel> list=null;
		list = cd.selectDetailModel(model);
		return list;
	}//serachDetailModel
	
}//CarSearchService
