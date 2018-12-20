package day1126;

/**
 * 클래스가 객체로 생성될 때 기본적으로 가지고 있어야 할 기본값을
 * 설정하거나, 기본적으로 수행될 코드를 정의하는 method의 일종.
 * @author owner
 */
public class TestConstructor {

	/**
	 * 기본 생성자: 클래스를 작성 할 때 생성자를 하나도 정의하지 않으면
	 * 컴파일러가 매개변수 없는 Default Constructor를 생성한다.  
	 */
	public TestConstructor() {
		System.out.println("기본 생성자");
//		TestConstructor(300);//생성자를 method 호출하듯 부를 수 없다.
	}//TestConstructor
	
	//Overload 조건: 접근지정자 같고, 반환형 없는거로 같고, 메소드 없는 것 같고, 호출 시 구분되도록 달라야 함
	/**
	 * 인자있는 생성자: 생성자의 Overload
	 * @param i 임의의 값
	 */
	public TestConstructor(int i) {
		System.out.println("인자있는 생성자"+i);
	}//TestConstructor
	
	public void test() {
		System.out.println("test method!!!");
		temp();//method 호출
	}//test
	//콘크리트 메소드, 고정적인 일을 하는 메소드
	public void temp() {
		System.out.println("-------------temp method!!!");
	}//temp
	
	public static void main(String[] args) {
		//Overloading된 생성자를 사용하여 객체화를 다양하게 할 수 있음.
		TestConstructor tc = new TestConstructor();//기본생성자
		TestConstructor tc1 = new TestConstructor(26);//인자있는 생성자	
		
		System.out.println(tc);
		System.out.println(tc1);
		
		tc.test();
	}//main

}//class
