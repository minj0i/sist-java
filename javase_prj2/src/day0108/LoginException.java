package day0108;

/**
 * ��������� ����ó�� Ŭ���� <br>
 * Exception(RuntimeException) ��ӹ޴´�.
 * @author owner
 */
@SuppressWarnings("serial")
public class LoginException extends Exception {
	public LoginException() {
		this("�α��� ����");
	}//LoginException
	public LoginException(String msg) {
		super(msg); //����ó�� ��ü�� ����Ͽ� ���ܸ޼����� ����� �� �ִ�.
	}//LoginException
	
}//class
