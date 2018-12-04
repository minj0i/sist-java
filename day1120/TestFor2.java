package day1120;

/**
 * 다양한 for의 형태
 * @author owner
 */
public class TestFor2 {

	public static void main(String[] args) {
//		//무한 loop
//		for(; ; ) {
//			System.out.println("무한 루프");
//		}//end for
		
		//증가하는 수를 세는 무한 loop
		for(int i=0; ;i++) {
			System.out.println("무한 loop");
			if (i==50) {
				break;
			}
		}//end for
		System.out.println(" ");

		//여러개의 초기값을 사용하는 for
		for(int i=0, j=10, k=30; i<10; i++, j++, k--) {
			System.out.println(i+" "+j+" "+k);
		}//end for
		
		//조건식을 잘못 설정하면 무한loop에 들어감
//		for(int i=0, i<10; i--) {
//			System.out.println(i);
//		}
		
		//for문 뒤에 ; 와서 끝나고 syso 한 번 나옴
		int i=0;
		for(i=0; i<10; i++);{
			System.out.println("반복문 "+i);
		}
	}//main

}//class
