package day1203;

/**
 * ����� ����Ư¡�� Person���� �����ٰ� ����ϰ� �ڽŸ��� Ư¡�� 
 * ������ Ŭ����
 * @author owner
 */
public final class Clark extends Person implements Fly{
	public int power;
	
	/**
	 * �⺻ ������: ��ü�� �����Ǹ� power�� 9�� �����ȴ�.
	 */
	public Clark() {
		super(3,1,1);
		power=9;
		
	}//Clark
	
	/**
	 * �ԷµǴ� ���� ������ ���� ���� ��ȭ�� �ް��ϰ� ��ȭ�Ѵ�.
	 * @param stone ���� ����
	 * @return ���� ��ȭ
	 */
	public String power(String stone) {
		String result=" ";
		
		if(stone.equals("Ŭ���䳪��Ʈ")) {
			power=0;
			result="���� ���� ~(_-_)~";
		}else if(stone.equals("���̾Ƹ��")) {
			power=10;
			result="�����մϴ�. ~m(^o^)m~";
		}else{
			power=12;
			result="���޾�. �Ѥ�+";
		}//end else
		
		return result;
	}//power
	
	@Override
	public String eat() {
		return getName()+"�� ������ ���� �Դ´�.";
	}//eat
	@Override
	public String eat(String menu, int price) {
		return getName()+"�� ����������� "+menu+"�� "+price+"$ ���� ��Դ´�.";
	}//eat
	
	@Override
	public String speed(String speed) {
		return getName()+"�� "+speed+"�� ����";
	}//speed

	@Override
	public String height(String height) {
		return getName()+"�� "+height+"�� ����";
	}//height
	

}//class