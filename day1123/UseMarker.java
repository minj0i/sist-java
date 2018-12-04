package day1123;

/**
 * 마카펜을 구현한 클래스를 사용하는 클래스<br>
 * 4. 객체생성<br>
 * 5. 생성된 객체 사용.
 * @author owner
 */
public class UseMarker {

	public static void main(String[] args) {
		//검은색 마카펜 1개 생성
		Marker black = new Marker();
//		black.setColor("검은색");
//		black.setCap(1);
//		black.setBody(1);
		
		System.out.printf("생성된 마카펜 색:[%s], 뚜껑[%d], 몸체[%d]\n", black.getColor(), black.getCap(), black.getBody());
		//생성된 객체의 사용
		System.out.println(black.write("안녕하세요"));
		System.out.println("===================================");
		Marker red = new Marker("빨간색", 5, 5);
//		red.color="흰색"; //접근지정자가 pu\blic이라면 외부에서 값을
		//직접 설정할 수 있으므로 잘못된 값이 입력될 수 있다.
		//private으로 주고 method를 통해서만 값 입력(캡슐화)
//		red.setColor("흰색");
//		red.setCap(5);
//		red.setBody(5);
		
		System.out.printf("생성된 마카펜 색:[%s], 뚜껑[%d], 몸체[%d]\n", red.getColor(), red.getCap(), red.getBody());
		//생성된 객체의 사용
		System.out.println(red.write("빨간맛"));		
		
		
	}//main

}//class
