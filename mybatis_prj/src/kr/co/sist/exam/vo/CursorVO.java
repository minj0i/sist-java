package kr.co.sist.exam.vo;

import java.util.List;

import kr.co.sist.exam.domain.EmpProcedure;

public class CursorVO {
	private int deptno; //��ȸ�� �μ� ��ȣ - ����ڰ� �Է��ϴ� ��
	private List<EmpProcedure> empList; //CURSOR�� ��ȸ�� �� - MyBatis�� �Է��ϴ� ��
	
	
	public int getDeptno() {
		return deptno;
	}
	
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	
	public List<EmpProcedure> getEmpList() {
		return empList;
	}
	
	public void setEmpList(List<EmpProcedure> empList) {
		this.empList = empList;
	}
	
	
}//class
