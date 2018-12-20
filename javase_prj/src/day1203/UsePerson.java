package day1203;

import java.util.Arrays;
import java.util.Date;

import day1129.Minjeong;

public class UsePerson {

	public static void main(String[] args) {
		HongGilDong gd=new HongGilDong();
		gd.setName("홍길동");//부모의 method 사용
		System.out.println("눈: "+gd.getEye()+", 코 : "+gd.getNose()+", 입: "+gd.getMouth());
		System.out.println(gd.eat());
		System.out.println(gd.eat("국밥", 1));
		//자신만의 특징
		System.out.println(gd.fight(6));//7>8
		System.out.println(gd.fight(7));//8>9
		System.out.println(gd.fight(9));//비김
		System.out.println(gd.fight(10));//진다9>8
		System.out.println(gd.fight(9));//진다. 8>7
		
		System.out.println("-----------------------------");
		Clark superman = new Clark();//자식이 생성되면 부모클래스가 먼저
		//생성된 후 자식이 생성된다.
		//자식의 객체로 부모클래스의 자원(변수, method)를 자식의 것처럼
		//사용할 수 있다. - 코드의 재사용성
		superman.setName("클락");
		System.out.println("눈: "+superman.getEye()+", 코 : "+superman.getNose()+
				", 입: "+superman.getMouth()+", 이름: "+superman.getName());
	
		System.out.println(superman.eat());
		System.out.println(superman.eat("스테이크", 10));
	
		//자식(자신)의 자원(변수, method)
		String stone="짱돌";
		System.out.println(stone+"을 맞은 결과: "+superman.power(stone)+", 힘의 변화: "+superman.power);
		stone="클립토나이트";
		System.out.println(stone+"을 맞은 결과: "+superman.power(stone)+", 힘의 변화: "+superman.power);
		stone="다이아몬드";
		System.out.println(stone+"을 맞은 결과: "+superman.power(stone)+", 힘의 변화: "+superman.power);
		
//		System.out.println(gd.toString());
//		Minjeong mj=new Minjeong();
//		System.out.println(mj.toString());
//		String s= new String("오늘은 금요일입니다");
//		System.out.println(s.toString());//Overriding
//		
//		Date d = new Date();
//		System.out.println(d.getYear());
//		
//		@SuppressWarnings("unused")
//		int i;
		
		System.out.println("------------------------------------");
		String[] clackLang=superman.language("외계어");
		clackLang=superman.language("영어");
		clackLang=superman.language("한국어");
		clackLang=superman.language("영어");
		clackLang=superman.language("한국어");
		clackLang=superman.language("스페인어");
		System.out.println(Arrays.toString(clackLang));
		
		String[] hongLang=gd.language("한국어");
		hongLang=gd.language("중국어");
		hongLang=gd.language("수화");
		System.out.println(Arrays.toString(hongLang));
		System.out.println("-----------------------");
		//Clark은 interface를 구현하였으므로 비행가능
		System.out.println(superman.speed("빠르"));
		System.out.println(superman.height("높"));
		
	}//main

}//class
