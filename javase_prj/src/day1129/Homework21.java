package day1129;

public class Homework21 {
	HomeworkData[] copyArr = null;

	public Homework21() {
		// 1. ���� : ��������[] �迭�� = null;
		HomeworkData[] hwArr = null;
		// 2. ����: �迭�� = new ��������[���� ��];
		hwArr = new HomeworkData[7];
		// 3. �� �Ҵ�: �迭��[���� ��ȣ]=new ������();
		// Ŭ������ ��ü��=new ������();
		// �迭��[���ǹ�ȣ]=��ü��;

		hwArr[0] = new HomeworkData("������", "����� ������ ���ﵿ", 28, "����");
		hwArr[1] = new HomeworkData("������", "����� ���빮�� ��ʸ���", 27, "����");
		hwArr[2] = new HomeworkData("������", "������ ���뱸 ���뵿", 26, "����");
		hwArr[3] = new HomeworkData("���ü�", "����� ���α� ���ε�", 27, "����");
		hwArr[4] = new HomeworkData("���ü�", "����� ���۱� �󵵵�", 29, "����");
		hwArr[5] = new HomeworkData("�����", "��⵵ ��õ�� ��õ��", 26, "����");
		hwArr[6] = new HomeworkData("�����", "����� ������ �����絿", 27, "����");

		printArr(hwArr);
	}// HomeworkData �⺻������

	// 1. ���ǰ��� �迭�� �Է��ϴ� method�� �ۼ��Ұ�.
	public void printArr(HomeworkData[] hwArr) {
		copyArr = new HomeworkData[hwArr.length];
		for (int i = 0; i < hwArr.length; i++) {
			copyArr[i] = hwArr[i];
			System.out.println(copyArr[i].getName() + " " + copyArr[i].getAddr() + " " + copyArr[i].getAge() + " "
					+ copyArr[i].getGender());
		} // end for
	} // end

//	2. �迭�� �Էµ� ���� ����ϴ� method �� �ۼ��Ұ�.
//	   2�� method ���� ����ÿ� ��� �ִ� �ο����� ��� �Ұ�.
//	   2�� method ���� ������ ���� ��� �Ұ�.
//	   2�� method ���� ���� ���̰� ���� ����� �̸��� ��� �� ��.
	public void print() {
		int count = 0;
		int sum = 0;
		int max = 0;
		String name = null;
		String gender = null;
		for (int i = 0; i < copyArr.length; i++) {
			if (copyArr[i].getAddr().startsWith("�����") == true) {
				count++;// ����� �ο� ��
				sum = copyArr[i].getAge() + sum; // ������ ��
			}
			if (max < copyArr[i].getAge()) {
				max = copyArr[i].getAge();
				name = copyArr[i].getName();
				gender = copyArr[i].getGender();
			} // �ְ������ �̸��� ������ ����
		}
		System.out.println("����ÿ� �����ϴ� �����: " + count + "�� �Դϴ�");
		System.out.println("������ �հ��: " + sum + "�� �Դϴ�");
		System.out.println("�ְ������ ���̴�:" + max + "�̰� �̸��� " + name + "(" + gender + ")");
	}

	public static void main(String[] args) {
		Homework21 use = new Homework21();
		System.out.println("-------------------");
		use.print();
	}// main
}// class