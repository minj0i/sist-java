package day1123;

/**
 * ����� �߻�ȭ�Ͽ� ���� Ŭ���� <br>
 * �����Ư¡: ȸ���, ���׶�/����������, ��������, ���� <br>
 * ������Ư¡: �ȸ���.
 * 
 * @author owner
 */
public class Noodle {
	private String name, company, shape;
	private int drysoup, price;

	
	/**
	 * 11-26-2018 �ڵ� �߰�
	 */
	public Noodle() {
		this("�����","�ȵ�","����",2,700);
	}
	
	/**
	 * 11-26-2018 �����ִ� ������ �ڵ� �߰�
	 * @param name
	 * @param company
	 * @param shape
	 * @param drysoup
	 * @param price
	 */
	public Noodle(String name, String company, String shape, int drysoup, int price) {
	this.name=name;
	this.company=company;
	this.shape=shape;
	this.drysoup=drysoup;
	this.price=price;
	}

	
	/**
	 * ��� �̸��� �����ϴ���
	 * @param name ����̸�
	 */
	public void setName(String name){
		this.name = name;
	}//company
	
	/**
	 * ��� �����縦 �����ϴ���
	 * @param company �������
	 */
	public void setCompany(String company){
		this.company = company;
	}//company
	
	/**
	 * ��� ���¸� �����ϴ� ��<br>
	 * �����̳� �簢���� ����
	 * @param shape �������
	 */
	public void setShape(String shape) {
		if (shape.equals("����") || shape.equals("�簢��")) {
			this.shape=shape;
		}else {
			this.shape="����";
		}
	}//shape
	
	/**
	 * �Ǵ������ ������ ���� ��
	 * @param drysoup �Ǵ�������� ����
	 */
	public void setDrysoup(int drysoup) {
		this.drysoup=drysoup;
	}//drysoup
	
	/**
	 * ��� ������ �����ϴ� ��
	 * @param price ����� ����
	 */
	public void setPrice(int price) {
		this.price=price;
	}//price
	
	/**
	 * ��� ���� ��ȯ�ϴ� ��
	 * @return name
	 */
	public String getName() {
		return name;
	}//getName
	
	/**
	 * ��� �����縦 ��ȯ�ϴ� ��
	 * @return company
	 */
	public String getCompany() {
		return company;
	}//getName
	
	/**
	 * ��� ���¸� ��ȯ�ϴ� ��
	 * @return shape
	 */
	public String getShape() {
		return shape;
	}//getName
	
	/**
	 * �������� ������ ��ȯ�ϴ� ��
	 * @return drysoup
	 */
	public int getDrysoup() {
		return drysoup;
	}//getName
	
	/**
	 * ��� ������ ��ȯ�ϴ� ��
	 * @return price
	 */
	public int getPrice() {
		return price;
	}//getName
	
	/**
	 * ������ Ư¡
	 * �Ǹŵȴٰ� ǥ��
	 * @return ���
	 */
	public String sale() {
		return "��� "+name+"��(��) "+company+"���� �Ǹŵȴ�.";
	}//sale
	
	public String output(String shape, int drysoup) {
		return name+"��(��) ������ "+shape+"�̸� "+drysoup+"���� ���������� ��������.";
	}//eat
	
	public void print() {
		System.out.format("������ ��� ���� �̸�[%S],�������[%S],��߸��[%S],�Ǵ����������[%d],����[%d]\n",
		name, company, shape,drysoup,price);
	}
	
}
