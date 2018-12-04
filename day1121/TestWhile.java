package day1121;

/**
 * while: 시작과 끝을 모를때 사용하는 반복문<br>
 * 			최소 0번 수행 최대 조건까지 수행 <br>
 * 문법) while(조건식){
 * 			반복수행문장;<br>
 * 		}
 * @author owner
 */
public class TestWhile {

	public static void main(String[] args) {
		int i=0;//초기값
		
		while(i<10) {//조건식
			System.out.println("i= "+i);//반복수행문장
			i++;//증가식
		}//end while
		
		System.out.println("------------------------------");
		
		//단을 입력받아 2~9단 사이라면 구구단 출력
		int a = Integer.parseInt(args[0]);
		int j=1;
		if (a>=2 && a<=9)
		while(j<10) {//조건식
			System.out.println(a+"*"+j+"="+(a*j));//반복수행문장
			j++;//증가식
		}//end while
		
		//무한loop
		i=0;
		while(true) {
			System.out.println("무한 loop");
			if(i==5) {
				break;
			}//end if
			i++;
		}//end while
//		System.out.println();
		
		
	}//main

}//class
