package day1206;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JaechanHw {
	// 필요한 인스턴스 변수 선언
	String m_name;
	int m_score;
	List<String> m_nameList;
	List<JaechanHw> m_resultList;

	// 생성자에서 인스턴스 변수 초기화 및 nameList에 이름 할당
	public JaechanHw() {
			m_name = "";
			m_score = 0;
			m_nameList = new ArrayList<String>();
			m_resultList = new ArrayList<JaechanHw>();
			
			m_nameList.add("백인재");
			m_nameList.add("이봉현");
			m_nameList.add("이재찬");
			m_nameList.add("정택성");
			m_nameList.add("이재현");
			m_nameList.add("김정운");
		}

	// 렌덤명수를 뽑아 이름과 점수를 리스트에 저장하는 메서드
	public List<JaechanHw> setNameAndScore(List<String> nameList) {
		List<JaechanHw> resultList = new ArrayList<JaechanHw>();// 결과 반환(이름 + 점수)를 위한 리스트
		Random r = new Random();
		int randPeopleTotal = r.nextInt(nameList.size() - 2) + 2; // 2명 ~ 6명의 성적처리대상을 렌덤으로 뽑는다.
		JaechanHw hw = null; // 렌덤으로 설정한 n명의 대상 만큼 인원만큼 반환할 클래스(사용자형데이터)을 선언한다.

		int randPeople = 0; // 결과 반환 리스트에 저장할 사람의 index
		int randScore = 0; //점수의 index

		for (int i = 0; i < randPeopleTotal; i++) {// 위의 랜덤으로 설정한 n명의 대상 만큼 인원을 뽑는다. (2명 이상)
			hw = new JaechanHw(); //주소를 할당(클래스는 주소만 가지고있음)
			randPeople = r.nextInt(nameList.size()); // 전체인원 중 렌덤으로 1명을 뽑는다.
			randScore = r.nextInt(100); // 점수를 렌덤으로 설정한다.

			hw.m_name = nameList.get(randPeople); // 클래스의 멤버변수로 방금 뽑은 이름을 저장
			nameList.remove(randPeople); // 뽑은 이름을 지운다.
			hw.m_score = randScore;

			resultList.add(hw); // 반환할 클래스데이터형 리스트에 이름과 점수가 저장된 클래스를 넣어준다.
		}
		return resultList;
	}

	// 저장된 이름과 점수를 리스트에서 총점과 함께 출력하는 메서드
	public void printNameAndScore(List<JaechanHw> resultList) {
		int totalScore = 0;// 총점 저장을 위한 변수

		for (int i = 0; i < resultList.size(); i++) {
			System.out.print(resultList.get(i).m_name + " " + resultList.get(i).m_score);
			totalScore += resultList.get(i).m_score;
			System.out.println();
		}
		System.out.println("총점 " + totalScore + "점");
	}

	public static void main(String[] args) {
		JaechanHw hw = new JaechanHw();

		hw.m_resultList = hw.setNameAndScore(hw.m_nameList);// 결과 List에 이름과 점수 저장
		hw.printNameAndScore(hw.m_resultList);

	}

}
