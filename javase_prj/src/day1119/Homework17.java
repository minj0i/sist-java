package day1119;

public class Homework17 {

	public static void main(String[] args) {
		/*
		 * ���� 1. ����� �ð��� �Է¹޾� �Ʒ��� �������� ����ϼ���. ��� : ����� �ð��� �ִ� 2�ð��� ������ ������ 60���� �Ѵ� �ٸ�
		 * "��Ÿ�/7H�־�" 60�� ���϶�� "�ܰŸ�"�� ����ϼ���.
		 */
		int a = Integer.parseInt(args[0]);

		if (a <= 120) {
			if (a <= 60) {
				System.out.println("�ܰŸ�");
			} else if (a > 60) {
				System.out.println("��Ÿ�, 7H�־�");
			}
		} else {
			System.out.println("2�ð� �ʰ�");
		}

		/*
		 * 2. �̸�, ������ܰ� ����� �Ÿ��� �Է¹޾� �Ʒ��� ���� ����ϼ���. ��������� "����,����ö,�ý�,����"�� �����Ѵ�. �������
		 * 1200��, ����ö ��� 1250��, �ýÿ�� 3800�� �Դϴ�. ����� 10Ű�� ������ �⺻���, �� 5Ű�� �ʰ��� ���� 100���� ����
		 * �մϴ�.
		 * 
		 * ��� : xxx�� ����� ��������� xx�̸� �Ÿ��� xx Ű�� �Դϴ�. �� �̿� ��� xx���̰�, �պ��̿� ��� xx���̸�, �Ѵ�
		 * 20�ϱ��� ������ ��: xxxx�� �Դϴ�.
		 */

		String name = args[1];
		String trp = args[2];
		int dis = Integer.parseInt(args[3]);

		int fee = 0;
		switch (trp) {
		case "����":	fee = 1200; break;
		case "����ö":fee = 1250; break;
		case "�ý�": fee = 3800; 	break;
		default: fee = 0;
		}// switch~case end

		int sum = 0;
		int add = (dis - 10) / 5;
		if (dis >= 10) {
			sum = fee + add * 100;
		} // if end

		System.out.println(name + "�� ����� ��������� " + trp + "�̸� �Ÿ��� " + dis + "Ű�� �Դϴ�.");
		System.out.println("�� �̿� ��� " + fee + "���̰�, �պ��̿� ���" + sum + "���̸�, �Ѵ� 20�ϱ���");
		System.out.println("������ ��: " + (sum * 20) + "�� �Դϴ�.");

	}
}
