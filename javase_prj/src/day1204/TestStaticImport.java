package day1204;

import static java.lang.Integer.MAX_VALUE;
//같은 이름의 상수는 하나만 static import 받는다
//import static java.lang.Byte.MAX_VALUE;

//method는 method명만 기술한다.
import static java.lang.Integer.parseInt;
import static java.lang.Integer.toBinaryString;

/**
 * static import
 * 다른 클래스의 static변수(Constant)나 method를 현재 클래스에
 * 있는 것처럼 사용할 때. <br>
 * 문법)
 * import static 패키지명.클래스명.method명|변수명
 * @author owner
 */
public class TestStaticImport {

	public static void main(String[] args) {
		int i=MAX_VALUE;
		System.out.println(i);
		System.out.println(MAX_VALUE);
		
		String year="2018";
		String month="12";
		String day="4";
		
		int intYear=parseInt(year);
		int intMonth=parseInt(month);
		int intDay=parseInt(day);
		
		System.out.println(intYear+"/"+intMonth+"/"+intDay);
		System.out.println(toBinaryString(intYear)+"/"+toBinaryString(intMonth)+"/"+toBinaryString(intDay));
		
		
	}//main

}//class
