package day1126;

/**
 * ���ڿ��� ���� ��
 * @author owner
 */
public class TestString {

	public static void main(String[] args) {
		String str = "ABC";//�⺻�� ������ ���
		//�⺻�� �������� ������ ���ڿ��� ���ڿ� ������� �ּҸ� �����ϱ� ������
		//==�񱳰� ����
		if(str=="ABC") {
			System.out.println("�⺻�� ����");
		}else {
			System.out.println("�⺻�� �ٸ�");
		}//end else
		String str1= new String("ABC");//������ ������ ���
		//������ �������� ����ϸ� ������ heap�� �ּҸ� �����ϰ�, 
		//heap�� ������� ��ü�� ���ڿ�������� �ּҸ� �����ϹǷ�
		//���� ���ڿ������� ==�񱳰� �Ұ���
		if(str1=="ABC") {
			System.out.println("������ ����");
		}else {
			System.out.println("������ �ٸ� ==�񱳰� �Ұ��� .eqauls�� ������");
		}//end else
		System.out.println("-----------------------------");
		if(str.equals("ABC") && str1.equals("ABC")) {
			System.out.println("����");
		}else {
			System.out.println("�ٸ�");
		}//end else
	}//main
}//class
