package day1121;

/**
 * static(clasS)����: Ŭ������ ����Ǹ� ���� ó�� �޸�(method)�� <br>
 * �ö󰡰�, ��� ��ü�� �ϳ��� ������ �����Ͽ� ����� ���� <br>
 * 
 * @author owner
 */
public class UseStaticVariable {
	static int i; //static ���� -> �ٷ� ���
	int j;//instance���� -> ��üȭ�Ͽ� ���.
	
	public void test() {
		i=100;
		j=200;
		System.out.println(i+" / "+j);
	}//test
	
	public static void main(String[] args) {
		//class ���� ���. Ŭ������.������
		UseStaticVariable.i=2000;
		System.out.println(UseStaticVariable.i);
		
		UseStaticVariable usv = new UseStaticVariable();
		UseStaticVariable usv1 = new UseStaticVariable();
		usv.j=5000;//instance������ ������ ��ü�� ���� ����Ѵ�.
		usv1.j=10000;
		UseStaticVariable.i=20;
//		usv.i=20; //usv1.i�� �ٲ����ʾƵ� �ڵ����� ���� �ٲ� //��ü������ ����ϸ� Ư�� ��ü�� ����(member ����)
		//�� �ƴϹǷ� 
		System.out.println("usv��ü �ν��Ͻ�����: "+usv.j+", ����ƽ����: "+UseStaticVariable.i);
		System.out.println("usv1��ü �ν��Ͻ�����: "+usv1.j+", ����ƽ����: "+UseStaticVariable.i);
		
//		j=200;//instance������ �Ƚ���
//		System.out.println(i+" / "+j);
		
	}//main

}//class
