package day1123;

public class UseNoodle {
	public UseNoodle() {
		System.out.println("물을 끓이고 시작합니다");
	}
	public UseNoodle(int i) {
		this();
		System.out.println("준비됐어요 msg");
	}
	
	public static void main(String[] args) {
		new UseNoodle(22);

		// 객체 생성: heap에 생성되고 instance 변수는 자동 초기화
		Noodle neoguri = new Noodle();
		// 참조형 데이터형인 Person은 heap의 주소를 가지고 있다.
		neoguri.setName("너구리");
		neoguri.setCompany("농심");
		neoguri.setShape("별모양");
		neoguri.setDrysoup(3);
		neoguri.setPrice(700);
		
		
		System.out.format("생성된 라면 정보 이름[%S],제조사명[%S],면발모양[%S],건더기수프갯수[%d],가격[%d]\n",
			neoguri.getName(),neoguri.getCompany(),neoguri.getShape(),neoguri.getDrysoup(),neoguri.getPrice());
		System.out.println(neoguri.sale());
		System.out.println("--------------------------------");
		
		Noodle bibim = new Noodle();
		System.out.format("생성된 라면 정보 이름[%S],제조사명[%S],면발모양[%S],건더기수프갯수[%d],가격[%d]\n",
				bibim.getName(),bibim.getCompany(),bibim.getShape(),bibim.getDrysoup(),bibim.getPrice());
		System.out.println(bibim.sale());
		System.out.println("--------------------------------");
		
		Noodle Jjappa = new Noodle("짜파게티", "몰라", "원형", 3, 900);
		Jjappa.print();
		System.out.println("--------------------------------");
		
		Noodle Ojjam = new Noodle();
		// 참조형 데이터형인 Person은 heap의 주소를 가지고 있다.
		Ojjam.setName("오징어짬뽕");
		Ojjam.setCompany("농심");
		Ojjam.setShape("사각형");
		Ojjam.setDrysoup(2);
		Ojjam.setPrice(750);
		
		System.out.format("생성된 라면 정보 이름[%S],제조사명[%S],면발모양[%S],건더기수프갯수[%d],가격[%d]\n",
				Ojjam.getName(),Ojjam.getCompany(),Ojjam.getShape(),Ojjam.getDrysoup(),Ojjam.getPrice());
		System.out.println(Ojjam.sale());
		
		System.out.println("--------------------------------");
		Noodle Shin = new Noodle();
		// 참조형 데이터형인 Person은 heap의 주소를 가지고 있다.
		Shin.setName("신라면");
		Shin.setCompany("농심");
		Shin.setShape("원형");
		Shin.setDrysoup(2);
		Shin.setPrice(600);
		
		System.out.format("생성된 라면 정보 이름[%S],제조사명[%S],면발모양[%S],건더기수프갯수[%d],가격[%d]\n",
				Shin.getName(),Shin.getCompany(),Shin.getShape(),Shin.getDrysoup(),Shin.getPrice());
		System.out.println(Shin.sale());
		System.out.println(Shin.output("원형",2));
		
		
		
	}//main

}//class
