package day0102;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class UseURLEncoder {

	public static void main(String[] args) {
		String msg="abc������def123";//MS949
		try {
			//�Էµ� ���ڿ��� ������ ����ϴ� ������ �ڵ尪���� ����
			String encode=URLEncoder.encode(msg,"UTF-8");//MS949�� �ѱ��� -> ������ ����ϴ� UTF-8�� ������ �ڵ尪���� ����.
			System.out.println("���ڵ� : "+encode);
			System.out.println("���̹� �ּ�â : abc%EA%B0%80%EB%82%98%EB%8B%A4def123");
			
			String decode=URLDecoder.decode(encode, /*"UTF-8"*/"EUC-KR");
			System.out.println("���ڵ� : "+decode);
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}//end catch
	}//main

}//class
