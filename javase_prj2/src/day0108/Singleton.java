package day0108;

/**
 * 실행중인 JVM에서 하나의 객체가 만들어지고, 하나의 객체만 사용되는 Pattern
 * @author owner
 */
public class Singleton {
	//1.1 private영역에서는 직접참조할 수 없기 때문에 static을 붙여줌
	private static Singleton single;
	
	/**
	 * 1. (private으로) class외부에서 객체화를 하지 못하도록 막는다.
	 */
	private Singleton() {
		
	}//Singleton
	

	public static Singleton getInstance() {
		if(single == null) {//객체가 생성되어 있지 않다면 객체를 생성하고
		single = new Singleton();
		}//end if
		//객체가 생성되어 있다면 생성된 객체를 반환
		return single;
	}
	
}//class
