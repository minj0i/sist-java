package day0226;

public class Person {
	private String name;
	public Person(String name) {
		this.name=name;
		System.out.println("���Ի�� "+name+"�� �Ի��ϼ̽��ϴ�.");
	}//������
	
	@Override
	public void finalize() {//��ü�� Garbage Collector�� ���� �Ҹ�� �� ȣ�� �ȴ�.
		System.out.println(name+"���� ����ϼ̽��ϴ�.");
	}//finalize
	
	public String getName() {
		return name;
	}//getName
	
}//class
