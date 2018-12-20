package day1122;

/**
 * Variable Arguments : �Ű������� �ϳ��ε� �μ��� ������ ���� �� �ִ� ��� <br>
 * method �������� �迭�� ó���ȴ�. <br>
 * ����) "�������� ... �Ķ���͸�" �������� ����
 * 
 * @author owner
 */
public class VariableArguments {

	/**
	 * ���� ������������ �� �μ� ���� ������ ��� �� ��.
	 * 
	 * @param param ���� �μ���
	 */
	public void test(int... param) {
		for (int val : param) {
			System.out.println(val);
		} // end for
		System.out.println("test method called");
	}// test

	/**
	 * ���� �μ��� �ޱ� ���� �Ű������� ���� ������������ �� �� �ִ�.
	 * 
	 * @param i ó�� �Ű����� int
	 * @param d �ι�° �Ű����� double
	 * @param j int...j
	 */
	public void test1(int i, double d, int... j) {
		System.out.println("ó�� �Ű�����: " + i);
		System.out.println("�ι�° �Ű�����: " + d);
		System.out.println("����° �Ű�����: " + j);//�迭�̱� ������ ���������� �ּҸ� ���
		for (int idx = 0; idx < j.length; idx++) {
			System.out.println(j[idx]);
		}//end for //for�� ���ؼ� ���� ���� ���
	}//end test1
	
	//���ڿ��� �Է¹��� �� �ִ� �Ű������� ���
	public void printName(String name) {
		System.out.println(name+"�� �ȳ��ϼ���");
	}//printName end
	

	public static void main(String[] args) {
		VariableArguments va = new VariableArguments();
//		va.test(1, 2, 3, 4);
		va.test();// ���� ���°Ŵ� �����ִ°� �θ� ��
		va.test1(1, 3.14, 10, 20, 30, 40, 50, 60); // ����°�� �迭������ �ּҰ� ����
		
		String name ="��! ���� ����r����r�ܤ�r ���� 16������� �߾���ȱ���";
		va.printName(name);
		String path="c:\temp\u0000 new.txt";
		System.out.println(path);
		
		System.out.println("");
	}

}
