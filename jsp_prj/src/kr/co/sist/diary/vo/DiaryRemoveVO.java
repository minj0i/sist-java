package kr.co.sist.diary.vo;

public class DiaryRemoveVO {
	private int num;
	private String pass;
	
	public DiaryRemoveVO() {
	}

	public DiaryRemoveVO(int num, String pass) {
		this.num = num;
		this.pass = pass;
	}

	public int getNum() {
		return num;
	}

	public String getPass() {
		return pass;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "DiaryRemoveVO [num=" + num + ", pass=" + pass + "]";
	}
	
	
}//class
