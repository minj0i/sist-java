package day1121;

public class Homework19 {

	
//		����
//		1.  while�� ����Ͽ� ������ ��ü ���� ����ϴ�  instance method��
//		    �ۼ��ϰ�, ȣ���ϼ���.
	public void instanceMethod() {
		int i=2, j=1;
		while(i<10) {
			while(j<10) {
				System.out.println(i+"*"+j+"="+(i*j));	
				j++;
			}
			j=1;
			i++;
		}
	}

//	}//instMethod
		
		
//		2.  do~while�� ����Ͽ� �Ʒ��� ������  *�� ����ϴ�  static method��
//		    �ۼ��Ͽ� ȣ���ϼ���.
//		    *
//		    **
//		    ***
//		    ****
	public static void staticmethod() {
	int k=0;
	int l=0;
		do{
			for(l=0; l<=k; l++) {
				System.out.print("*");
			}
			System.out.println();
			k++;
		}while(k<4);

	}
	
	
	public static void main(String[] args) {
		Homework19 um= new Homework19();
		um.instanceMethod();
		System.out.println("=========");
		Homework19.staticmethod();
	
	}
}

