package day1218;

/**
 * ��������� ����ó�� Ŭ����
 * @author owner
 */
//1. Exception�̳� runtimeException�� ��ӹ޴´�.
@SuppressWarnings("serial")
public class TobaccoException extends RuntimeException { //Runtime�ƴϰ� �׳� ExceptionȤ�� CompileException���� �ϴ� ��� try~catch�� ��ƾ���

	public TobaccoException() {
		this("��迹��-����� ���� ��! �׷��� �ǿ�ðڽ��ϱ�?");
	}
	public TobaccoException(String msg) {
		super(msg);
	}
	
}
