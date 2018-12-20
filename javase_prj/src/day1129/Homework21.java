package day1129;

public class Homework21 {
	HomeworkData[] copyArr = null;

	public Homework21() {
		// 1. 선언 : 데이터형[] 배열명 = null;
		HomeworkData[] hwArr = null;
		// 2. 생성: 배열명 = new 데이터형[방의 수];
		hwArr = new HomeworkData[7];
		// 3. 값 할당: 배열명[방의 번호]=new 생성자();
		// 클래스명 객체명=new 생성자();
		// 배열명[방의번호]=객체명;

		hwArr[0] = new HomeworkData("이재찬", "서울시 강남구 역삼동", 28, "남자");
		hwArr[1] = new HomeworkData("이재현", "서울시 동대문구 답십리동", 27, "남자");
		hwArr[2] = new HomeworkData("김정운", "수원시 영통구 영통동", 26, "남자");
		hwArr[3] = new HomeworkData("정택성", "서울시 구로구 구로동", 27, "남자");
		hwArr[4] = new HomeworkData("정택순", "서울시 동작구 상도동", 29, "여자");
		hwArr[5] = new HomeworkData("김건하", "경기도 부천시 부천동", 26, "남자");
		hwArr[6] = new HomeworkData("이재순", "서울시 광진구 광나루동", 27, "여자");

		printArr(hwArr);
	}// HomeworkData 기본생성자

	// 1. 위의값을 배열에 입력하는 method를 작성할것.
	public void printArr(HomeworkData[] hwArr) {
		copyArr = new HomeworkData[hwArr.length];
		for (int i = 0; i < hwArr.length; i++) {
			copyArr[i] = hwArr[i];
			System.out.println(copyArr[i].getName() + " " + copyArr[i].getAddr() + " " + copyArr[i].getAge() + " "
					+ copyArr[i].getGender());
		} // end for
	} // end

//	2. 배열에 입력된 값을 출력하는 method 를 작성할것.
//	   2번 method 에서 서울시에 살고 있는 인원수를 출력 할것.
//	   2번 method 에서 나이의 합을 출력 할것.
//	   2번 method 에서 가장 나이가 많은 사람의 이름을 출력 할 것.
	public void print() {
		int count = 0;
		int sum = 0;
		int max = 0;
		String name = null;
		String gender = null;
		for (int i = 0; i < copyArr.length; i++) {
			if (copyArr[i].getAddr().startsWith("서울시") == true) {
				count++;// 서울시 인원 수
				sum = copyArr[i].getAge() + sum; // 나이의 합
			}
			if (max < copyArr[i].getAge()) {
				max = copyArr[i].getAge();
				name = copyArr[i].getName();
				gender = copyArr[i].getGender();
			} // 최고령자의 이름과 성별을 받음
		}
		System.out.println("서울시에 거주하는 사람은: " + count + "명 입니다");
		System.out.println("나이의 합계는: " + sum + "살 입니다");
		System.out.println("최고령자의 나이는:" + max + "이고 이름은 " + name + "(" + gender + ")");
	}

	public static void main(String[] args) {
		Homework21 use = new Homework21();
		System.out.println("-------------------");
		use.print();
	}// main
}// class