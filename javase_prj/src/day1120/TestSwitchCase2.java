package day1120;

/**
 * switch~case를 사용한 학점 구하기
 * @author owner
 */
public class TestSwitchCase2 {
	
	public static final int GRADE_A_PLUS=10;
	public static final int GRADE_A=9;
	public static final int GRADE_B=8;
	public static final int GRADE_C=7;
	public static final int GRADE_D=6;

	public static void main(String[] args) {
		
		int score = 109; //score/10의 문제는 101~109까지 10이 나온다는것
		//ㄸㄹㅇ 가 쓴다고 생각하고 유효성 검증..
//		char grade = ' ';	//char는 문자를 저장한다. ''는 문자가 없다 라는것으로 
				           //' '공백문자(white space)- unicode \u0000(~\uFFFF)
		                   //코드셋에 존재하지 않아 들어가지 않는다.Error
		                   //(int)Character.MIN_VALUE = \u0000  MAX_VALUE = \uFFFF
		//System.out.println((int)Character.MIN_VALUE+"/"+Character.MIN_VALUE)
		char grade=64;
		
		//case의 상수는 가독성이 떨어지기 때문에 Constant를 사용하려 한다..
		if(0<=score && score<=100) {
			switch(score/10) {
	/*		case 10 :
			case 9 : grade = 'A'; break;
			case 8 : grade = 'B'; break;
			case 7 : grade = 'C'; break;
			case 6 : grade = 'D'; break;
	    	default : grade = 'F';	*/
	    	//break; default는 아랫줄에 실행될 코드가 없으므로 분기문을 사용하지않는다. 줄일수있닷
			
			case TestSwitchCase2.GRADE_D: grade++;	//64->65
			case TestSwitchCase2.GRADE_C: grade++;	//65->67
			case TestSwitchCase2.GRADE_B: grade++;
			case TestSwitchCase2.GRADE_A: 
			case TestSwitchCase2.GRADE_A_PLUS: grade++;break;  //이렇게 해야 가독성이 좋은 코드
			default : grade+=6;
			//a=65,b=66 ~ F=70
			//break 있는게 이경우에서는 더 좋다. 한줄하고 나가니깐, 여러줄수행 안해서
			//case i 는 변수라 안돼고 상수를 쓰면 가독성이 떨어진다. constant를 넣어주는게 좋다.
			//6이 무언지 7이 무언지 알수 없어서?=>나쁜코드
			}//end switch
		
			System.out.println(score +" 점의 학점은 "+grade);
		} else {
			System.out.println("점수는 0~100점 사이만 입력 가능!!! 입력점수["+score+"]");
		}
	}//main

}//class
