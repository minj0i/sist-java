package day0108;

public class UseSingleton {

	public static void main(String[] args) {
		//Singleton Pattern으로 만들어진 객체 사용.
		
//		Singleton s = new Singleton();//생성자가 private이므로 클래스 외부에서 객체화를 할 수 없음
		
		Singleton s = Singleton.getInstance();
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		Singleton s3 = Singleton.getInstance();
		
		//singleton으로 가장했지만 객체가 다 다르게 나옴 = 이것은 singleton이 아닙니다.
		//해결 : Singleton 클래스에서 
		//public static Singleton getInstance() {에  if(single == null) {}을 추가해줌
		System.out.println(s);
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		
		
		
	}//main
}//class
