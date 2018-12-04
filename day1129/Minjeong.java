package day1129;

public class Minjeong extends Person {
	public int chan;
	
	/**
	 * 기본생성자: 반찬이 3개씩 챙긴다
	 */
	public Minjeong() {
		chan=3;
		}
	
	/**
	 * 입력되는 잔고에 따라 반찬의 가지수가 달라진다.
	 * @param money 잔고
	 * @return 반찬의 갯수와 메세지
	 */
	public String banchan(int money) {
		String result="";
		if(money>=200) {
			chan=5;
			result="반찬을 두 가지 늘렸습니다";
		}else if (money>100) {
			chan=4;
			result="반찬을 한 가지 늘렸습니다";
		}else if(money<=100 && money>=10) {
			chan=3;
			result="그럭저럭 먹고 살만 합니다";
		}else {
			chan=2;
			result="먹고 사는게 다행입니다";
		}
		return result;
	}//banchan end
}//Minjeong end
