package day1114;
class Homework15{
	public static void main(String[] args)	{
	/*1. 아래의 값을 저장할 변수를 만들고 출력해 보세요.
   이니셜 : 'K', 나이 : 자신의나이, 왼눈시력 : 1.5, 오른눈 시력 : 0.8
   출력 : 나의 이니셜은 'K'이고, xx살입니다. 시력은 왼눈 xx, 오른눈 xx입니다.*/

 char c='K';
 int age=28;
 float left=1.5f, right=0.8f;

 System.out.println("나의 이니셜은: "+c+"이고, "+age+"살입니다. 시력은 왼눈 "+
	 left+", 오른눈 "+right+"입니다.");

/*2. 기본형 데이터형에 대응되는 클래스를 Wrapper Class라고 한다. 
   Java Document에서 Wrapper클래스의 상수가 존재하는지 찾아보고 
   그에 대한 최소값과 최대값을 출력 한다. */

System.out.println("byte의 최소값: "+Byte.MIN_VALUE+" 최대값: "+Byte.MAX_VALUE);
System.out.println("short의 최소값: "+Short.MIN_VALUE+" 최대값: "+Short.MAX_VALUE);
System.out.println("Integer의 최소값: "+Integer.MIN_VALUE+" 최대값: "+Integer.MAX_VALUE);
System.out.println("Float의 최소값: "+Float.MIN_VALUE+" 최대값: "+Float.MAX_VALUE);
System.out.println("Double의 최소값: "+Double.MIN_VALUE+" 최대값: "+Double.MAX_VALUE);
System.out.println("Long의 최소값: "+Long.MIN_VALUE+" 최대값: "+Long.MAX_VALUE);
System.out.println("Character의 최소값: "+(int)Character.MIN_VALUE+" 최대값: "+(int)Character.MAX_VALUE);

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
