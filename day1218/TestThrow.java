package day1218;

import java.util.Random;

/**
 * 예외를 강제로 발생
 * 
 * @author owner
 */
public class TestThrow {

	/**
	 * 길을 가다가 담배를 피우는 학생을 보면 정의사회를 구현한다.
	 */
	public void taeksung() throws Exception {
		String[] grade = { "초등학생", "중학생", "고등학생", "대학생" };
		String randomGd = grade[new Random().nextInt(grade.length)];

		if (randomGd.equals("초등학생")) {
//			try {
			throw new Exception(randomGd + "행님들 금연해야하는 부분인지용?");
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
		} else {
			System.out.println(randomGd + "이 담배를 피우면 모른척 지나간다. (\" )( \")");

		} // end else

	}// taeksung

	public void taeksung2() {
		String[] grade = { "초등학생", "중학생", "고등학생", "대학생" };
		String randomGd = grade[new Random().nextInt(grade.length)];

		if (randomGd.equals("초등학생")) {
			throw new TobaccoException();
		} else {
			System.out.println(randomGd + "이 담배를 피우면 모른척 지나간다. (\" )( \")");

		} // end else

	}// taeksung

	public static void main(String[] args) {
		TestThrow tt = new TestThrow();
		try {
			tt.taeksung();
		} catch (Exception e) {
			e.printStackTrace();
		} // end catch
		System.out.println("--------------------------------------");
			tt.taeksung2();
			//RuntimeException은 try~catch안해줘도 되고 throw로 안날려줘도 됨

	}// main

}// class
