package day1126;

/**
 * 문자열에 대한 비교
 * @author owner
 */
public class TestString {

	public static void main(String[] args) {
		String str = "ABC";//기본형 형식의 사용
		//기본형 형식으로 선언한 문자열은 문자열 저장소의 주소를 저장하기 때문에
		//==비교가 가능
		if(str=="ABC") {
			System.out.println("기본형 같음");
		}else {
			System.out.println("기본형 다름");
		}//end else
		String str1= new String("ABC");//참조형 형식의 사용
		//참조형 형식으로 사용하면 변수는 heap의 주소를 저장하고, 
		//heap에 만들어진 객체가 문자열저장소의 주소를 저장하므로
		//같은 문자열일지라도 ==비교가 불가능
		if(str1=="ABC") {
			System.out.println("참조형 같음");
		}else {
			System.out.println("참조형 다름 ==비교가 불가능 .eqauls을 쓰세요");
		}//end else
		System.out.println("-----------------------------");
		if(str.equals("ABC") && str1.equals("ABC")) {
			System.out.println("같음");
		}else {
			System.out.println("다름");
		}//end else
	}//main
}//class
