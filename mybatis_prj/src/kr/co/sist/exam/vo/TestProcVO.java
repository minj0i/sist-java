package kr.co.sist.exam.vo;

/**
 * Procedure에 사용되는 VO는 In Parameter값과 OutParameter 값을 모두
 * 가지고 있어야 한다.
 * @author owner
 */
public class TestProcVO {
	
	private int empno, sal, rowCnt;
	private String ename, job, msg;
	
	//인자 생성을 내가 하므로 인자있는 생성자와 getter, setter를 만들어줌
	public TestProcVO(int empno, int sal, int rowCnt, String ename, String job, String msg) {
		this.empno = empno;
		this.sal = sal;
		this.rowCnt = rowCnt;
		this.ename = ename;
		this.job = job;
		this.msg = msg;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public int getRowCnt() {
		return rowCnt;
	}

	public void setRowCnt(int rowCnt) {
		this.rowCnt = rowCnt;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getmsg() {
		return msg;
	}

	public void setmsg(String msg) {
		this.msg = msg;
	}
	
}//class
