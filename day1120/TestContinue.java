package day1120;

/**
 * Continue: �ݺ������� �ݺ����� �ڵ��� ������ �ǳ� �ٴ� ��.<br>
 * 
 * @author owner
 */
public class TestContinue {

	public static void main(String[] args) {
System.out.println(args);
		//0~100���� Ȧ���� ���
		for(int i=0; i<100; i++) {
			System.out.println("i ="+i);
			if(i%2==0) {
			continue;
			}//end if
			System.out.println("i ="+i);
		}
	}//main

}//class
