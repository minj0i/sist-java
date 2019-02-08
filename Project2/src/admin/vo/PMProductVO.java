package admin.vo;

public class PMProductVO {
	private String menuCode, menuName, img;
	private int quan;
	
	public PMProductVO(String menuCode, String menuName, String img, int quan) {
		this.menuCode = menuCode;
		this.menuName = menuName;
		this.img = img;
		this.quan = quan;
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
	public int getQuan() {
		return quan;
	}
	
}//class
