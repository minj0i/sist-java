package day1206;

import java.util.Random;

/**
 * Random : �پ��� ������ ������� ��ü.
 * @author owner
 */
public class UseRandom {
	public UseRandom() {
	//1.����)
		Random r = new Random();
		//�Ǽ� ����
		double d = r.nextDouble();
		System.out.println(d);
		System.out.println(d*5);
		System.out.println((int)(d*5));
		System.out.println("-----------------------------");
		//���� ����
		int i = r.nextInt();
		System.out.println(i);
		System.out.println(i%5);
		System.out.println(Math.abs(i%5));
		System.out.println("-----------------------------");
		int j= r.nextInt(5);//������ �߻����� �ʴ´�.
		System.out.println(j);
		System.out.println("-----------------------------");
		//�Ҹ� ����
		boolean b = r.nextBoolean();
		System.out.println(b);
	}//UseRandom
	
	public static void main(String[] args) {
		new UseRandom();
	}//main

}//class