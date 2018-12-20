package day1115;
/*
	���׿�����(Unary)
	~, !, +, -, ++, --
*/

class Operator1 {
	public static void main(String[] args) {
		int i=11;
		int j=-11;
		//~(tilde): 1�� ��������
		//~���: ��ȣ���� 1����
		System.out.println("~"+i+"="+~i);//-12
		//~����: ��ȣ���� 1����
		System.out.println("~"+j+"="+~j);//10	
		
		//!(NOT): true-> false, false -> true
		boolean b = true;
		boolean c = false;
		System.out.println("!"+b+"="+!b);//false
		System.out.println("!"+c+"="+!c);//true
		System.out.println(!(11>15));//!�� boolean���� ��밡��

		//+: ����������
		System.out.println("+"+i+"="+ +i);//11
		System.out.println("+"+j+"="+ +j);//-11

		//-: 2�Ǻ�������, ��ȣ�ٲ޿���
		System.out.println("-"+i+"="+ -i);//-11		
		System.out.println("-"+j+"="+ -j);//11

		//++:�������� (���ü�� ���� 1�� ����)
		i=0;
		j=10;

		//��������: ������ ���ü;
		++i;
		--j;
		System.out.println("�������� �� i="+i);//1		
		System.out.println("�������� �� j="+j);//9
		
		//��������: ���ü ������;
		i++;
		j--;
		System.out.println("�������� �� i="+i);//2		
		System.out.println("�������� �� j="+j);//8

		//���������ڿ� ���ҿ����ڴ� ���Կ����ڿ� �Բ� ���Ǹ�
		//������ ������ �ٸ� ���� �����Ѵ�.
		j=0;
		j=++i;
		System.out.println("���������� i: "+i+", ����j: "+j);
		//����: ���� �� ����
		j=0;
		j=i++;
		System.out.println("���������� i: "+i+", ����j: "+j);
	}
}
