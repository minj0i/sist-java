package day1121.sub;

import day1121.InstAccModifi;

/**
 * ���� ��Ű���� �����ϴ� �ٸ� Ŭ������ �ν��Ͻ����� ���<br>
 * ��Ӱ��迡 �ִٸ� �ڽ�Ŭ������ �����Ͽ� �θ� Ŭ������ ���� <br>
 * �ν��Ͻ� ������ ���������ڰ� public, protected �� �͸� ��� ����.<br>
 * @author owner
 */
public class UseintAccModifi2 extends InstAccModifi{

	public static void main(String[] args) {
		UseintAccModifi2 ivam=new UseintAccModifi2();
		System.out.println("public: "+ivam.pub_i);
		System.out.println("protected: "+ivam.pro_i); 
//		System.out.println("private: "+ivam.pri_i); //���Ұ� 
//		System.out.println("default: "+ivam.def_i); //���Ұ�
		
	}

}
