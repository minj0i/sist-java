package day1121;

public class Homework19 {

	
//		숙제
//		1.  while을 사용하여 구구단 전체 단을 출력하는  instance method를
//		    작성하고, 호출하세요.
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
		
		
//		2.  do~while을 사용하여 아래의 형태의  *을 출력하는  static method를
//		    작성하여 호출하세요.
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

