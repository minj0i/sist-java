package day1205;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Calendar : ���� ��¥ ������ ���� ��
 * @author owner
 */
public class UseCalendar {

	public UseCalendar() {
		//CalendarŬ������ �ν��Ͻ� ���
		//1.getInstance���
//		Calendar cal = new Calendar();//abstract class
		Calendar cal = Calendar.getInstance();
		//2. is a ����
		Calendar cal1 = new GregorianCalendar();
		//3. �ڽĸ����� ��üȭ
		GregorianCalendar gc = new GregorianCalendar();
		System.out.println(cal);
		System.out.println(cal1);
		System.out.println(gc);
		
		int year = cal.get(Calendar.YEAR);//Constant�� ���� ���� : ���������
		
		System.out.println(year);
		
	}//UseCalendar
	
	
	public static void main(String[] args) {
		new UseCalendar();
	}//main

}//class
