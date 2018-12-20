package day1119;

public class Homework17 {

	public static void main(String[] args) {
		/*
		 * 숙제 1. 출퇴근 시간을 입력받아 아래의 조건으로 출력하세요. 출력 : 출퇴근 시간은 최대 2시간의 제한이 있으며 60분을 넘는 다면
		 * "장거리/7H멀어" 60분 이하라면 "단거리"를 출력하세요.
		 */
		int a = Integer.parseInt(args[0]);

		if (a <= 120) {
			if (a <= 60) {
				System.out.println("단거리");
			} else if (a > 60) {
				System.out.println("장거리, 7H멀어");
			}
		} else {
			System.out.println("2시간 초과");
		}

		/*
		 * 2. 이름, 교통수단과 출퇴근 거리를 입력받아 아래와 같이 출력하세요. 교통수단은 "버스,지하철,택시,도보"로 제한한다. 버스요금
		 * 1200원, 지하철 요금 1250원, 택시요금 3800원 입니다. 요금은 10키로 까지는 기본요금, 매 5키로 초과시 마다 100원씩 증가
		 * 합니다.
		 * 
		 * 출력 : xxx님 출퇴근 교통수단은 xx이며 거리는 xx 키로 입니다. 편도 이용 요금 xx원이고, 왕복이용 요금 xx원이며, 한달
		 * 20일기준 교통비는 총: xxxx원 입니다.
		 */

		String name = args[1];
		String trp = args[2];
		int dis = Integer.parseInt(args[3]);

		int fee = 0;
		switch (trp) {
		case "버스":	fee = 1200; break;
		case "지하철":fee = 1250; break;
		case "택시": fee = 3800; 	break;
		default: fee = 0;
		}// switch~case end

		int sum = 0;
		int add = (dis - 10) / 5;
		if (dis >= 10) {
			sum = fee + add * 100;
		} // if end

		System.out.println(name + "님 출퇴근 교통수단은 " + trp + "이며 거리는 " + dis + "키로 입니다.");
		System.out.println("편도 이용 요금 " + fee + "원이고, 왕복이용 요금" + sum + "원이며, 한달 20일기준");
		System.out.println("교통비는 총: " + (sum * 20) + "원 입니다.");

	}
}
