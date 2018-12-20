package day1130;

/**
 * 
 * @author owner
 */
public class TestSub extends TestSuper {
	int p_j;
	
	@Override
	public void method() {
		p_i=400;// 코드의 재사용성//부모의 변수
		super.p_j=500;//같은 이름의 변수가 존재하면 자식의 것을 사용
		
		System.out.println("자식의 Method:"+this.p_i+"/"+this.p_j);
		super.method();
		
		System.out.println(this);
//		System.out.println(super);//super의 주소는 출력할 수 없다.
	}//method
	
	public static void main(String[] args) {
		TestSub ts = new TestSub();
		ts.method();
	}//main

}//class
