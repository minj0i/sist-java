package day1127;

/**
 * 1���� �迭: ���ϳ��� ���θ� ������ �迭<br>
 * �迭 - �޸𸮿� ���ϵ����������� ������ ��������<br>
 * ������ ��������, �������� ��<br>
 * �ϰ�ó���� ��� .<br>
 * ���� ���� ��� (�迭��.length)
 * 
 * @author owner
 */
public class UseArray1 {

	/**
	 * 1���� �迭�� ������ �������� ���
	 */
	public UseArray1() {
//		System.out.println("������");
	}// UseArray1

	public void method() {
//		System.out.println("method");
		// 1. �迭 ����) ��������[] �迭�� = null;
		int[] arr = null;
		//2. �迭 ����) �迭�� = new ��������[���ǰ���];
		arr = new int[6];
		//����� ����) ��������[] �迭�� = new ��������[���� ����];
		int[] arr1 = new int[8];
		System.out.println(arr + "/"+arr1);
		
		System.out.println("arr�迭 ���� ���� "+arr.length+", arr1�迭 ���� ����: "+arr1.length);
		
		//3. ���Ҵ�) �迭��[���� �ε���]=��;
		arr[0]=11;
		arr[1]=27;
		arr[2]=14;
		arr[3]=46;
		//4. �� ���)
		System.out.printf("arr[0]=%d,arr[1]=%d,arr[2]=%d,arr[3]=%d\n", arr[0], arr[1], arr[2], arr[3]);
		System.out.println("arr[5]="+arr[5]);
		System.out.println("-------------------------------------------");
		//�ϰ�ó��
		for(int i=0; i<arr.length; i++) {
			System.out.printf("arr[%d]=%d\n", i, arr[i]);
		}
	}// method

	/**
	 * 1���� �迭�� �⺻������ ���. new ���x
	 */
	public void arrayPrimitive() {
		System.out.println("-----------------------");
		//1. ���� : ��������[] �迭��={��......};
		int[]arr = {2018,11,27,15,20};
		System.out.println("���� ��: "+arr.length);
		int[]arr1 = new int[] {1,2,3,4,5,6,7}; //���� ������ �����ϸ� ����
		System.out.println("���� ��: "+arr1.length);
		
		arr[0]=2019;
		System.out.println(arr[0]+"/"+arr[1]);
		
		for(int i=0; i< arr.length; i++) {
			System.out.println("arr["+i+"]="+arr[i]);
		}//end for
		
		//���� for : �迭�̳� Collection(List, Set)�� ó�� ����� �������
		//��� ���� ���� ���������� �ս��� ��� �� ��
		/*
		 * for(�迭���� ���� ������ ����: �迭){
		 * ������
		 * }
		 */
		for(int value : arr1) {
			System.out.println(value);
		}//end for
		
		System.out.println("--------");
		//arr1�迭�� ����������� ó�� ����� ���
		int i = arr.length-1;
		for (int j=0; j<arr.length; j++) {
			System.out.print("arr["+i+"]="+arr[i]+" ");
			i=i-1;
		}
		
	}//arrayPrimitive
	public static void main(String[] args) {
		new UseArray1().arrayPrimitive();
	}// main

}// class
