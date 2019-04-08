package day0403;

public class DeptVO {
	private int deptno;
	private String dname, loc;
	
	//인자있는 생성자가 훨씬 편함
	public DeptVO(int deptno, String dname, String loc) {
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}

	//있는걸 전달만 하면 되서 getter만 있어도 됨
	public int getDeptno() {
		return deptno;
	}

	public String getDname() {
		return dname;
	}

	public String getLoc() {
		return loc;
	}
	
	
}//DeptVO
