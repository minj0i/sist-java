package day1203;

public class TestSub2 extends TestSuper {
	int i;
	public TestSub2() {
//		super();//가 숨어 있음
		System.out.println("자식의 생성자222222");
	}//TestSub
	
	public void subMethod() {
		System.out.println("자식의 subMethod2222222222");
	}//subMethod
	
	@Override 
	public void printI() {
		System.out.println("자식22222이 Override 한 method "+this.i+", 부모의 i "+super.i);		
	}//printI
	
}//class
