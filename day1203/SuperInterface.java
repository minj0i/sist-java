package day1203;

/**
 * 구현클래스(자식클래스)에서 반드시 Override 해야하는 일의 목록만
 * 정의하는 interface 사용법. (구현의 강제성)
 * @author owner
 */
//Interface는 부모를 여러개 가질 수 있다.
public interface SuperInterface extends InterA, InterB {
	//constant : 변수를 상수처럼 사용.
//	int i;	//변수는 작성할 수 없음
	public static final int FLAG_VALUE=12;
	
	//추상 method 구성 => body가 없음
	//일반 method는 가질 수 없음 Error
//	public void test();
//	}
	
	//인터페이스 간 상속에는 추상 method를 Override하지 않는다.
//	@Override
//	public String msg();//InterA에 있는 걸 넣어준다고 해도 Body를 갖을 수 없기 때문에 의미가 없음

	//abstract을 사용하지 않아도 된다.
	public void methodA();
	//abstract을 사용해도 된다.
	public abstract void methodB(int i);
}//interface
