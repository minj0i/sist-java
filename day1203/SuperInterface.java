package day1203;

/**
 * ����Ŭ����(�ڽ�Ŭ����)���� �ݵ�� Override �ؾ��ϴ� ���� ��ϸ�
 * �����ϴ� interface ����. (������ ������)
 * @author owner
 */
//Interface�� �θ� ������ ���� �� �ִ�.
public interface SuperInterface extends InterA, InterB {
	//constant : ������ ���ó�� ���.
//	int i;	//������ �ۼ��� �� ����
	public static final int FLAG_VALUE=12;
	
	//�߻� method ���� => body�� ����
	//�Ϲ� method�� ���� �� ���� Error
//	public void test();
//	}
	
	//�������̽� �� ��ӿ��� �߻� method�� Override���� �ʴ´�.
//	@Override
//	public String msg();//InterA�� �ִ� �� �־��شٰ� �ص� Body�� ���� �� ���� ������ �ǹ̰� ����

	//abstract�� ������� �ʾƵ� �ȴ�.
	public void methodA();
	//abstract�� ����ص� �ȴ�.
	public abstract void methodB(int i);
}//interface
