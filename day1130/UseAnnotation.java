package day1130;

import java.util.ArrayList;
import java.util.List;

/**
 * JDK1.5�������� �߰��� annotation�� ���
 * @author owner
 */
public class UseAnnotation {

	
	/**
	 * �� method�� �ڶ� ������ �߻���ų �� �ֽ��ϴ�. 
	 */
	@Deprecated
	public void test() {
		System.out.println("���Ŀ� ������ �߻��� ����");
	}//test
	
	@Override
	public String toString() {
		return "�´����ʸ�";
	}
	
	//method ���� �����ϸ� method ���� ��� ��� ��Ȳ�� �����Ѵ�.
	@SuppressWarnings({"rawtypes", "unused"})
	public void temp() {
		//unused ������ ������� �ʾƵ� �� ��
//		@SuppressWarnings("unused")
		int i=0;
		
		//rawtypes: Generic�� ������� ���� �� ��� ����
		//�������� �����ϸ� �ٷ� �Ʒ� �ִ� ������ ��� �����ϰ� 
//		@SuppressWarnings({"rawtypes", "unused"})
		List l = new ArrayList();
		
		
		int j=0;
		System.out.println("temp j="+j);
	}
	
	public static void main(String[] args) {
		UseAnnotation ua = new UseAnnotation();
		ua.test();
		System.out.println(ua);
	}//main

}
