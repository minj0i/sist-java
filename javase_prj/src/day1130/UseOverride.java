package day1130;

import day1129.HongGilDong;

public class UseOverride {

	public static void main(String[] args) {

		OverrideToString ots = new OverrideToString();
		HongGilDong gd= new HongGilDong();
		String str = new String("문자열저장소");

//		System.out.println(ots.toString());
//		System.out.println(gd.toString());
//		System.out.println(str.toString());
		System.out.println(ots);
		System.out.println(gd);
		System.out.println(str);
		
		
	}

}
