package day1122;

/**
 * Ư������: ���ڿ� �� \�� �����ϴ� ����� ���� ����
 * @author owner
 */
public class UseEscapeCharacter {

	public static void main(String[] args) {
		System.out.println("��\t����");//\t:tab
		System.out.println("��\t\t����");
		System.out.println("��\n�ü�");//\n:new line
		System.out.println("��\r�ü�");//\r:return (Ŀ���� ������)
		System.out.println("������\"�޿���\"�Դϴ�");//\" : "
		System.out.println("������''''''�޿���'�Դϴ�");//\' : '
		System.out.println("c:\\dev\\workspace\\javase_prj\\src\\day1122\\Test.java");
		System.out.println("c:/dev/workspace/javase_prj/src/day1122/Test.java");
		System.out.println("������\b");
	}

}
