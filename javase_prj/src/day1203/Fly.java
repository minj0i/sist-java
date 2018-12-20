package day1203;

/**
 * 나는 것들의 일 <br>
 * 나는 것은 속도, 높이
 * @author owner
 */
public interface Fly {
	//interface의 추상메소드는 public만 가능
	/**
	 * 나는 속도
	 * @param speed
	 * @return
	 */
	public abstract String speed(String speed);
	/**
	 * 나는 높이
	 * @param height
	 * @return
	 */
	public String height(String height);
}//interface
