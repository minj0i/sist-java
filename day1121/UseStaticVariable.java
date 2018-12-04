package day1121;

/**
 * static(clasS)변수: 클래스가 실행되면 가장 처음 메모리(method)에 <br>
 * 올라가고, 모든 객체가 하나의 변수를 참조하여 사용한 변수 <br>
 * 
 * @author owner
 */
public class UseStaticVariable {
	static int i; //static 변수 -> 바로 사용
	int j;//instance변수 -> 객체화하여 사용.
	
	public void test() {
		i=100;
		j=200;
		System.out.println(i+" / "+j);
	}//test
	
	public static void main(String[] args) {
		//class 변수 사용. 클래스명.변수명
		UseStaticVariable.i=2000;
		System.out.println(UseStaticVariable.i);
		
		UseStaticVariable usv = new UseStaticVariable();
		UseStaticVariable usv1 = new UseStaticVariable();
		usv.j=5000;//instance변수는 생성된 객체가 각각 사용한다.
		usv1.j=10000;
		UseStaticVariable.i=20;
//		usv.i=20; //usv1.i는 바꾸지않아도 자동으로 같이 바뀜 //객체명으로 사용하면 특정 객체에 속한(member 변수)
		//가 아니므로 
		System.out.println("usv객체 인스턴스변수: "+usv.j+", 스태틱변수: "+UseStaticVariable.i);
		System.out.println("usv1객체 인스턴스변수: "+usv1.j+", 스태틱변수: "+UseStaticVariable.i);
		
//		j=200;//instance변수는 안써짐
//		System.out.println(i+" / "+j);
		
	}//main

}//class
