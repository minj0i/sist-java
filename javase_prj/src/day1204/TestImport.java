package day1204;

import java.util.Date;
//import java.awt.List;//��Ű���� �ٸ��� �̸��� ���� Ŭ������
//�� �� �ϳ��� import ���� �� �ִ�.
import java.util.List;
import java.util.Random;

//import java.util.*;//��Ű�� ���� ��� class(interface)�� �ѹ��� ����� �� �ִ�.

/**
 * import: �ٸ� ��Ű���� Ŭ������ �����Ͽ� ����� ��.
 * @author owner
 */
public class TestImport {

	public static void main(String[] args) {
		Random r = new Random();//�ٷ� ���ַ��� : lang package�� �ִ� ���, import �ϸ� ��
		Random r1 = new Random();
		Random r2 = new Random();
		
		Date d = new Date();
		
		//���� �̸��� Ŭ����(interface)�� �� �� ���� ���Ǵ� ���� import��
		//ó���ϰ�, ���� ���Ǵ� ���� full path�� ó����.
		java.awt.List list = null;//awt.List//�տ� java.awt�� �ٿ��� ����
		List list1 = null;//util.List
		
		
		
	}//main

}//class
