package day1203;

public class TestSub2 extends TestSuper {
	int i;
	public TestSub2() {
//		super();//�� ���� ����
		System.out.println("�ڽ��� ������222222");
	}//TestSub
	
	public void subMethod() {
		System.out.println("�ڽ��� subMethod2222222222");
	}//subMethod
	
	@Override 
	public void printI() {
		System.out.println("�ڽ�22222�� Override �� method "+this.i+", �θ��� i "+super.i);		
	}//printI
	
}//class
