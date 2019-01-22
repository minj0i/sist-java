package kr.co.sist.lunch.user.vo;

public class OrderListVO {
	private String lunchName, orderDate;
	private int Quantity;
	
	public OrderListVO(String lunchName, String orderDate, int quantity) {
		this.lunchName = lunchName;
		this.orderDate = orderDate;
		this.Quantity = quantity;
	}
	

	public String getLunchName() {
		return lunchName;
	}
	public String getorderDate() {
		return orderDate;
	}
	public int getQuantity() {
		return Quantity;
	}
	@Override
	public String toString() {
		return "OrderListVO [lunchName=" + lunchName + ", orderDate=" + orderDate + ", Quantity=" + Quantity + "]";
	}
	
}//class
