package day1122;

/**
 * 숙제20
 * 아래의 업무를 처리하는 method를 type에 알맞게 작성하고 API주석을<br>
 * 설정한 후 호출하여 결과를 본 후 Java Doc을 생성해보세요.<br>
 * - API주석은 어떤 형태의 method인지를 주석으로 기술할것.
 * @author owner
 */
public class Homework20 {
//	1. 자신의 이름을 반환하는 method작성. (고정 값 - 반환형O, String, 매개변수 X)
//	2. 나이를 입력받아 태어난 해를 반환하는  method 작성. (가변값 -반환형 O int, 매개변수 O, int)
//	3. 문자를 입력받아 해당 문자의 Unicode 값을 반환하는 method 작성. (가변값 - 반환형 O int, 매개변수 O char)
//	4. 숫자를 입력받아 숫자가  영문자, 숫자의 범위에 있을 때 해당 숫자의
//	    문자를  출력하는 일을 하는 method  작성 (가변 일 - 반환형 O void, 매개변수 O int)
//	5. 호출하면 자신의 주소를 출력하는  method 작성. (고정 일 - 반환형X, 매개변수 X)
//	6. 친구의 이름을 입력받아 출력하는  method 작성(친구는 n명 입니다.) (가변 일 - 반환형 X , 매개변수 O Variable Arguments)
	

	/**
	 * 반환형 있고 매개변수 없는 형- 같은 일을 수행<br>
	 * @return 이름
	 */
	public String type1() {
		return "김민정"; 
	}// type1
	
//	/**
//	 * 반환형 없고 매개변수 있는 형-가변 일<br>
//	 * 
//	 * @param i 출력하고 싶은(=태어난 해) 값
//	 */
//	public void type2(int y) {
//		int i= (2018-y+1);
//		System.out.println("태어난 해: "+i);
//	}// type2
	
	/**
	 * 반환형있고, 매개변수 있는 형 - 가변 값
	 * 
	 * @param age 태어난 해를 계산하고 싶은 나이<br>
	 * @return 태어난 해
	 */
	public int type2(int age) {
		int i = 2018-age+1;
		System.out.println("태어난 해: " + i);
		return i;
	}// type2
	
	/**
	 * 반환형있고, 매개변수 있는 형 - 가변 값
	 * 
	 * @param c 입력받은 문자
	 * @return 유니코드로 변환된 숫자
	 */
	public int type3(char c) {
		int i = (int)c;
		System.out.println(c+ "의 유니코드 : "+ i);
		return i;
	}// type3
	
	
	/**
	 * 반환형있고, 매개변수 있는 형 - 가변 값
	 * 
	 * @param number 입력받은 문자
	 * @return 유니코드로 변환된 숫자
	 */
	public char type4(int number) {
		char j = (char)number;
		if ((j<='z'&& j>='a')||(j<='Z'&& j>='A')||(j>='0'&& j<='9')) {
		System.out.println(number+ "의 유니코드: "+ j);
		}else {
			System.out.println("문자열 범위에 있지 않습니다");
		}
		return j;
	}// type4
	
	/**
	 * 동일 데이터형으로 된 인수 값을 출력 할 때
	 * @param classaddress 자신의 주소를 불러올 값
	 */
	public void type5(Homework20 classaddress) {
		System.out.println("호출당한 것의 주소: "+classaddress);
	}//end type5
	
	
	/**
	 * 
	 * @param count 친구의 이름
	 */
	public void type6(String... count) {
		int idx = count.length;
		System.out.println("친구들의 숫자는 "+idx+"명 입니다");
		System.out.print("친구들의 이름은 ");
		for (int j = 0; j < count.length; j++) {
			System.out.print(count[j]+" ");
		}//end for
		System.out.print("입니다");
	}

	
	public static void main(String[] args) {
		Homework20 hw=new Homework20();
		// 1. 고정 이름 method 호출
		String name = hw.type1();//자신의 이름을 반환하는 method작성.
		System.out.println("이름은 " +name);
		//2.가변 값 method 호출 - 나이를 입력
		hw.type2(28);
		
		//3. 가변 값 method 호출 - 문자를 입력
		hw.type3('a');
		
		//4. 가변 값 method 호출 - 숫자를 입력
		hw.type4(92);
		
		//5. 고정 일 method 호출 - 자신의 주소를 출력
		hw.type5(hw);

		//6. 가변 일 method 호출 - 친구들의 숫자를 출력
		hw.type6("김민정", "박은영");		
	}

}
