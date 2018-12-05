package day1205;

/**
 * StringBuffer, StringBuilder(JDK1.5)
 * 문자열을 heap에 직접 저장하고 사용하는 클래스
 * @author owner
 */
public class UseStringBuilder {

	public void useStringBuffer() {
	//1.클래스 생성
	StringBuffer sb = new StringBuffer();
	//2.값(정수, 실수, 문자, 불린, 문자열..)을 추가
	sb.append("오늘은 ");//문자열
	sb.append(12);//정수
	sb.append("월 5일").append(" 수요일 입니다.");
	System.out.println(sb);//toString
	
	//3. 값 삽입
	//오늘은 12월 5일 수요일 입니다.
	//0 1234
	sb.insert(4,"2018년 ");//4부터 뒤로 쭉 밀림
	System.out.println(sb);
	
	//4. 값 삭제: delete(시작인덱스,끝인덱스+1)
	//오늘은 2018년 12월 5일 수요일 입니다.
	//0 123
	sb.delete(0, 4);//문자열끝에 null문자까지 있기 때문에 끝인덱스+1을 해야함
	System.out.println(sb);
	
	//5. 값 뒤집기
	sb.reverse();
	System.out.println(sb);
	sb.reverse();
	System.out.println(sb);
	
	}//useStringBuffer
	
	public void useStringBuilder() {
	//1.클래스 생성
	StringBuilder sbr = new StringBuilder();
	//2.값(정수, 실수, 문자, 불린, 문자열..)을 추가
	sbr.append("오늘은 ");//문자열
	sbr.append(12);//정수
	sbr.append("월 5일").append(" 수요일 입니다.");
	System.out.println(sbr);//메모리에 직접 저장되서 주소가 아니라 값을 불러올 수 있음
	
	//3. 값 삽입
	//오늘은 12월 5일 수요일 입니다.
	//0 1234
	sbr.insert(4,"2018년 ");//4부터 뒤로 쭉 밀림
	System.out.println(sbr);
	
	//4. 값 삭제: delete(시작인덱스,끝인덱스+1)
	//오늘은 2018년 12월 5일 수요일 입니다.
	//0 123
	sbr.delete(0, 4);//문자열끝에 null문자까지 있기 때문에 끝인덱스+1을 해야함
	System.out.println(sbr);
	
	//5. 값 뒤집기
	sbr.reverse();
	System.out.println(sbr);
	sbr.reverse();
	System.out.println(sbr);
	
	}//useStringBuilder
	
	public static void main(String[] args) {
		UseStringBuilder usb = new UseStringBuilder();
		usb.useStringBuffer();
		System.out.println("---------------------------");
		usb.useStringBuilder();

		
		String str="안녕하세요?"; //짧은문자열은 String에 저장한다.
		System.out.println(str);
		
		String str1="안";
		//문자열에 +가 붙어서 긴 문자열
		System.out.println(str1+"녕"+"하"+"세"+"요");
		//new StringBuilder().append(str1).append("녕").append("하"),,,
		
		}//main

}//class
