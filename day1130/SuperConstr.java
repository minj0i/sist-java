package day1130;

public class SuperConstr {
	int i;
	
	public SuperConstr() {
		this(100);
		System.out.println("부모의 기본생성자");
	}//SuperConstr
	
	public SuperConstr(int i) {
		System.out.println("부모의 인자생성자"+i);
	}//SuperConstr
}//class
