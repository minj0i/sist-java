package day0104;

public class OneCpDeptVO { //값이 하나라도 틀리면 VO를 무조건 새로 만듬
	private String dname, loc;

	public OneCpDeptVO() {
	}

	public OneCpDeptVO(String dname, String loc) {
		this.dname = dname;
		this.loc = loc;
	}

	public String getDname() {
		return dname;
	}

	public String getLoc() {
		return loc;
	}
	
	
	
}
