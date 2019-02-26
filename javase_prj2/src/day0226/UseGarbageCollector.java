package day0226;

/**
 * Garbage Collector를 호출하여 객체를 소멸시키기(메모리의 여유공간이 확보)
 * @author owner
 */
public class UseGarbageCollector {

	public static void main(String[] args) {
		Person p= new Person("이재찬");
		p = new Person("김정윤");
		p = new Person("정택성");
		p = new Person("공선의");
		p = new Person("이재현");
		
		System.gc();//가비지 컬렉터 호출
		System.out.println("남은 사원: "+ p.getName());
	}//main
}//class
