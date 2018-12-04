package day1203;

public class TestSub extends TestSuper {
	int i;
	public TestSub() {
//		super();//가 숨어 있음
		System.out.println("자식의 생성자");
	}//TestSub
	
	public void subMethod() {
		System.out.println("자식의 subMethod");
	}//subMethod
	
	@Override 
	public void printI() {
		System.out.println("자식이 Override 한 method "+this.i+", 부모의 i "+super.i);		
	}//printI
	

}//class
