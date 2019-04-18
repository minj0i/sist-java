package kr.co.sist.vo;

public class SessionVO {
	private String name, addr;

	//Spring framework가 만들어주므로 getter, setter만 있으면 됨
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
}//class
