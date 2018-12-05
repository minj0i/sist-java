package day1205;

/**
 * ��ü�� �������� �ʰ� ����ϴ� Ŭ����.
 * 
 * @author owner
 */
public class UseMath {
	public UseMath() {
//		Math m = new Math();//������ ��� ����
		int i = -12;
		System.out.println(i + "�� ���밪:" + Math.abs(i));
		System.out.println(Math.ceil(10.0));
		System.out.println(Math.round(10.5));// �Ҽ��� ���� ù�ڸ�����
		System.out.println(Math.floor(10.5));// �Ҽ��� ���� ù�ڸ�����

		double d = Math.random();
		System.out.println("�߻��� ���� :" + d);
		System.out.println("������ ������ ���� :" + d * 5);
		System.out.println("������ ������ �������� ���� :" + (int) (d * 5));// casting�� ���� ���� �Ǽ� ��ȣ�� ������� ��

		// A(65)-Z(90)�� �ϳ��� ���ڸ� ��ȯ�ϴ� //a(97)-z(122)
		System.out.println((char) ((int) (d * 26) + 65));

	}// UseMath

	public char[] createPassword() {
		char[] tempPass = new char[8];
		// �����ڴ빮��(65~90), �ҹ���(97~122), ����(48~57)�� �̷���� ������ ��й�ȣ 8�ڸ��� �����Ͽ� ��ȯ�ϴ���
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
	/* �̴�θ� �ϸ� ���ǿ� ���� �ʴ� ���� null�� ���� �Ѿ������ ������ �߸� ��µǾ ���ѹݺ��� while�� ����ؼ� ����
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
