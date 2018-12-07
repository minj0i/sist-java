package day1206;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * List:<br>
 * �ߺ����� ����ϸ�, �˻��� ����� �ְ� ������� ���� �Է��ϴ� ����������.
 * 
 * @author owner
 */
public class UseList {

	public UseList() {
		// JDK1.4������ Generic�� �������� �ʰ� ��ü�� ����ȴ�.
//		List list = new ArrayList();
//		//�� �߰�: JDK 1.5���Ͽ����� ��ü�θ� ���� ���� �� �ִ�.
//		list.add(new Integer(10));
//		list.add(new Short((short)10));
//		list.add("������");
//		
//		System.out.println(list.size());
//		//�� ���
////		System.out.println(list.get(0)+10);//��ü�� ������ ���� ����
//		+10�� ���ֱ� ���ؼ� Integer������ ��ȯ��Ű�� int�� �޾� ����
//		System.out.println(((Integer)list.get(0)).intValue()+10);

		// JDK1.5+ ���� ���: Generic, auto boxing, unboxing
		// Generic�� ����.
		List<Integer> list = new ArrayList<Integer>();
		list.add(10); // autoboxing => list.add(new Integer(10));
		list.add(20);
		list.add(new Integer(30));
//		list.add("�����"); //Generic���� ������ ���� �ƴ� ���������� �߰��� �� ����

		System.out.println("ũ��" + list.size());
		System.out.println((Integer) list.get(0) + 10);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		} // end for

	}// UseList

	/**
	 * ArrayList ���: MultiThreadȯ�濡�� ���� ���� ����.(����ȭX)
	 */
	public void UseArrayList() {
		// 1.����
		ArrayList<String> al = new ArrayList<String>();// �� 0��
		List<String> al1 = new ArrayList<String>(100);// �� 100��

		System.out.println(al + "/" + al1); // toString�� Overriding�ؼ� �ּҰ� �ƴ� []�� ����
		// �� �߰�: ������� �߰��ȴ�.
		al.add("������");
		al.add("���ü�");
		al.add("������");
		al.add("�����");
		al.add("������"); // �ߺ����� ������ �� ����
		al.add("������");
		al.add("������"); // �ߺ����� ������ �� ����
		al.add("������");
		System.out.println(al + "/" + al1);
		// size(): �������� ũ��: ũ��� ������� ���� ����ִ� ������ŭ ����
		System.out.println("a1 ũ��: " + al.size() + "/ al1�� ũ��: " + al1.size());

		// �迭�� ����
		String[] names = new String[al.size()];
		al.toArray(names);

		// ���� �� ����
		// �ε����� ���� : Ư�� �ε������� ���� ����
		al.remove(4);
		System.out.println(al.size() + "/" + al);
		// ���� �������� ����
		al.remove("������"); // L->R���� �����ϸ鼭 ��ġ�ϴ� ù���� ���� ����(����/��λ��� �ƴ�)
		System.out.println(al.size() + "/" + al);

		for (String name : al) { // ������ for�� ���� �迭�� ������ ��
			System.out.print(name + " ");
		}
		System.out.println();

		// ��� ���� �� ����:
		al.clear();
		System.out.println("���� �� " + al.size() + "/" + al);

		// �迭�� ��
		for (int i = 0; i < names.length; i++) {
			System.out.printf("%s\t", names[i]);
		} // end for
		System.out.println();
	}// UseArrayList

	public void useVector() {
		// 1.����
		Vector<String> vec = new Vector<String>();// �� 0��
		List<String> vec1 = new Vector<String>(100);// �� 100��

		System.out.println(vec + "/" + vec1); // toString�� Overriding�ؼ� �ּҰ� �ƴ� []�� ����
		// �� �߰�: ������� �߰��ȴ�.
		vec.add("������");
		vec.add("���ü�");
		vec.add("������");
		vec.add("�����");
		vec.add("������"); // �ߺ����� ������ �� ����
		vec.add("������");
		vec.add("������"); // �ߺ����� ������ �� ����
		vec.add("������");
		System.out.println(vec + "/" + vec1);
		// size(): �������� ũ��: ũ��� ������� ���� ����ִ� ������ŭ ����
		System.out.println("vec ũ��: " + vec.size() + "/ vec1�� ũ��: " + vec1.size());

		// �迭�� ����
		String[] names = new String[vec.size()];
		vec.toArray(names);

		// ���� �� ����
		// �ε����� ���� : Ư�� �ε������� ���� ����
		vec.remove(4);
		System.out.println(vec.size() + "/" + vec);
		// ���� �������� ����
		vec.remove("������"); // L->R���� �����ϸ鼭 ��ġ�ϴ� ù���� ���� ����(����/��λ��� �ƴ�)
		System.out.println(vec.size() + "/" + vec);

		for (String name : vec) { // ������ for�� ���� �迭�� ������ ��
			System.out.print(name + " ");
		}
		System.out.println();

		// ��� ���� �� ����:
		vec.clear();
		System.out.println("���� �� " + vec.size() + "/" + vec);

		// �迭�� ��
		for (int i = 0; i < names.length; i++) {
			System.out.printf("%s\t", names[i]);
		} // end for
		System.out.println();

	}// UseVector

	public void UseLinkedList() {
		// 1.����
		LinkedList<String> ll = new LinkedList<String>();// �� 0��
		List<String> ll1 = new LinkedList<String>();

		System.out.println(ll + "/" + ll1); // toString�� Overriding�ؼ� �ּҰ� �ƴ� []�� ����
		// �� �߰�: ������� �߰��ȴ�.
		ll.add("������");
		ll.add("���ü�");
		ll.add("������");
		ll.add("�����");
		ll.add("������"); // �ߺ����� ������ �� ����
		ll.add("������");
		ll.add("������"); // �ߺ����� ������ �� ����
		ll.add("������");
		System.out.println(ll + "/" + ll1);
		// size(): �������� ũ��: ũ��� ������� ���� ����ִ� ������ŭ ����
		System.out.println("ll ũ��: " + ll.size() + "/ ll1�� ũ��: " + ll1.size());

		// �迭�� ����
		String[] names = new String[ll.size()];
		ll.toArray(names);

		// ���� �� ����
		// �ε����� ���� : Ư�� �ε������� ���� ����
		ll.remove(4);
		System.out.println(ll.size() + "/" + ll);
		// ���� �������� ����
		ll.remove("������"); // L->R���� �����ϸ鼭 ��ġ�ϴ� ù���� ���� ����(����/��λ��� �ƴ�)
		System.out.println(ll.size() + "/" + ll);

		for (String name : ll) { // ������ for�� ���� �迭�� ������ ��
			System.out.print(name + " ");
		}
		System.out.println();

		// ��� ���� �� ����:
		ll.clear();
		System.out.println("���� �� " + ll.size() + "/" + ll);

		// �迭�� ��
		for (int i = 0; i < names.length; i++) {
			System.out.printf("%s\t", names[i]);
		} // end for
		System.out.println();
	}// UseLinkedList

	public static void main(String[] args) {
		UseList ul = new UseList();
		System.out.println("----------------ArrayList------------------");
		ul.UseArrayList();
		System.out.println("----------------UseVector------------------");
		ul.useVector();
		System.out.println("----------------UseLinkedList------------------");
		ul.UseLinkedList();
	}// main

}// class
