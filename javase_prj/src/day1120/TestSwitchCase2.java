package day1120;

/**
 * switch~case�� ����� ���� ���ϱ�
 * @author owner
 */
public class TestSwitchCase2 {
	
	public static final int GRADE_A_PLUS=10;
	public static final int GRADE_A=9;
	public static final int GRADE_B=8;
	public static final int GRADE_C=7;
	public static final int GRADE_D=6;

	public static void main(String[] args) {
		
		int score = 109; //score/10�� ������ 101~109���� 10�� ���´ٴ°�
		//������ �� ���ٰ� �����ϰ� ��ȿ�� ����..
//		char grade = ' ';	//char�� ���ڸ� �����Ѵ�. ''�� ���ڰ� ���� ��°����� 
				           //' '���鹮��(white space)- unicode \u0000(~\uFFFF)
		                   //�ڵ�¿� �������� �ʾ� ���� �ʴ´�.Error
		                   //(int)Character.MIN_VALUE = \u0000  MAX_VALUE = \uFFFF
		//System.out.println((int)Character.MIN_VALUE+"/"+Character.MIN_VALUE)
		char grade=64;
		
		//case�� ����� �������� �������� ������ Constant�� ����Ϸ� �Ѵ�..
		if(0<=score && score<=100) {
			switch(score/10) {
	/*		case 10 :
			case 9 : grade = 'A'; break;
			case 8 : grade = 'B'; break;
			case 7 : grade = 'C'; break;
			case 6 : grade = 'D'; break;
	    	default : grade = 'F';	*/
	    	//break; default�� �Ʒ��ٿ� ����� �ڵ尡 �����Ƿ� �б⹮�� ��������ʴ´�. ���ϼ��ִ�
			
			case TestSwitchCase2.GRADE_D: grade++;	//64->65
			case TestSwitchCase2.GRADE_C: grade++;	//65->67
			case TestSwitchCase2.GRADE_B: grade++;
			case TestSwitchCase2.GRADE_A: 
			case TestSwitchCase2.GRADE_A_PLUS: grade++;break;  //�̷��� �ؾ� �������� ���� �ڵ�
			default : grade+=6;
			//a=65,b=66 ~ F=70
			//break �ִ°� �̰�쿡���� �� ����. �����ϰ� �����ϱ�, �����ټ��� ���ؼ�
			//case i �� ������ �ȵŰ� ����� ���� �������� ��������. constant�� �־��ִ°� ����.
			//6�� ������ 7�� ������ �˼� ���?=>�����ڵ�
			}//end switch
		
			System.out.println(score +" ���� ������ "+grade);
		} else {
			System.out.println("������ 0~100�� ���̸� �Է� ����!!! �Է�����["+score+"]");
		}
	}//main

}//class
