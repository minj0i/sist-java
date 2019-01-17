package chap02;

public class number {

	public static void main(String[] args) {
	for(int i=1; i<8; i++) {
		for(int j=1; j<8; j++) {
			if(i==j || i+j==8) {
			System.out.print(1);
			}else {
				System.out.print(0);
			}
			System.out.print(" ");
		}
		System.out.println();
	}
		
	}//main
	
}//class
