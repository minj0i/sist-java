package kr.co.sist.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.vo.EmpVO;

public class DAOOracleImpl implements Dao{

	@Override
	public int insertEmp(EmpVO ev) throws SQLException {
		//OracleDB에 insert 작업 수행
		//원래는 JDBC 단계 써줌
		System.out.println("Oracle에 사원정보 추가");
		return 1;
	}//insertEmp

	@Override
	public List<EmpVO> selectEmp() throws SQLException {
		List<EmpVO> list= new ArrayList<EmpVO>();
		list.add(new EmpVO(1111, "노진경"));
		list.add(new EmpVO(1112, "김희철"));
		list.add(new EmpVO(1113, "김정윤"));
		list.add(new EmpVO(1114, "이재찬"));
		return list;
	}//selectEmp

}
