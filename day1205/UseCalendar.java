package day1205;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Calendar : 단일 날짜 정보를 얻을 때
 * 
 * @author owner
 */
public class UseCalendar {

	public UseCalendar() {
		// Calendar클래스의 인스턴스 얻기
		// 1.getInstance사용
//		Calendar cal = new Calendar();//abstract class
		Calendar cal = Calendar.getInstance();
		// 2. is a 관계
		Calendar cal1 = new GregorianCalendar();
		// 3. 자식만으로 객체화
		GregorianCalendar gc = new GregorianCalendar();
		System.out.println(cal);
		System.out.println(cal1);
		System.out.println(gc);

		// Constant를 쓰는 이유 : 가독성향상
		int year = cal.get(Calendar.YEAR);
		// java에서는 월의 시작이 0월
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int day_of_year = cal.get(Calendar.DAY_OF_YEAR);
		// 요일: 일-1,월,화,수,목,금,토-7
		int day_of_week = cal.get(Calendar.DAY_OF_WEEK);

		System.out.printf("%d-%d-%d 오늘은 올해의 %d번째 날입니다. \n", year, month + 1, day, day_of_year);
//		String week = "";
//		switch (day_of_week) {
//		case Calendar.SUNDAY:
//			week = "일요일";
//			break;
//		case Calendar.MONDAY:
//			week = "월요일";
//			break;
//		case Calendar.TUESDAY:
//			week = "화요일";
//			break;
//		case Calendar.WEDNESDAY:
//			week = "수요일";
//			break;
//		case Calendar.THURSDAY:
//			week = "목요일";
//			break;
//		case Calendar.FRIDAY:
//			week = "금요일";
//			break;
//		case Calendar.SATURDAY:
//			week = "토요일";
//		}// end switch
		String[] weekTitle = {"일","월","화","수","목","금","토"};
		System.out.printf("오늘은 %d요일 %s \n", day_of_week, weekTitle[day_of_week-1]);
		int am_pm=cal.get(Calendar.AM_PM);
//		switch(am_pm) {
//		case Calendar.AM: //case 0:이라고 하면 무슨경우인지 가독성이 안좋기 때문에
//			System.out.println("오전");
//			break;
//		case Calendar.PM:
//			System.out.println("오후");
//			break;
//		}
		System.out.printf("%d이면 %s \n", am_pm,am_pm==Calendar.AM?"오전":"오후");
		
		int hour = cal.get(Calendar.HOUR);
		int hour24 = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		System.out.printf("%d( %d시):%d:%d \n", hour,hour24,minute,second);
		
		System.out.println("----------------------------");
		System.out.printf("설정 전 %d-%d-%d %s \n",cal1.get(Calendar.YEAR),
				cal1.get(Calendar.MONTH)+1,cal1.get(Calendar.DAY_OF_MONTH),
				"일,월,화,수,목,금,토".split(",")[cal1.get(Calendar.DAY_OF_WEEK)-1]);
		//년
		cal1.set(Calendar.YEAR, 2019);//2019-12-06
		//월 : 사람이 생각하는 월보다 1적게 설정
		cal1.set(Calendar.MONTH, 5);//2019-06-06
		//일 :
		cal1.set(Calendar.DAY_OF_MONTH, 32);//2019-05-15
		//일: 해당월에 존재하지 않는 일자가 설정되면 다음달로 넘어가고 1일부터 나머지가 더해진 날짜가 나옴
		cal1.set(Calendar.DAY_OF_MONTH, 32);//2019-05-15
		
		System.out.printf("설정 후 %d-%d-%d %s \n",cal1.get(Calendar.YEAR),
				cal1.get(Calendar.MONTH)+1,cal1.get(Calendar.DAY_OF_MONTH),
				"일,월,화,수,목,금,토".split(",")[cal1.get(Calendar.DAY_OF_WEEK)-1]);
		
		System.out.println("이번달의 마지막날 : "+cal.getActualMaximum(Calendar.DATE));
	}// UseCalendar

	public static void main(String[] args) {
		new UseCalendar();
	}// main

}// class
