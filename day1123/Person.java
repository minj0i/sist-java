package day1123;

/**
 * ����� �߻�ȭ�Ͽ� ���� Ŭ���� <br>
 * �����Ư¡: ��, ��, ��, �̸�<br>
 * ������Ư¡: �Դ´�.<br>
 * 
 * ��üȭ) Person ��ü�� = new Person(); <br>
 * 	������ ��ü�� �Դ����� �� �� �ִ�.
 * 
 * 
 * @author owner
 */
public class Person {
	private String name; //�̸�
	private int eye, nose, mouth;//��, ��,��
	
	/**
	 * ���Ŭ������ �⺻������<br>
	 * �� 2��, �� 1��, �� 1���� ���� ���� ��� ��ü�� ����
	 */
	public Person() {
		this(2,1,1);
//		eye=2;
//		nose=1;
//		mouth=1;
	}//Person
	
	/**
	 * ��2��, �� 1��, �� 1���� �ƴ� ��� ��ü�� ������ �� ����ϴ� ������. 
	 * @param eye ���� ��
	 * @param nose ���� ��
	 * @param mouth ���� ��
	 */
	public Person(int eye, int nose, int mouth) {
		this.eye=eye;
		this.nose=nose;
		this.mouth=mouth;
	}
	
	/**
	 * ������ ��� ��ü�� �̸��� �����ϴ� ��
	 * @param name �̸�
	 */
	public void setName(String name) {
		this.name=name;
	}//end setName
	
	/**
	 * ������ ��� ��ü�� ���� �����ϴ� ��.<br>
	 * ������ ���� �ִ� ������ 3������ ������ �� �ִ�.<br>
	 * 3���� �Ѿ�� 2���� �����ȴ�.
	 * @param eye ���� ����
	 */
	public void setEye(int eye) {
		if(eye>3) {
			eye=2;
		}//end if
		this.eye=eye;
	}//end setEye
	
	/**
	 * ������ ��� ��ü�� �ڸ� �����ϴ� ��.
	 * @param nose ���� ����
	 */
	public void setNose(int nose) {
		this.nose=nose;
	}//setNose
	
	/**
	 * ������ ��� ��ü�� ���� �����ϴ� ��.
	 * @param mouth ���� ����
	 */
	public void setMouth(int mouth) {
		this.mouth=mouth;
	}//setMouth
	
	/**
	 * ������ ��� ��ü�� �̸��� ��ȯ�ϴ� ��.
	 * @return �̸�
	 */
	public String getName() {
		return name;
	}//getName
	
	/**
	 * ������ ��� ��ü�� ������ �ִ� ���� ���� ��ȯ�ϴ� ��.
	 * @return ���� ����
	 */
	public int getEye() {
		return eye;
	}//getEye
	
	/**
	 * ������ ��� ��ü�� ������ �ִ� ���� ���� ��ȯ�ϴ� ��.
	 * @return ���� ����
	 */
	public int getNose() {
		return nose;
	}//getNose
	
	/**
	 * ������ ��� ��ü�� ������ �ִ� ���� ���� ��ȯ�ϴ� ��.
	 * @return ���� ����
	 */
	public int getMouth() {
		return mouth;
	}//getMouth
	
	/**
	 * ������ Ư¡ <br>
	 * ������ ��� ��ü�� ������ ���� �Դ� �� ����.
	 * @return ���
	 */
	public String eat() {
		return name+"�� ������ ���� �Դ´�.";
	}//eat
	
	/**
	 * method�� Overload(overloading): ������ - ���� �̸��� method��
	 * ������ �����ϴ� ���<br>
	 * ������ �����ü�� �Ĵ翡�� �ֹ��� ������ �Դ� ��
	 * @param menu ������ ����
	 * @param price ���� ����
	 * @return ���
	 */
	public String eat(String menu, int price) {
		return name+"��(��) �Ĵ翡�� "+menu+"�� ������ "+price+"�� ���� ��Դ´�.";
	}//eat
	
	
	
	
}//class
