package day1130;

/**
 * Override
 * �θ�Ŭ������ �����ϴ� ����� �ڽ�Ŭ������ ���� �ʴ� �ٸ�
 * �ڽ�Ŭ�������� �θ�Ŭ������ method�� ������ method�� �����Ͽ�
 * ����ϴ� ��
 * @author owner
 */
public class OverrideToString {

	@Override
	public String toString() {
//		toString();
		return "OverrideToString Ŭ����"+super.toString();
	}//toString

}
