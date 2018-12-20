package day1129;

/**
 * ����� ����Ư¡�� �θ�(Person)�κ��� ����ϰ� �ڽŸ��� Ư¡��(�ο��� ����)
 * 
 * @author owner
 */
public class HongGilDong extends Person {
	private int level;// �ο� ����

	/**
	 * ȫ�浿�� �ο��� ��κ��� ���ϹǷ� 7���� ����
	 */
	public HongGilDong() {
		super();
		level = 7;
	}// HongGilDong

	/**
	 * �ο��ϴ� ��: �Էµ� �������� ���ٸ� �й� ���ٸ� �¸�, �Էµ� ������ ���ٸ� ���<br>
	 * �¸��ϸ� ������ 1����, �й��ϸ� ���� 1����, ���� ������ȭ���� ������ �ִ� 10, �ּ� 0�� ������.
	 * 
	 * @param inputlevel : �ο������� ����
	 * @return �ο��� ���
	 */
	public String fight(int inputLevel) {
		String result = "";

		if (level > inputLevel) {// �¸�
			result = "�̰��. s('.^)V";
			level++;
			if (level > 10) {
				level = 10;
			}// end if
		} else if (level < inputLevel) {// �й�
			result = "����. ~(_-_)~";
			level--;
			if (level < 1) {
				level = 1;
			}// end if
		} else {// ���
			result = "��� �Ѥ�+;;";
		}// end else

		return result;
	}// flight
	
	@Override
	public String toString() {
		return "ȫ�浿 ��ü�� �� :"+getEye()+"/"+getNose()+"/"+getMouth();
	}//toString
	
	/**
	 * �θ�Ŭ������ �����ϴ� method�� ����� �ڽĿ��� ���� �ʾ�<br>
	 * ����� �Ĵ��� �ָ����� ���� <br>
	 * ȭ������� ���� ������ ����
	 */
	@Override
	public String eat(String menu, int price) {
		return getName()+"�� �ָ����� "+menu+"�� ������ "+price+"�� �ְ� ��Դ´�.";
	}
	
}// class
