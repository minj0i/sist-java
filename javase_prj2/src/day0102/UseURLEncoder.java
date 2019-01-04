package day0102;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class UseURLEncoder {

	public static void main(String[] args) {
		String msg="abc가나다def123";//MS949
		try {
			//입력된 문자열을 웹에서 사용하는 형태의 코드값으로 변경
			String encode=URLEncoder.encode(msg,"UTF-8");//MS949인 한글을 -> 웹에서 사용하는 UTF-8의 형식의 코드값으로 변경.
			System.out.println("인코딩 : "+encode);
			System.out.println("네이버 주소창 : abc%EA%B0%80%EB%82%98%EB%8B%A4def123");
			
			String decode=URLDecoder.decode(encode, /*"UTF-8"*/"EUC-KR");
			System.out.println("디코딩 : "+decode);
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}//end catch
	}//main

}//class
