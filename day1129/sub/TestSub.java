package day1129.sub;

import day1129.TestSuper;

/**
 * TestSuper�� �ڽ�Ŭ����
 * @author owner
 */
public class TestSub extends TestSuper {
	int i;
	public TestSub() {
		System.out.println("�ڽ��� ������");
	}//TestSub
	public void subMethod() {
		System.out.println("�ڽ� Method");
	}//subMethod
	
	public static void main(String[] args) {
		//��üȭ�� �ڽ�Ŭ������ ����
		TestSub ts=new TestSub();
		//�ڽİ� �θ� �ٸ� ��Ű�� �����ϸ� �θ� ����
		//������ method�� ���������ڰ� public, protected��
		//�ڿ��� ����� �� �ִ�. (ĸ��ȭ - encapsulation)
		ts.pub_i=10; //public
		ts.pro_i=20;//protected
//		ts.def_i=30; //default
		ts.i=100;
		
		System.out.println("�θ��� �ڿ� "+ts.pub_i+"/"+ts.pro_i/*+"/"+ts.def_i*/);
		ts.superMetohd();
		System.out.println("�ڽ��� �ڿ�"+ts.i);
		
		
	}//main

}//class
