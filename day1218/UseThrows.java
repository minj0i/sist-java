package day1218;

import java.util.Random;

/**
 * method내에서 발생한 예외를 method를 호출한 곳에서 처리하는 throws의 사용.
 * @author owner
 */
public class UseThrows {
	
	public void test() throws ClassNotFoundException{
		//throws로 예외를 날리면 method 안에서 try~catch할 필요가 없다.
		String className = "day1217.UseRuntimeException";
		
		if(new Random().nextBoolean()) {
			className="java.long.Integer";
		}//end if
		
		Object obj = Class.forName(className);
		System.out.println("클래스가 로딩되었습니다."+obj);
	}//test

	public static void main(String[] args) {
		UseThrows ut = new UseThrows();
		try {
			ut.test();//method를 호출하여 일 수행하다 보면 문제가 발생할 수도 있다.
		} catch (ClassNotFoundException cnfe) {
			System.err.println("죄송합니다.");
			cnfe.printStackTrace();
			System.out.println("정상출력");
		}
	}//main

}//class
