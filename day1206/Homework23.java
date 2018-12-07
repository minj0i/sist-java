package day1206;
//숙제 :

import java.util.ArrayList;
import java.util.Random;

//1. 아래의 데이터를 처리하는 프로그램을 작성하세요.
//
//  백인재,이봉현,이재찬,정택성,이재현,김정운 의 데이터가 존재하고, //String배열
// 점수는 0~100점 사이로 발생할수있습니다. //점수:random String.valueOf(Math.random() * 100) + 1
//
// 프로그램이 실행되면 위의 사람중에 2명이상 성적처리 대상자 이고 
// n명의 이름과 점수를 저장하여 출력하는 일을 하는 프로그램 작성.
// 중복이름은 들어갈 수 없다. 
//
//출력 예 )
// 이재찬 89
// 정택성 77
// 김정운 90
//  총점   xx점

public class Homework23 {
	public Homework23() {
		
	}// Homework23

	public void print() {
		ArrayList<String> ll = new ArrayList<String>();
		// 값 추가: 순서대로 추가된다.
		ll.add("백인재");
		ll.add("이봉현");
		ll.add("이재찬");
		ll.add("정택성");
		ll.add("이재현"); 
		ll.add("김정운");
		ll.add("이재현"); // 중복값을 저장할 수 있음
		ll.add("김정운"); // 중복값을 저장할 수 있음
		
		// 방의 내용으로 삭제
		for (int i = 0; i < ll.size(); i++) {
			for (int j = 0; j < i; j++) {
				if (ll.get(i) == ll.get(j)) {
					ll.remove(i);
				} // end if
			} // end for j
		} // end for i
		System.out.print("이름: ");
		System.out.println(ll);
		
		//점수입력
		ArrayList<Integer> score = new ArrayList<Integer>();
		System.out.print("점수: ");
		// 값 추가: 순서대로 추가된다.
		for (int i = 0; i < ll.size(); i++) {
			score.add((int)(Math.random() * 101));
		}//end for
		for (int i = 0; i < ll.size(); i++) {
		System.out.print(score.get(i)+" ");
		}//end for
		System.out.println();
		
		//2명 이상 랜덤으로 찍기
		Random r = new Random();
		int choose = r.nextInt(ll.size()-2)+2; //2명 이상 
		int choosePeople=0;
		int sum=0;
		
		//이름과 점수 출력
		System.out.println("-----------랜덤으로 2명 이상을 뽑습니다--------");
		System.out.println("이름 / 점수");
		for(int i=0; i<choose; i++) {
			choosePeople = r.nextInt(ll.size());
			System.out.println(ll.get(choosePeople) + "/ " + score.get(choosePeople));
			sum = score.get(choosePeople)+sum;
			ll.remove(choosePeople);
			score.remove(choosePeople);
		}
		System.out.println("총점  /" + sum);
	}// name
		
		
	public static void main(String[] args) {
		Homework23 hw23 = new Homework23();
		hw23.print();
	}// main
}// class
