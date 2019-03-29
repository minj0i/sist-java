package kr.co.sist.diary.vo;

public class DiaryListVO {
	private int num;
	private String subject, writer, e_year, e_month, e_day, w_date;
	
	public DiaryListVO() {
	}

	public DiaryListVO(int num, String subject, String writer, String e_year, String e_month, String e_day,
			String w_date) {
		this.num = num;
		this.subject = subject;
		this.writer = writer;
		this.e_year = e_year;
		this.e_month = e_month;
		this.e_day = e_day;
		this.w_date = w_date;
	}

	public int getNum() {
		return num;
	}

	public String getSubject() {
		return subject;
	}

	public String getWriter() {
		return writer;
	}

	public String getE_year() {
		return e_year;
	}

	public String getE_month() {
		return e_month;
	}

	public String getE_day() {
		return e_day;
	}

	public String getW_date() {
		return w_date;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
}//class
