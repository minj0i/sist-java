package admin.vo;

public class PMProductAddVO {
	private String menuCode, menuName, img;
	private int price;
	
	public PMProductAddVO(String menuCode, String menuName, String img, int price) {
		this.menuCode = menuCode;
		this.menuName = menuName;
		this.img = img;
		this.price = price;
	}

	public String getMenuCode() {
		return menuCode;
	}

	public String getMenuName() {
		return menuName;
	}

	public String getImg() {
		return img;
	}

	public int getPrice() {
		return price;
	}
	
}//class
