package day1129;

import java.util.Arrays;

public class UseSecureArray {

	public static void main(String[] args) {
		SecureArray sa=new SecureArray();
		int[]tempArr=sa.getArr();
		//�迭 ���� ���� �ս��� ��� �ҷ��� Arrays Ŭ����
		tempArr[0]=190;
		System.out.println(Arrays.toString(tempArr));	
		System.out.println("--------------");
		
		int[]tempArr1=sa.getArr();
		System.out.println(Arrays.toString(tempArr1));

		//�ּҰ� �ϳ����� ������ �ٲ� ���� ���� =>secureArray�� temp[]�� �߰��Ͽ�
		//arr�� ��ȯ���� �ʰ� temp�� ��ȯ�ϸ� ��
	}

}
