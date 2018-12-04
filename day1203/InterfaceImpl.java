package day1203;

/**
 * interface�� �����ϴ� class(�ڽ�Ŭ�����̰� interface�� ��� 
 * �߻� method�� Override�ϴ� Ŭ����
 * ���� interface�� �θ� interface�� �����ٸ� �������� �ڽ�Ŭ����������
 * ��� �߻�method�� �����ؾ��� 
 * 
 * @author owner
 */
//extends �ڿ��� class�� ��
//public class InterfaceImpl extends SuprInterface{
//implements�� �ؾ� ��
public class InterfaceImpl implements SuperInterface{

	//Ŭ������������ ���� �ִ� ��� ����� ��=> String msg �� �� 
	//���� �ڽ�Ŭ���������� �������ָ� ��
	public String msg() {//InterA
		return "������ ȭ�����Դϴ�";
	}//msg
	
	public String msgB() {//InterB
		return "������ �������Դϴ�";
	}//msgB
		
	@Override
	public void methodA() {//SuperInterface
		System.out.println("methodA�Դϴ�");
	}//methodA

	@Override
	public void methodB(int i) {//SuperInterface
		System.out.println("methodB�Դϴ�");
	}//methodB
	
	public void test() {
		
	}

	public static void main(String[] args) {
		//�ڽ�Ŭ������ ��üȭ : ��� method�� ȣ���� �� �ִ�.
		//ii.msg(),ii.msgB(),ii.methodA(), ii.methodB(), ii.test()
		InterfaceImpl ii=new InterfaceImpl();
		ii.methodB(12);
		
		//is a ������ ��üȭ : �θ� �տ� �ΰ� ��üȭ �ϴ� ��
		//SuperInterface�� ��üȭ�� �ϸ� Override�� method�� ȣ��
		//�θ��� method�� ��� ȣ�� ����
		//si.msg(), si.msgB(), si.methodA(), si.methodB()
		//���� �ڽĿ� �ִ� si.test()�� �� �� ����.
		SuperInterface si = new InterfaceImpl();
		System.out.println(si.msg());
		System.out.println("----");
		
		//InterA�� ��üȭ�ϸ� ia.msg()�� ����
		InterA ia= new InterfaceImpl();
		System.out.println(ia.msg());
		//InterB�� ��üȭ�ϸ� ib.msgB()�� ����
		InterB ib= new InterfaceImpl();
		System.out.println(ib.msgB());
		
		//Object o = new InterfaceImpl ����
		//Object�� ��� �ڽ��� �� ���� �� �ִ�.
		//interface�� ��üȭ���� �ʴ´�.
//		InterA ia1 = new InterA();
//		SuperInterface si1 = new SuperInterface();
		
		
	}//main


}//class
