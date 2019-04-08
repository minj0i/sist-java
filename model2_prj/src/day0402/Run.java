package day0402;

import java.util.HashMap;
import java.util.Map;

public class Run {

	/**
	 * Is a ���踦 ������� ��
	 */
	public void useIsA() {
		Map<String, Person> map=new HashMap<String, Person>();
		//�� �Ҵ�
		map.put("gong", new SeonUi());
		map.put("lee", new JaeHyun());
		map.put("jung", new TeackSung());
		
		//Ű
		String key = "jung";
		//��ü �������� ����Ͽ� �θ� �� �ڽ��� �����Ѵ�.
		if(map.containsKey(key)) { //nullPoint����
			Person person = map.get(key);
			System.out.println(person.execute());
		}
	}//useIsA
	
	/**
	 * Is a ���踦 ������� �ʰ� ��ü�� ����� ��
	 */
	public void notUseIsA() {
		//HashMap�� �����尡 ������ ���� ������ ���ÿ� ������ �����ϴ�
		Map<String, Object> map=new HashMap<String, Object>();
		//�� �Ҵ�
		map.put("gong", new SeonUi());
		map.put("lee", new JaeHyun());
		map.put("jung", new TeackSung());
		//�� ���
		String key="lee";
		if("gong".equals(key)) { //nullPointException�� �����ϱ� ���ؼ�
			SeonUi su=(SeonUi)map.get(key);
			System.out.println(su.execute());
		}//end if
		if("lee".equals(key)) { //nullPointException�� �����ϱ� ���ؼ�
			JaeHyun jh=(JaeHyun)map.get(key);
			System.out.println(jh.execute());
		}//end if
		if("jung".equals(key)) { //nullPointException�� �����ϱ� ���ؼ�
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
