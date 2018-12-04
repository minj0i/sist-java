package day1122;

/**
 * 다형성: method Overload <br>
 * 하나의 클래스에서 같은 이름의 method를 여러개 작성하는 것.<br>
 * 규칙) 접근지정자 반환형 method명은 같게 만들고, 반환형만 다르게 작성.
 * 
 * @author owner
 */
public class TestOverload {

	/**
	 * ★을 하나 출력하는 일
	 */
	public void printStar() {
		System.out.println("★");
	}// printStar

	/**
	 * 입력되는 값에 따라 ☆을 여러개 출력하는 일
	 * 
	 * @param count 출력할 별의 갯수
	 */
	public void printStar(int count) {
		for (int i = 0; i < count; i++) {
			System.out.print("☆");
		} // end for
	}// printStar

	public void gugudan() {
		int i = 3, j = 0;
		for (j = 1; j < 10; j++) {
			System.out.print(i + "*" + j + "=" + (i * j) + " ");
		} // end for
	}// end gugudan

	public void gugudan(int dan) {
		if (dan >= 2 && dan <= 9) {
			do {
				for (int j = 1; j < 10; j++) {
					System.out.print(dan + "*" + j + "=" + (dan * j) + " ");
				} // end for
				System.out.println(" ");
				dan++;
			} while (dan < 10);
		} // end if
	}// end gugudan(int dan)

	public static void main(String[] args) {
		TestOverload to = new TestOverload();
		// 별 한개 출력
		to.printStar();
		// 별 여러개 출력
		to.printStar(5);

		System.out.println("------------3단-------------");
		// 구구단 3단을 출력하는 method
		to.gugudan();
		System.out.println();
		System.out.println("------------입력하는 단부터 9단까지------------");
		// 입력하는 단이 2~9단 사이일때 해당 단부터 9단까지를 출력하는 method
		to.gugudan(4);
	}// main

}// class
