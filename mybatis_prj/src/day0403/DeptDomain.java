package day0403;

/**
 * ��ȸ�ϴ� �÷��� ���� �����ϴ� VO�� Domain
 * @author owner
 */
public class DeptDomain {
	private int deptno;
	private String dname, loc;
	
	//Ŭ������ �⺻�����ڸ� ������ ������ ������ �����Ϸ��� ������ֱ⶧���� getter, setter�� ���� ������������
	/*public DeptDomain() {
		System.out.println("DeptDomain �⺻������");
	}//DeptDomain
	public DeptDomain(int deptno, String dname, String loc) {
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
		System.out.println("DeptDomain �����ִ� ������");
	}
	 */
	
	public int getDeptno() {
		return deptno;
	}

	public String getDname() {
		return dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}
	
}
