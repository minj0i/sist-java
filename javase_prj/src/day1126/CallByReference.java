package day1126;

/**
 * method의 매개변수가 참조형데이터형(class, 문자열, array)인 경우
 * arguments를 넣으면 하나의 주소가 할당된다.
 * (값을 변경하면 생성된 객체가 가진 값이 변경된다.)
 * @author owner
 */
public class CallByReference {
	private int i;
	private int j;
	
	public void swap(CallByReference cbr) {//주소가 그대로 전달된다
		int temp=0;
		temp=cbr.i;
		cbr.i=cbr.j;
		cbr.j=temp;
		System.out.println("swap method 내 i="+i+",j="+j);
	}
	public static void main(String[] args) {
		CallByReference cbr= new CallByReference();
		cbr.i=11;
		cbr.j=26;
		System.out.println("swap 전의 i="+cbr.i+",j="+cbr.j);
		cbr.swap(cbr);//주소가 그대로 전달된다
		System.out.println("swap 후의 i="+cbr.i+",j="+cbr.j);
	}

}
