package day1129;

public class Minjeong extends Person {
	public int chan;
	
	/**
	 * �⺻������: ������ 3���� ì���
	 */
	public Minjeong() {
		chan=3;
		}
	
	/**
	 * �ԷµǴ� �ܰ� ���� ������ �������� �޶�����.
	 * @param money �ܰ�
	 * @return ������ ������ �޼���
	 */
	public String banchan(int money) {
		String result="";
		if(money>=200) {
			chan=5;
			result="������ �� ���� �÷Ƚ��ϴ�";
		}else if (money>100) {
			chan=4;
			result="������ �� ���� �÷Ƚ��ϴ�";
		}else if(money<=100 && money>=10) {
			chan=3;
			result="�׷����� �԰� �츸 �մϴ�";
		}else {
			chan=2;
			result="�԰� ��°� �����Դϴ�";
		}
		return result;
	}//banchan end
}//Minjeong end
