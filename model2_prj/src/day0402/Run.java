package day0402;

import java.util.HashMap;
import java.util.Map;

public class Run {

	/**
	 * Is a 관계를 사용했을 때
	 */
	public void useIsA() {
		Map<String, Person> map=new HashMap<String, Person>();
		//값 할당
		map.put("gong", new SeonUi());
		map.put("lee", new JaeHyun());
		map.put("jung", new TeackSung());
		
		//키
		String key = "jung";
		//객체 다형성을 사용하여 부모에 얻어낸 자식을 저장한다.
		if(map.containsKey(key)) { //nullPoint방지
			Person person = map.get(key);
			System.out.println(person.execute());
		}
	}//useIsA
	
	/**
	 * Is a 관계를 사용하지 않고 객체를 사용할 때
	 */
	public void notUseIsA() {
		//HashMap은 쓰레드가 여러개 돌고 있을때 동시에 접근이 가능하다
		Map<String, Object> map=new HashMap<String, Object>();
		//값 할당
		map.put("gong", new SeonUi());
		map.put("lee", new JaeHyun());
		map.put("jung", new TeackSung());
		//값 사용
		String key="lee";
		if("gong".equals(key)) { //nullPointException을 감지하기 위해서
			SeonUi su=(SeonUi)map.get(key);
			System.out.println(su.execute());
		}//end if
		if("lee".equals(key)) { //nullPointException을 감지하기 위해서
			JaeHyun jh=(JaeHyun)map.get(key);
			System.out.println(jh.execute());
		}//end if
		if("jung".equals(key)) { //nullPointException을 감지하기 위해서
			TeackSung ts=(TeackSung)map.get(key);
			System.out.println(ts.execute());
		}//end if
		
	}//notUseIsA
	
	public static void main(String[] args) {
		Run run = new Run();
		run.useIsA();
		System.out.println("---------------------------------");
		run.notUseIsA();
	}//main

}//class
