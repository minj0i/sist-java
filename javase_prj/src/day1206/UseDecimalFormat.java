package day1206;

import java.text.DecimalFormat;

/**
 * DecimalFormat
 * 숫자를 지정한 문자열로 변경.
 * @author owner
 */
public class UseDecimalFormat {

	public UseDecimalFormat () {
		int temp=20181206;
		System.out.println(temp);
		
		DecimalFormat df = new DecimalFormat("0,000,000,000");
//		DecimalFormat df = new DecimalFormat("0,000"); //알아서 세자리마다 ,로 만들어줌(오라클에 없는 기능)
		DecimalFormat df1 = new DecimalFormat("#,###,###,###");
		
		System.out.println("0사용: "+df.format(temp));
		System.out.println("#사용: "+df1.format(temp));
		
		DecimalFormat df2 = new DecimalFormat("#,###.00");
		//실수자릿수를 사용하면 마지막뒷자리의 값이 반올림 대상이라면 반올림한 결과를
		//보여준다.
		System.out.println("소수자리수 표현: "+df2.format(201812.066));
	}//UseDecimalFormat 생성자
		
	public static void main(String[] args) {
		new UseDecimalFormat();
	}//main

}//class
