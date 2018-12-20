package day1130;

public class SubConstr extends SuperConstr{
	int i;

	public SubConstr() {
		super();
		System.out.println("자식의 기본생성자");
	}// SubConstr
	
	public SubConstr(int i) {
		this();
		System.out.println("자식의 인자생성자"+i);
	}
}
