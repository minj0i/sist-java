package day0313;

public class TestVO {
	private String firstName;
	private int age;
	
	//�⺻������ �ּ�ó���ص� �����Ϸ��� ��������
	public TestVO() {
		System.out.println("TestVO�� �⺻ ������");
	}

	//�����ڰ� �ϳ��� ������������� �����Ϸ��� �ڵ����� ������ �� ��� ����
	public TestVO(String firstName, int age) {
		this.firstName = firstName;
		this.age = age;
		System.out.println("TestVO�� �����ִ� ������");
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
