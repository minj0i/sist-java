package day1115;
class Homework16{
	public static void main(String[] args) {
/* ����
1. ������ �Ҵ�� ���� ����϶��� 2������ ����ϰ� ������� ~�� ����Ͽ�
    ����� �����ϰ� �Էµ� �״���� 10������ ���.
    ��� ��)  "��� �ΰ��"  10 ��(��)  1010
                 "���� �ΰ��"  -10 ��(��) 10
*/
		int i=Integer.parseInt(args[0]);
		System.out.println(i+"��(��)"+(i>=0? Integer.toBinaryString(i):(~i)+1));

/*2. 2147483647�� ������ ���� 2byte�� ���� 2byte ���� �и��Ͽ� ����غ�����. 
    ��� ��) ���� 2byte -> 32767
           ���� 2byte -> 65535
*/
		int j=2147483647;
		System.out.println("����2byte�� "+(j>>16));
		System.out.println("����2byte�� "+~(j<<16));
		j=j&0x0000FFFF;
		System.out.println("����2byte�� "+(j));		

/*
3. ||�� ������� �� ������ true��� ������ �������� �ʴ� ���� ������ �� �ִ�
     �ڵ带 �ۼ��ϼ���
*/
		boolean flag1=false;
		boolean flag2=false;
		boolean flag3=false;

		flag3=(flag1=4>3)||(flag2=5>4);
		System.out.println("����: "+flag1+", ����:"+flag2+", ����:"+flag3);
	}
}
