package day1205;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * ������ �ִ� ��¥������ ���� ��
 * ���� - java.text.SimpleDateFormat
 * @author owner
 */
public class UseDate {

	public UseDate() {
		Date date=new Date();
		System.out.println(date);//object�� �ִ� toString�� Override�߱⶧���� �ּҰ� �ȳ����� ���� ����
//		System.out.println(date.getYear());//����õ method�� ����.
		
		SimpleDateFormat sdf = new SimpleDateFormat
				("yyyy��MM��dd�� a EEEE HH(hh,kk):mm:ss",Locale.CHINA);
		String formatDate = sdf.format(date); //has a ����
		System.out.println(formatDate);

		
		
	}//UseDate
	
	public static void main(String[] args) {
		new UseDate();
	}//main

}//class
