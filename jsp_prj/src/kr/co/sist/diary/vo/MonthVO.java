package kr.co.sist.diary.vo;

public class MonthVO {
	private int num;
	private String subject;
	
	public MonthVO() {
	}
	
	public MonthVO(int num, String subject) {
		this.num = num;
		this.subject = subject;
	}

	public int getNum() {
		return num;
	}

	public String getSubject() {
		return subject;
	}
	
}//class
