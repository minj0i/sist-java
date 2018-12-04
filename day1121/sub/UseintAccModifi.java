package day1121.sub;

import day1121.InstAccModifi;

/**
 * 같은 패키지에 존재하는 다른 클래스의 인스턴스변수 사용<br>
 * 접근지정자가 public인 것만 사용 가능.<br>
 * @author owner
 */
public class UseintAccModifi {

	public static void main(String[] args) {
		InstAccModifi ivam=new InstAccModifi();
		System.out.println("public: "+ivam.pub_i);
//		System.out.println("protected: "+ivam.pro_i); //사용불가
//		System.out.println("private: "+ivam.pri_i); //사용불가
//		System.out.println("default: "+ivam.def_i); //사용불가
		
	}

}
