package day1127;

/**
 * ���ڿ� ������� �ּҸ� �����ϰ�, ���ڿ��� �ٷ�� ����� �����ϴ� String class�� ���.<br>
 * java���� �����ϴ� Ŭ������ �̸��� ���� ���� Ŭ������ �̸��� ���ٸ� �������� Ŭ������ ���� ����ϰ� �ȴ�. java���� �����ϴ�
 * Ŭ������ ����� �� ���� "full path: ��Ű������ ��� ����Ͽ� Ŭ������ ����ϴ� ��" ��Ű����.Ŭ������
 * 
 * @author owner
 */
public class UseString {

	public static void main(String[] args) {
		// �⺻�� ���� ���. String s="���ڿ�";
		String str = "AbcdEfg";
		// ������ ���� ���. String s1=new String("���ڿ�");
		String mail = new String("h_hoh@naver.com");
		System.out.println(str);
		System.out.println(mail);
		
		System.out.println(str+"�� ����"+str.length());
		System.out.println(mail+"�� ����"+mail.length());
		
		System.out.println(str+"�� ��� �빮�ڷ�"+str.toUpperCase());
		System.out.println(str+"�� ��� �ҹ��ڷ�"+str.toLowerCase());
		//"AbcdEfg"
		//0 123456
		//indexOf�� L->R�� �����ϸ� ���� ó�� ã������ ���ڿ��� �ε����� ��� ��
		System.out.println(str+"���� 'd'�� �ε���"+str.indexOf("d"));
		System.out.println(str+"���� 'z'�� �ε���"+str.indexOf("z"));
		
		System.out.println(mail+"���� \"@\"�� �ε���"+mail.indexOf("@"));
		str="AbcdEfAg";
		//lastIndexOf�� R->L�� �����ϸ鼭 ���� ó�� ã�Ƴ��� ���ڿ��� �ε����� ����
		System.out.println(str+"���ڿ����� �ڷκ��� 'A'�� �ε���"+str.lastIndexOf("A"));//���ڴ� ����
		
		//Ư�� �ε��� ���� ���
		char temp=str.charAt(2);
		System.out.println(str+"���� 2��° �ε����� �ش��ϴ� ����"+temp);
		//�ڽĹ��ڿ� �ڸ���
		System.out.println(str+"���� �ε����� 2~5��°�� �ش��ϴ� ���ڿ�"+str.substring(2,6));
		//h_hoh @naver .com
		//01234 5678910 <-String index
		System.out.println(mail+"���� ���� �ּҸ� ���"+mail.substring(0,(mail.indexOf("@"))));
		System.out.println(mail+"���� ������ �ּҸ� ���"+mail.substring(mail.indexOf("@")+1));
		
		//�յڰ��� �ڸ���
		str="   A BC ";
		System.out.println("["+str+"]"+"���� �� �� ���� �ڸ���"+str.trim());
		
		//���ڿ����̱�
		str="Abcd";
		String str1=str.concat("Efg");
		String str2=str+"Efg";
		System.out.println(str1);
		System.out.println(str2);
		
		//���ڿ��� �Ϻ��ϰ� ������ ��
		str="������";
		System.out.println(str+"�� "+(str.equals("������")?"����":"���"));
		
		//���ڿ��� �� ���ڿ��� �����ϴ���
		str="�Ǿ���";
		if(str.startsWith("����")) {
			System.out.println("���� ����� �� �����ϴ�");
		}else {
			System.out.println(str);
		}//else
		
		str="����� ������";
		str1="������ �ȴޱ�";
		
		System.out.println(str+"��(��) "+(str.startsWith("����")?"����Ư����":"������ �ƴ�"));
		System.out.println(str1+"��(��) "+(str1.startsWith("����")?"����Ư����":"������ �ƴ�"));
		
		//Ư�� ���ڿ��� ��������
		str="����� ������ ���ﵿ";
		str1="��⵵ ������ ������";
		
		System.out.println(str+"��(��) "+(str.endsWith("��")?"����":"�ð�"));
		System.out.println(str1+"��(��) "+(str1.endsWith("��")?"����":"�ð�"));
		
		//ġȯ: ���ڿ� ���� ��� ���ڿ� ã�Ƽ� ġȯ
		str="�� ���� �Ǿ����ε� �� ���� �������!";
		System.out.println(str.replaceAll("��", "*").replaceAll("��", "*"));
		
		str="   A BC   ";
		System.out.println(str.replaceAll(" ", ""));
		
		int i=27;
		//str i; int�� String���� �Ҵ� �� �� ����.
		//�⺻������������ ���ڿ��� ��ȯ
		str=String.valueOf(i);
		System.out.println(str);
		double d=11.27;
		str=d+"";
		System.out.println(str);
		
		str="";
		System.out.println(str.isEmpty());
		
		//��ü ������ ���� �ʾ��� �� �� Ŭ������ �����ϴ� method��
		//����� �� ����. Error
//		str=null;
//		System.out.println(str.isEmpty());
		
	}// main

}// class
