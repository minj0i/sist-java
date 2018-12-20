package day1115;
class Homework16{
	public static void main(String[] args) {
/* 숙제
1. 변수에 할당된 값이 양수일때만 2진수로 출력하고 음수라면 ~를 사용하여
    양수로 변경하고 입력된 그대로의 10진수로 출력.
    출력 예)  "양수 인경우"  10 은(는)  1010
                 "음수 인경우"  -10 은(는) 10
*/
		int i=Integer.parseInt(args[0]);
		System.out.println(i+"는(은)"+(i>=0? Integer.toBinaryString(i):(~i)+1));

/*2. 2147483647의 값에서 상위 2byte와 하위 2byte 값을 분리하여 출력해보세요. 
    출력 예) 상위 2byte -> 32767
           하위 2byte -> 65535
*/
		int j=2147483647;
		System.out.println("상위2byte는 "+(j>>16));
		System.out.println("하위2byte는 "+~(j<<16));
		j=j&0x0000FFFF;
		System.out.println("하위2byte는 "+(j));		

/*
3. ||를 사용했을 때 전항이 true라면 후항을 연산하지 않는 것을 증명할 수 있는
     코드를 작성하세요
*/
		boolean flag1=false;
		boolean flag2=false;
		boolean flag3=false;

		flag3=(flag1=4>3)||(flag2=5>4);
		System.out.println("전항: "+flag1+", 후항:"+flag2+", 판정:"+flag3);
	}
}
