package day1204;

import java.util.Date;
//import java.awt.List;//패키지는 다르나 이름이 같은 클래스는
//둘 중 하나만 import 받을 수 있다.
import java.util.List;
import java.util.Random;

//import java.util.*;//패키지 내의 모든 class(interface)를 한번에 사용할 수 있다.

/**
 * import: 다른 패키지의 클래스를 참조하여 사용할 때.
 * @author owner
 */
public class TestImport {

	public static void main(String[] args) {
		Random r = new Random();//바로 써주려면 : lang package에 있는 경우, import 하면 됨
		Random r1 = new Random();
		Random r2 = new Random();
		
		Date d = new Date();
		
		//같은 이름의 클래스(interface)는 둘 중 많이 사용되는 것을 import로
		//처리하고, 적게 사용되는 것을 full path로 처리함.
		java.awt.List list = null;//awt.List//앞에 java.awt를 붙여서 구분
		List list1 = null;//util.List
		
		
		
	}//main

}//class
