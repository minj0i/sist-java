package day1115;
/*
	����Ʈ������
	<<(left shift): ��Ʈ�� �������� �а� �о ��ĭ�� �׻� 0���� ä���.
	>>(right shift): ��Ʈ�� ���������� �а� �о ��ĭ�� �ֻ��� ��ȣ��Ʈ�� ����
					����� 0��, ������ 1�� ä���.
	>>>(unsigned right shift): ��Ʈ�� ���������� �а� �о ��ĭ�� �׻� 0���� ä���.
*/

class Operator3{
	public static void main(String[] args){
		
	//method: static method
	//Ŭ������.method��(��)
	int i=11;
	System.out.println(Integer.toBinaryString(i));//1011
	System.out.println(Integer.toOctalString(i));//013
	System.out.println(Integer.toHexString(i));//0xb

	i=9;
	System.out.println(i+"<<3="+ (i << 3));
	i=36; //10010
	System.out.println(i+">>3="+ (i >> 3));
	i=120; //0111 1000
	System.out.println(i+">>>4="+ (i >>> 4));

	i=1;
	System.out.println(i<<31);//�ֻ��� ��ȣ��Ʈ ����

	i=-1;
	System.out.println(i>>100);//�ֻ��� ��ȣ��Ʈ����

	i=-1;
	System.out.println(i>>>1);//�ֻ��� ��ȣ��Ʈ����

	}//main
}//class
