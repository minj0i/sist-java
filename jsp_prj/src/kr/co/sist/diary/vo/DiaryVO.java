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

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public void setE_year(String e_year) {
		this.e_year = e_year;
	}

	public void setE_month(String e_month) {
		this.e_month = e_month;
	}

	public void setE_day(String e_day) {
		this.e_day = e_day;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Override
	public String toString() {
		return "DiaryVO [writer=" + writer + ", subject=" + subject + ", contents=" + contents + ", e_year=" + e_year
				+ ", e_month=" + e_month + ", e_day=" + e_day + ", pass=" + pass + ", ip=" + ip + "]";
	}
	
}//class
