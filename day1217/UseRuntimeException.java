package day1217;

/**
 * JVM�� �ڵ����� ���ܸ� ó�����ִ� RuntimeException
 * 
 * @author owner
 */
public class UseRuntimeException {

	public static void main(String[] args) {
		try {
			int num1 = Integer.parseInt(args[0]);
			int num2 = Integer.parseInt(args[1]);
			int result = 0;

			result = num1 / num2;

			System.out.println(num1 + "/" + num2 + "=" + result);
		} catch (ArrayIndexOutOfBoundsException aioobe) {
			System.err.println("�迭�� �ε����� �߸� �Ǿ����ϴ�.");
			System.err.println("������ ����: "+aioobe.getMessage());
			System.err.println("����ó�� Ŭ������� ����: "+aioobe);
			aioobe.printStackTrace();
		}catch (NumberFormatException nfe) {
			System.err.println("�Է°��� �������°� �ƴմϴ�.");
			System.err.println("������ ����:"+nfe.getMessage());
			System.err.println("����ó�� Ŭ������� ����:"+nfe);
			nfe.printStackTrace();
		}catch (ArithmeticException ae) {
			System.err.println("0���� ���� �� �����ϴ�.");
			System.err.println("������ ����:"+ae.getMessage());
			System.err.println("����ó�� Ŭ������� ����:"+ae);
			ae.printStackTrace();
		}catch (Exception e) {
			System.err.println("�����ڰ� �������� ���� ����");
			e.printStackTrace();
		}finally {
			System.out.println("�ݵ�� ����Ǿ���� �ڵ�");
		}
	}// main

}// class
