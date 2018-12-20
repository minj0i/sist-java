package day1207;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/**
 * Set:검색의 기능이 없으며(get x)중복값을 저장
 * 
 * @author owner
 */
public class UseSet {

	public UseSet() {
		// JDK1.5이하에서는 Generic이 지원되지 않고 객체만 저장.
		// 1.생성)
		Set<String> set = new HashSet<String>();
		// 2.값 할당) 값이 순서대로 들어가지 않음
		set.add("정택성");
		set.add("이재현");
		set.add("공선의");
		set.add("김정운");
		set.add("노진경");
		set.add("최지우");
		set.add("이봉현");
		set.add("김정운");// 중복값 저장 안함
		System.out.println(set.size() + "/" + set);
		// 3.값 삭제) - 가변길이형
		set.remove("김정운");
		System.out.println(set.size() + "/" + set);

		// 4.배열로 복사)
		String[] names = new String[set.size()];
		set.toArray(names);

		// 5.set의 모든 방(Element)의 값 출력
//		System.out.println(set.get("김정운"));//set 자체는 검색의 기능이 없다
		Iterator<String> ita = set.iterator();

		String name = ""; // "" : Empty
		while (ita.hasNext()) { // Iterator가 참조하는 set의 요소가 존재한다면
			name = ita.next();// 해당요소의 값을 얻고 다음 포인터로 이동
			System.out.println(name);
		} // end while
		System.out.println("----------향상된 for-----------");
		for (String temp : set) {
			System.out.println(temp);
		} // end for

		// 모든 방의 값 삭제
		set.clear();
		System.out.println("clear후 " + set.size() + " / " + set);

		// 복사한 배열의 값 출력
		for (int i = 0; i < names.length; i++) {
			System.out.println(names[i]);
		} // end for

	}// useSet


	public int[] lotto() {
		int[] tempLotto = new int[6];
		
		Random random = new Random();
		for(int i=0; i<tempLotto.length; i++) {
			tempLotto[i]= random.nextInt(45)+1; //같은 수가 발생할 수 있다. 
			for(int j=0; j<i; j++) {
				if(tempLotto[i]==tempLotto[j]) { //방의 값이 같다.
					i--;//중복 발생된 번호의 인덱스번째를 다시 발생시키기 위해 
					//인덱스번호를 하나 줄인다.
					break;//반복문을 빠져나간다.
				}//end if
			}//end for
		}//end for
		
		return tempLotto;
	}// lotto
	
	public Integer[] lotto1() {
		Integer[] tempLotto = new Integer[6];
		
		Set<Integer> set = new HashSet<Integer>();//중복값을 저장하지 않는다.
		
		Random random = new Random();
		while(true) {
			set.add(random.nextInt(45)+1); //같은 수가 추가되지 않는다.
		if(set.size()==6) {
			break;
		}//end if
		}//end while
		set.toArray(tempLotto);
		return tempLotto;
	}// lotto
	
	public static void main(String[] args) {
		UseSet us = new UseSet();
		int[] temp = us.lotto();

		for (int i = 0; i < temp.length; i++) {
			System.out.print(temp[i]+" ");
		} // end for
		
		System.out.println();
		System.out.println("----------------------");
		Integer[] temp1 = us.lotto1();
		for (int i = 0; i < temp1.length; i++) {
			System.out.print(temp1[i]+" ");
		} // end for
	}// main

}// class
