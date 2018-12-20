package day1123;

/**
 * 마카펜을 대상으로 선정하여, 추상화를 진행하고 만들어진 클래스 <br>
 * 마카펜- 명사적인 특징: 색, 몸체, 뚜껑 =&gt; 변수 <br>
 * 동사적인 특징: 쓴다=&gt; method<br>
 * 
 * 사용법)<br>
 * 		기본생성자를 사용하여 객체를 생성한 후 setter method를
 * 		호출하여 값을 설정한 후 사용한다.
 * 		Marker m = new Marker();
 * 		m.setXxx(값);<br>
 * 
 * class는 사용자정의 자료형, 참조형 데이터형
 * 
 * @author owner
 */
public class Marker {
	private String color;// 마카펜의 색을 저장하는 변수
	private int body;// 마카펜의 몸체의 갯수를 저장하는 변수
	private int cap;// 마카펜의 뚜껑의 갯수를 저장하는 변수

	/**
	 * 기본 생성자로 마카펜 객체가 생성되면 검은색, 뚜껑1개, 몸체 1개인
	 * 마카펜 객체를 생성합니다.<br>
	 * 11-26-2018 코드 추가
	 */
	public Marker() {
		this("검은색", 1, 1); //인자있는 생성자를 호출하여 값 설정. = 중복코드 줄게 됨
		System.out.println("Marker 기본생성자");
//	color="검은색";
//	body=1;
//	cap=1;
	}//Marker
	
	/**
	 * 인자 있는 생성자 - 검은색, 뚜껑과 몸체가 1개가 아닌 마카펜을
	 * 생성할때 사용하는 생성자.<br> 
	 * 색, 뚜껑의 수, 몸체의 수를 입력받아 마카펜을 
	 * 생성하는 생성자. 
	 * @param color 마카펜의 색
	 * @param cap 마카펜의 뚜껑
	 * @param body 마카펜의 몸체
	 */
	public Marker(String color, int cap, int body) {
		this.color=color;
		this.cap=cap;
		this.body=body;
		System.out.println("Marker 매개변수 있는 생성자");
	}//Marker
	
	/**
	 * 생성된 마카펜객체의 색을 설정하는 일. 검은색, 파란색, 빨간색만 설정한다. 그 이외의 색은 검은색으로 처리한다.
	 * 
	 * @param color 설정할 색
	 */
	public void setColor(String color) {
		//인스턴스 변수에 설정될 값에 대한 검증 수행.
		if (!(color.equals("검은색") || color.equals("파란색") || color.equals("빨간색"))) {
			color = "검은색";
		}//end if
		this.color = color;
	}//setColor

	/**
	 * 생성된 마카펜객체의 몸체 갯수를 설정하는 일.
	 * @param body 몸체의 갯수
	 */
	public void setBody(int body) {
		this.body = body;
	}//setBody
	
	/**
	 * 생성된 마카펜의 객체의 뚜껑 갯수를 설정하는 일.
	 * @param cap 뚜껑의 수
	 */
	public void setCap(int cap) {
		this.cap=cap;
	}//setCap
	
	/**
	 * 생성된 마카펜 객체가 가지고 있는 색을 반환하는 일
	 * @return 색
	 */
	public String getColor() {
		return color;
	}//get color
	
	/**
	 * 생성된 마카펜 객체가 가지고 있는 몸체의 갯수
	 * @return 몸체의 갯수
	 */
	public int getBody() {
		return body;
	}//get Body
	
	/**
	 * 생성된 마카펜 객체가 가지고 있는 뚜껑의 갯수
	 * @return 뚜껑의 갯수
	 */
	public int getCap() {
		return cap;
	}//get Cap
	
	/**
	 * 생성된 메세지를 생성된 마카펜으로 칠판에 쓰는 일.
	 * @param msg 칠판에 쓸 메세지
	 * @return 결과
	 */
	public String write(String msg) {
		return color+"인 마카펜으로 칠판에 \""+msg+"\""+"를 쓴다";
	}//write
}// class
