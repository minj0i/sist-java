package day1130;

public class SubConstr extends SuperConstr{
	int i;

	public SubConstr() {
		super();
		System.out.println("�ڽ��� �⺻������");
	}// SubConstr
	
	public SubConstr(int i) {
		this();
		System.out.println("�ڽ��� ���ڻ�����"+i);
	}
}
