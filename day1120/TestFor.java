package day1120;

/**
 * for : 시작과 끝을 알 때 사용하는 반복문<br>
 * 문법 : for(시작값; 끝값; 증가|감소식)<br>
 *          반복 수행 문장;<br>
 *      }
 * @author owner
 */
public class TestFor {

	public static void main(String[] args) {
		//0~에서부터 10보다 작을 때까지 반복수행하는 for
		for(int i=0; i<10; i++) {
			System.out.println(i+"번 안녕 ");
		}//end for
		
		//1에서 부터 1씩 증가하며 100까지 반복수행 하는 for
		//반복문에서 i<=100쓰면 작은지1번 같은지2번 더 하게되어서 가급적이면 i<101이 좋다.요즘HDD가 좋아져서..별차이가 없김함..
		for(int i=1; i<101; i++ ) {
			System.out.println(i);
		}//end for
		
		//1에서 부터 1씩 증가하며 100까지 짝수만 옆으로 출력 for
		for(int i=1; i<101; i++ ) {
			if(i%2==0)
				System.out.print(i+" ");
		}//end for
		System.out.println(); //<위에서 줄안건너서 그냥 건너,아무것도 없이도 가능 맞았당~
		
		//1에서 부터 100까지 홀수만 옆으로 출력
		int cnt = 0;
		for(int i=1; i<101; i++ ) {
			cnt++;
			if(i%2==1)
				System.out.print(i+" ");
		}//end for
		System.out.println("\n"+cnt+"번");
		
		
		//1에서 부터 100까지 홀수만 옆으로 출력
		int cnt1 = 0;
		//증/감소식은 변수에 값을 변화시키고 유지시킬수 있는 모든 연산자를 다 사용할 수 있다.
		//< i++ 후위연산 = i+=1 = i=i+1 => 이렇게 사용함으로 절반으로 줄었다.
		//<i&=2  i^=2 도 다 상관은 없다. 단지 돌뿐..가장 적합한걸 쓰면된다.
		for(int i=1; i<101; i+=2 ) {
			cnt1++;
				System.out.print(i+" ");
		}//end for
		System.out.println("\n"+cnt1+"번");
		
		//1~100까지 출력하기 3의 배수마다 숫자대신 "짝"을 출력
		int cnt2=0;
		for(int i=1; i<101;) {
			cnt2++;
			if (i%3==0) {
				System.out.print("짝 ");
			}else {
			System.out.print(i+" ");
			}//end if
			i++;
		}//end for
		System.out.println("\n"+cnt2+"번");
		
		//1~100까지의 합 출력
		int sum=0;
		for(int i=1; i<101; i++) {
			sum=sum+i;
		}//end for
		System.out.println("1에서부터 100까지의 합은: "+sum);
		
		//알파벳 A~Z까지 출력
		for(int i=65; i<91; i++) {
			System.out.print((char)i+" ");
		}//end for
		System.out.println(" ");
		
		for(char c='A'; c<='Z'; c++) {
			System.out.print(c+" ");
		}//end for
		System.out.println(" ");
		
		for(int i=1; i<10; i++) {
			System.out.print(2*i+ " ");
		}//end for
		
		
		
		
	}//main

}//class
