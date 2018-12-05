package day1205;

import java.util.StringTokenizer;

/**
 * 
 * @author owner
 */
public class UseStringTokenizer {

	public UseStringTokenizer() {
		String msg = "오늘은 수요일 입니다. 날씨는 -5입니다.";

		// 공백으로 구분 : 매개변수 하나인 생성자를 사용
		StringTokenizer stk = new StringTokenizer(msg);

		System.out.println(stk.countTokens() + "개");
		while (stk.hasMoreTokens()) {// 토큰이 존재하는지?
			// 토큰을 얻고 포인터를 다음으로 이동
			System.out.println(stk.nextToken());
		} // end while

		String names = "이재현,이재찬~정택성,김희철.김정운~김정윤,공선의";

		// 특정문자로 토큰 구분
		StringTokenizer stk1 = new StringTokenizer(names, "김");
		System.out.println("--------------------------");
		System.out.println("토큰의 수 : " + stk1.countTokens());

		while (stk1.hasMoreTokens()) {
			System.out.println(stk1.nextToken());
		}
		System.out.println("--------------------------");
		StringTokenizer stk2 = new StringTokenizer(names, ",~ ");
		System.out.println("토큰의 수 : " + stk2.countTokens());

		while (stk2.hasMoreTokens()) {
			System.out.println(stk2.nextToken());
		}
		System.out.println("--------------------------");
		StringTokenizer stk3 = new StringTokenizer(names, "~");
		System.out.println("토큰의 수 : " + stk3.countTokens());

		while (stk3.hasMoreTokens()) {
			System.out.println(stk3.nextToken());
		}
		
		//특정문자로 토큰 구분, 구분된 문자열도 토큰으로 처리:
		//매개변수 세개인 생성자
		StringTokenizer stk4 = new StringTokenizer(names, ",. ", false);
		System.out.println("----------------------");
		while (stk4.hasMoreTokens()) {
			System.out.println(stk4.nextToken());
		}
		
	}// UseStringTokenizer

	public static void main(String[] args) {
		new UseStringTokenizer();
	}// main

}// class
