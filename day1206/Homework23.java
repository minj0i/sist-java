package day1206;
//���� :

import java.util.ArrayList;
import java.util.Random;

//1. �Ʒ��� �����͸� ó���ϴ� ���α׷��� �ۼ��ϼ���.
//
//  ������,�̺���,������,���ü�,������,������ �� �����Ͱ� �����ϰ�, //String�迭
// ������ 0~100�� ���̷� �߻��Ҽ��ֽ��ϴ�. //����:random String.valueOf(Math.random() * 100) + 1
//
// ���α׷��� ����Ǹ� ���� ����߿� 2���̻� ����ó�� ����� �̰� 
// n���� �̸��� ������ �����Ͽ� ����ϴ� ���� �ϴ� ���α׷� �ۼ�.
// �ߺ��̸��� �� �� ����. 
//
//��� �� )
// ������ 89
// ���ü� 77
// ������ 90
//  ����   xx��

public class Homework23 {
	public Homework23() {
		
	}// Homework23

	public void print() {
		ArrayList<String> ll = new ArrayList<String>();
		// �� �߰�: ������� �߰��ȴ�.
		ll.add("������");
		ll.add("�̺���");
		ll.add("������");
		ll.add("���ü�");
		ll.add("������"); 
		ll.add("������");
		ll.add("������"); // �ߺ����� ������ �� ����
		ll.add("������"); // �ߺ����� ������ �� ����
		
		// ���� �������� ����
		for (int i = 0; i < ll.size(); i++) {
			for (int j = 0; j < i; j++) {
				if (ll.get(i) == ll.get(j)) {
					ll.remove(i);
				} // end if
			} // end for j
		} // end for i
		System.out.print("�̸�: ");
		System.out.println(ll);
		
		//�����Է�
		ArrayList<Integer> score = new ArrayList<Integer>();
		System.out.print("����: ");
		// �� �߰�: ������� �߰��ȴ�.
		for (int i = 0; i < ll.size(); i++) {
			score.add((int)(Math.random() * 101));
		}//end for
		for (int i = 0; i < ll.size(); i++) {
		System.out.print(score.get(i)+" ");
		}//end for
		System.out.println();
		
		//2�� �̻� �������� ���
		Random r = new Random();
		int choose = r.nextInt(ll.size()-2)+2; //2�� �̻� 
		int choosePeople=0;
		int sum=0;
		
		//�̸��� ���� ���
		System.out.println("-----------�������� 2�� �̻��� �̽��ϴ�--------");
		System.out.println("�̸� / ����");
		for(int i=0; i<choose; i++) {
			choosePeople = r.nextInt(ll.size());
			System.out.println(ll.get(choosePeople) + "/ " + score.get(choosePeople));
			sum = score.get(choosePeople)+sum;
			ll.remove(choosePeople);
			score.remove(choosePeople);
		}
		System.out.println("����  /" + sum);
	}// name
		
		
	public static void main(String[] args) {
		Homework23 hw23 = new Homework23();
		hw23.print();
	}// main
}// class
