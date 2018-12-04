package day1122;

/**
 * ����20
 * �Ʒ��� ������ ó���ϴ� method�� type�� �˸°� �ۼ��ϰ� API�ּ���<br>
 * ������ �� ȣ���Ͽ� ����� �� �� Java Doc�� �����غ�����.<br>
 * - API�ּ��� � ������ method������ �ּ����� ����Ұ�.
 * @author owner
 */
public class Homework20 {
//	1. �ڽ��� �̸��� ��ȯ�ϴ� method�ۼ�. (���� �� - ��ȯ��O, String, �Ű����� X)
//	2. ���̸� �Է¹޾� �¾ �ظ� ��ȯ�ϴ�  method �ۼ�. (������ -��ȯ�� O int, �Ű����� O, int)
//	3. ���ڸ� �Է¹޾� �ش� ������ Unicode ���� ��ȯ�ϴ� method �ۼ�. (������ - ��ȯ�� O int, �Ű����� O char)
//	4. ���ڸ� �Է¹޾� ���ڰ�  ������, ������ ������ ���� �� �ش� ������
//	    ���ڸ�  ����ϴ� ���� �ϴ� method  �ۼ� (���� �� - ��ȯ�� O void, �Ű����� O int)
//	5. ȣ���ϸ� �ڽ��� �ּҸ� ����ϴ�  method �ۼ�. (���� �� - ��ȯ��X, �Ű����� X)
//	6. ģ���� �̸��� �Է¹޾� ����ϴ�  method �ۼ�(ģ���� n�� �Դϴ�.) (���� �� - ��ȯ�� X , �Ű����� O Variable Arguments)
	

	/**
	 * ��ȯ�� �ְ� �Ű����� ���� ��- ���� ���� ����<br>
	 * @return �̸�
	 */
	public String type1() {
		return "�����"; 
	}// type1
	
//	/**
//	 * ��ȯ�� ���� �Ű����� �ִ� ��-���� ��<br>
//	 * 
//	 * @param i ����ϰ� ����(=�¾ ��) ��
//	 */
//	public void type2(int y) {
//		int i= (2018-y+1);
//		System.out.println("�¾ ��: "+i);
//	}// type2
	
	/**
	 * ��ȯ���ְ�, �Ű����� �ִ� �� - ���� ��
	 * 
	 * @param age �¾ �ظ� ����ϰ� ���� ����<br>
	 * @return �¾ ��
	 */
	public int type2(int age) {
		int i = 2018-age+1;
		System.out.println("�¾ ��: " + i);
		return i;
	}// type2
	
	/**
	 * ��ȯ���ְ�, �Ű����� �ִ� �� - ���� ��
	 * 
	 * @param c �Է¹��� ����
	 * @return �����ڵ�� ��ȯ�� ����
	 */
	public int type3(char c) {
		int i = (int)c;
		System.out.println(c+ "�� �����ڵ� : "+ i);
		return i;
	}// type3
	
	
	/**
	 * ��ȯ���ְ�, �Ű����� �ִ� �� - ���� ��
	 * 
	 * @param number �Է¹��� ����
	 * @return �����ڵ�� ��ȯ�� ����
	 */
	public char type4(int number) {
		char j = (char)number;
		if ((j<='z'&& j>='a')||(j<='Z'&& j>='A')||(j>='0'&& j<='9')) {
		System.out.println(number+ "�� �����ڵ�: "+ j);
		}else {
			System.out.println("���ڿ� ������ ���� �ʽ��ϴ�");
		}
		return j;
	}// type4
	
	/**
	 * ���� ������������ �� �μ� ���� ��� �� ��
	 * @param classaddress �ڽ��� �ּҸ� �ҷ��� ��
	 */
	public void type5(Homework20 classaddress) {
		System.out.println("ȣ����� ���� �ּ�: "+classaddress);
	}//end type5
	
	
	/**
	 * 
	 * @param count ģ���� �̸�
	 */
	public void type6(String... count) {
		int idx = count.length;
		System.out.println("ģ������ ���ڴ� "+idx+"�� �Դϴ�");
		System.out.print("ģ������ �̸��� ");
		for (int j = 0; j < count.length; j++) {
			System.out.print(count[j]+" ");
		}//end for
		System.out.print("�Դϴ�");
	}

	
	public static void main(String[] args) {
		Homework20 hw=new Homework20();
		// 1. ���� �̸� method ȣ��
		String name = hw.type1();//�ڽ��� �̸��� ��ȯ�ϴ� method�ۼ�.
		System.out.println("�̸��� " +name);
		//2.���� �� method ȣ�� - ���̸� �Է�
		hw.type2(28);
		
		//3. ���� �� method ȣ�� - ���ڸ� �Է�
		hw.type3('a');
		
		//4. ���� �� method ȣ�� - ���ڸ� �Է�
		hw.type4(92);
		
		//5. ���� �� method ȣ�� - �ڽ��� �ּҸ� ���
		hw.type5(hw);

		//6. ���� �� method ȣ�� - ģ������ ���ڸ� ���
		hw.type6("�����", "������");		
	}

}
