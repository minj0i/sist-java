package kr.co.sist.diary.vo;

public class DiaryUpdateVO {
	private int num;
	private String contents, pass;
	
	public DiaryUpdateVO() {
	}

	public DiaryUpdateVO(int num, String contents, String pass) {
		this.num = num;
		this.contents = contents;
		this.pass = pass;
	}

	public int getNum() {
		return num;
	}

	public String getContents() {
		return contents;
	}

	public String getPass() {
		return pass;
	}
	
	
}//class
