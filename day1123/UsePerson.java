package day1123;

/**
 * ����� �߻�ȭ�Ͽ� ���� Person Ŭ������ ����ϴ� Ŭ����
 * @author owner
 */
public class UsePerson {

	public static void main(String[] args) {
		//��ü ����: heap�� �����ǰ� instance ������ �ڵ� �ʱ�ȭ
		Person taecksung = new Person();
		//������ ���������� Person�� heap�� �ּҸ� ������ �ִ�.
		System.out.println("��ü�� ����ϸ� �ּҰ� ��� "+taecksung);
		taecksung.setName("���ü�");
//		taecksung.setEye(2);
//		taecksung.setNose(1);
//		taecksung.setMouth(1);
		
		System.out.format("������ ��� ��ü ���� ��[%d],��[%d],��[%d],�̸�[%s]\n",
				taecksung.getEye(),taecksung.getNose(),taecksung.getMouth(),taecksung.getName());
		//������ ��ü���� ���ǵ� ���� ���.
		System.out.println(taecksung.eat());
		System.out.println(taecksung.eat("��ȸ�����", 8000));
		
		System.out.println("-----------------------------------");
		Person jinban=new Person(3,1,1);
		jinban.setName("õ����");
//		jinban.setEye(3);
//		jinban.setNose(1);
//		jinban.setMouth(1);
		
		System.out.format("������ ��� ��ü ���� ��[%d],��[%d],��[%d],�̸�[%s]\n",
				jinban.getEye(),jinban.getNose(),jinban.getMouth(),jinban.getName());
		System.out.println(jinban.eat());
		System.out.println(jinban.eat("����",1));
	}//main

}//class
