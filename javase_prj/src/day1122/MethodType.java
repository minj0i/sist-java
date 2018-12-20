package day1122;

/**
 * method�� 4���� ����
 * 
 * @author owner
 */
public class MethodType {

	/**
	 * ��ȯ�� ���� �Ű����� ���� ��- ���� ���� ����
	 */
	public void typeA() {
		System.out.println("�ȳ��ϼ���");
	}// typeA

	/**
	 * ��ȯ�� ���� �Ű����� �ִ� ��-���� ��
	 * 
	 * @param i ����ϰ� ���� ��
	 */
	public void typeB(int i) {
		System.out.println(i + "�� �ȳ�");
	}// typeB

	/**
	 * ��ȯ�� �ְ�, �Ű����� ���� �� - ���� ��<br>
	 * ���� �޾� ����ϴ� �ڵ尡 �ʿ�.
	 * 
	 * @return ��.���� �Ǽ������� ��ȯ
	 */
	public double typeC() {
//		int i=11;
		return 2018.11;
		// float type���� �Ϸ��� ���� ����ȯ�ϰų� �����
//		System.out.println("|||");//return���� �Ʒ��� �ڵ尡 ���� �� �� ����
	}// typeC

	/**
	 * ��ȯ���ְ�, �Ű����� �ִ� �� - ���� ��
	 * 
	 * @param d ������ ����� ���� �Ǽ���
	 * @return ������ ��ȯ�� ��
	 */
	public int typeD(double d) {
		int i = (int) d;
		return i;
	}// type D

	public static void main(String[] args) {
		MethodType mt = new MethodType();
		// 1. ���� �� method ȣ��
		mt.typeA();
		// int j = mt.typeA();���� �ϸ� ����. �������� ���� �����Ƿ�
		// 2. ���� �� method ȣ��
		mt.typeB(22);
		mt.typeB(21);
		mt.typeB(202);
		// 3. ���� �� method ȣ�� - ��ȯ���� ��ġ�ϴ� ������ ���� ���� �����ؾ� ��
		double i = mt.typeC() + 1;
		System.out.println("������ " + i);
		// 4. ���� �� method ȣ�� - ��ȯ���� ��ġ�ϴ� ������ ���� ���� �����ؾ� ��
		int j = mt.typeD(300.003);
		System.out.println("������ " + j);
	}// main

}// class
