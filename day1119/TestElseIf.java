package day1119;

/**
 * else~if: ������ ���� ������ ���� ��. <br>
 * ����)if(���ǽ�){<br>
 * 			���ǿ� ���� �� ���� ����;<br>
 * 		}else if(���ǽ�){<br>
 * 			���ǿ� ���� �� ���� ����<br>
 * 		}else if(���ǽ�){<br>
 * 			���ǿ� ���� �� ���� ����<br>
 * 			.<br>
 * 			.<br>
 * 		}else {<br>
 * 				��� ���ǿ� ���� ���� �� ���� ����;<br>
 * 		}
 * @author owner
 */
public class TestElseIf {

	public static void main(String[] args) {

		int i=Integer.parseInt(args[0]);
		System.out.println(i+"��(��) ");
		
		if(i<0) {
			System.out.println("0���� �۾Ƽ� ����");	
		}else if(i>100){
			System.out.println("100���� Ŀ�� ����");	
		}else {
			System.out.println("�Է� ����");	
		}//end else
		
		//�̸��� �Է� �޾� "������"�̸� ������
		//�̺���, �ڿ���, ������, ������ �̸� ������
		//�׷��� ������ "���"�� �̸��տ� ����ϼ���.
		
		if (args[1].equals("������")){
			System.out.print("����");
		} else if(args[1].equals("�̺���")||args[1].equals("�ڿ���")||
				  args[1].equals("������")||args[1].equals("������")){
			System.out.print("����");
		}else {
			System.out.print("���");
		}//end else
		System.out.println(" "+args[1]+"�� �ȳ��ϼ���");
		
		//�¾��(1995)�� �Է¹޾� ��(12)���ϱ�
		//11-��, 10-��, 9-��, 8-��, 7-�䳢, 6-ȣ����, 5-�� 4-�� 3-���� 2-�� 1-�� 0-������
		int b=Integer.parseInt(args[2]);
		System.out.print(args[1]+"���� ���: ");
		if (b%12==11) {
			System.out.println("���");
		}else if(b%12==10) {
			System.out.println("����");
		}else if(b%12==9) {
			System.out.println("���");
		}else if(b%12==8) {
			System.out.println("���");
		}else if(b%12==7) {
			System.out.println("�䳢��");
		}else if(b%12==6) {
			System.out.println("ȣ���̶�");
		}else if(b%12==5) {
			System.out.println("�Ҷ�");
		}else if(b%12==4) {
			System.out.println("���");
		}else if(b%12==3) {
			System.out.println("������");
		}else if(b%12==2) {
			System.out.println("����");
		}else if(b%12==1) {
			System.out.println("�߶�");
		}else if(b%12==0) {
			System.out.println("�����̶�");
		}else {
			System.out.println("����?");
		}//end else
	}//main

}//class
