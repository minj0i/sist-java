package day1119;

/**
 * switch~case : 정수를 비교할 때.(JDK1.7에서부터는 문자열도 비교 가능)<br>
 * 문법) switch (변수명) {<br>
 * 			case 상수 : 수행문장; <br>
 * 			case 상수 : 수행문장; <br>
 * 			case 상수 : 수행문장; <br>
 * 				.<br>
 * 				.<br>
 * 				.<br>
 * 			default : 일치하는 상수가 없을 때 수행문장;<br>
 * 			}<br>
 * @author owner
 */
public class TestSwitchCase {
	
	public static void main(String[] args) {
		// char i='1'로 넣으면 Unicode가 들어감, case 1과 다른 것
		//String i="1"; Java1.7이상에서 String 가능
		int i=0;
		//switch에 입력되는 변수의 데이터형은 byte, short, int, char, String
		switch(i) {
		//case는 입력되는 변수에 따라 다른 범위를 가진다
		case 1 : System.out.println("아침");
		case 2 : System.out.println("점심");
		case 3  : System.out.println("저녁");
		default: System.out.println("새벽");
		}//end switch
		
	}//main
}//class
