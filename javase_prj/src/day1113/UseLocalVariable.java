package day1113;
//�������� ���� ���
//1 I l O 0
class UseLocalVariable{

	public static void main(String[] args){
	//1. �������� ����: �������� ������;
	int i; //�ڵ��ʱ�ȭ�� �ȵ�
	int j=11; //������ �ʱ�ȭ: ������ �����ϸ鼭 �� �Ҵ�

	//2. ���Ҵ� : ������=��;
	i=100;

	//3. �� ���: ���, ����, ���Ҵ�
	System.out.println(i);
	System.out.println(j);
	
	//int i=200; // ���� �̸��� ������ �ۼ��� �� ����.

	//�������� �ѱ۷� �����ϳ� �ѱ��� ������� x
	int ���� =300;
	long l = 3000000000L;
	System.out.println(����);
	System.out.println(����);
	System.out.println(����);
	System.out.println(����);
	System.out.println(����);
	System.out.println(����);
	System.out.println(l);
	}//main
}//class