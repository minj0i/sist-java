package day0108;

public class UseSingleton {

	public static void main(String[] args) {
		//Singleton Pattern���� ������� ��ü ���.
		
//		Singleton s = new Singleton();//�����ڰ� private�̹Ƿ� Ŭ���� �ܺο��� ��üȭ�� �� �� ����
		
		Singleton s = Singleton.getInstance();
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		Singleton s3 = Singleton.getInstance();
		
		//singleton���� ���������� ��ü�� �� �ٸ��� ���� = �̰��� singleton�� �ƴմϴ�.
		//�ذ� : Singleton Ŭ�������� 
		//public static Singleton getInstance() {��  if(single == null) {}�� �߰�����
		System.out.println(s);
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		
		
		
	}//main
}//class
