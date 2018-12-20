package day1203;

/**
 * interface를 구현하는 class(자식클래스이고 interface내 모든 
 * 추상 method를 Override하는 클래스
 * 구현 interface가 부모 interface를 가진다면 최종적인 자식클래스에서는
 * 모든 추상method를 구현해야함 
 * 
 * @author owner
 */
//extends 뒤에는 class만 옴
//public class InterfaceImpl extends SuprInterface{
//implements로 해야 함
public class InterfaceImpl implements SuperInterface{

	//클래스계층에서 위에 있는 모두 써줘야 함=> String msg 두 개 
	//최종 자식클래스에서만 구현해주면 됨
	public String msg() {//InterA
		return "내일은 화요일입니다";
	}//msg
	
	public String msgB() {//InterB
		return "오늘은 월요일입니다";
	}//msgB
		
	@Override
	public void methodA() {//SuperInterface
		System.out.println("methodA입니다");
	}//methodA

	@Override
	public void methodB(int i) {//SuperInterface
		System.out.println("methodB입니다");
	}//methodB
	
	public void test() {
		
	}

	public static void main(String[] args) {
		//자식클래스로 객체화 : 모든 method를 호출할 수 있다.
		//ii.msg(),ii.msgB(),ii.methodA(), ii.methodB(), ii.test()
		InterfaceImpl ii=new InterfaceImpl();
		ii.methodB(12);
		
		//is a 관계의 객체화 : 부모를 앞에 두고 객체화 하는 것
		//SuperInterface로 객체화를 하면 Override된 method만 호출
		//부모의 method도 모두 호출 가능
		//si.msg(), si.msgB(), si.methodA(), si.methodB()
		//제일 자식에 있는 si.test()는 쓸 수 없음.
		SuperInterface si = new InterfaceImpl();
		System.out.println(si.msg());
		System.out.println("----");
		
		//InterA로 객체화하면 ia.msg()만 가능
		InterA ia= new InterfaceImpl();
		System.out.println(ia.msg());
		//InterB로 객체화하면 ib.msgB()만 가능
		InterB ib= new InterfaceImpl();
		System.out.println(ib.msgB());
		
		//Object o = new InterfaceImpl 가능
		//Object은 모든 자식을 다 담을 수 있다.
		//interface는 객체화되지 않는다.
//		InterA ia1 = new InterA();
//		SuperInterface si1 = new SuperInterface();
		
		
	}//main


}//class
