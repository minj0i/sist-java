package day1121;

/**
 * while: ���۰� ���� �𸦶� ����ϴ� �ݺ���<br>
 * 			�ּ� 0�� ���� �ִ� ���Ǳ��� ���� <br>
 * ����) while(���ǽ�){
 * 			�ݺ����๮��;<br>
 * 		}
 * @author owner
 */
public class TestWhile {

	public static void main(String[] args) {
		int i=0;//�ʱⰪ
		
		while(i<10) {//���ǽ�
			System.out.println("i= "+i);//�ݺ����๮��
			i++;//������
		}//end while
		
		System.out.println("------------------------------");
		
		//���� �Է¹޾� 2~9�� ���̶�� ������ ���
		int a = Integer.parseInt(args[0]);
		int j=1;
		if (a>=2 && a<=9)
		while(j<10) {//���ǽ�
			System.out.println(a+"*"+j+"="+(a*j));//�ݺ����๮��
			j++;//������
		}//end while
		
		//����loop
		i=0;
		while(true) {
			System.out.println("���� loop");
			if(i==5) {
				break;
			}//end if
			i++;
		}//end while
//		System.out.println();
		
		
	}//main

}//class
