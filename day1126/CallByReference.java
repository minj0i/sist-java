package day1126;

/**
 * method�� �Ű������� ��������������(class, ���ڿ�, array)�� ���
 * arguments�� ������ �ϳ��� �ּҰ� �Ҵ�ȴ�.
 * (���� �����ϸ� ������ ��ü�� ���� ���� ����ȴ�.)
 * @author owner
 */
public class CallByReference {
	private int i;
	private int j;
	
	public void swap(CallByReference cbr) {//�ּҰ� �״�� ���޵ȴ�
		int temp=0;
		temp=cbr.i;
		cbr.i=cbr.j;
		cbr.j=temp;
		System.out.println("swap method �� i="+i+",j="+j);
	}
	public static void main(String[] args) {
		CallByReference cbr= new CallByReference();
		cbr.i=11;
		cbr.j=26;
		System.out.println("swap ���� i="+cbr.i+",j="+cbr.j);
		cbr.swap(cbr);//�ּҰ� �״�� ���޵ȴ�
		System.out.println("swap ���� i="+cbr.i+",j="+cbr.j);
	}

}
