package day1119;

/**
 * switch~case : ������ ���� ��.(JDK1.7�������ʹ� ���ڿ��� �� ����)<br>
 * ����) switch (������) {<br>
 * 			case ��� : ���๮��; <br>
 * 			case ��� : ���๮��; <br>
 * 			case ��� : ���๮��; <br>
 * 				.<br>
 * 				.<br>
 * 				.<br>
 * 			default : ��ġ�ϴ� ����� ���� �� ���๮��;<br>
 * 			}<br>
 * @author owner
 */
public class TestSwitchCase {
	
	public static void main(String[] args) {
		// char i='1'�� ������ Unicode�� ��, case 1�� �ٸ� ��
		//String i="1"; Java1.7�̻󿡼� String ����
		int i=0;
		//switch�� �ԷµǴ� ������ ���������� byte, short, int, char, String
		switch(i) {
		//case�� �ԷµǴ� ������ ���� �ٸ� ������ ������
		case 1 : System.out.println("��ħ");
		case 2 : System.out.println("����");
		case 3  : System.out.println("����");
		default: System.out.println("����");
		}//end switch
		
	}//main
}//class
