package day1119;

/**
 * if~else: �� �� �ϳ��� �ڵ带 �����ؾ� �� �� ���<br>
 * ����) if(���ǽ�){<br>
 * ���ǿ� ���� �� ������ �����;<br>
 * }else{<br>
 * ���ǿ� ���� ���� �� ������ �����;<br>
 * }
 * 
 * @author owner
 */
public class TestIfElse {

	public static void main(String[] args) {
		int i = -20;
		// ������ �����ϴ� ���� �������� ��������� �Ǵ�
		System.out.print(i + "��(��)");
		if (i < 0) {
			System.out.println(" ����");
		} else {
			System.out.println(" ���");
		}
		// ������ �����ϴ� ���� Ȧ������ ¦�������� �Ǵ�
		// �����ϴ� ����� �����̶�� {�� ������ �� �ִ�.
		System.out.print(i + "��(��)");
		if (i % 2 == 0) {
			System.out.println(" ¦��");
		}else { 
			System.out.println(" Ȧ��");
		}//end if
		
		System.out.println(" Ȧ������"); //else�� ������ �ʰ� ������ �ڵ��� ������
		
		//�Է��ϴ� ���� 3�� ������ "¦"�� ����ϰ� �׷��� ������
		//�Է��� ���� ����ϼ���.
		int j= Integer.parseInt(args[0]);
		if (j%3==0) {
			System.out.println("¦");
		}else {
			System.out.println(args[0]);
		}//end if
		
		
		
		
	}// main

}// class
