package day1205;

import java.util.StringTokenizer;

/**
 * 
 * @author owner
 */
public class UseStringTokenizer {

	public UseStringTokenizer() {
		String msg = "������ ������ �Դϴ�. ������ -5�Դϴ�.";

		// �������� ���� : �Ű����� �ϳ��� �����ڸ� ���
		StringTokenizer stk = new StringTokenizer(msg);

		System.out.println(stk.countTokens() + "��");
		while (stk.hasMoreTokens()) {// ��ū�� �����ϴ���?
			// ��ū�� ��� �����͸� �������� �̵�
			System.out.println(stk.nextToken());
		} // end while

		String names = "������,������~���ü�,����ö.������~������,������";

		// Ư�����ڷ� ��ū ����
		StringTokenizer stk1 = new StringTokenizer(names, "��");
		System.out.println("--------------------------");
		System.out.println("��ū�� �� : " + stk1.countTokens());

		while (stk1.hasMoreTokens()) {
			System.out.println(stk1.nextToken());
		}
		System.out.println("--------------------------");
		StringTokenizer stk2 = new StringTokenizer(names, ",~ ");
		System.out.println("��ū�� �� : " + stk2.countTokens());

		while (stk2.hasMoreTokens()) {
			System.out.println(stk2.nextToken());
		}
		System.out.println("--------------------------");
		StringTokenizer stk3 = new StringTokenizer(names, "~");
		System.out.println("��ū�� �� : " + stk3.countTokens());

		while (stk3.hasMoreTokens()) {
			System.out.println(stk3.nextToken());
		}
		
		//Ư�����ڷ� ��ū ����, ���е� ���ڿ��� ��ū���� ó��:
		//�Ű����� ������ ������
		StringTokenizer stk4 = new StringTokenizer(names, ",. ", false);
		System.out.println("----------------------");
		while (stk4.hasMoreTokens()) {
			System.out.println(stk4.nextToken());
		}
		
	}// UseStringTokenizer

	public static void main(String[] args) {
		new UseStringTokenizer();
	}// main

}// class
