package day1207;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/*
 * main method�� arguments�� ��¥�� ������ �Է� �޾� �Է¹��� ��¥��
 ������ �����ϰ� ����ϴ� method �� �ۼ��ϼ���.
��¥�� �ߺ����� ����
Map�� set ���

��) java Test 4 12 30 32 35 15 4   

���) 4 ȭ
     12 ��
     15 ��
     30 ��  
  
 */
public class Homework24 {
	public Homework24() {
		//Calendar
		Calendar cal = Calendar.getInstance();
		// ����: ��-2,��,ȭ,��,��,��-7,��-1
		String[] weekTitle = {"��","��","ȭ","��","��","��","��"};
		//��¥�� ���� ��Ī
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
//			System.out.printf("������ %d�� %s���� \n", date, weekTitle[day_of_week-1]);
//		}

	public static void main(String[] args) {
		Homework24 hw = new Homework24();
		hw.putData(args);
		
	}// main

}// class
