package day0313;

public class TestVO {
	private String firstName;
	private int age;
	
	//기본생성자 주석처리해도 컴파일러가 생성해줌
	public TestVO() {
		System.out.println("TestVO의 기본 생성자");
	}

	//생성자가 하나라도 만들어져있으면 컴파일러가 자동으로 생성할 수 없어서 에러
	public TestVO(String firstName, int age) {
		this.firstName = firstName;
		this.age = age;
		System.out.println("TestVO의 인자있는 생성자");
	}

	public String getFirstName() {
		return firstName;
	}

	public int getAge() {
		return age;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}//class
