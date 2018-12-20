package day1218;

/**
 * Compile Exception : byte code�� ���������� �����ϱ� ���� ��
 * �����ڰ� �ݵ�� ���ܻ�Ȳ�� ó���ؾ� �ϴ� ����
 * @author owner
 */
public class UseCompileException {

	public static void main(String[] args) {
		
		try {
			//java.lang.String1���� �ϴ� ��� ����
//			Object obj=Class.forName("java.lang.String"); //��Ӱ��迡 �ִ� �θ�� Object�� ���� �� ����
			Object obj=Class.forName("day1217.UseRuntimeException");
			System.out.println("�ε��� Ŭ����" +  obj); //new�� ���� �ʰ� ��ü�� �� �� �� ����
		} catch (ClassNotFoundException cnfe) {
			System.err.println("�����մϴ�.");
			System.err.println("���� �޼��� ���: "+cnfe.getMessage());
			System.err.println("����ó�� ��ü�� �޼���: "+cnfe);
			cnfe.printStackTrace();
//			System.out.println("-----");//println�� printStackTrace���� ���� ��µȴ�. Trace�ϴµ� �ð��ɷ���
			
		}finally {
			System.out.println("������ּż� �����մϴ�");
		}//end finally
	}//main

}//class
