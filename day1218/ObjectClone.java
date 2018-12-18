package day1218;

import java.util.Stack;

/**
 * 객체 복제 : 복제되는 객체는 Cloneable interface를 구현해야만 한다.
 * @author owner
 */
public class ObjectClone implements Cloneable{ //Cloneable interface가 있어야 가능
	
	private int i;
	private Stack<ObjectClone> stack;
	

	public static void main(String[] args) {
		
		ObjectClone oc = new ObjectClone();
		oc.i=100;
		
		try {
			ObjectClone oc1 = (ObjectClone) oc.clone();
			System.out.println("복제 성공"+oc1);
			oc.i=200;
			System.out.println("원본:"+oc.i+"/ 복제분: "+oc1.i);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
	}

}
