package day0108;

/**
 * �������� JVM���� �ϳ��� ��ü�� ���������, �ϳ��� ��ü�� ���Ǵ� Pattern
 * @author owner
 */
public class Singleton {
	//1.1 private���������� ���������� �� ���� ������ static�� �ٿ���
	private static Singleton single;
	
	/**
	 * 1. (private����) class�ܺο��� ��üȭ�� ���� ���ϵ��� ���´�.
	 */
	private Singleton() {
		
	}//Singleton
	

	public static Singleton getInstance() {
		if(single == null) {//��ü�� �����Ǿ� ���� �ʴٸ� ��ü�� �����ϰ�
		single = new Singleton();
		}//end if
		//��ü�� �����Ǿ� �ִٸ� ������ ��ü�� ��ȯ
		return single;
	}
	
}//class
