package day1122;

/**
 * Variable Arguments : 매개변수는 하나인데 인수를 여러개 넣을 수 있는 기능 <br>
 * method 내에서는 배열로 처리된다. <br>
 * 정의) "데이터형 ... 파라메터명" 형식으로 정의
 * 
 * @author owner
 */
public class VariableArguments {

	/**
	 * 동일 데이터형으로 된 인수 값을 여러개 출력 할 때.
	 * 
	 * @param param 가변 인수형
	 */
	public void test(int... param) {
		for (int val : param) {
			System.out.println(val);
		} // end for
		System.out.println("test method called");
	}// test

	/**
	 * 가변 인수를 받기 위한 매개변수는 가장 마지막에서만 쓸 수 있다.
	 * 
	 * @param i 처음 매개변수 int
	 * @param d 두번째 매개변수 double
	 * @param j int...j
	 */
	public void test1(int i, double d, int... j) {
		System.out.println("처음 매개변수: " + i);
		System.out.println("두번째 매개변수: " + d);
		System.out.println("세번째 매개변수: " + j);//배열이기 때문에 참조형으로 주소를 출력
		for (int idx = 0; idx < j.length; idx++) {
			System.out.println(j[idx]);
		}//end for //for문 통해서 실제 값을 출력
	}//end test1
	
	//문자열을 입력받을 수 있는 매개변수로 사용
	public void printName(String name) {
		System.out.println(name+"님 안녕하세요");
	}//printName end
	

	public static void main(String[] args) {
		VariableArguments va = new VariableArguments();
//		va.test(1, 2, 3, 4);
		va.test();// 인자 없는거는 위에있는거 부른 것
		va.test1(1, 3.14, 10, 20, 30, 40, 50, 60); // 세번째는 배열인지라 주소가 나옴
		
		String name ="아! 제가 에ㅂr세ㅂr줌ㅂr 댄스를 16배속으로 추어버렸군요";
		va.printName(name);
		String path="c:\temp\u0000 new.txt";
		System.out.println(path);
		
		System.out.println("");
	}

}
