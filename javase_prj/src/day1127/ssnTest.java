package day1127;

public class ssnTest {
	String ssn;

	// 1-1. �����ڴ� �ֹι�ȣ�� �޾� instance������ �Ҵ��Ѵ�.
	public ssnTest(String ssn) {
		this.ssn = ssn;
	}

	// 1-2. �ֹι�ȣ�� ����üũ�Ͽ� 14�ڰ� �ƴϸ� false ��ȯ
	private boolean validLength() {
		boolean flag = false;
		if (ssn.length() == 14) {
			flag = true;
		}
		return flag;
	}

	// 1-3. �ֹι�ȣ�� 6��° �ڸ��� - �� �ƴϸ� false ��ȯ
	private boolean sixIndex() {
		boolean flag = false;
		flag = (ssn.charAt(6) == '-');
		return flag;
	}

	// 1-4. �ֹι�ȣ�� ��ȿ�� ���� :
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

			sum += ssnArr[j];// �� �ڸ��� ���Ѱ��� ����
		}
		sum = (11 - (sum % 11)) % 10;

		return (sum == ssnArr[12]);
	}//

	// 1-5. ������� ��ȯ�ϴ� �� "1988-11-11"
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

	// 1-6. ���̸� ��ȯ�ϴ� �� 31
	private int age() {
		int age = 0;
		String year = birthday().substring(0, 4);
		age = 2018 - Integer.valueOf(year) + 1;

		return age;
	}

	// 1-7. ������ ��ȯ ��/��
	private String gender() {
		String gender = null;
		if (ssn.charAt(7) % 2 == 1) {
			gender = "��";
		} else {
			gender = "��";
		}
		return gender;
	}

	// 1-8. ������/�ܱ��� ��ȯ ������:012349 �ܱ���:5678
	private String foreigner() {
		String foreigner = null;

		switch (ssn.charAt(7)) {
		case '0':
		case '1':
		case '2':
		case '3':
		case '4':
		case '9':
			foreigner = "������";
			break;
		default:
			foreigner = "�ܱ���";
			break;
		}
		return foreigner;
	}

//1-9. �츦 ��ȯ : "���"
	private String zodiac() {
		String year = birthday().substring(0, 4);
		String[] zodiac ={"�����̶�", "�߶�", "����", "������",
						"���","�Ҷ�", "ȣ���̶�", "�䳢��", "���", "���", "����", "���"}; 
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
					System.out.println("�������: " + st.birthday());// 1-5
					System.out.println("����: " + st.age());// 1-6
					System.out.println("����: " + st.gender());// 1-7
					System.out.println("��/�ܱ��� ����: " + st.foreigner());// 1-8
					System.out.println("12����: " + st.zodiac());// 1-9
				} else {
					System.out.println("�ֹι�ȣ�� ��ȿ�� ������ �ѱ��� ���߽��ϴ�");
				}
			} else {
				System.out.println("�ֹι�ȣ�� 6��°��-�� �����ϴ�");
			}
		} else {
			System.out.println("�ֹι�ȣ�� 14�ڸ��� �ƴմϴ�");

		}

	}

}
