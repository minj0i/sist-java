package day1204;

/**
 * 인터페이스가 method의 매개변수일 때 간단하게 사용하는 방법.<br>
 * 
 * @author owner
 */
public class TestAnony {
	public void useAnonyInter(AnonyInter ai) {
		System.out.println(ai.getMsg()+" "+ai.getName());
		
	}//useAnonyInter
	public static void main(String[] args) {
//		AnonyInter ai = new AnonyInter();//객체화가 안됨. 인터페이스 안에 들어갈 수 있는 것은 상수, abstract method
		//클래스에 들어갈 수 있는 것: 변수 , method
		//인터페이스가 매개변수였을때는
		//1. 인터페이스를 구현한 클래스를 생성 (AnonyImpl)
		//2. 구현클래스로 객체화
		AnonyInter ai = new AnonyImpl(); //is a 관계의 인스턴스화
		//AnonyInter대신 AnonyImpl로 만들어도 괜찮음
		//3.매개변수를 가진 method를 호출하기위해 객체 생성
		TestAnony ta = new TestAnony();
		//4.method를 호출
		ta.useAnonyInter(ai);
		System.out.println("--------anonymous innerclass---------");
		//anonymous inner class를 사용하면 클래스를 따로 만들필요가 없음.
		
		ta.useAnonyInter(new AnonyInter() {
			@Override
			public String getName() {
				return "공선의"+test();
			}//getName

			@Override
			public String getMsg() {
				return "온뇨쇼";
			}//getMsg
			public String test() {
				return "자식 method";
			}
		});
		
	}//main

}//class
