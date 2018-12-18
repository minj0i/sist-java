package day1218;

/**
 * 사용자정의 예외처리 클래스
 * @author owner
 */
//1. Exception이나 runtimeException을 상속받는다.
@SuppressWarnings("serial")
public class TobaccoException extends RuntimeException { //Runtime아니고 그냥 Exception혹은 CompileException으로 하는 경우 try~catch로 잡아야함

	public TobaccoException() {
		this("담배예외-폐암의 원인 흡연! 그래도 피우시겠습니까?");
	}
	public TobaccoException(String msg) {
		super(msg);
	}
	
}
