package day1204;

/**
 * @author owner
 *
 */
public class Outer {
	int i;
	public Outer() {
		System.out.println("바깥 클래스의 생성자");
	}//Outer
	
	public void outMethod() {
	System.out.println("바깥클래스의 method, 안쪽클래스의 자원 i="+i);
//	System.out.println("안쪽 클래스의 j="+j);//
	//안쪽클래스를 객체화 
	Outer.Inner in =this.new Inner();
	in.j=100;
	in.inMethod();
	}//outMethod
	
	////////////안쪽클래스가 시작//////////////////
	public class Inner{
		int j;
		public Inner( ) {
			System.out.println("안쪽 클래스의 생성자");
		}//Inner
		public void inMethod() {
			System.out.println("안쪽 클래스의 자원 j="+j+",바깥클래스의 자원 i="+i);
//			outMethod();//바깥클래스의 method
		}//inMethod
	}//class
	
	////////////안쪽클래스가 시작//////////////////
	public static void main(String[] args) {
		//1.바깥 클래스의 객체화
		Outer out =new Outer();
		out.i=10;
		out.outMethod();
//		out.j=10; //안쪽클래스의 자원을 직접 접근하여 사용할 수 없다.
//		out.inMethod();//안쪽클래스의 자원을 직접 접근하여 사용할 수 없다.
		//2.안쪽클래스의 객체화:
		//--바깥클래스에서 안쪽 클래스의 자원을 사용할 수 있다.
		//바깥클래스명.안쪽클래스명 객체명 = 바깥클래스의 객체명.new 안쪽생성자();
//		Outer.Inner in = out.new Inner();
		//바깥클래스명은 생략할 수 있다.
//		Inner in = out.new Inner();
//		in.j=12;
//		in.inMethod();
		
		
	}//main
}//class
