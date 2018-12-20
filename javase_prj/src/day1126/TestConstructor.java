package day1126;

/**
 * Ŭ������ ��ü�� ������ �� �⺻������ ������ �־�� �� �⺻����
 * �����ϰų�, �⺻������ ����� �ڵ带 �����ϴ� method�� ����.
 * @author owner
 */
public class TestConstructor {

	/**
	 * �⺻ ������: Ŭ������ �ۼ� �� �� �����ڸ� �ϳ��� �������� ������
	 * �����Ϸ��� �Ű����� ���� Default Constructor�� �����Ѵ�.  
	 */
	public TestConstructor() {
		System.out.println("�⺻ ������");
//		TestConstructor(300);//�����ڸ� method ȣ���ϵ� �θ� �� ����.
	}//TestConstructor
	
	//Overload ����: ���������� ����, ��ȯ�� ���°ŷ� ����, �޼ҵ� ���� �� ����, ȣ�� �� ���еǵ��� �޶�� ��
	/**
	 * �����ִ� ������: �������� Overload
	 * @param i ������ ��
	 */
	public TestConstructor(int i) {
		System.out.println("�����ִ� ������"+i);
	}//TestConstructor
	
	public void test() {
		System.out.println("test method!!!");
		temp();//method ȣ��
	}//test
	//��ũ��Ʈ �޼ҵ�, �������� ���� �ϴ� �޼ҵ�
	public void temp() {
		System.out.println("-------------temp method!!!");
	}//temp
	
	public static void main(String[] args) {
		//Overloading�� �����ڸ� ����Ͽ� ��üȭ�� �پ��ϰ� �� �� ����.
		TestConstructor tc = new TestConstructor();//�⺻������
		TestConstructor tc1 = new TestConstructor(26);//�����ִ� ������	
		
		System.out.println(tc);
		System.out.println(tc1);
		
		tc.test();
	}//main

}//class
