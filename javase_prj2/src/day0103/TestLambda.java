package day0103;

//@FunctionalInterface : JDK 1.8에서부터 제공하는 에노테이션인데, 인터페이스의 추상method가 하나인지 체크하는 기능
@FunctionalInterface//Lambda식으로 편하게 사용할 수 있다.
public interface TestLambda {
	public abstract String toDay();//추상메소드가 무조건 하나이어야한다.
//	public abstract String toDay2();//에노테이션을 달고 추가하면 Error
}//interface
