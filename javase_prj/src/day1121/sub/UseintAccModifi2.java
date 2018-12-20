package day1121.sub;

import day1121.InstAccModifi;

/**
 * 같은 패키지에 존재하는 다른 클래스의 인스턴스변수 사용<br>
 * 상속관계에 있다면 자식클래스로 생성하여 부모 클래스가 가진 <br>
 * 인스턴스 변수의 접근지정자가 public, protected 인 것만 사용 가능.<br>
 * @author owner
 */
public class UseintAccModifi2 extends InstAccModifi{

	public static void main(String[] args) {
		UseintAccModifi2 ivam=new UseintAccModifi2();
		System.out.println("public: "+ivam.pub_i);
		System.out.println("protected: "+ivam.pro_i); 
//		System.out.println("private: "+ivam.pri_i); //사용불가 
//		System.out.println("default: "+ivam.def_i); //사용불가
		
	}

}
