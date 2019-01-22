package kr.co.sist.lunch.admin.vo;

public class FlagVO {
	private String request;
	private boolean readFlag;

	public FlagVO(String request,boolean readFlag) {
		this.request = request;
		this.readFlag=readFlag;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public void setReadFlag(boolean readFlag) {
		this.readFlag = readFlag;
	}

	public String getRequest() {
		return request;
	}

	public boolean isReadFlag() {
		return readFlag;
	}
	
}
