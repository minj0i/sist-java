package xml0327;

public class AttVO {
	private String firstName, lastName, city, zipcode, address;

	public AttVO() {
	}

	public AttVO(String firstName, String lastName, String city, String zipcode, String address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.zipcode = zipcode;
		this.address = address;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "AttVO [firstName=" + firstName + ", lastName=" + lastName + ", city=" + city + ", zipcode=" + zipcode
				+ ", address=" + address + "]";
	}
	
	
}//class
