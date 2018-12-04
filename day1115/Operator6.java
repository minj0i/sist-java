package day1115;
/*
	삼항(조건)연산자
	? :
*/

class Operator6{
	public static void main(String[] args)	{
		int i=10;
		System.out.println(i+"는(은)"+(i>=0? "양수":"음수"));
		//절대값
		System.out.println(i+"는(은)"+(i>=0? i:-i));
		//변수의 값이 짝수인지 홀수인지 판단하는 삼항연산자
		System.out.println(i+"는(은)"+((i%2)==0? "짝수":"홀수"));


	}//main
}//class
