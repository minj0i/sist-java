package day0103;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UseLambda {

	public static void main(String[] args) {
//		TestLambda tl=()->new Date().toString();//return생략가능
//		TestLambda tl=()->{return new Date().toString();};//return기술에는 { }가 필요
		//추상abstract method내의 코드가 복잡(여러줄)한 경우에는 { } 반드시 기술
		TestLambda tl=()->{
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			for(int i=0; i<10; i++) {
				System.out.println("i="+i);
			}//end for
			return sdf.format(new Date());
		};
		
		System.out.println(tl.toDay());
		//메소드도 클래스도 리턴도 다 필요가 없어졌다.=>되게 편하다~~
		//추상메소드로 오버라이딩 할필요도 없어졌다~~
	}//main

}//class
