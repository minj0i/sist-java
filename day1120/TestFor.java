package day1120;

/**
 * for : ���۰� ���� �� �� ����ϴ� �ݺ���<br>
 * ���� : for(���۰�; ����; ����|���ҽ�)<br>
 *          �ݺ� ���� ����;<br>
 *      }
 * @author owner
 */
public class TestFor {

	public static void main(String[] args) {
		//0~�������� 10���� ���� ������ �ݺ������ϴ� for
		for(int i=0; i<10; i++) {
			System.out.println(i+"�� �ȳ� ");
		}//end for
		
		//1���� ���� 1�� �����ϸ� 100���� �ݺ����� �ϴ� for
		//�ݺ������� i<=100���� ������1�� ������2�� �� �ϰԵǾ �������̸� i<101�� ����.����HDD�� ��������..�����̰� ������..
		for(int i=1; i<101; i++ ) {
			System.out.println(i);
		}//end for
		
		//1���� ���� 1�� �����ϸ� 100���� ¦���� ������ ��� for
		for(int i=1; i<101; i++ ) {
			if(i%2==0)
				System.out.print(i+" ");
		}//end for
		System.out.println(); //<������ �پȰǳʼ� �׳� �ǳ�,�ƹ��͵� ���̵� ���� �¾Ҵ�~
		
		//1���� ���� 100���� Ȧ���� ������ ���
		int cnt = 0;
		for(int i=1; i<101; i++ ) {
			cnt++;
			if(i%2==1)
				System.out.print(i+" ");
		}//end for
		System.out.println("\n"+cnt+"��");
		
		
		//1���� ���� 100���� Ȧ���� ������ ���
		int cnt1 = 0;
		//��/���ҽ��� ������ ���� ��ȭ��Ű�� ������ų�� �ִ� ��� �����ڸ� �� ����� �� �ִ�.
		//< i++ �������� = i+=1 = i=i+1 => �̷��� ��������� �������� �پ���.
		//<i&=2  i^=2 �� �� ����� ����. ���� ����..���� �����Ѱ� ����ȴ�.
		for(int i=1; i<101; i+=2 ) {
			cnt1++;
				System.out.print(i+" ");
		}//end for
		System.out.println("\n"+cnt1+"��");
		
		//1~100���� ����ϱ� 3�� ������� ���ڴ�� "¦"�� ���
		int cnt2=0;
		for(int i=1; i<101;) {
			cnt2++;
			if (i%3==0) {
				System.out.print("¦ ");
			}else {
			System.out.print(i+" ");
			}//end if
			i++;
		}//end for
		System.out.println("\n"+cnt2+"��");
		
		//1~100������ �� ���
		int sum=0;
		for(int i=1; i<101; i++) {
			sum=sum+i;
		}//end for
		System.out.println("1�������� 100������ ����: "+sum);
		
		//���ĺ� A~Z���� ���
		for(int i=65; i<91; i++) {
			System.out.print((char)i+" ");
		}//end for
		System.out.println(" ");
		
		for(char c='A'; c<='Z'; c++) {
			System.out.print(c+" ");
		}//end for
		System.out.println(" ");
		
		for(int i=1; i<10; i++) {
			System.out.print(2*i+ " ");
		}//end for
		
		
		
		
	}//main

}//class
