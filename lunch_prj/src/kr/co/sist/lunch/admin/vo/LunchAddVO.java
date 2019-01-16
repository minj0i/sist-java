package kr.co.sist.lunch.admin.vo;

public class LunchAddVO {
	private String Lunch_name, img, spec;
	private int price;
	public LunchAddVO(String lunch_name, String img, String spec, int price) {
		Lunch_name = lunch_name;
		this.img = img;
		this.spec = spec;
		this.price = price;
	}//»ý¼ºÀÚ
	public String getLunch_name() {
		return Lunch_name;
	}
	public String getImg() {
		return img;
	}
	public String getSpec() {
		return spec;
	}
	public int getPrice() {
		return price;
	}
	
}//class
