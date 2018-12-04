package day1121;

/**
 * Instance(member) ���� <br>
 * 	��ü�� �����ɶ� �޸�(heap)�� �Ҵ� �ǰ�, �� �ּҸ� ������
 *	����(��ü, instance, object)��	����Ͽ� �����ϴ� ����. <br>
 *	�ڵ��ʱ�ȭ�� �ȴ�.
 *	
 * @author owner
 */
public class UseInstanceVariable {

	int i;//������ �ʱ�ȭ�� 0
	int j;
	double d;//�Ǽ��� �ʱ�ȭ�� 0.0
	char c;//������ �ʱ�ȭ�� \u0000
	boolean b;//�Ҹ��� �ʱ�ȭ�� false
	String str;//������ �ʱ�ȭ�� null
	UseInstanceVariable jaehyun;//������ �ʱ�ȭ�� null
	
	public static void main(String[] args) {
		//static ������ ���� ���� �޸�(method)�� �ε�ǹǷ�, ���������� �𸣴�
		//instance ������ ���� ����� �� ����.
		//i=300;
		
		//��üȭ�� �ϸ� ��ü�� �޸�(heap)�����ǰ�, �� �ּҸ� �޸�(stack)����
		//��üȭ ����: Ŭ������ ��ü��=new Ŭ������();
		//������ stack�� ����, �������� heap�� ����
		UseInstanceVariable uiv = new UseInstanceVariable();
		UseInstanceVariable uiv1 = new UseInstanceVariable();
		System.out.println("��ü���(heap)"+uiv);
		System.out.println("��ü���(heap)"+uiv1);
		
		//heap�� ������ instance variable�� ���.
		uiv.i=11;
		uiv.j=21;
		
		System.out.println("uiv��ü�� ������� i="+uiv.i);
		System.out.println("uiv��ü�� instance���� j="+uiv.j);
		
		//instance/member ������ �ڵ��ʱ�ȭ ��
		System.out.println("uiv1��ü i:"+uiv1.i+" uiv��ü j:"+uiv1.j);
		System.out.println("----------�ڵ� �ʱ�ȭ ��--------------");
		System.out.println("������:"+uiv1.i);
		System.out.println("�Ǽ���:"+uiv1.d);
		System.out.println("������:"+uiv1.c);
		System.out.println("�Ҹ���:"+uiv1.b);
		System.out.println("������:"+uiv1.str);
		System.out.println("������:"+uiv1.jaehyun);

	}//main

}//class
