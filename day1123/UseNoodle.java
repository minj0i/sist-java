package day1123;

public class UseNoodle {
	public UseNoodle() {
		System.out.println("���� ���̰� �����մϴ�");
	}
	public UseNoodle(int i) {
		this();
		System.out.println("�غ�ƾ�� msg");
	}
	
	public static void main(String[] args) {
		new UseNoodle(22);

		// ��ü ����: heap�� �����ǰ� instance ������ �ڵ� �ʱ�ȭ
		Noodle neoguri = new Noodle();
		// ������ ���������� Person�� heap�� �ּҸ� ������ �ִ�.
		neoguri.setName("�ʱ���");
		neoguri.setCompany("���");
		neoguri.setShape("�����");
		neoguri.setDrysoup(3);
		neoguri.setPrice(700);
		
		
		System.out.format("������ ��� ���� �̸�[%S],�������[%S],��߸��[%S],�Ǵ����������[%d],����[%d]\n",
			neoguri.getName(),neoguri.getCompany(),neoguri.getShape(),neoguri.getDrysoup(),neoguri.getPrice());
		System.out.println(neoguri.sale());
		System.out.println("--------------------------------");
		
		Noodle bibim = new Noodle();
		System.out.format("������ ��� ���� �̸�[%S],�������[%S],��߸��[%S],�Ǵ����������[%d],����[%d]\n",
				bibim.getName(),bibim.getCompany(),bibim.getShape(),bibim.getDrysoup(),bibim.getPrice());
		System.out.println(bibim.sale());
		System.out.println("--------------------------------");
		
		Noodle Jjappa = new Noodle("¥�İ�Ƽ", "����", "����", 3, 900);
		Jjappa.print();
		System.out.println("--------------------------------");
		
		Noodle Ojjam = new Noodle();
		// ������ ���������� Person�� heap�� �ּҸ� ������ �ִ�.
		Ojjam.setName("��¡��«��");
		Ojjam.setCompany("���");
		Ojjam.setShape("�簢��");
		Ojjam.setDrysoup(2);
		Ojjam.setPrice(750);
		
		System.out.format("������ ��� ���� �̸�[%S],�������[%S],��߸��[%S],�Ǵ����������[%d],����[%d]\n",
				Ojjam.getName(),Ojjam.getCompany(),Ojjam.getShape(),Ojjam.getDrysoup(),Ojjam.getPrice());
		System.out.println(Ojjam.sale());
		
		System.out.println("--------------------------------");
		Noodle Shin = new Noodle();
		// ������ ���������� Person�� heap�� �ּҸ� ������ �ִ�.
		Shin.setName("�Ŷ��");
		Shin.setCompany("���");
		Shin.setShape("����");
		Shin.setDrysoup(2);
		Shin.setPrice(600);
		
		System.out.format("������ ��� ���� �̸�[%S],�������[%S],��߸��[%S],�Ǵ����������[%d],����[%d]\n",
				Shin.getName(),Shin.getCompany(),Shin.getShape(),Shin.getDrysoup(),Shin.getPrice());
		System.out.println(Shin.sale());
		System.out.println(Shin.output("����",2));
		
		
		
	}//main

}//class
