package day1129;

/**
 * ��Ӱ����� �θ�Ŭ����: ��� �ڽ��� ������ �� ���� Ư¡ ����
 * �θ𿡰� ���ǵ� �ڵ�� �ڽĿ��� ����� �� �ִ�.
 * @author owner
 */
public class TestSuper {
	public int pub_i;//��� �ִ� �ڽ��̵� �ڽĿ��� ��밡��.
	protected int pro_i;//���� ��Ű���� �ڽ�, �ٸ���Ű���� �ڽĿ��� ��� ����
	private int pri_i;//�θ�Ŭ���� �ȿ����� ��� ����
	int def_i;//���� ��Ű���� �ڽĿ��� ��밡��, ��Ű���� �ٸ��� ���Ұ�.
	
	public TestSuper() {
		System.out.println("�θ�Ŭ������ �⺻������");
	}//TestSuper
	
	public void superMetohd() {
		System.out.println("�θ�Ŭ������ method");
	}
	
}//class
