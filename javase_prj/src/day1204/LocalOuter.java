package day1204;

/**
 * method안에 클래스를 정의하는 지역class의 사용.<br>
 * 생성된 객체를 지역변수처럼 사용하는 클래스
 * @author owner
 */
public class LocalOuter {
	int i;
	
	public LocalOuter() {
		System.out.println("바깥 클래스의 생성자");
	}//LocalOuter
	
	public void method(int param_i, final int param_j ) {
		int local_i=0;
		final int local_j=0;
		
		///////////////////지역클래스 시작//////////////////
		class Local{
			int loc_i;
			
			public Local() {
				System.out.println("지역클래스의 생성자");
			}//Local
			public void locMethod() {
				System.out.println("지역클래스의 loc_i="+loc_i);
				System.out.println("외부 클래스의 인스턴스 변수 i="+i);
				//final이 붙은 매개변수만 사용할 수 있었다.
				System.out.println("매개변수(Parameter) param_i="+param_i+" parma_j="+param_j);
				//final이 붙은 지역변수만 사용할 수 있었다.
				System.out.println("지역변수 local_i="+local_i+", local_j="+local_j);
//				local_i=2018;//JDK1.8에서부터는 final붙어있지않은
				//지역변수의 값 사용(출력)은 가능하지만 값 할당은 불가능
				
			}//locMethod
			
		}//class
		///////////////////지역클래스 끝//////////////////
		//지역클래스의 객체화
		Local lo = new Local();
		//생성된 객체로 클래스 내의 자원을 사용할 수 있다.
//		loc_i=100;//직접 사용불가
		lo.loc_i=100;
		lo.locMethod();
		
		System.out.println("바깥 클래스의 method 호출");
	}//method
	
	public static void main(String[] args) {
		LocalOuter lo = new LocalOuter();
		lo.method(12, 4);
	}//main

}//class
