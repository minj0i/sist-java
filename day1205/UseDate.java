package day1205;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 형식이 있는 날짜정보를 얻을 때
 * 형식 - java.text.SimpleDateFormat
 * @author owner
 */
public class UseDate {

	public UseDate() {
		Date date=new Date();
		System.out.println(date);//object에 있는 toString을 Override했기때문에 주소가 안나오고 값이 나옴
//		System.out.println(date.getYear());//비추천 method가 많다.
		
		SimpleDateFormat sdf = new SimpleDateFormat
				("yyyy년MM월dd일 a EEEE HH(hh,kk):mm:ss",Locale.CHINA);
		String formatDate = sdf.format(date); //has a 관계
		System.out.println(formatDate);

		
		
	}//UseDate
	
	public static void main(String[] args) {
		new UseDate();
	}//main

}//class
