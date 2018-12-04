package day1127;

public class ssnTest {
	String ssn;

	// 1-1. 생성자는 주민번호를 받아 instance변수에 할당한다.
	public ssnTest(String ssn) {
		this.ssn = ssn;
	}

	// 1-2. 주민번호의 길이체크하여 14자가 아니면 false 반환
	private boolean validLength() {
		boolean flag = false;
		if (ssn.length() == 14) {
			flag = true;
		}
		return flag;
	}

	// 1-3. 주민번호의 6번째 자리가 - 이 아니면 false 반환
	private boolean sixIndex() {
		boolean flag = false;
		flag = (ssn.charAt(6) == '-');
		return flag;
	}

	// 1-4. 주민번호의 유효성 검증 :
	private boolean valiSsn() {
		int[] ssnArr = new int[13];
		int sum = 0;
		String newssn = ssn.replaceAll("-", "");
		for (int i = 0; i < 13; i++) {
			ssnArr[i] = newssn.charAt(i) - 48;
		}
		for (int j = 0; j < 12; j++) {
			if (j < 8)
				ssnArr[j] = ssnArr[j] * (j + 2);
			else
				ssnArr[j] = ssnArr[j] * (j - 6);

			sum += ssnArr[j];// 각 자리에 곱한값을 더함
		}
		sum = (11 - (sum % 11)) % 10;

		return (sum == ssnArr[12]);
	}//

	// 1-5. 생년월일 반환하는 일 "1988-11-11"
	private String birthday() {
		String birth = ssn.substring(0, 2);

		switch (ssn.charAt(7)) {
		case '0':
		case '9':
			birth = "18" + birth;
			break;
		case '1':
		case '2':
		case '5':
		case '6':
			birth = "19" + birth;
			break;
		case '3':
		case '4':
		case '7':
		case '8':
			birth = "20" + birth;
			break;
		}
		birth = birth + "-" + ssn.substring(2, 4) + "-" + ssn.substring(4, 6);

		return birth;
	}

	// 1-6. 나이를 반환하는 일 31
	private int age() {
		int age = 0;
		String year = birthday().substring(0, 4);
		age = 2018 - Integer.valueOf(year) + 1;

		return age;
	}

	// 1-7. 성별을 반환 남/여
	private String gender() {
		String gender = null;
		if (ssn.charAt(7) % 2 == 1) {
			gender = "남";
		} else {
			gender = "여";
		}
		return gender;
	}

	// 1-8. 내국인/외국인 반환 내국인:012349 외국인:5678
	private String foreigner() {
		String foreigner = null;

		switch (ssn.charAt(7)) {
		case '0':
		case '1':
		case '2':
		case '3':
		case '4':
		case '9':
			foreigner = "내국인";
			break;
		default:
			foreigner = "외국인";
			break;
		}
		return foreigner;
	}

//1-9. 띠를 반환 : "양띠"
	private String zodiac() {
		String year = birthday().substring(0, 4);
		String[] zodiac ={"원숭이띠", "닭띠", "개띠", "돼지띠",
						"쥐띠","소띠", "호랑이띠", "토끼띠", "용띠", "뱀띠", "말띠", "양띠"}; 
		int ck = Integer.valueOf(year) % 12;
		return zodiac[ck];
	}

	public static void main(String[] args) {
//		String ssn = "910309-2013011";
//		ssnTest st1 = new ssnTest(ssn);// 1-1

//		String ssn = "930111-1009515";
//		ssnTest st = new ssnTest(ssn);

		String ssn = "930321-2013016";
		ssnTest st = new ssnTest(ssn);

		// 1-2
		if (st.validLength()) {
			// 1-3.
			if (st.sixIndex()) {
				// 1-4.
				if (st.valiSsn()) {
					System.out.println("생년월일: " + st.birthday());// 1-5
					System.out.println("나이: " + st.age());// 1-6
					System.out.println("성별: " + st.gender());// 1-7
					System.out.println("내/외국인 구분: " + st.foreigner());// 1-8
					System.out.println("12간지: " + st.zodiac());// 1-9
				} else {
					System.out.println("주민번호가 유효성 검증을 넘기지 못했습니다");
				}
			} else {
				System.out.println("주민번호의 6번째에-가 없습니다");
			}
		} else {
			System.out.println("주민번호가 14자리가 아닙니다");

		}

	}

}
