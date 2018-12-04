package day1203;

public class UseDefaultMethod implements UseDefault {

	@Override
	public void test() {
		System.out.println("Override method");
	}//test

	public static void main(String[] args) {
		//자식 클래스로 객체화
		UseDefaultMethod udm = new UseDefaultMethod();
		udm.test();
		udm.temp();//default method
		
		//is a 관계의 객체화
		UseDefault ud = new UseDefaultMethod();
		ud.test();//Override한 method가 호출
		ud.temp();
	}//main

}//class
