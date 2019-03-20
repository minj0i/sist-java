package kr.co.sist.diary.vo;

public class DiaryVO {
	private String writer, subject, contents, e_year, e_month, e_day, pass, ip;

	public DiaryVO() {
	}

	public DiaryVO(String writer, String subject, String contents, String e_year, String e_month, String e_day,
			String pass, String ip) {
		this.writer = writer;
		this.subject = subject;
		this.contents = contents;
		this.e_year = e_year;
		this.e_month = e_month;
		this.e_day = e_day;
		this.pass = pass;
		this.ip = ip;
	}

	public String getWriter() {
		return writer;
	}

	public String getSubject() {
		return subject;
	}

	public String getContents() {
		return contents;
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

	public String getPass() {
		return pass;
	}

	public String getIp() {
		return ip;
	}
	
	
	
}//class
