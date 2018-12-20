package day1123;

/**
 * 사람을 추상화하여 만든 Person 클래스를 사용하는 클래스
 * @author owner
 */
public class UsePerson {

	public static void main(String[] args) {
		//객체 생성: heap에 생성되고 instance 변수는 자동 초기화
		Person taecksung = new Person();
		//참조형 데이터형인 Person은 heap의 주소를 가지고 있다.
		System.out.println("객체를 출력하면 주소가 출력 "+taecksung);
		taecksung.setName("정택성");
//		taecksung.setEye(2);
//		taecksung.setNose(1);
//		taecksung.setMouth(1);
		
		System.out.format("생성된 사람 객체 정보 눈[%d],코[%d],입[%d],이름[%s]\n",
				taecksung.getEye(),taecksung.getNose(),taecksung.getMouth(),taecksung.getName());
		//생성된 객체에서 정의된 일을 사용.
		System.out.println(taecksung.eat());
		System.out.println(taecksung.eat("육회비빔밥", 8000));
		
		System.out.println("-----------------------------------");
		Person jinban=new Person(3,1,1);
		jinban.setName("천진반");
//		jinban.setEye(3);
//		jinban.setNose(1);
//		jinban.setMouth(1);
		
		System.out.format("생성된 사람 객체 정보 눈[%d],코[%d],입[%d],이름[%s]\n",
				jinban.getEye(),jinban.getNose(),jinban.getMouth(),jinban.getName());
		System.out.println(jinban.eat());
		System.out.println(jinban.eat("선두",1));
	}//main

}//class
