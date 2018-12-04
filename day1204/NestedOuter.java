package day1204;

/**
 * ����Ŭ������ static ����ó�� ����� �� �ִ�
 * @author owner
 */
public class NestedOuter {
	int i;
	static int j;
	public NestedOuter() {
		System.out.println("�ٱ� Ŭ������ ������");
	}//NestedOuter
	
	public void outInstMethod() {
		System.out.println("�ٱ� Ŭ������ �ν��Ͻ� method");
	}//outInstMethod
	
	public static void outStatMethod() {
		System.out.println("�ٱ� Ŭ������ static method");
	}//outInstMethod
	
	///////////////////Nested class ���� //////////////////
	static class NestedInner{
		int in_i;//instance����
		static int in_j;//static����
		//public Nested Inner(){
		//	}
		public void inMethod() {
			System.out.println("���� Ŭ������ �ν��Ͻ� method");
		}//inMethod
		
		public static void inStatMethod() {
			System.out.println("���� Ŭ������ static method");
			System.out.println("�ٱ� Ŭ������ �ڿ� ���.i�»��Ұ�, j="+NestedOuter.j);
//			OutInstMethod();//instance������ method�̹Ƿ� ����� �� ����.
			NestedOuter.outStatMethod();
			
		}//inStatMethod
	}//class
	///////////////////Nested class �� //////////////////
	public static void main(String[] args) {
		//static������ ����Ҷ����� ��üȭ���� Ŭ������.������,
		//Ŭ������.method������ ����Ѵ�.
		NestedInner.inStatMethod();
	}//main

}//class
