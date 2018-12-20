package day1204;

/**
 * �������̽��� method�� �Ű������� �� �����ϰ� ����ϴ� ���.<br>
 * 
 * @author owner
 */
public class TestAnony {
	public void useAnonyInter(AnonyInter ai) {
		System.out.println(ai.getMsg()+" "+ai.getName());
		
	}//useAnonyInter
	public static void main(String[] args) {
//		AnonyInter ai = new AnonyInter();//��üȭ�� �ȵ�. �������̽� �ȿ� �� �� �ִ� ���� ���, abstract method
		//Ŭ������ �� �� �ִ� ��: ���� , method
		//�������̽��� �Ű�������������
		//1. �������̽��� ������ Ŭ������ ���� (AnonyImpl)
		//2. ����Ŭ������ ��üȭ
		AnonyInter ai = new AnonyImpl(); //is a ������ �ν��Ͻ�ȭ
		//AnonyInter��� AnonyImpl�� ���� ������
		//3.�Ű������� ���� method�� ȣ���ϱ����� ��ü ����
		TestAnony ta = new TestAnony();
		//4.method�� ȣ��
		ta.useAnonyInter(ai);
		System.out.println("--------anonymous innerclass---------");
		//anonymous inner class�� ����ϸ� Ŭ������ ���� �����ʿ䰡 ����.
		
		ta.useAnonyInter(new AnonyInter() {
			@Override
			public String getName() {
				return "������"+test();
			}//getName

			@Override
			public String getMsg() {
				return "�´���";
			}//getMsg
			public String test() {
				return "�ڽ� method";
			}
		});
		
	}//main

}//class
