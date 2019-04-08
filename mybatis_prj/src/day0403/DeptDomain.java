package day0403;

/**
 * 조회하는 컬럼의 값을 저장하는 VO를 Domain
 * @author owner
 */
public class DeptDomain {
	private int deptno;
	private String dname, loc;
	
	//클래스의 기본생성자를 만들지 않으면 어차피 컴파일러가 만들어주기때문에 getter, setter만 만들어도 에러나지않음
	/*public DeptDomain() {
		System.out.println("DeptDomain 기본생성자");
	}//DeptDomain
	public DeptDomain(int deptno, String dname, String loc) {
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
		System.out.println("DeptDomain 인자있는 생성자");
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
