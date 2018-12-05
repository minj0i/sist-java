package day1205;

/**
 * 객체를 생성하지 않고 사용하는 클래스.
 * 
 * @author owner
 */
public class UseMath {
	public UseMath() {
//		Math m = new Math();//생성자 없어서 에러
		int i = -12;
		System.out.println(i + "의 절대값:" + Math.abs(i));
		System.out.println(Math.ceil(10.0));
		System.out.println(Math.round(10.5));// 소수점 이하 첫자리에서
		System.out.println(Math.floor(10.5));// 소수점 이하 첫자리에서

		double d = Math.random();
		System.out.println("발생한 난수 :" + d);
		System.out.println("범위를 설정한 난수 :" + d * 5);
		System.out.println("범위를 설정한 난수에서 정수 :" + (int) (d * 5));// casting이 제일 먼저 되서 괄호로 묶어줘야 함

		// A(65)-Z(90)중 하나의 문자를 반환하는 //a(97)-z(122)
		System.out.println((char) ((int) (d * 26) + 65));

	}// UseMath

	public char[] createPassword() {
		char[] tempPass = new char[8];
		// 영문자대문자(65~90), 소문자(97~122), 숫자(48~57)로 이루어진 임의의 비밀번호 8자리를 생성하여 반환하는일
		for (int i = 0; i < tempPass.length; i++) {
	         int d;
	         while(true) {
	            d = (int) (Math.random() * 122) + 1;
	           
	            if ((d >= 65 && d <= 90) || (d >= 97 && d <= 122) || (d >= 48 && d <= 57)) {
	               break;
	            }//end if
	         }//end while

	         tempPass[i] = (char)d;
	         // 48 65 97
	/* 이대로만 하면 조건에 맞지 않는 값은 null로 놓고 넘어가버리기 때문에 잘못 출력되어서 무한반복문 while을 사용해서 보완
	          * if (d >= 65 && d <= 90) { tempPass[i] = (char)d; }else if (d >= 97 && d <=
	          * 122){ tempPass[i] = (char)d; }else if (d >= 48 && d <= 57) { tempPass[i] =
	          * (char)d; }
	          */
	         System.out.print(tempPass[i]);
		}
		System.out.println("---------");
		
		/////////////////
		char[] num = new char[3];

		for (int j = 0; j < tempPass.length; j++) {
			double n = Math.random();
			num[0] = (char) ((int) (n * 10) + 48);
			num[1] = (char) ((int) (n * 26) + 65);
			num[2] = (char) ((int) (n * 26) + 97);
			double x = (Math.random() * 3);
			tempPass[j] = num[(int) x];
			System.out.print(tempPass[j]);
		}
		System.out.println();
		System.out.println("---------------");

		String flag = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		for (int j = 0; j < tempPass.length; j++) {
			tempPass[j] = flag.charAt((int) (Math.random() * flag.length()));
			System.out.print(tempPass[j]);
		} // end for

		return tempPass;
	}// createPasswrod

	public static void main(String[] args) {
		new UseMath().createPassword();
	}// main

}// class
