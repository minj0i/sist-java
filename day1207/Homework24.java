package day1207;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/*
 * main method의 arguments로 날짜를 여러개 입력 받아 입력받은 날짜의
 요일을 저장하고 출력하는 method 를 작성하세요.
날짜가 중복되지 않음
Map과 set 사용

예) java Test 4 12 30 32 35 15 4   

출력) 4 화
     12 수
     15 토
     30 일  
  
 */
public class Homework24 {
	public Homework24() {
		//Calendar
		Calendar cal = Calendar.getInstance();
		// 요일: 일-2,월,화,수,목,금-7,토-1
		String[] weekTitle = {"일","월","화","수","목","금","토"};
		//날짜와 요일 매칭
			int date = cal.get(Calendar.DAY_OF_MONTH);
			int day_of_week = (int)(cal.get(Calendar.DAY_OF_WEEK));	
	}
	
	public void putData(String[] args){
		//Map
		Map<String, String> map = new HashMap<String, String>();
		map.put(args[0],"");
		System.out.println(args[1]);
		System.out.println(args[2]);
	}
//		public void weekTitlePrint() {
//			System.out.printf("오늘은 %d일 %s요일 \n", date, weekTitle[day_of_week-1]);
//		}

	public static void main(String[] args) {
		Homework24 hw = new Homework24();
		hw.putData(args);
		
	}// main

}// class
