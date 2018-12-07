package day1205;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Calendar : ���� ��¥ ������ ���� ��
 * 
 * @author owner
 */
public class UseCalendar {

	public UseCalendar() {
		// CalendarŬ������ �ν��Ͻ� ���
		// 1.getInstance���
//		Calendar cal = new Calendar();//abstract class
		Calendar cal = Calendar.getInstance();
		// 2. is a ����
		Calendar cal1 = new GregorianCalendar();
		// 3. �ڽĸ����� ��üȭ
		GregorianCalendar gc = new GregorianCalendar();
		System.out.println(cal);
		System.out.println(cal1);
		System.out.println(gc);

		// Constant�� ���� ���� : ���������
		int year = cal.get(Calendar.YEAR);
		// java������ ���� ������ 0��
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int day_of_year = cal.get(Calendar.DAY_OF_YEAR);
		// ����: ��-1,��,ȭ,��,��,��,��-7
		int day_of_week = cal.get(Calendar.DAY_OF_WEEK);

		System.out.printf("%d-%d-%d ������ ������ %d��° ���Դϴ�. \n", year, month + 1, day, day_of_year);
//		String week = "";
//		switch (day_of_week) {
//		case Calendar.SUNDAY:
//			week = "�Ͽ���";
//			break;
//		case Calendar.MONDAY:
//			week = "������";
//			break;
//		case Calendar.TUESDAY:
//			week = "ȭ����";
//			break;
//		case Calendar.WEDNESDAY:
//			week = "������";
//			break;
//		case Calendar.THURSDAY:
//			week = "�����";
//			break;
//		case Calendar.FRIDAY:
//			week = "�ݿ���";
//			break;
//		case Calendar.SATURDAY:
//			week = "�����";
//		}// end switch
		String[] weekTitle = {"��","��","ȭ","��","��","��","��"};
		System.out.printf("������ %d���� %s \n", day_of_week, weekTitle[day_of_week-1]);
		int am_pm=cal.get(Calendar.AM_PM);
//		switch(am_pm) {
//		case Calendar.AM: //case 0:�̶�� �ϸ� ����������� �������� ������ ������
//			System.out.println("����");
//			break;
//		case Calendar.PM:
//			System.out.println("����");
//			break;
//		}
		System.out.printf("%d�̸� %s \n", am_pm,am_pm==Calendar.AM?"����":"����");
		
		int hour = cal.get(Calendar.HOUR);
		int hour24 = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		System.out.printf("%d( %d��):%d:%d \n", hour,hour24,minute,second);
		
		System.out.println("----------------------------");
		System.out.printf("���� �� %d-%d-%d %s \n",cal1.get(Calendar.YEAR),
				cal1.get(Calendar.MONTH)+1,cal1.get(Calendar.DAY_OF_MONTH),
				"��,��,ȭ,��,��,��,��".split(",")[cal1.get(Calendar.DAY_OF_WEEK)-1]);
		//��
		cal1.set(Calendar.YEAR, 2019);//2019-12-06
		//�� : ����� �����ϴ� ������ 1���� ����
		cal1.set(Calendar.MONTH, 5);//2019-06-06
		//�� :
		cal1.set(Calendar.DAY_OF_MONTH, 32);//2019-05-15
		//��: �ش���� �������� �ʴ� ���ڰ� �����Ǹ� �����޷� �Ѿ�� 1�Ϻ��� �������� ������ ��¥�� ����
		cal1.set(Calendar.DAY_OF_MONTH, 32);//2019-05-15
		
		System.out.printf("���� �� %d-%d-%d %s \n",cal1.get(Calendar.YEAR),
				cal1.get(Calendar.MONTH)+1,cal1.get(Calendar.DAY_OF_MONTH),
				"��,��,ȭ,��,��,��,��".split(",")[cal1.get(Calendar.DAY_OF_WEEK)-1]);
		
		System.out.println("�̹����� �������� : "+cal.getActualMaximum(Calendar.DATE));
	}// UseCalendar

	public static void main(String[] args) {
		new UseCalendar();
	}// main

}// class
