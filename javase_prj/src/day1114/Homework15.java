package day1114;
class Homework15{
	public static void main(String[] args)	{
	/*1. �Ʒ��� ���� ������ ������ ����� ����� ������.
   �̴ϼ� : 'K', ���� : �ڽ��ǳ���, �޴��÷� : 1.5, ������ �÷� : 0.8
   ��� : ���� �̴ϼ��� 'K'�̰�, xx���Դϴ�. �÷��� �޴� xx, ������ xx�Դϴ�.*/

 char c='K';
 int age=28;
 float left=1.5f, right=0.8f;

 System.out.println("���� �̴ϼ���: "+c+"�̰�, "+age+"���Դϴ�. �÷��� �޴� "+
	 left+", ������ "+right+"�Դϴ�.");

/*2. �⺻�� ���������� �����Ǵ� Ŭ������ Wrapper Class��� �Ѵ�. 
   Java Document���� WrapperŬ������ ����� �����ϴ��� ã�ƺ��� 
   �׿� ���� �ּҰ��� �ִ밪�� ��� �Ѵ�. */

System.out.println("byte�� �ּҰ�: "+Byte.MIN_VALUE+" �ִ밪: "+Byte.MAX_VALUE);
System.out.println("short�� �ּҰ�: "+Short.MIN_VALUE+" �ִ밪: "+Short.MAX_VALUE);
System.out.println("Integer�� �ּҰ�: "+Integer.MIN_VALUE+" �ִ밪: "+Integer.MAX_VALUE);
System.out.println("Float�� �ּҰ�: "+Float.MIN_VALUE+" �ִ밪: "+Float.MAX_VALUE);
System.out.println("Double�� �ּҰ�: "+Double.MIN_VALUE+" �ִ밪: "+Double.MAX_VALUE);
System.out.println("Long�� �ּҰ�: "+Long.MIN_VALUE+" �ִ밪: "+Long.MAX_VALUE);
System.out.println("Character�� �ּҰ�: "+(int)Character.MIN_VALUE+" �ִ밪: "+(int)Character.MAX_VALUE);

int deci=15;
int octal=017;
int hex=0xf;
int tel=01012345;
System.out.println(deci +octal +hex);
System.out.println(tel);

// 128 64 32 16 8 4 2 1
//29: 0001 1101
//50: 0011 0010
//99: 0110 0011
//300: 1 0010 1100 
	}
}
