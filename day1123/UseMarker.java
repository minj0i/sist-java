package day1123;

/**
 * ��ī���� ������ Ŭ������ ����ϴ� Ŭ����<br>
 * 4. ��ü����<br>
 * 5. ������ ��ü ���.
 * @author owner
 */
public class UseMarker {

	public static void main(String[] args) {
		//������ ��ī�� 1�� ����
		Marker black = new Marker();
//		black.setColor("������");
//		black.setCap(1);
//		black.setBody(1);
		
		System.out.printf("������ ��ī�� ��:[%s], �Ѳ�[%d], ��ü[%d]\n", black.getColor(), black.getCap(), black.getBody());
		//������ ��ü�� ���
		System.out.println(black.write("�ȳ��ϼ���"));
		System.out.println("===================================");
		Marker red = new Marker("������", 5, 5);
//		red.color="���"; //���������ڰ� pu\blic�̶�� �ܺο��� ����
		//���� ������ �� �����Ƿ� �߸��� ���� �Էµ� �� �ִ�.
		//private���� �ְ� method�� ���ؼ��� �� �Է�(ĸ��ȭ)
//		red.setColor("���");
//		red.setCap(5);
//		red.setBody(5);
		
		System.out.printf("������ ��ī�� ��:[%s], �Ѳ�[%d], ��ü[%d]\n", red.getColor(), red.getCap(), red.getBody());
		//������ ��ü�� ���
		System.out.println(red.write("������"));		
		
		
	}//main

}//class
