package day1126;

/**
 * this를 사용한 생성자 호출
 * @author owner
 */
public class ThisConstructor {
	public ThisConstructor() {
//		this(26);
		System.out.println("기본 생성자");
	}//ThisConstructor
	
	public ThisConstructor(int i) {
		this();
		System.out.println("인자있는 생성자");
//		this(); //생성자의 첫번째 줄에서만 사용 가능
	}//ThisConstructor
	public static void main(String[] args) {
		new ThisConstructor(22);
	}//main

}//class
