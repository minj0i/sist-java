package day1204;

/**
 * 내부클래스를 static 변수처럼 사용할 수 있는
 * @author owner
 */
public class NestedOuter {
	int i;
	static int j;
	public NestedOuter() {
		System.out.println("바깥 클래스의 생성자");
	}//NestedOuter
	
	public void outInstMethod() {
		System.out.println("바깥 클래스의 인스턴스 method");
	}//outInstMethod
	
	public static void outStatMethod() {
		System.out.println("바깥 클래스의 static method");
	}//outInstMethod
	
	///////////////////Nested class 시작 //////////////////
	static class NestedInner{
		int in_i;//instance변수
		static int in_j;//static변수
		//public Nested Inner(){
		//	}
		public void inMethod() {
			System.out.println("안쪽 클래스의 인스턴스 method");
		}//inMethod
		
		public static void inStatMethod() {
			System.out.println("안쪽 클래스의 static method");
			System.out.println("바깥 클래스의 자원 사용.i는사용불가, j="+NestedOuter.j);
//			OutInstMethod();//instance영역의 method이므로 사용할 수 없다.
			NestedOuter.outStatMethod();
			
		}//inStatMethod
	}//class
	///////////////////Nested class 끝 //////////////////
	public static void main(String[] args) {
		//static영역을 사용할때에는 객체화없이 클래스명.변수명,
		//클래스명.method명으로 사용한다.
		NestedInner.inStatMethod();
	}//main

}//class
