package day1218;

import java.util.Random;

/**
 * ���ܸ� ������ �߻�
 * 
 * @author owner
 */
public class TestThrow {

	/**
	 * ���� ���ٰ� ��踦 �ǿ�� �л��� ���� ���ǻ�ȸ�� �����Ѵ�.
	 */
	public void taeksung() throws Exception {
		String[] grade = { "�ʵ��л�", "���л�", "����л�", "���л�" };
		String randomGd = grade[new Random().nextInt(grade.length)];

		if (randomGd.equals("�ʵ��л�")) {
//			try {
			throw new Exception(randomGd + "��Ե� �ݿ��ؾ��ϴ� �κ�������?");
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
		} else {
			System.out.println(randomGd + "�� ��踦 �ǿ�� ��ô ��������. (\" )( \")");

		} // end else

	}// taeksung

	public void taeksung2() {
		String[] grade = { "�ʵ��л�", "���л�", "����л�", "���л�" };
		String randomGd = grade[new Random().nextInt(grade.length)];

		if (randomGd.equals("�ʵ��л�")) {
			throw new TobaccoException();
		} else {
			System.out.println(randomGd + "�� ��踦 �ǿ�� ��ô ��������. (\" )( \")");

		} // end else

	}// taeksung

	public static void main(String[] args) {
		TestThrow tt = new TestThrow();
		try {
			tt.taeksung();
		} catch (Exception e) {
			e.printStackTrace();
		} // end catch
		System.out.println("--------------------------------------");
			tt.taeksung2();
			//RuntimeException�� try~catch�����൵ �ǰ� throw�� �ȳ����൵ ��

	}// main

}// class
