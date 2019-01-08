package day0107.hwk;

public class HwSelectTableVO {
	private String tname;
	
	private HwSelectTableVO() {
		
	}//기본 생성자
	
	public HwSelectTableVO(String tname) {
		this.tname = tname;
	}//인자 있는 생성자

	public String getTname() {
		return tname;
	}
	
	
}
