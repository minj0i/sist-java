package kr.co.sist.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.vo.EmpVO;

public class DAOMySqlImpl implements Dao{

	@Override
	public int insertEmp(EmpVO ev) throws SQLException {
		System.out.println("MySQL에 사원정보 추가");
		return 1;
	}//insertEmp

	@Override
	public List<EmpVO> selectEmp() throws SQLException {
		List<EmpVO> list= new ArrayList<EmpVO>();
		list.add(new EmpVO(2111, "공선의"));
		list.add(new EmpVO(2112, "이재현"));
		list.add(new EmpVO(2113, "오영근"));
		list.add(new EmpVO(2114, "정택성"));
		list.add(new EmpVO(2115, "이봉현"));
		return list;
	}//selectEmp

}
