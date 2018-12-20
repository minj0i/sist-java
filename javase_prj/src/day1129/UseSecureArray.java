package day1129;

import java.util.Arrays;

public class UseSecureArray {

	public static void main(String[] args) {
		SecureArray sa=new SecureArray();
		int[]tempArr=sa.getArr();
		//배열 방의 값을 손쉽게 출력 할려면 Arrays 클래스
		tempArr[0]=190;
		System.out.println(Arrays.toString(tempArr));	
		System.out.println("--------------");
		
		int[]tempArr1=sa.getArr();
		System.out.println(Arrays.toString(tempArr1));

		//주소가 하나여서 위에서 바뀐 값이 나옴 =>secureArray에 temp[]를 추가하여
		//arr를 반환하지 않고 temp를 반환하면 됨
	}

}
