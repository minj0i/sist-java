package day1203;

/**
 * 사람의 공통특징은 Person에서 가져다가 사용하고 자신만의 특징을 
 * 정의한 클래스
 * @author owner
 */
public final class Clark extends Person implements Fly{
	public int power;
	
	/**
	 * 기본 생성자: 객체가 생성되면 power가 9로 설정된다.
	 */
	public Clark() {
		super(3,1,1);
		power=9;
		
	}//Clark
	
	/**
	 * 입력되는 돌의 종류에 따라 힘의 변화가 급격하게 변화한다.
	 * @param stone 돌의 종류
	 * @return 힘의 변화
	 */
	public String power(String stone) {
		String result=" ";
		
		if(stone.equals("클립토나이트")) {
			power=0;
			result="힘이 방전 ~(_-_)~";
		}else if(stone.equals("다이아몬드")) {
			power=10;
			result="감사합니다. ~m(^o^)m~";
		}else{
			power=12;
			result="열받아. ㅡㅡ+";
		}//end else
		
		return result;
	}//power
	
	@Override
	public String eat() {
		return getName()+"이 집에서 빵을 먹는다.";
	}//eat
	@Override
	public String eat(String menu, int price) {
		return getName()+"이 레스토랑에서 "+menu+"를 "+price+"$ 내고 사먹는다.";
	}//eat
	
	@Override
	public String speed(String speed) {
		return getName()+"은 "+speed+"게 난다";
	}//speed

	@Override
	public String height(String height) {
		return getName()+"은 "+height+"이 난다";
	}//height
	

}//class
