package day0107;

public class CpEmp2AllVO {
	private int empno, sal;
	private String ename, hiredate;
	
	public CpEmp2AllVO() {
	}//기본

	public CpEmp2AllVO(int empno, int sal, String ename, String hiredate) {
		this.empno = empno;
		this.sal = sal;
		this.ename = ename;
		this.hiredate = hiredate;
	}//인자있는생성자

	public int getEmpno() {
		return empno;
	}

	public int getSal() {
		return sal;
	}

	public String getEname() {
		return ename;
	}

	public String getHiredate() {
		return hiredate;
	}

	//toString()을 안하면 주소값이 나오고
	//이것을 해야 DAO에서 selectAllCpEmp2했을때 값으로 나옴
	@Override
	public String toString() {
		return "CpEmp2AllVO [empno=" + empno + ", sal=" + sal + ", ename=" + ename + ", hiredate=" + hiredate + "]";
	}
	
	
}//class
