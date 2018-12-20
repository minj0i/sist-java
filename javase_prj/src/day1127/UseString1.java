package day1127;

public class UseString1 {
	// 이메일을 입력받아 이메일의 유효성을 검증하여 boolean형으로 (5자이상이면서 @, . 포함)
	// 결과를 만들어 반환하는 일을 하는 method를 만들어 호출하여
	// 사용해보세요
	private boolean validEmail(String email) {
		boolean flag = false;
//		if(email.length()>=6 && email.indexOf("@")!=-1 && email.indexOf(".")!=-1) {
//			flag=true;
//		}//end else
		flag = email.length() >= 6 && email.contains("@") && email.contains(".");
//		flag =email.length()>=6 && email.indexOf("@")!=-1 && email.indexOf(".")!=-1;
		
		//메소드는 일만 하고 출력하는 것이 없음
//		if (flag == true) {
//			System.out.println("이메일 적합");
//		} else {
//			System.out.println("이메일 부적합");
//		}
		return flag;
//		return email.length()>=6 && email.contains("@") && email.contains(".");

	}
	
	//'시군구의 형태의 '주소를 n개 입력받아 서울시인지 아닌지 여부 판단하여
	//출력하는 method
	

	public static void main(String[] args) {
		UseString1 us1 = new UseString1();
//		us1.validEmail("abc@de.kr");
//		us1.validEmail("abc@dekr");
//		us1.validEmail("abcde.kr");
		String email = "dd@dd.net";
		 if(us1.validEmail(email)){
		System.out.println("유효");
	}else {
		System.out.println("무효");
	}

	}

}
