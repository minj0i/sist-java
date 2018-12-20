package day1205;

public class UseCurrentTime {

	public void test() {
		long st = System.currentTimeMillis();
		long sum = 0;
		for (int i = 0; i < 5000; i++) {
			sum = sum + i;
		}
		long et = System.currentTimeMillis();
		System.out.println((et - st) + "ms");
	}// test

	public static void main(String[] args) {
		UseCurrentTime uct = new UseCurrentTime();
		long[] avgTime = new long[17];
		long st = 0, et = 0;
		for (int i = 0; i < avgTime.length; i++) {
			st = System.currentTimeMillis();
			uct.test();
			et = System.currentTimeMillis();
			System.out.println((et - st) + "ms");
			avgTime[i] = (et - st);
		}
	}
}
