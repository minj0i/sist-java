package day0403;

public class DeptVO {
	private int deptno;
	private String dname, loc;
	
	//�����ִ� �����ڰ� �ξ� ����
	public DeptVO(int deptno, String dname, String loc) {
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}

	//�ִ°� ���޸� �ϸ� �Ǽ� getter�� �־ ��
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
