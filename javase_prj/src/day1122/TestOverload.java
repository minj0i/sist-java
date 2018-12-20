package day1122;

/**
 * ������: method Overload <br>
 * �ϳ��� Ŭ�������� ���� �̸��� method�� ������ �ۼ��ϴ� ��.<br>
 * ��Ģ) ���������� ��ȯ�� method���� ���� �����, ��ȯ���� �ٸ��� �ۼ�.
 * 
 * @author owner
 */
public class TestOverload {

	/**
	 * ���� �ϳ� ����ϴ� ��
	 */
	public void printStar() {
		System.out.println("��");
	}// printStar

	/**
	 * �ԷµǴ� ���� ���� ���� ������ ����ϴ� ��
	 * 
	 * @param count ����� ���� ����
	 */
	public void printStar(int count) {
		for (int i = 0; i < count; i++) {
			System.out.print("��");
		} // end for
	}// printStar

	public void gugudan() {
		int i = 3, j = 0;
		for (j = 1; j < 10; j++) {
			System.out.print(i + "*" + j + "=" + (i * j) + " ");
		} // end for
	}// end gugudan

	public void gugudan(int dan) {
		if (dan >= 2 && dan <= 9) {
			do {
				for (int j = 1; j < 10; j++) {
					System.out.print(dan + "*" + j + "=" + (dan * j) + " ");
				} // end for
				System.out.println(" ");
				dan++;
			} while (dan < 10);
		} // end if
	}// end gugudan(int dan)

	public static void main(String[] args) {
		TestOverload to = new TestOverload();
		// �� �Ѱ� ���
		to.printStar();
		// �� ������ ���
		to.printStar(5);

		System.out.println("------------3��-------------");
		// ������ 3���� ����ϴ� method
		to.gugudan();
		System.out.println();
		System.out.println("------------�Է��ϴ� �ܺ��� 9�ܱ���------------");
		// �Է��ϴ� ���� 2~9�� �����϶� �ش� �ܺ��� 9�ܱ����� ����ϴ� method
		to.gugudan(4);
	}// main

}// class
