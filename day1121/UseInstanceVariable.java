package day1121;

/**
 * Instance(member) 변수 <br>
 * 	객체가 생성될때 메모리(heap)에 할당 되고, 그 주소를 저장한
 *	변수(객체, instance, object)를	사용하여 접근하는 변수. <br>
 *	자동초기화가 된다.
 *	
 * @author owner
 */
public class UseInstanceVariable {

	int i;//정수형 초기화값 0
	int j;
	double d;//실수형 초기화값 0.0
	char c;//문자형 초기화값 \u0000
	boolean b;//불린형 초기화값 false
	String str;//참조형 초기화값 null
	UseInstanceVariable jaehyun;//참조형 초기화값 null
	
	public static void main(String[] args) {
		//static 영역은 가장 먼저 메모리(method)에 로드되므로, 생성될지도 모르는
		//instance 변수를 직접 사용할 수 없다.
		//i=300;
		
		//객체화를 하면 객체가 메모리(heap)생성되고, 그 주소를 메모리(stack)저장
		//객체화 문법: 클래스명 객체명=new 클래스명();
		//왼쪽은 stack에 생성, 오른쪽은 heap에 생성
		UseInstanceVariable uiv = new UseInstanceVariable();
		UseInstanceVariable uiv1 = new UseInstanceVariable();
		System.out.println("객체출력(heap)"+uiv);
		System.out.println("객체출력(heap)"+uiv1);
		
		//heap에 생성된 instance variable을 사용.
		uiv.i=11;
		uiv.j=21;
		
		System.out.println("uiv객체의 멤버변수 i="+uiv.i);
		System.out.println("uiv객체의 instance변수 j="+uiv.j);
		
		//instance/member 변수는 자동초기화 됨
		System.out.println("uiv1객체 i:"+uiv1.i+" uiv객체 j:"+uiv1.j);
		System.out.println("----------자동 초기화 값--------------");
		System.out.println("정수형:"+uiv1.i);
		System.out.println("실수형:"+uiv1.d);
		System.out.println("문자형:"+uiv1.c);
		System.out.println("불린형:"+uiv1.b);
		System.out.println("참조형:"+uiv1.str);
		System.out.println("참조형:"+uiv1.jaehyun);

	}//main

}//class
