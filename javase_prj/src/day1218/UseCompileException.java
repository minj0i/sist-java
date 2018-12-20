package day1218;

/**
 * Compile Exception : byte code를 정상적으로 생성하기 위한 것
 * 개발자가 반드시 예외상황을 처리해야 하는 예외
 * @author owner
 */
public class UseCompileException {

	public static void main(String[] args) {
		
		try {
			//java.lang.String1으로 하는 경우 에러
//			Object obj=Class.forName("java.lang.String"); //상속관계에 있는 부모라서 Object로 받을 수 있음
			Object obj=Class.forName("day1217.UseRuntimeException");
			System.out.println("로딩한 클래스" +  obj); //new를 하지 않고도 객체를 얻어서 쓸 수 있음
		} catch (ClassNotFoundException cnfe) {
			System.err.println("뎨동합니다.");
			System.err.println("예외 메세지 출력: "+cnfe.getMessage());
			System.err.println("예외처리 객체와 메세지: "+cnfe);
			cnfe.printStackTrace();
//			System.out.println("-----");//println은 printStackTrace보다 먼저 출력된다. Trace하는데 시간걸려서
			
		}finally {
			System.out.println("사용해주셔서 감사합니다");
		}//end finally
	}//main

}//class
