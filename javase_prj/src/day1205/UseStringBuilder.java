package day1205;

/**
 * StringBuffer, StringBuilder(JDK1.5)
 * ���ڿ��� heap�� ���� �����ϰ� ����ϴ� Ŭ����
 * @author owner
 */
public class UseStringBuilder {

	public void useStringBuffer() {
	//1.Ŭ���� ����
	StringBuffer sb = new StringBuffer();
	//2.��(����, �Ǽ�, ����, �Ҹ�, ���ڿ�..)�� �߰�
	sb.append("������ ");//���ڿ�
	sb.append(12);//����
	sb.append("�� 5��").append(" ������ �Դϴ�.");
	System.out.println(sb);//toString
	
	//3. �� ����
	//������ 12�� 5�� ������ �Դϴ�.
	//0 1234
	sb.insert(4,"2018�� ");//4���� �ڷ� �� �и�
	System.out.println(sb);
	
	//4. �� ����: delete(�����ε���,���ε���+1)
	//������ 2018�� 12�� 5�� ������ �Դϴ�.
	//0 123
	sb.delete(0, 4);//���ڿ����� null���ڱ��� �ֱ� ������ ���ε���+1�� �ؾ���
	System.out.println(sb);
	
	//5. �� ������
	sb.reverse();
	System.out.println(sb);
	sb.reverse();
	System.out.println(sb);
	
	}//useStringBuffer
	
	public void useStringBuilder() {
	//1.Ŭ���� ����
	StringBuilder sbr = new StringBuilder();
	//2.��(����, �Ǽ�, ����, �Ҹ�, ���ڿ�..)�� �߰�
	sbr.append("������ ");//���ڿ�
	sbr.append(12);//����
	sbr.append("�� 5��").append(" ������ �Դϴ�.");
	System.out.println(sbr);//�޸𸮿� ���� ����Ǽ� �ּҰ� �ƴ϶� ���� �ҷ��� �� ����
	
	//3. �� ����
	//������ 12�� 5�� ������ �Դϴ�.
	//0 1234
	sbr.insert(4,"2018�� ");//4���� �ڷ� �� �и�
	System.out.println(sbr);
	
	//4. �� ����: delete(�����ε���,���ε���+1)
	//������ 2018�� 12�� 5�� ������ �Դϴ�.
	//0 123
	sbr.delete(0, 4);//���ڿ����� null���ڱ��� �ֱ� ������ ���ε���+1�� �ؾ���
	System.out.println(sbr);
	
	//5. �� ������
	sbr.reverse();
	System.out.println(sbr);
	sbr.reverse();
	System.out.println(sbr);
	
	}//useStringBuilder
	
	public static void main(String[] args) {
		UseStringBuilder usb = new UseStringBuilder();
		usb.useStringBuffer();
		System.out.println("---------------------------");
		usb.useStringBuilder();

		
		String str="�ȳ��ϼ���?"; //ª�����ڿ��� String�� �����Ѵ�.
		System.out.println(str);
		
		String str1="��";
		//���ڿ��� +�� �پ �� ���ڿ�
		System.out.println(str1+"��"+"��"+"��"+"��");
		//new StringBuilder().append(str1).append("��").append("��"),,,
		
		}//main

}//class
