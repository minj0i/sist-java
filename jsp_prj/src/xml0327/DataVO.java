package xml0327;

public class DataVO {

	private String carModel, company, owner, carType;
	private int cc;
	
	public DataVO() {
	}

	public DataVO(String carModel, String company, String owner, String carType, int cc) {
		this.carModel = carModel;
		this.company = company;
		this.owner = owner;
		this.carType = carType;
		this.cc = cc;
	}

	public String getCarModel() {
		return carModel;
	}

	public String getCompany() {
		return company;
	}

	public String getOwner() {
		return owner;
	}

	public String getCarType() {
		return carType;
	}

	public int getCc() {
		return cc;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public void setCc(int cc) {
		this.cc = cc;
	}
	
	
	
}//class
