package kr.co.sist.util;

import java.io.UnsupportedEncodingException;

public class HangulConv {
	public static String toUTF(String kor) {
		if(kor!=null || !"".equals(kor)) { //앞으로 equals는 이렇게 쓰기, 절대 nullpoint 안남
			try {
				kor=new String(kor.getBytes("8859_1"),"UTF-8"); //3byte씩 조합해라
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}//end catch
		}//end if
		return kor;
	}//toUTF
	public static String toEUC(String kor) {
		if(kor!=null || !"".equals(kor)) { 
			try {
				kor=new String(kor.getBytes("8859_1"),"EUC-KR"); //2byte씩 조합해라
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}//end catch
		}//end if
		return kor;
	}//toUTF
}//class
