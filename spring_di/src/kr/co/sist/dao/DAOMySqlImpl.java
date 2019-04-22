package kr.co.sist.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.vo.EmpVO;

public class DAOMySqlImpl implements Dao{

	@Override
	public int insertEmp(EmpVO ev) throws SQLException {
		System.out.println("MySQL�� ������� �߰�");
		return 1;
	}//insertEmp

	@Override
	public List<EmpVO> selectEmp() throws SQLException {
		List<EmpVO> list= new ArrayList<EmpVO>();
		list.add(new EmpVO(2111, "������"));
		list.add(new EmpVO(2112, "������"));
		list.add(new EmpVO(2113, "������"));
		list.add(new EmpVO(2114, "���ü�"));
		list.add(new EmpVO(2115, "�̺���"));
		return list;
	}//selectEmp

}
