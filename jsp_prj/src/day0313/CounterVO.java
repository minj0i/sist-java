package day0313;

/**
 * scope 속성에 따라 다르게 생성되는 객체
 * @author owner
 */
public class CounterVO {
	private int cnt;
	
	public CounterVO(){
		System.out.println("CounterVO");
	}//counterVO

	public int getCnt() {
		return cnt;
	}

	//누적합이 되도록 대입연산자를 바꿔줌
	public void setCnt(int cnt) {
		this.cnt += cnt;
	}
	
}//class
